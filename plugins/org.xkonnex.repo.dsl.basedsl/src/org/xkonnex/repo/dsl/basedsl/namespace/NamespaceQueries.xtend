package org.xkonnex.repo.dsl.basedsl.namespace

import java.util.List
import org.xkonnex.repo.dsl.basedsl.baseDsl.Namespace

class NamespaceQueries {
	
	def List<Namespace> getNamespacePath (Namespace ns) {
		val List<Namespace> nsList = newLinkedList(ns)
		return getNamespacePath(nsList)
	}
	
	private def List<Namespace> getNamespacePath (List<Namespace> domList) {
		if (domList.head()?.eContainer instanceof Namespace) {
			domList.add (0, domList.head().eContainer as Namespace) 
			getNamespacePath (domList);
			return domList;
		} else { 
			return domList.filter (typeof (Namespace)).toList();
		}
	}
	
}