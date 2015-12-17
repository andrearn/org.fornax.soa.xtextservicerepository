package org.xkonnex.repo.dsl.basedsl.scoping;

import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.util.Strings;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

public class MapBasedScope extends AbstractScope {
	
	private Map<QualifiedName, ? extends EObject> entries;
	
	public MapBasedScope(Map<QualifiedName, ? extends EObject> entries) {
		super(IScope.NULLSCOPE, false);
		this.entries = entries;
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		return Iterables.transform(entries.entrySet(), new Function<Map.Entry<QualifiedName, ? extends EObject>, IEObjectDescription>() {
			public IEObjectDescription apply(Map.Entry<QualifiedName, ? extends EObject> from) {
				return new MapEntry(from);
			}
		});
	}
	
	@Override
	protected Iterable<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		EObject element = entries.get(name);
		if (element != null)
			return singleton(EObjectDescription.create(name, element));
		return emptySet();
	}

	public static class MapEntry implements IEObjectDescription {

		private final Map.Entry<QualifiedName, ? extends EObject> entry;

		public MapEntry(Map.Entry<QualifiedName, ? extends EObject> entry) {
			this.entry = entry;
		}
		
		public QualifiedName getName() {
			return entry.getKey();
		}

		public QualifiedName getQualifiedName() {
			return entry.getKey();
		}

		public EObject getEObjectOrProxy() {
			return entry.getValue();
		}

		public URI getEObjectURI() {
			return EcoreUtil.getURI(entry.getValue());
		}

		public EClass getEClass() {
			return entry.getValue().eClass();
		}

		public String getUserData(String name) {
			return null;
		}

		public String[] getUserDataKeys() {
			return Strings.EMPTY_ARRAY;
		}

	}

}
