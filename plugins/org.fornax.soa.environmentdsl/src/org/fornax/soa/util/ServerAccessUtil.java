package org.fornax.soa.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.fornax.soa.environmentDsl.Connector;
import org.fornax.soa.environmentDsl.Server;

public class ServerAccessUtil {
	
	public static EList<Connector> getConnectors (Server s) {
		EStructuralFeature connectorsFeature = s.eClass().getEStructuralFeature("connectors");
		if (connectorsFeature != null) {
			return (EList<Connector>)s.eGet(connectorsFeature);
		}
		return new BasicEList<Connector>();
	}

}
