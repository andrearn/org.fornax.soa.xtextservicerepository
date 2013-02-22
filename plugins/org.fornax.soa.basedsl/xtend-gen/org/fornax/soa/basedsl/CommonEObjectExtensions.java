package org.fornax.soa.basedsl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;

@SuppressWarnings("all")
public class CommonEObjectExtensions {
  @Inject
  private IQualifiedNameProvider nameProvider;
  
  public EObject eRootContainer(final EObject o) {
    EObject _xifexpression = null;
    EObject _eContainer = o.eContainer();
    boolean _notEquals = (!Objects.equal(_eContainer, null));
    if (_notEquals) {
      EObject _eRootContainer = this.eRootContainer(o);
      _xifexpression = _eRootContainer;
    } else {
      return o;
    }
    return _xifexpression;
  }
  
  public String fqn(final EObject o) {
    QualifiedName _fullyQualifiedName = this.nameProvider.getFullyQualifiedName(o);
    String _string = _fullyQualifiedName.toString();
    return _string;
  }
}
