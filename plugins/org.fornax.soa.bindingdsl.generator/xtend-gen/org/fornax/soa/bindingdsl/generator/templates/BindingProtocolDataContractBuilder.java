package org.fornax.soa.bindingdsl.generator.templates;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.util.Arrays;
import org.fornax.soa.bindingDsl.Binding;
import org.fornax.soa.bindingDsl.BindingProtocol;
import org.fornax.soa.bindingDsl.SOAP;
import org.fornax.soa.bindingdsl.generator.templates.IProtocolContractBuilder;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;
import org.fornax.soa.service.VersionedDomainNamespace;
import org.fornax.soa.serviceDsl.SubNamespace;

@SuppressWarnings("all")
public class BindingProtocolDataContractBuilder {
  @Inject
  @Named(value = "soapBindingTemplates")
  private IProtocolContractBuilder soapBindingTemplates;
  
  protected void _toDataContractForProtocol(final VersionedDomainNamespace svc, final Binding bind, final BindingProtocol prot, final SOAProfile profile) {
  }
  
  protected void _toDataContractForProtocol(final SubNamespace svc, final Binding bind, final BindingProtocol prot, final SOAProfile profile) {
  }
  
  protected void _toDataContractForProtocol(final VersionedDomainNamespace svc, final Binding bind, final SOAP prot, final SOAProfile profile) {
  }
  
  protected void _toDataContractForProtocol(final SubNamespace svc, final Binding bind, final SOAP prot, final SOAProfile profile) {
  }
  
  public void toDataContractForProtocol(final Object svc, final Binding bind, final BindingProtocol prot, final SOAProfile profile) {
    if (svc instanceof SubNamespace
         && prot instanceof SOAP) {
      _toDataContractForProtocol((SubNamespace)svc, bind, (SOAP)prot, profile);
      return;
    } else if (svc instanceof SubNamespace
         && prot != null) {
      _toDataContractForProtocol((SubNamespace)svc, bind, prot, profile);
      return;
    } else if (svc instanceof VersionedDomainNamespace
         && prot instanceof SOAP) {
      _toDataContractForProtocol((VersionedDomainNamespace)svc, bind, (SOAP)prot, profile);
      return;
    } else if (svc instanceof VersionedDomainNamespace
         && prot != null) {
      _toDataContractForProtocol((VersionedDomainNamespace)svc, bind, prot, profile);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(svc, bind, prot, profile).toString());
    }
  }
}
