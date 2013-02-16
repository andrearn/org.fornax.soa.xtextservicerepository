package org.fornax.soa.profiledsl.query;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.basedsl.search.IPredicateSearch;
import org.fornax.soa.profiledsl.sOAProfileDsl.SOAProfile;

@SuppressWarnings("all")
public class ProfileQueries {
  @Inject
  private IPredicateSearch search;
  
  public SOAProfile getDefaultProfile() {
    Predicate<IEObjectDescription> _alwaysTrue = Predicates.<IEObjectDescription>alwaysTrue();
    Iterable<IEObjectDescription> _search = this.search.search("SOAProfile ", _alwaysTrue);
    Iterable<SOAProfile> _filter = Iterables.<SOAProfile>filter(_search, SOAProfile.class);
    SOAProfile _head = IterableExtensions.<SOAProfile>head(_filter);
    return _head;
  }
}
