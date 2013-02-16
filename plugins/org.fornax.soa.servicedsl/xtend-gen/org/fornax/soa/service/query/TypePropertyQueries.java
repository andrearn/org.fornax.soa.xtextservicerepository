package org.fornax.soa.service.query;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.fornax.soa.serviceDsl.BusinessObject;
import org.fornax.soa.serviceDsl.Property;

@SuppressWarnings("all")
public class TypePropertyQueries {
  public List<Property> getAllBOKeys(final BusinessObject bo) {
    EList<Property> _properties = bo.getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _or = false;
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          if (_isIsBusinessKey) {
            _or = true;
          } else {
            boolean _isIsProvidedKey = e.isIsProvidedKey();
            _or = (_isIsBusinessKey || _isIsProvidedKey);
          }
          return Boolean.valueOf(_or);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    List<Property> _list = IterableExtensions.<Property>toList(_filter);
    return _list;
  }
  
  public List<Property> getBOBusinessKeys(final BusinessObject bo) {
    EList<Property> _properties = bo.getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsBusinessKey = e.isIsBusinessKey();
          return Boolean.valueOf(_isIsBusinessKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    List<Property> _list = IterableExtensions.<Property>toList(_filter);
    return _list;
  }
  
  public List<Property> getBOProvidedKeys(final BusinessObject bo) {
    EList<Property> _properties = bo.getProperties();
    final Function1<Property,Boolean> _function = new Function1<Property,Boolean>() {
        public Boolean apply(final Property e) {
          boolean _isIsProvidedKey = e.isIsProvidedKey();
          return Boolean.valueOf(_isIsProvidedKey);
        }
      };
    Iterable<Property> _filter = IterableExtensions.<Property>filter(_properties, _function);
    List<Property> _list = IterableExtensions.<Property>toList(_filter);
    return _list;
  }
}
