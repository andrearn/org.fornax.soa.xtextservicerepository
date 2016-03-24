/**
 * Based on concepts from org.springframework.beans.BeanUtils and
 * org.springframework.util.ClassUtils
 */
package org.xkonnex.repo.dsl.basedsl.util

import java.util.Date
import java.net.URI
import java.net.URL
import java.util.Locale
import java.beans.PropertyDescriptor
import java.lang.reflect.Modifier
import java.beans.Introspector
import java.util.Collection
import java.util.List

/**
 * Merger for JavaBeans regarding their property values. The JavaBeans should 
 * not use primitive typed properties, to support proper override semantics 
 * as proper null values are required to determine whether the respective 
 * source property value shall be ignored.
 */
class JavaBeanMerger {

	/**
	 * Merge property values of the source object into the target object if the 
	 * properties value is not null. Otherwise the values in the target bean will be 
	 * overwritten.
	 * 
	 * @param source Source object
	 * @param target Target object into which the values from source object will be merged
	 * @returns the merged target object 
	 */
	def <T> T merge(T source, T target) {
		val actualEditable = target.getClass();
		val PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);

		for (targetPd : targetPds) {
			val writeMethod = targetPd.getWriteMethod();
			if (writeMethod != null) {
				val sourcePd = getPropertyDescriptor(source.class, targetPd.name);
				if (sourcePd != null) {
					val readMethod = sourcePd.getReadMethod();
					val targetReadMethod = targetPd.getReadMethod();
					if (readMethod != null &&
						isAssignable (writeMethod.parameterTypes.get(0), readMethod.getReturnType())) {
						try {
							if (!Modifier.isPublic (readMethod.getDeclaringClass().getModifiers())) {
								readMethod.setAccessible(true);
							}
							if (!Modifier.isPublic (targetReadMethod.getDeclaringClass().getModifiers())) {
								targetReadMethod.setAccessible(true);
							}
							val value = readMethod.invoke(source);
							val targetValue = targetReadMethod.invoke(target)
							if ((isCollectionType (targetPd.propertyType) || isSimpleValueType(targetPd.propertyType)) &&
								value != null) {
								if (!Modifier.isPublic (writeMethod.getDeclaringClass().getModifiers())) {
									writeMethod.setAccessible(true);
								}
								writeMethod.invoke (target, value);
							} else if (!isCollectionType (targetPd.propertyType) &&
								!isSimpleValueType (targetPd.propertyType) && value != null) {
								merge(value, targetValue)
							}
						} catch (Throwable ex) {
							throw new RuntimeException(
								"Could not merge property '" + targetPd.getName() + "' from source to target", ex);
						}
					}
				}
			}
		}
		target as T
	}
	
	def <T> T merge (List<T> bottomUpBeanHierarchy) {
		var T mergedBean = bottomUpBeanHierarchy.get(0)
		for (var int i=1; i < bottomUpBeanHierarchy.size; i++) {
			mergedBean = merge(bottomUpBeanHierarchy.get(i), mergedBean)
		}
		return mergedBean
	}

	private def boolean isAssignable(Class<?> lhsType, Class<?> rhsType) {
		if (lhsType.isAssignableFrom(rhsType)) {
			return true;
		}
		return false;
	}

	private def PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {
		val propDescs = getPropertyDescriptors(clazz)
		for (pd : propDescs) {
			if (pd.name === propertyName)
				return pd
		}
		return null
	}

	private def PropertyDescriptor[] getPropertyDescriptors(Class<?> clazz) {
		val beanInfo = Introspector.getBeanInfo(clazz)
		beanInfo.propertyDescriptors
	}

	private def boolean isSimpleValueType(Class<?> clazz) {
		return (isPrimitiveOrWrapper(clazz) || clazz.isEnum() || typeof(CharSequence).isAssignableFrom(clazz) ||
			typeof(Number).isAssignableFrom(clazz) || typeof(Date).isAssignableFrom(clazz) || typeof(URI) == clazz ||
			typeof(URL) == clazz || typeof(Locale) == clazz || typeof(Class) == clazz);
	}

	private def boolean isCollectionType(Class<?> clazz) {
		return Collection.isAssignableFrom(clazz)
	}

	private def boolean isPrimitiveOrWrapper(Class<?> clazz) {
		val isPrimitive = clazz.isPrimitive
		if (isPrimitive) {
			return true
		} else if (typeof(Long) == clazz || typeof(Integer) == clazz || typeof(Short) == clazz ||
			typeof(Byte) == clazz || typeof(Double) == clazz || typeof(Float) == clazz || typeof(Character) == clazz ||
			typeof(Boolean) == clazz) {
			return true
		} else {
			return false
		}
	}

}
