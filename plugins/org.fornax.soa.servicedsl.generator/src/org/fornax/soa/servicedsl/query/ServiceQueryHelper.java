package org.fornax.soa.servicedsl.query;

import java.util.ArrayList;
import java.util.List;

import org.fornax.soa.serviceDsl.Service;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class ServiceQueryHelper {
	
	public List<List<Service>> separateMajorVersionsAsList (List<Service> services) {
		List<List<Service>> sepSvc = new ArrayList<List<Service>>();
		List<String> majorVersions = Lists.transform(services, new Function<Service, String> (){

			@Override
			public String apply(Service from) {
				final String v = from.getVersion().getVersion();
				return v.substring(0, v.indexOf("."));
			}
			
		});
		for (final String majorVer : majorVersions) {
			Iterable<Service> svcByMajorVer = Iterables.filter(services, new Predicate<Service> () {

				@Override
				public boolean apply(Service input) {
					return input.getVersion().getVersion().startsWith (majorVer);
				}
				
			});
			sepSvc.add (Lists.newArrayList(svcByMajorVer));
		}
		return sepSvc;
	}
}
