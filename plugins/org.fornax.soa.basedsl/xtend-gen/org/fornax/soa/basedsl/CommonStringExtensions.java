package org.fornax.soa.basedsl;

import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class CommonStringExtensions {
  public String stripCommentBraces(final String s) {
    String _replaceFirst = s.replaceFirst("\\/\\*", "");
    String _replaceFirst_1 = _replaceFirst.replaceFirst("\\*\\/", "");
    String _replaceAll = _replaceFirst_1.replaceAll("\\n(\\t)+(\\s)*(\\*)+", "\n\t");
    return _replaceAll;
  }
  
  public String stripXtextEscapes(final String s) {
    String _replaceFirst = s.replaceFirst("\\^", "");
    return _replaceFirst;
  }
  
  public String stripTrailingSlash(final String s) {
    String _xifexpression = null;
    boolean _endsWith = s.endsWith("/");
    if (_endsWith) {
      int _length = s.length();
      int _minus = (_length - 1);
      String _substring = s.substring(0, _minus);
      _xifexpression = _substring;
    } else {
      _xifexpression = s;
    }
    return _xifexpression;
  }
  
  public Integer asInteger(final String s) {
    Integer _xtrycatchfinallyexpression = null;
    try {
      int _parseInt = Integer.parseInt(s);
      _xtrycatchfinallyexpression = _parseInt;
    } catch (final Throwable _t) {
      if (_t instanceof Exception) {
        final Exception ex = (Exception)_t;
        _xtrycatchfinallyexpression = null;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
