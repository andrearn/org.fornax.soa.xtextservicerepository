package org.fornax.soa.servicedsl.test.query;

import java.io.FileNotFoundException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.fornax.soa.basedsl.resource.IEObjectDescriptionBuilder;
import org.fornax.soa.basedsl.search.IEObjectLookup;
import org.fornax.soa.basedsl.util.TreeNode;
import org.fornax.soa.service.query.type.BusinessObjectQueries;
import org.fornax.soa.service.query.type.DataObjectQueryInternal;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.OrganizationNamespace;
import org.fornax.soa.serviceDsl.ServiceModel;
import org.fornax.soa.serviceDsl.Type;
import org.fornax.soa.test.AbstractModelBasedTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

@RunWith(XtextRunner.class)
public class ModelBusinessObjectQueryTest extends AbstractModelBasedTest {

	@Inject
	private
	BusinessObjectQueries boQuery;
	
	@Inject
	private
	IQualifiedNameProvider nameProvider;
	
	@Inject
	IEObjectDescriptionBuilder descriptionBuilder;
	
	@Inject
	IEObjectLookup eObjectLookup;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		List<Injector> allInjectors = reader.getAllInjectors ();
		
		allInjectors.get (0).injectMembers (this);
	}
	
	@Test
	public void testGetAllSubtypes () {
		for (Resource resource : resources) {
			EObject contents = resource.getContents ().get (0);
			if (contents instanceof ServiceModel) {
				OrganizationNamespace orgNamespace = ((ServiceModel)contents).getOrgNamespaces ().get (0);
				
				for (Type t : orgNamespace.getSubNamespaces ().get (0).getTypes ()) {
					if (t instanceof BusinessObject && ((BusinessObject)t).getName ().equals ("AbstractAddress")) {
						BusinessObject bo = (BusinessObject)t;
						List<TreeNode<IEObjectDescription>> allSubTypes = boQuery.getAllSubTypes (bo, resource.getResourceSet ());
						assertEquals (2, allSubTypes.size ());
						int subTypeCount = 0;
						for (TreeNode<IEObjectDescription> node : allSubTypes) {
							if (node.getElement ().getName ().getLastSegment ().equals ("StreetAddress")) {
								subTypeCount++;
								List<TreeNode<IEObjectDescription>> subSubTypes = node.getChildren ();
								assertEquals (1, subSubTypes.size ());
								assertEquals ("ExtStreetAddress", subSubTypes.get(0).getElement ().getName ().getLastSegment ());
							}
							if (node.getElement ().getName ().getLastSegment ().equals ("POBoxAddress"))
								subTypeCount++;
						}
						assertEquals (2, subTypeCount);
					}
				}
			}
		}
	}

}
