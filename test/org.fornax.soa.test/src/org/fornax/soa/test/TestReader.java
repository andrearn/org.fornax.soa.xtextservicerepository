package org.fornax.soa.test;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.mwe.Reader;

import com.google.inject.Injector;

public class TestReader extends Reader {
	
	public List<Injector> getAllInjectors () {
		return getInjectors ();
	}
	
	public ResourceSet getReaderResourceSet () {
		return getResourceSet ();
	}

}
