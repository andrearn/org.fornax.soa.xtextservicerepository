/*
* generated by Xtext
*/
package org.xkonnex.repo.dsl.servicedsl.ui.labeling;

import org.apache.log4j.Logger;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.xkonnex.repo.dsl.basedsl.baseDsl.Import;
import org.xkonnex.repo.dsl.profiledsl.profileDsl.LifecycleState;
import org.xkonnex.repo.dsl.profiledsl.scoping.versions.ILifecycleStateResolver;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Aggregate;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ComplexConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ConsiderationParameterRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObjectRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumTypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ErrorResponse;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ExceptionRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.IntReturnCode;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.InternalNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OperationRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.QueryObject;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.RequiredInterfaceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ResourceOperation;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Response;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleConsiderationPropertyRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.StringReturnCode;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ServiceDslLabelProvider extends DefaultEObjectLabelProvider {
	
	private static Logger _log = Logger.getLogger (ServiceDslLabelProvider.class);
	
	@Inject
	private ILifecycleStateResolver stateResolver;

	private static Styler STRIKETHROUGH = new Styler() {
		@Override
		public void applyStyles(TextStyle textStyle) {
			textStyle.strikeout = true;
		}
	};
	
	@Inject
	public ServiceDslLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	Object text (Service ele) {
		StyledString name = new StyledString(ele.getName());
		LifecycleState state = stateResolver.getLifecycleState(ele);
		String stateName = state != null ? state.getName () : "";
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + stateName, StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		if (ele.isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	String image (Resource ele) {
		return "full/obj16/service_obj.gif";
	}
	Object text (Resource ele) {
		StyledString name = new StyledString(ele.getName());
		LifecycleState state = stateResolver.getLifecycleState(ele);
		String stateName = state != null ? state.getName () : "";
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + stateName, StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		if (ele.isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	String image (Service ele) {
		return "full/obj16/service_obj.gif";
	}
	
	Object text (ServiceRef ele) {
		StyledString name = new StyledString(ele.getService ().getName());
		if (ele.getService().isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	
	String image (ServiceRef ele) {
		return "full/obj16/ServiceRef.gif";
	}
	Object text (RequiredInterfaceRef ele) {
		if (ele.getInterfaceRef() instanceof Service) {
			Service service = (Service)ele.getInterfaceRef ();
			StyledString name = new StyledString(service.getName());
			if (service.isDeprecated()) {
				name.setStyle(0, name.length(), STRIKETHROUGH);
			}
			return name;
		}
		if (ele.getInterfaceRef() instanceof Resource) {
			Resource resource = (Resource)ele.getInterfaceRef ();
			StyledString name = new StyledString(resource.getName());
			if (resource.isDeprecated()) {
				name.setStyle(0, name.length(), STRIKETHROUGH);
			}
			return name;
		}
		if (ele.getInterfaceRef() instanceof Aggregate) {
			Aggregate aggregate = (Aggregate)ele.getInterfaceRef ();
			StyledString name = new StyledString(aggregate.getName());
			if (aggregate.isDeprecated()) {
				name.setStyle(0, name.length(), STRIKETHROUGH);
			}
			return name;
		}
		return "";
	}
	
	String image (RequiredInterfaceRef ele) {
		return "full/obj16/ServiceRef.gif";
	}
	
	Object text (BusinessObject ele) {
		StyledString name = new StyledString(ele.getName());
		LifecycleState state = stateResolver.getLifecycleState(ele);
		String stateName = state != null ? state.getName () : "";
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + stateName, StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		if (ele.isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	String image (BusinessObject ele) {
		return "full/obj16/bo_obj.gif";
	}
	Object text (QueryObject ele) {
		StyledString name = new StyledString(ele.getName());
		LifecycleState state = stateResolver.getLifecycleState(ele);
		String stateName = state != null ? state.getName () : "";
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + stateName, StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		if (ele.isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	String image (QueryObject ele) {
		return "full/obj16/QueryObject.gif";
	}
	
	Object text (Enumeration ele) {
		StyledString name = new StyledString(ele.getName());
		LifecycleState state = stateResolver.getLifecycleState(ele);
		String stateName = state != null ? state.getName () : "";
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + stateName, StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		if (ele.isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	String image (Enumeration ele) {
		return "full/obj16/enum_obj.gif";
	}
	
	Object text (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception ele) {
		StyledString name = new StyledString(ele.getName());
		LifecycleState state = stateResolver.getLifecycleState(ele);
		String stateName = state != null ? state.getName () : "";
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + stateName, StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		if (ele.isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	
	String image (org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception ele) {
		return "full/obj16/fault.gif";
	}
	
	String image (DomainNamespace ele) {
		return "full/obj16/package_obj.gif";
	}

	String image (InternalNamespace ele) {
		return "full/obj16/packd_obj.gif";
	}
	
	Object text (Operation ele) {
		StyledString name = new StyledString(ele.getName());
		if (ele.isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	Object text (ResourceOperation ele) {
		StyledString uri = new StyledString(ele.getPath());
		if (ele.isDeprecated()) {
			uri.setStyle(0, uri.length(), STRIKETHROUGH);
		}
		return uri;
	}
	
	Object text (Response ele) {
		if (ele.getResponseCode() instanceof IntReturnCode) {
			Integer returnCode = ((IntReturnCode)ele.getResponseCode()).getReturnCode();
			StyledString code = new StyledString(returnCode.toString());
			return code;
		} else {
			String returnCode = ((StringReturnCode)ele.getResponseCode()).getReturnCode();
			StyledString code = new StyledString(returnCode);
			return code;
		}
	}
	
	Object text (ErrorResponse ele) {
		if (ele.getResponseCode() instanceof IntReturnCode) {
			Integer returnCode = ((IntReturnCode)ele.getResponseCode()).getReturnCode();
			StyledString code = new StyledString(returnCode.toString());
			return code;
		} else {
			String returnCode = ((StringReturnCode)ele.getResponseCode()).getReturnCode();
			StyledString code = new StyledString(returnCode);
			return code;
		}
	}
	Object text (OperationRef ele) {
		StyledString name = new StyledString(ele.getOperation().getName());
		if (ele.getOperation().isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}

	String image (Operation ele) {
		return "full/obj16/methpub_obj.gif";
	}
	
	Object text (Property ele) {
		String name = ele.getName();
		String typeName = getTypeName(ele.getType());
		if (typeName != null) {
			StyledString styledName = new StyledString (name);
			StyledString styledTypeName = new StyledString (" : " + typeName, StyledString.DECORATIONS_STYLER);
			styledName.append(styledTypeName);
			return styledName;
		} else {			
			return ele.getName();
		}
	}
	String image (Property ele) {
		return "full/obj16/field_public_obj.gif";
	}
		
	Object text (Parameter ele) {
		String name = ele.getName();
		String typeName = getTypeName(ele.getType());
		if (typeName != null) {
			StyledString styledName = new StyledString (name);
			StyledString styledTypeName = new StyledString (" : " + typeName, StyledString.DECORATIONS_STYLER);
			styledName.append(styledTypeName);
			return styledName;
		} else {			
			return ele.getName();
		}
	}

	String image (Import ele) {
		return "full/obj16/imp_obj.gif";
	}
	
	String text(ConsiderationParameterRef ele) {
		return ele.getParam().getName();
	}
	
	String text(ComplexConsiderationPropertyRef ele) {
		return ele.getParentProperty().getName();
	}
	
	String text(SimpleConsiderationPropertyRef ele) {
		return ele.getProperty().getName();
	}
	
	Object text(DataObjectRef ele) {
		StyledString name = new StyledString(ele.getType().getName());
		if (ele.getType().isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	Object text(EnumTypeRef ele) {
		StyledString name = new StyledString(ele.getType().getName());
		if (ele.getType().isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	Object text(ExceptionRef ele) {
		StyledString name = new StyledString(ele.getException().getName());
		if (ele.getException().isDeprecated()) {
			name.setStyle(0, name.length(), STRIKETHROUGH);
		}
		return name;
	}
	
	
	private String getTypeName (TypeRef t) {
		if (t instanceof DataTypeRef) {
			DataTypeRef dtRef = (DataTypeRef) t;
			if (dtRef.getType() instanceof org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType )
				return ((org.xkonnex.repo.dsl.profiledsl.profileDsl.DataType) dtRef.getType()).getName();
			else
				_log.error("Unexpected reference type " + dtRef.getType().eClass().getName());
		}
		if (t instanceof DataObjectRef)
			return ((DataObjectRef)t).getType().getName();
		if (t instanceof EnumTypeRef)
			return ((EnumTypeRef)t).getType().getName();
		if (t instanceof VersionedTypeRef)
			return ((VersionedTypeRef)t).getType().getName();
		return null;
	}
}
