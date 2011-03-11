/*
* generated by Xtext
*/
package org.fornax.soa.ui.labeling;

import org.apache.log4j.Logger;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.fornax.soa.basedsl.sOABaseDsl.Import;
import org.fornax.soa.serviceDsl.Attribute;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.BusinessObjectRef;
import org.fornax.soa.serviceDsl.DataType;
import org.fornax.soa.serviceDsl.DataTypeRef;
import org.fornax.soa.serviceDsl.DomainNamespace;
import org.fornax.soa.serviceDsl.EnumTypeRef;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.serviceDsl.InternalNamespace;
import org.fornax.soa.serviceDsl.Operation;
import org.fornax.soa.serviceDsl.Parameter;
import org.fornax.soa.serviceDsl.Reference;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.TypeRef;
import org.fornax.soa.serviceDsl.VersionedTypeRef;

import com.google.inject.Inject;

/**
 * Provides labels for a EObjects.
 * 
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#labelProvider
 */
public class ServiceDslLabelProvider extends DefaultEObjectLabelProvider {
	
	private static Logger _log = Logger.getLogger (ServiceDslLabelProvider.class);

	@Inject
	public ServiceDslLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	Object text (Service ele) {
		StyledString name = new StyledString(ele.getName());
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + ele.getState().toString(), StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		return name;
	}
	String image (Service ele) {
		return "full/obj16/service_obj.gif";
	}
	
	Object text (BusinessObject ele) {
		StyledString name = new StyledString(ele.getName());
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + ele.getState().toString(), StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		return name;
	}
	String image (BusinessObject ele) {
		return "full/obj16/bo_obj.gif";
	}
	
	Object text (Enumeration ele) {
		StyledString name = new StyledString(ele.getName());
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + ele.getState().toString(), StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		return name;
	}
	String image (Enumeration ele) {
		return "full/obj16/enum_obj.gif";
	}
	
	String image (DataType ele) {
		return "full/obj16/datatype_obj.gif";
	}
	
	Object text (org.fornax.soa.serviceDsl.Exception ele) {
		StyledString name = new StyledString(ele.getName());
		StyledString versionAndState  = new StyledString(" " + ele.getVersion().getVersion() + " " + ele.getState().toString(), StyledString.DECORATIONS_STYLER);
		name.append(versionAndState);
		return name;
	}
	
	String image (org.fornax.soa.serviceDsl.Exception ele) {
		return "full/obj16/fault.gif";
	}
	
	String image (DomainNamespace ele) {
		return "full/obj16/package_obj.gif";
	}

	String image (InternalNamespace ele) {
		return "full/obj16/packd_obj.gif";
	}

	String image (Operation ele) {
		return "full/obj16/methpub_obj.gif";
	}
	
	Object text (Attribute ele) {
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

	String image (Attribute ele) {
		return "full/obj16/field_public_obj.gif";
	}
	
	Object text (Reference ele) {
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

	String image (Reference ele) {
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
	
	
	private String getTypeName (TypeRef t) {
		if (t instanceof DataTypeRef) {
			DataTypeRef dtRef = (DataTypeRef) t;
			if (dtRef.getType() instanceof org.fornax.soa.profiledsl.sOAProfileDsl.DataType )
				return ((org.fornax.soa.profiledsl.sOAProfileDsl.DataType) dtRef.getType()).getName();
			else
				_log.error("Unexpected reference type " + dtRef.getType().eClass().getName());
		}
		if (t instanceof BusinessObjectRef)
			return ((BusinessObjectRef)t).getType().getName();
		if (t instanceof EnumTypeRef)
			return ((EnumTypeRef)t).getType().getName();
		if (t instanceof VersionedTypeRef)
			return ((VersionedTypeRef)t).getType().getName();
		return null;
	}
}
