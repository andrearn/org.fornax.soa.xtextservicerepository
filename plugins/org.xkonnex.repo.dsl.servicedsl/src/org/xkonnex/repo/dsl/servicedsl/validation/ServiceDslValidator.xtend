package org.xkonnex.repo.dsl.servicedsl.validation

import com.google.common.base.Predicate
import com.google.common.collect.Iterables
import com.google.common.collect.Lists
import com.google.inject.Inject
import java.util.ArrayList
import java.util.Iterator
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.validation.Check
import org.eclipse.xtext.validation.CheckType
import org.xkonnex.repo.dsl.basedsl.ref.DependencyDescription
import org.xkonnex.repo.dsl.basedsl.search.IPredicateSearch
import org.xkonnex.repo.dsl.basedsl.validation.NameAndVersionAreUniqueValidator
import org.xkonnex.repo.dsl.basedsl.validation.PluggableChecks
import org.xkonnex.repo.dsl.profiledsl.profileDsl.ServiceBaseCategory
import org.xkonnex.repo.dsl.profiledsl.util.ReferencedStateChecker
import org.xkonnex.repo.dsl.servicedsl.service.ModelExtensions
import org.xkonnex.repo.dsl.servicedsl.service.query.type.DataObjectQueries
import org.xkonnex.repo.dsl.servicedsl.service.validation.version.BusinessObjectVersionValidator
import org.xkonnex.repo.dsl.servicedsl.service.validation.version.EnumerationVersionValidator
import org.xkonnex.repo.dsl.servicedsl.service.validation.version.ExceptionVersionValidator
import org.xkonnex.repo.dsl.servicedsl.service.validation.version.ServiceVersionValidator
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Aggregate
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.BusinessObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DataObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.DomainNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Entity
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.EnumLiteral
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Enumeration
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Exception
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.GovernanceApproval
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Operation
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Parameter
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Property
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.QueryObject
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Resource
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Service
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceDslPackage
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.ServiceRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SimpleAttribute
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.SubNamespace
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.Type
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.TypeRef
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedType
import org.xkonnex.repo.dsl.servicedsl.serviceDsl.VersionedTypeRef

