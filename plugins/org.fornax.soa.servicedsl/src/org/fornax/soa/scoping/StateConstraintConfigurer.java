package org.fornax.soa.scoping;

import org.eclipse.emf.ecore.EObject;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Enumeration;
import org.fornax.soa.basedsl.sOABaseDsl.LifecycleState;
import org.fornax.soa.serviceDsl.Service;
import org.fornax.soa.serviceDsl.SubNamespace;
import org.fornax.soa.util.DslElementAccessor;

public class StateConstraintConfigurer {
	
	public static LifecycleState getMinDevState (EObject o) {
		if (o instanceof SubNamespace) {
			SubNamespace ns = (SubNamespace)o;
			if (ns.getLinkingPolicy() != null)
				return ns.getLinkingPolicy().getMinDevState();
			else
				return LifecycleState.DEVELOPMENT;
		}
		o = DslElementAccessor.INSTANCE.getVersionedOwner(o);
		if (o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject)o;
			if (bo.getLinkingPolicy() != null && bo.getLinkingPolicy().getMinDevState() != null )
				return bo.getLinkingPolicy().getMinDevState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState();
		}
		if (o instanceof Enumeration) {
			Enumeration en = (Enumeration)o;
			if (en.getLinkingPolicy() != null && en.getLinkingPolicy().getMinDevState() != null )
				return en.getLinkingPolicy().getMinDevState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState();
		}
		if (o instanceof org.fornax.soa.serviceDsl.Exception) {
			org.fornax.soa.serviceDsl.Exception ex = (org.fornax.soa.serviceDsl.Exception)o;
			if (ex.getLinkingPolicy() != null && ex.getLinkingPolicy().getMinDevState() != null )
				return ex.getLinkingPolicy().getMinDevState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState();
		}
		if (o instanceof Service) {
			Service s = ((Service) o);
			if (s.getLinkingPolicy() != null && s.getLinkingPolicy().getMinDevState() != null )
				return s.getLinkingPolicy().getMinDevState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinDevState();
		}
		return LifecycleState.DEVELOPMENT;
	}
	
	public static LifecycleState getMinTestState (EObject o) {
		if (o instanceof SubNamespace)
			if (((SubNamespace)o).getLinkingPolicy() != null)
				return ((SubNamespace)o).getLinkingPolicy().getMinTestState();
			else
				return LifecycleState.TEST;
		o = DslElementAccessor.INSTANCE.getVersionedOwner(o);
		if (o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject)o;
			if (bo.getLinkingPolicy() != null && bo.getLinkingPolicy().getMinTestState() != null )
				return bo.getLinkingPolicy().getMinTestState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState();
		}
		if (o instanceof Enumeration) {
			Enumeration en = (Enumeration)o;
			if (en.getLinkingPolicy() != null && en.getLinkingPolicy().getMinTestState() != null )
				return en.getLinkingPolicy().getMinTestState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState();
		}
		if (o instanceof org.fornax.soa.serviceDsl.Exception) {
			org.fornax.soa.serviceDsl.Exception ex = (org.fornax.soa.serviceDsl.Exception)o;
			if (ex.getLinkingPolicy() != null && ex.getLinkingPolicy().getMinTestState() != null )
				return ex.getLinkingPolicy().getMinTestState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState();
		}
		if (o instanceof Service) {
			Service s = ((Service) o);
			if (s.getLinkingPolicy() != null && s.getLinkingPolicy().getMinTestState() != null )
				return s.getLinkingPolicy().getMinTestState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinTestState();
		}
		return LifecycleState.TEST;
	}
	
	public static LifecycleState getMinProdState (EObject o) {
		if (o instanceof SubNamespace)
			if (((SubNamespace)o).getLinkingPolicy() != null)
				return ((SubNamespace)o).getLinkingPolicy().getMinProdState();
			else
				return LifecycleState.PRODUCTIVE;
		o = DslElementAccessor.INSTANCE.getVersionedOwner(o);
		if (o instanceof BusinessObject) {
			BusinessObject bo = (BusinessObject)o;
			if (bo.getLinkingPolicy() != null && bo.getLinkingPolicy().getMinProdState() != null )
				return bo.getLinkingPolicy().getMinProdState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState();
		}
		if (o instanceof Enumeration) {
			Enumeration en = (Enumeration)o;
			if (en.getLinkingPolicy() != null && en.getLinkingPolicy().getMinProdState() != null )
				return en.getLinkingPolicy().getMinProdState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState();
		}
		if (o instanceof org.fornax.soa.serviceDsl.Exception) {
			org.fornax.soa.serviceDsl.Exception ex = (org.fornax.soa.serviceDsl.Exception)o;
			if (ex.getLinkingPolicy() != null && ex.getLinkingPolicy().getMinProdState() != null )
				return ex.getLinkingPolicy().getMinProdState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState();
		}
		if (o instanceof Service) {
			Service s = ((Service) o);
			if (s.getLinkingPolicy() != null && s.getLinkingPolicy().getMinProdState() != null )
				return s.getLinkingPolicy().getMinProdState();
			else if(o.eContainer() instanceof SubNamespace && ((SubNamespace)o.eContainer()).getLinkingPolicy() != null && ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState() != null)
				return ((SubNamespace)o.eContainer()).getLinkingPolicy().getMinProdState();
		}
		return LifecycleState.PRODUCTIVE;
	}

}
