package org.fornax.soa.servicedsl.generator.templates.webservice;

import com.google.inject.Inject;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaTypeExtensions;

@SuppressWarnings("all")
public class WsdlParameterExtensions {
  @Inject
  private SchemaTypeExtensions _schemaTypeExtensions;
  
  public String toElementType(final Parameter param) {
    String _xifexpression = null;
    boolean _and = false;
    TypeRef _type = param.getType();
    if (!(_type instanceof DataTypeRef)) {
      _and = false;
    } else {
      boolean _isAttachmentRef = param.isAttachmentRef();
      _and = ((_type instanceof DataTypeRef) && _isAttachmentRef);
    }
    if (_and) {
      _xifexpression = "ref:swaRef";
    } else {
      TypeRef _type_1 = param.getType();
      String _typeNameRef = this._schemaTypeExtensions.toTypeNameRef(_type_1);
      _xifexpression = _typeNameRef;
    }
    return _xifexpression;
  }
}
