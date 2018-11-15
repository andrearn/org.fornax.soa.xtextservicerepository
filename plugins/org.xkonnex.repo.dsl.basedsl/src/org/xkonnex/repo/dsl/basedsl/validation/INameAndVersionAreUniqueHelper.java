package org.xkonnex.repo.dsl.basedsl.validation;

import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.inject.ImplementedBy;

@ImplementedBy (NameAndVersionAreUniqueValidationHelper.class)
public interface INameAndVersionAreUniqueHelper {

	/**
	 * Create errors for objects that have the same name. Objects, that do not belong to
	 * the same cluster will not get any errors.
	 * @see INamesAreUniqueValidationHelper#checkUniqueNames(Iterable, CancelIndicator, ValidationMessageAcceptor)
	 * 
	 * @param descriptions indexed object descriptions to validate
	 * @param acceptor accepts ValidationMessages
	 */
	void checkUniqueNames(Iterable<IEObjectDescription> descriptions,  ValidationMessageAcceptor acceptor);
	
	/**
	 * Create errors for objects that have the same name. Objects, that do not belong to
	 * the same cluster will not get any errors. The cancel indicator may be used to interrupt 
	 * the validation.
	 * 
	 * @param descriptions indexed object descriptions to validate
	 * @param cancelIndicator indicator to cancel validation
	 * @param acceptor accepts ValidationMessages 
	 */
	void checkUniqueNames(Iterable<IEObjectDescription> descriptions, CancelIndicator cancelIndicator, ValidationMessageAcceptor acceptor);

}
