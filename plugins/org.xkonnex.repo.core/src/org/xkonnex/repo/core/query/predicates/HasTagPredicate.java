package org.xkonnex.repo.core.query.predicates;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.xkonnex.repo.dsl.semanticsdsl.semanticsDsl.Tag;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

public class HasTagPredicate implements Predicate<IEObjectDescription> {
	
	private static final String TAGS_ATTR_NAME = "tags";
	
	private List<String> tagNames;
	private ResourceSet resourceSet;
	private boolean allTags;
	private boolean withTagsFromParent;
	private Function<Tag, String> tagToTagNameConverter;
	
	public HasTagPredicate(List<String> tagName, boolean allTags, boolean withTagsFromParent, ResourceSet resourceSet) {
		this.tagNames = tagName;
		this.resourceSet = resourceSet;
		if (tagName == null) {
			tagName = new ArrayList<String>();
		}
		this.allTags = allTags;
		this.withTagsFromParent = withTagsFromParent;
		tagToTagNameConverter = new Function<Tag, String>() {
			
			public String apply(Tag input) {
				return input.getName();
			}
		};
	}

	public boolean apply(IEObjectDescription input) {
		if (tagNames.isEmpty()) {
			return true;
		} else {
			EObject o = input.getEObjectOrProxy();
			if (o.eIsProxy()) {
				o = EcoreUtil2.resolve(o, resourceSet);
			}
			if (hasTag(o)) {
				return true;
			}
			if (withTagsFromParent) {
				while (o.eContainer() != null && o.eClass().getEStructuralFeature(TAGS_ATTR_NAME) == null) {
					o = o.eContainer();
					if (o.eIsProxy()) {
						o = EcoreUtil2.resolve(o, resourceSet);
					}
					if (hasTag(o)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private boolean hasTag(EObject o) {
		EStructuralFeature tagsFeature = o.eClass()
				.getEStructuralFeature(TAGS_ATTR_NAME);
		if (tagsFeature != null && o.eIsSet(tagsFeature)) {
			Object tagsObj = o.eGet (tagsFeature, true);
			if (tagsObj instanceof List) {
				List<Tag> tags = (List<Tag>) tagsObj;
				if (allTags) {
					List<String> assignedTagNames = Lists.transform(tags, tagToTagNameConverter);
					return assignedTagNames.containsAll(tagNames);
				} else {
					for (Tag tag : tags) {
						if (tagNames.contains(tag.getName())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

}
