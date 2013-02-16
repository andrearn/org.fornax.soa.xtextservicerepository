package org.fornax.soa.servicedsl.generator.templates.xsd;

import com.google.inject.Inject;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.servicedsl.generator.templates.xsd.SchemaNamespaceExtensions;

@SuppressWarnings("all")
public class SchemaTemplateExtensions {
  @Inject
  private SchemaNamespaceExtensions _schemaNamespaceExtensions;
  
  public String toOpWrapperXSDFileName(final Service s) {
    String _fileNameFragment = this._schemaNamespaceExtensions.toFileNameFragment(s);
    String _plus = (_fileNameFragment + "-OpWrappers.xsd");
    return _plus;
  }
}