@PluggableChecks(validators=#[typeof(GovernanceApprovalValidator), typeof(LifecycleStatefulReferenceValidator),
	typeof(ServiceVersionValidator), typeof(BusinessObjectVersionValidator), typeof(EnumerationVersionValidator),
	typeof(ExceptionVersionValidator), typeof(ServiceUsageValidator),
	typeof(NameAndVersionAreUniqueValidator)]) class ServiceDslValidator extends AbstractServiceDslValidator {
		@Inject package IQualifiedNameProvider nameProvider
		@Inject DataObjectQueries dataObjQuery
		@Inject package IPredicateSearch predicateSearch
		@Inject package IResourceDescriptions resourceDescriptions
		@Inject package ReferencedStateChecker referencedStateChecker
		@Inject extension ModelExtensions

		@Check def void checkNoPropertyOverrides(Property prop) {
			if (prop.eContainer() instanceof DataObject) {
				var DataObject dataObject = (prop.eContainer() as DataObject)
				if (dataObject.superObject !== null && dataObject.superObject.getType() !== null) {
					val String propName = prop.getName()
					for (DataObject superType : dataObjQuery.getAllSuperTypes(dataObject, null)) {
						var overridesSuperTypeProp = superType.properties.exists[name == propName]
						if (overridesSuperTypeProp) {
							var StringBuilder errMsg = new StringBuilder("Property ")
							errMsg.append(propName).append(" overrides an inherited property from ").append(
								superType.name).append(" version ").append(dataObject.version.getVersion())
							error(errMsg.toString(), ServiceDslPackage.Literals::PROPERTY__NAME)
						}
					}
				}
			}
		}

		@Check def void checkUniqueOperationNames(Operation op) {
			var Service svc = (op.eContainer() as Service)
			val String opName = op.getName()
			var Iterable<Operation> ops = Iterables::filter(svc.getOperations(), ([ Operation curOp |
				return curOp.getName().equals(opName)
			] as Predicate<Operation>))
			var List<Operation> opList = Lists::newArrayList(ops)
			if (opList.size() > 1) {
				var StringBuilder errMsg = new StringBuilder("Duplicate operation ")
				errMsg.append(opName).append(" in service ").append(svc.getName()).append(" version ").append(
					svc.getVersion().getVersion())
				error(errMsg.toString(), ServiceDslPackage.Literals::ABSTRACT_OPERATION__NAME)
			}
		}

		@Check def void checkUniquePropertyNames(Property prop) {
			if (prop.eContainer() instanceof BusinessObject) {
				var BusinessObject bo = (prop.eContainer() as BusinessObject)
				val String propName = prop.getName()
				var Iterable<Property> props = Iterables::filter(bo.getProperties(), ([ Property curProp |
					return curProp.getName().equals(propName)
				] as Predicate<Property>))
				var List<Property> opList = Lists::newArrayList(props)
				if (opList.size() > 1) {
					var StringBuilder errMsg = new StringBuilder("Duplicate property ")
					errMsg.append(propName).append(" in business object ").append(bo.getName()).append(" version ").
						append(bo.getVersion().getVersion())
					error(errMsg.toString(), ServiceDslPackage.Literals::PROPERTY__NAME)
				}
			}
		}

		@Check def void checkUniqueEnumLiteral(EnumLiteral enumLit) {
			if (enumLit.eContainer() instanceof Enumeration) {
				var Enumeration en = (enumLit.eContainer() as Enumeration)
				val String enumLitName = enumLit.getName()
				var Iterable<EnumLiteral> enumLiterals = Iterables::filter(en.getLiterals(), ([ EnumLiteral curEnum |
					return curEnum.getName().equals(enumLitName)
				] as Predicate<EnumLiteral>))
				var List<EnumLiteral> opList = Lists::newArrayList(enumLiterals)
				if (opList.size() > 1) {
					var StringBuilder errMsg = new StringBuilder("Duplicate enum literal ")
					errMsg.append(enumLitName).append(" in enumeration ").append(en.getName()).append(" version ").
						append(en.getVersion().getVersion())
					error(errMsg.toString(), ServiceDslPackage.Literals::ENUM_LITERAL__NAME)
				}
			}
		}

		@Check def void checkUniqueSimpleAttributeNames(SimpleAttribute prop) {
			if (prop.eContainer() instanceof Exception) {
				var Exception exc = (prop.
					eContainer() as Exception)
				val String propName = prop.getName()
				var Iterable<SimpleAttribute> props = Iterables::filter(exc.getProperties(),
					([ SimpleAttribute curProp |
						return curProp.getName().equals(propName)
					] as Predicate<SimpleAttribute>))
				var List<SimpleAttribute> opList = Lists::newArrayList(props)
				if (opList.size() > 1) {
					var StringBuilder errMsg = new StringBuilder("Duplicate attribute ")
					errMsg.append(propName).append(" in exception ").append(exc.getName()).append(" version ").append(
						exc.getVersion().getVersion())
					error(errMsg.toString(), ServiceDslPackage.Literals::SIMPLE_ATTRIBUTE__NAME)
				}
			}
		}

		@Check def void checkUniqueParamName(Parameter param) {
			var Operation op = (param.eContainer() as Operation)
			if (param.eContainingFeature().getName().equals("parameters")) {
				val String paramName = param.getName()
				var Iterable<Parameter> params = Iterables::filter(op.getParameters(), ([ Parameter curParam |
					return curParam.getName().equals(paramName)
				] as Predicate<Parameter>))
				var List<Parameter> paramList = Lists::newArrayList(params)
				if (paramList.size() > 1) {
					var StringBuilder errMsg = new StringBuilder("Duplicate parameter ")
					errMsg.append(paramName).append(" in operation ").append(op.getName())
					error(errMsg.toString(), ServiceDslPackage.Literals::PARAMETER__NAME)
				}
			} else if (param.eContainingFeature().getName().equals("return")) {
				val String paramName = param.getName()
				var Iterable<Parameter> params = Iterables::filter(op.getReturn(), ([ Parameter curParam |
					return curParam.getName().equals(paramName)
				] as Predicate<Parameter>))
				var List<Parameter> paramList = Lists::newArrayList(params)
				if (paramList.size() > 1) {
					var StringBuilder errMsg = new StringBuilder("Duplicate return parameter ")
					errMsg.append(paramName).append(" in operation ").append(op.getName())
					error(errMsg.toString(), ServiceDslPackage.Literals::PARAMETER__NAME)
				}
			}
		}

		// Call semantics
		@Check(CheckType::NORMAL) def void checkEntityServicesDontCallProcessServices(ServiceRef svcRef) {
			var EObject o = svcRef.eContainer().eContainer()
			if (o instanceof Service) {
				var Service s = (svcRef.eContainer().eContainer() as Service)
				if (s.getCategory() !== null && s.getCategory().getBaseCategory() === ServiceBaseCategory::ENTITY) {
					if (svcRef.getService().getCategory().getBaseCategory() === ServiceBaseCategory::PROCESS) {
						error("Business entity services may not call business process services",
							ServiceDslPackage.Literals::ABSTRACT_OPERATION__REQUIRES)
					}
				}
			}
		}

		// @Check(CheckType.NORMAL)
		// public void checkEntityServicesDontCallActivityServices(ServiceRef svcRef) {
		// EObject o = svcRef.eContainer().eContainer();
		// if (o instanceof Service) {
		// Service s = (Service) o;
		// if (s.getCategory() != null && s.getCategory().getBaseCategory () == ServiceBaseCategory.ACTIVITY) {
		// if (svcRef.getService().getCategory()!= null && svcRef.getService().getCategory().getBaseCategory () == ServiceBaseCategory.PROCESS) {
		// error("Business entity services may not call business activity services",
		// ServiceDslPackage.Literals.OPERATION__REQUIRES);
		// }
		// }
		// }
		// }
		//
		// @Check(CheckType.NORMAL)
		// public void checkEntityServicesDontCallRuleServices(ServiceRef svcRef) {
		// EObject o = svcRef.eContainer().eContainer();
		// if (o instanceof Service) {
		// Service s = (Service) svcRef.eContainer().eContainer();
		// if (s.getCategory() != null && s.getCategory().getBaseCategory () == ServiceBaseCategory.ACTIVITY) {
		// if (svcRef.getService().getCategory()!= null && svcRef.getService().getCategory().getBaseCategory () == ServiceBaseCategory.PROCESS) {
		// error("Business entity services may not call business rule services",
		// ServiceDslPackage.Literals.OPERATION__REQUIRES);
		// }
		// }
		// }
		// }
		//
		// @Check
		// public void checkProvidedContractOnPrivateServiceOnly(Service s) {
		// if (s.getProvidedContractUrl() != null
		// && s.getVisibility() != Visibility.PRIVATE)
		// error("Only private services may provide a predefined contract such as a WSDL",
		// ServiceDslPackage.Literals.SERVICE__PROVIDED_CONTRACT_URL);
		// }
		@Check def void checkProvidedDefOnInternalBOOnly(VersionedType o) {
			if (o.getProvidedContractUrl() !== null && o.eContainer() instanceof DomainNamespace)
				error(
					'''Only internal «getObjectTypeName(o)»s may provide a predefined definition such as an XSD'''.
						toString, ServiceDslPackage.Literals::VERSIONED_TYPE__PROVIDED_CONTRACT_URL)
		}

		@Check def void checkProvidedDefOnInternalEnumOnly(Enumeration o) {
			if (o.getProvidedContractUrl() !== null && o.eContainer() instanceof DomainNamespace)
				error(
					'''Only internal «getObjectTypeName(o)»s may provide a predefined definition such as an XSD'''.
						toString, ServiceDslPackage.Literals::VERSIONED_TYPE__PROVIDED_CONTRACT_URL)
		}

		@Check def void checkProvidedDefOnInternalEnumOnly(Exception o) {
			if (o.getProvidedContractUrl() !== null && o.eContainer() instanceof DomainNamespace)
				error("Only internal exceptions may provide a predefined definition such as an XSD or WSDL",
					ServiceDslPackage.Literals::VERSIONED_TYPE__PROVIDED_CONTRACT_URL)
		}

		// Consistency
		@Check def void checkBusinessKeyIsMandatory(Property p) {
			if (p.isIsBusinessKey() && p.isOptional())
				error("A business-key attribute may not be optional.",
					ServiceDslPackage.Literals::PROPERTY__IS_BUSINESS_KEY)
		}

		@Check def void checkNoDirectNamespaceCycle(Property p) {
			if (p.getType() instanceof VersionedTypeRef) {
				val EObject ownNs = p.eContainer().eContainer()
				var VersionedType refType = ((p.getType() as VersionedTypeRef)).getType()
				var refNsTypes = ((refType.eContainer() as SubNamespace)).types
				for (Type refNsType : refNsTypes) {
					if (!refNsType.equals(p.eContainer())) {
						if (refNsType instanceof BusinessObject && !ownNs.equals(refNsType.eContainer())) {
							var BusinessObject refNsBO = (refNsType as BusinessObject)
							for (Property refNsProp : refNsBO.getProperties()) {
								var TypeRef refNsPropType = refNsProp.getType()
								if (refNsPropType instanceof VersionedTypeRef) {
									var VersionedType refNsPropVerType = ((refNsPropType as VersionedTypeRef)).getType()
									if (ownNs.equals(refNsPropVerType.eContainer())) {
										warning(
											"The property references a type from another namespace that references a type from this namespace leading to a dependency cycle",
											ServiceDslPackage.Literals::PROPERTY__TYPE)
										return;
									}
								}
							}
						}
					}
				}
			}
		}

		@Check(CheckType::NORMAL) def void checkNoTransitiveNamespaceCycle(Property p) {
			if (p.getType() instanceof VersionedTypeRef) {
				var VersionedType targetType = ((p.getType() as VersionedTypeRef)).getType()
				if (!targetType.eContainer().equals(p.eContainer().eContainer())) {
					var DependencyDescription transDepsRoot = dataObjQuery.
						getTransitiveDependencies(p, true, true, null, null)
					var boolean hasTransitImport = false
					var boolean rootVisited = false
					var List<String> foundPaths = new ArrayList<String>()
					if (transDepsRoot !== null) {
						for (DependencyDescription dep : transDepsRoot) {
							if (rootVisited) {
								var VersionedType verType = dataObjQuery.toVersionedType(dep.getTarget(), p.eResource())
								if (verType !== null) {
									if (!nameProvider.getFullyQualifiedName(p.eContainer().eContainer()).equals(
										dep.getContainer().getName())) {
										hasTransitImport = true
									}
									var List<QualifiedName> otherTypeNsRefersToNs = dataObjQuery.
										getOtherTypeNsRefsToNs(verType, (p.eContainer().eContainer() as SubNamespace))
									if (hasTransitImport && !otherTypeNsRefersToNs.isEmpty()) {
										var StringBuilder msg = new StringBuilder()
										var String path = getReferrerDependencyPath(dep, new StringBuilder())
										if (!foundPaths.contains(path)) {
											foundPaths.add(path)
											msg.append('''The property «p.getName()» references a type from another namespace that leads to an import cycle via:
	'''.toString)
											msg.append(path)
											if (otherTypeNsRefersToNs !== null && !otherTypeNsRefersToNs.isEmpty()) {
												msg.append("\n for the following business object properties in namespace ")
												msg.append(dep.getContainer().getName().toString())
												msg.append(":\n")
												var Iterator<QualifiedName> otherTypeNsRefersToNsIt = otherTypeNsRefersToNs.
													iterator()
												while (otherTypeNsRefersToNsIt.hasNext()) {
													var QualifiedName name = otherTypeNsRefersToNsIt.next()
													msg.append(getPropertyShortName(name))
													if (otherTypeNsRefersToNsIt.hasNext()) {
														msg.append(", ")
													}
												}
											}
											warning(msg.toString(), ServiceDslPackage.Literals::PROPERTY__TYPE)
										}
									}
								}
							} else {
								rootVisited = true
							}
						}
					}
				}
			}
		}

		@Check def package void checkPropertyLessBOisAbstractOrProposal(BusinessObject bo) { // if (BusinessObjectQuery.getAllVisibleProperties(bo).isEmpty())
			// if (bo.getState() == LifecycleState.PROPOSED && !bo.isAbstract())
			// warning ("The businessObject " + bo.getName() + " version " + bo.getVersion().getVersion() + " has no own or inherited properties! As the businessObject is treaded as an proposal this is toleraed. However, it must have properties after leaving the proposal state or must be declared abstract!", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
			// else if (!bo.isAbstract())
			// error ("The businessObject " + bo.getName() + " version " + bo.getVersion().getVersion() + " has no own or inherited properties! The businessObject must be declared abstract!", ServiceDslPackage.Literals.VERSIONED_TYPE__NAME);
		}

		def private String getObjectTypeName(EObject o) {
			if(o instanceof BusinessObject) return "businessObject" else if(o instanceof QueryObject) return "queryObject" else if(o instanceof Entity) return "entity" else if(o instanceof Aggregate) return "aggregate" else if(o instanceof Enumeration) return "enum" else if(o instanceof Exception) return "exception" else if(o instanceof Service) return "service" else if(o instanceof Resource) return "resource" else return ""
		}

		def private String getContainingObjectTypeName(EObject ele) {
			var EObject o = ele.eContainer()
			if(o instanceof BusinessObject) return "businessObject" else if(o instanceof QueryObject) return "queryObject" else if(o instanceof Entity) return "entity" else if(o instanceof Aggregate) return "aggregate" else if(o instanceof Enumeration) return "enum" else if(o instanceof Exception) return "exception" else if(o instanceof Service) return "service" else if(o instanceof Resource) return "resource" else return ""
		}

		def private String getPubCanocicalName(GovernanceApproval g) {
			return "canonical"
		}

		def private String getReferrerDependencyPath(DependencyDescription leaf, StringBuilder path) {
			var pathVar = path
			if(pathVar === null) pathVar = new StringBuilder()
			if (pathVar.length() > 0) {
				pathVar.insert(0, " -> ")
			}
			pathVar.insert(0, leaf.getTarget().getName().getLastSegment())
			if (leaf.getReferrer() !== null) {
				getReferrerDependencyPath(leaf.getReferrer(), pathVar)
			}
			return pathVar.toString()
		}

		def private String getPropertyShortName(QualifiedName propName) {
			var StringBuilder shortName = new StringBuilder()
			if (propName.getSegmentCount() > 2) {
				for (var int i = 0; i < propName.getSegmentCount(); i++) {
					if (i > propName.getSegmentCount() - 3) {
						shortName.append(propName.getSegment(i))
						if(i < propName.getSegmentCount() - 1) shortName.append(".")
					}
				}
				return shortName.toString()
			}
			return propName.toString()
		}

		def DataObjectQueries getDataObjectQuery() {
			return dataObjQuery
		}

		def void setQoQuery(DataObjectQueries dataObjectQuery) {
			this.dataObjQuery = dataObjectQuery
		}
	}
	