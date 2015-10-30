package org.xkonnex.repo.dsl.servicedsl.test.query;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.xkonnex.repo.dsl.basedsl.resource.IEObjectDescriptionBuilder;
import org.xkonnex.repo.dsl.basedsl.search.IEObjectLookup;
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.OrganizationNamespace;
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceModel;
import org.xkonnex.repo.test.AbstractModelBasedTest;

import com.google.inject.Inject;
import com.google.inject.Injector;

@RunWith(XtextRunner.class)
public class ModelBusinessObjectQueryTest extends AbstractModelBasedTest {

	@Inject
	private
	DataObjectQueries boQuery;
	
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
				
//				for (Type t : orgNamespace.getSubNamespaces ().get (0).getTypes ()) {
//					if (t instanceof BusinessObject && ((BusinessObject)t).getName ().equals ("AbstractAddress")) {
//						BusinessObject bo = (BusinessObject)t;
//						List<TreeNode<IEObjectDescription>> allSubTypes = boQuery.getAllSubTypes (bo, reader.getReaderResourceSet());
//						assertEquals (2, allSubTypes.size ());
//						int subTypeCount = 0;
//						for (TreeNode<IEObjectDescription> node : allSubTypes) {
//							if (node.getElement ().getName ().getLastSegment ().equals ("StreetAddress")) {
//								subTypeCount++;
//								List<TreeNode<IEObjectDescription>> subSubTypes = node.getChildren ();
//								assertEquals (1, subSubTypes.size ());
//								assertEquals ("ExtStreetAddress", subSubTypes.get(0).getElement ().getName ().getLastSegment ());
//							}
//							if (node.getElement ().getName ().getLastSegment ().equals ("POBoxAddress"))
//								subTypeCount++;
//						}
//						assertEquals (2, subTypeCount);
//					}
//				}
			}
		}
	}

}