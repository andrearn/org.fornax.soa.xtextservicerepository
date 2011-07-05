package org.fornax.soa.basedsl.validation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.SimpleCache;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.AbstractInjectableValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ComposedChecks;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;
import org.eclipse.xtext.validation.RangeBasedDiagnostic;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.base.Function;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class AbstractPluggableDeclarativeValidator extends AbstractInjectableValidator implements ValidationMessageAcceptor {
		
	private static final Logger log = Logger.getLogger(AbstractPluggableDeclarativeValidator.class);
	
	public static class StateAccess {
		
		private AbstractPluggableDeclarativeValidator validator;
		
		private StateAccess(AbstractPluggableDeclarativeValidator validator) {
			this.validator = validator;
		}

		public State getState() {
			State result = validator.state.get();
			if (result == null) {
				result = new State();
				validator.state.set(result);
			}
			return result;
		}
		
	}

	static class MethodWrapper {
		public final Method method;
		private final String s;
		private final AbstractPluggableDeclarativeValidator instance;

		public MethodWrapper(AbstractPluggableDeclarativeValidator instanceToUse, Method m) {
			this.instance = instanceToUse;
			this.method = m;
			this.s = m.getName() + ":" + m.getParameterTypes()[0].getName();
		}

		@Override
		public int hashCode() {
			return s.hashCode() ^ instance.hashCode();
		}

		public boolean isMatching(Class<?> param) {
			return method.getParameterTypes()[0].isAssignableFrom(param);
		}

		public void invoke(State state) {
			if (instance.state.get() != null && instance.state.get() != state)
				throw new IllegalStateException("State is already assigned.");
			boolean wasNull = instance.state.get() == null;
			if (wasNull)
				instance.state.set(state);
			try {
				Check annotation = method.getAnnotation(Check.class);
				if (!state.checkMode.shouldCheck(annotation.value()))
					return;
				try {
					state.currentMethod = method;
					state.currentCheckType = annotation.value();
					method.setAccessible(true);
					method.invoke(instance, state.currentObject);
				}
				catch (IllegalArgumentException e) {
					log.error(e.getMessage(), e);
				}
				catch (IllegalAccessException e) {
					log.error(e.getMessage(), e);
				}
				catch (InvocationTargetException e) {
					// ignore GuardException, check is just not evaluated if
					// guard is false
					// ignore NullPointerException, as not having to check for
					// NPEs all the time is a convenience feature
					Throwable targetException = e.getTargetException();
					if (!(targetException instanceof RuntimeException)
							&& !(targetException instanceof NullPointerException))
						throw new RuntimeException(targetException);
				}
			}
			finally {
				if (wasNull)
					instance.state.set(null);
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof MethodWrapper))
				return false;
			MethodWrapper mw = (MethodWrapper) obj;
			return s.equals(mw.s) && instance == mw.instance;
		}
	}

	private volatile Set<MethodWrapper> checkMethods = null;
	
	private ValidationMessageAcceptor messageAcceptor;

	@Inject
	private Injector injector;
	
	public void setInjector(Injector injector) {
		this.injector = injector;
	}
	
	public AbstractPluggableDeclarativeValidator() {
		this.state = new ThreadLocal<State>();
		this.messageAcceptor = this;
	}
	
	protected Set<AbstractPluggableDeclarativeValidator> getRegisteredValidators () {
		return new HashSet<AbstractPluggableDeclarativeValidator>();
	}

	protected List<MethodWrapper> collectMethods(Class<? extends AbstractPluggableDeclarativeValidator> clazz) {
		List<MethodWrapper> checkMethods = new ArrayList<MethodWrapper>();
		Set<Class<?>> visitedClasses = new HashSet<Class<?>>(4);
		collectMethods(this, clazz, visitedClasses, checkMethods);
		for (AbstractPluggableDeclarativeValidator validator : getRegisteredValidators()) {
			collectMethods(this, validator.getClass(), visitedClasses, checkMethods);
		}
		return checkMethods;
	}

	protected void collectMethods(AbstractPluggableDeclarativeValidator instance,
			Class<? extends AbstractPluggableDeclarativeValidator> clazz, Collection<Class<?>> visitedClasses,
			Collection<MethodWrapper> result) {
		if (visitedClasses.contains(clazz))
			return;
		collectMethodsImpl(instance, (Class<? extends AbstractPluggableDeclarativeValidator>) clazz, visitedClasses, result);
		Class<? extends AbstractPluggableDeclarativeValidator> k = clazz;
		while (k != null) {
			PluggableChecks checks = k.getAnnotation(PluggableChecks.class);
			if (checks != null) {
				for (Class<? extends AbstractPluggableDeclarativeValidator> external : checks.validators())
					collectMethods(null, external, visitedClasses, result);
			}
			k = getPluggableSuperClass(k);
		}
	}

	private Class<? extends AbstractDeclarativeValidator> getSuperClass(
			Class<? extends AbstractDeclarativeValidator> clazz) {
		try {
			Class<? extends AbstractDeclarativeValidator> superClass = clazz.getSuperclass().asSubclass(
					AbstractDeclarativeValidator.class);
			if (AbstractDeclarativeValidator.class.equals(superClass))
				return null;
			return superClass;
		}
		catch (ClassCastException e) {
			return null;
		}
	}
	
	private Class<? extends AbstractPluggableDeclarativeValidator> getPluggableSuperClass(
			Class<? extends AbstractPluggableDeclarativeValidator> clazz) {
		try {
			Class<? extends AbstractPluggableDeclarativeValidator> superClass = clazz.getSuperclass().asSubclass(
					AbstractPluggableDeclarativeValidator.class);
			if (AbstractPluggableDeclarativeValidator.class.equals(superClass))
				return null;
			return superClass;
		}
		catch (ClassCastException e) {
			return null;
		}
	}

	private void collectMethodsImpl(AbstractPluggableDeclarativeValidator instance,
			Class<? extends AbstractPluggableDeclarativeValidator> clazz, Collection<Class<?>> visitedClasses,
			Collection<MethodWrapper> result) {
		if (!visitedClasses.add(clazz))
			return;
		AbstractPluggableDeclarativeValidator instanceToUse;
			instanceToUse = instance;
			if (instanceToUse == null) {
				instanceToUse = newPluggableInstance(clazz);
			}
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			if (method.getAnnotation(Check.class) != null && method.getParameterTypes().length == 1) {
				result.add(new MethodWrapper(instanceToUse, method));
			}
		}
		Class<? extends AbstractPluggableDeclarativeValidator> superClass = getPluggableSuperClass(clazz);
		if (superClass != null)
			collectMethodsImpl(instanceToUse, superClass, visitedClasses, result);
	}
	

	protected AbstractDeclarativeValidator newInstance(Class<? extends AbstractDeclarativeValidator> clazz) {
		AbstractDeclarativeValidator instanceToUse;
		if (injector == null)
			throw new IllegalStateException("the class is not configured with an injector.");
		instanceToUse = injector.getInstance(clazz);
		return instanceToUse;
	}
	protected AbstractPluggableDeclarativeValidator newPluggableInstance(Class<? extends AbstractPluggableDeclarativeValidator> clazz) {
		AbstractPluggableDeclarativeValidator instanceToUse;
		if (injector == null)
			throw new IllegalStateException("the class is not configured with an injector.");
		instanceToUse = injector.getInstance(clazz);
		return instanceToUse;
	}

	private final SimpleCache<Class<?>, List<MethodWrapper>> methodsForType = new SimpleCache<Class<?>, List<MethodWrapper>>(
			new Function<Class<?>, List<MethodWrapper>>() {
				public List<MethodWrapper> apply(Class<?> param) {
					List<MethodWrapper> result = new ArrayList<MethodWrapper>();
					for (MethodWrapper mw : checkMethods) {
						if (mw.isMatching(param))
							result.add(mw);
					}
					return result;
				}
			});

	public static class State {
		public DiagnosticChain chain = null;
		public EObject currentObject = null;
		public Method currentMethod = null;
		public CheckMode checkMode = null;
		public CheckType currentCheckType = null;
		public boolean hasErrors = false;
		public Map<Object, Object> context;
	}

	private final ThreadLocal<State> state;

	protected EObject getCurrentObject() {
		return state.get().currentObject;
	}

	protected Method getCurrentMethod() {
		return state.get().currentMethod;
	}

	protected DiagnosticChain getChain() {
		return state.get().chain;
	}

	protected CheckMode getCheckMode() {
		return state.get().checkMode;
	}
	
	protected Map<Object, Object> getContext() {
		return state.get().context;
	}

	@Override
	protected boolean internalValidate(EClass class1, EObject object, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (checkMethods == null) {
			synchronized(this) {
				if (checkMethods == null) {
					Set<MethodWrapper> checkMethods = Sets.newLinkedHashSet();
					checkMethods.addAll(collectMethods(getClass()));
					this.checkMethods = checkMethods;
				}
			}
		}
		CheckMode checkMode = CheckMode.getCheckMode(context);

		State state = new State();
		state.chain = diagnostics;
		state.currentObject = object;
		state.checkMode = checkMode;
		state.context=context;

		for (MethodWrapper method : methodsForType.get(object.getClass())) {
			method.invoke(state);
		}

		return !state.hasErrors;
	}
	
	////////////////////////////
	// Convenience methods below
	////////////////////////////

	protected void info(String message, EStructuralFeature feature) {
		info(message, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}
	
	protected void info(String message, EStructuralFeature feature, int index) {
		info(message, feature, index, null);
	}

	protected void info(String message, EStructuralFeature feature, int index, String code, String... issueData) {
		info(message, state.get().currentObject, feature, index, code, issueData);
	}
	
	protected void info(String message, EObject source, EStructuralFeature feature, int index) {
		info(message, source, feature, index, null);
	}
	
	/**
	 * @since 2.0
	 */
	protected void info(String message, EStructuralFeature feature, String code, String... issueData) {
		info(message, state.get().currentObject, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code, issueData);
	}
	
	protected void info(String message, EObject source, EStructuralFeature feature, int index, String code, String... issueData) {
		getMessageAcceptor().acceptInfo(message, source, feature, index, code, issueData);
	}
	
	protected void warning(String message, EStructuralFeature feature) {
		warning(message, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}
	
	protected void warning(String message, EStructuralFeature feature, int index) {
		warning(message, feature, index, null);
	}

	protected void warning(String message, EStructuralFeature feature, String code, String... issueData) {
		warning(message, state.get().currentObject, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code, issueData);
	}

	protected void warning(String message, EStructuralFeature feature, int index, String code, String... issueData) {
		warning(message, state.get().currentObject, feature, index, code, issueData);
	}
	
	protected void warning(String message, EObject source, EStructuralFeature feature, int index) {
		warning(message, source, feature, index, null);
	}

	protected void warning(String message, EObject source, EStructuralFeature feature, int index, String code, String... issueData) {
		getMessageAcceptor().acceptWarning(message, source, feature, index, code, issueData);
	}
	
	protected void warning(String message, EObject source, EStructuralFeature feature, String code, String... issueData) {
		getMessageAcceptor().acceptWarning(message, source, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code, issueData);
	}
	
	protected void error(String message, EStructuralFeature feature) {
		error(message, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, null);
	}
	
	protected void error(String message, EStructuralFeature feature, int index) {
		error(message, feature, index, null);
	}

	protected void error(String message, EStructuralFeature feature, String code, String... issueData) {
		error(message, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code, issueData);
	}

	protected void error(String message, EStructuralFeature feature, int index, String code, String... issueData) {
		error(message, state.get().currentObject, feature, index, code, issueData);
	}
	
	protected void error(String message, EObject source, EStructuralFeature feature, int index) {
		error(message, source, feature, index, null);
	}

	protected void error(String message, EObject source, EStructuralFeature feature, String code, String... issueData) {
		getMessageAcceptor().acceptError(message, source, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code, issueData);
	}
	
	protected void error(String message, EObject source, EStructuralFeature feature, int index, String code, String... issueData) {
		getMessageAcceptor().acceptError(message, source, feature, index, code, issueData);
	}
	
	protected void guard(boolean guardExpression) {
		if (!guardExpression) {
			throw new GuardException();
		}
	}

	protected void checkDone() {
		throw new GuardException();
	}

	//////////////////////////////////////////////////////////
	// Implementation of the Validation message acceptor below
	//////////////////////////////////////////////////////////
	
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		this.state.get().hasErrors = true;
		state.get().chain.add(createDiagnostic(Severity.ERROR, message, object, feature, index, code, issueData));
	}
	
	public void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		state.get().chain.add(createDiagnostic(Severity.WARNING, message, object, feature, index, code, issueData));
	}
	
	public void acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
		state.get().chain.add(createDiagnostic(Severity.INFO, message, object, feature, index, code, issueData));
	}
	
	public void acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		this.state.get().hasErrors = true;
		state.get().chain.add(createDiagnostic(Severity.ERROR, message, object, offset, length, code, issueData));
	}

	public void acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData) {
		state.get().chain.add(createDiagnostic(Severity.WARNING, message, object, offset, length, code, issueData));
	}
	
	public void acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData) {
		state.get().chain.add(createDiagnostic(Severity.INFO, message, object, offset, length, code, issueData));
	}
	
	protected Diagnostic createDiagnostic(Severity severity, String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		int diagnosticSeverity = toDiagnosticSeverity(severity);
		Diagnostic result = new FeatureBasedDiagnostic(diagnosticSeverity, message, object, feature, index, state.get().currentCheckType, code, issueData);
		return result;
	}

	protected Diagnostic createDiagnostic(Severity severity, String message, EObject object, int offset, int length, String code, String... issueData) {
		int diagnosticSeverity = toDiagnosticSeverity(severity);
		Diagnostic result = new SOABaseRangeBasedDiagnostic(diagnosticSeverity, message, object, offset, length, state.get().currentCheckType, code, issueData);
		return result;
	}
	
	protected int toDiagnosticSeverity(Severity severity) {
		int diagnosticSeverity = -1;
		switch(severity) {
			case ERROR: diagnosticSeverity = Diagnostic.ERROR; break;
			case WARNING: diagnosticSeverity = Diagnostic.WARNING; break;
			case INFO: diagnosticSeverity = Diagnostic.INFO; break;
			default: throw new IllegalArgumentException("Unknown severity " + severity);
		}
		return diagnosticSeverity;
	}
	
	public StateAccess setMessageAcceptor(ValidationMessageAcceptor messageAcceptor) {
		this.messageAcceptor = messageAcceptor;
		return new StateAccess(this);
	}

	public ValidationMessageAcceptor getMessageAcceptor() {
		return messageAcceptor;
	}
	
	

}
