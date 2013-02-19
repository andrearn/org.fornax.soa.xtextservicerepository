package org.fornax.soa.servicerepo.ui.wizards

import org.eclipse.xtext.generator.IFileSystemAccess

class ServiceRepositoryNewProjectGenerator {
	
	def generateProject (IFileSystemAccess fsa) {
		generateProfile (fsa)
		generateBusinessObjectViewMap (fsa)
		generateBusinessObjectViewStyle (fsa)
		generateSeriveViewMap (fsa)
		generateServiceViewStyle (fsa)
	}
	
	def generateProfile (IFileSystemAccess fsa) {
		val content = '''
			datatype int
			datatype byte
			datatype long
			datatype float
			datatype double
			datatype string
			datatype char
			datatype date
			datatype datetime
			datatype boolean
			datatype decimal
			datatype base64Binary
			datatype binary
			datatype anyType
			
			soa-profile ExampleOrgSOA {
				scope "Example.org"
				
				lifecycle DefaultLifecycle {
					initial state proposed {
						qualifies-for Local-Environment
						-> defined 
					}
					state defined {
						qualifies-for Local-Environment, Development-Environment
						-> development
						-> proposed
					}
					state development {
						qualifies-for Local-Environment, Development-Environment
						-> test
						-> proposed
					}
					state test {
						qualifies-for Local-Environment, Development-Environment, Test-Environment
						-> productive
						-> development
						-> proposed
					}
					state productive {
						qualifies-for Local-Environment, Development-Environment, Test-Environment, Staging-Environment, Production-Environment
						-> deprecated
						-> test
						-> proposed
					}
					state deprecated {
						qualifies-for Local-Environment, Development-Environment, Test-Environment, Staging-Environment, Production-Environment
						-> retired
						-> productive
						-> proposed
					}
					end state retired {
						-> proposed
					}
				}
				
				
				service-categories {
					^activity base-category activity
					^entity base-category entity
					^process base-category process
					^rule base-category rule
					^utility base-category utility
				}
			
				// define messaging rules like message headers here in the messaging section
				
				
				design-rules {
					
					internal-namespace-rule internal {
						internal-qualifier must-contain-internal-qualifier
						qualifying-name internal
					}
					
					types {
						extendable-properties
						extendable-XML-attributes
						allow-enums
						allow-inheritance
						allow-polymorphism
					}
					
					services {
						operations {
							allow-polymorphism
						}
					}	
				}
				
				// major version number is part of the namespace
				versioning-strategy namespace-based
			}
		'''
		fsa.generateFile("model/profile.profdsl", content)
	}
	
	def generateSeriveViewMap (IFileSystemAccess fsa) {
		val content='''
			import org.fornax.soa.serviceDsl.*
			
			diagram ServiceDiagram type SubNamespace {
				
				node ServiceNode for each services {
					label Name for name
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					
					node OperationNode for operations {
						label Name for each map (op|op.name + "(" + {if (op.parameters?.size < 4) {op.parameters.map(p|p.name).join(",")} else "..."} + ")")
					}
					hidden edge BOEdge for each 
						operations.map(op | op.parameters).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof BusinessObject)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call BusinessObjectNode for (this as BusinessObject)
					}
					hidden edge EnumEdge for each 
						operations.map(op | op.parameters).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof org.fornax.soa.serviceDsl.Enumeration)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call EnumNode for (this as org.fornax.soa.serviceDsl.Enumeration)
					}
					
					hidden edge BOReturnEdge for each 
						operations.map(op | op.^return).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof BusinessObject)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call BusinessObjectNode for (this as BusinessObject)
					}
					hidden edge EnumReturnEdge for each 
						operations.map(op | op.^return).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof org.fornax.soa.serviceDsl.Enumeration)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call EnumNode for (this as org.fornax.soa.serviceDsl.Enumeration)
					}
					edge ExceptionEdge for each 
						operations.map(op | op.^throws).flatten.filter(t|t.eContainer.eContainer.eContainer.eContainer == t.exception.eContainer).map(e|e.exception).toSet {
						=> ref HiddenExceptionNode for this
					}
					hidden edge HiddenExceptionEdge for each
						operations.map(op | op.^throws).flatten.filter(t|t.eContainer.eContainer.eContainer.eContainer != t.exception.eContainer).map(e|e.exception).toSet {
						=> call HiddenExceptionNode for this
					}
				}
			
				node BusinessObjectNode for this as BusinessObject {
					label Name for name
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type.name)
					} unless properties.empty
					
					
					edge ReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							((p.^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.BusinessObject).eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref BusinessObjectNode for ((^type as VersionedTypeRef).^type as BusinessObject)
						label HiddenEdgeLabel for name
					} 
					edge EnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof org.fornax.soa.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef).^type as org.fornax.soa.serviceDsl.Enumeration)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref EnumNode for ((^type as VersionedTypeRef).^type as org.fornax.soa.serviceDsl.Enumeration)
						label EdgeLabel for name
					}
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) &&
							((p.^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.BusinessObject)?.eContainer != p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> call BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name
					} 
					hidden edge HiddenEnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.fornax.soa.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)?.eContainer != p.eContainer.eContainer && 
							eContainer == p.eContainer.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef).^type as org.fornax.soa.serviceDsl.Enumeration)
						label EdgeLabel for name
					}
					
					hidden edge InhertanceEdge for superBusinessObject?.^type {
						=> call BusinessObjectNode for this
					} unless superBusinessObject == null
				} unless !(this instanceof BusinessObject)
			
			
				node EnumNode for this as org.fornax.soa.serviceDsl.Enumeration {
					label EnumLabel  for "<<Enum>>"
					label Name for name
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					hidden node EnumLiteralNode for literals {
						label Label for each map(lit|lit.name)
					} unless literals.empty
				} unless !(this instanceof org.fornax.soa.serviceDsl.Enumeration)
				
				node HiddenExceptionNode for this as org.fornax.soa.serviceDsl.Exception {
					label ExceptionLabel for "<<Exception>>"
					label Name for name	
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type.name)
					} unless properties.filter (up | up.^type instanceof DataTypeRef).nullOrEmpty
					hidden edge ReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							((p.^type as VersionedTypeRef)?.^type as BusinessObject).eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> call BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label EdgeLabel for name
					}
					hidden edge EnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.fornax.soa.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration).eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)
						label EdgeLabel for name
					}
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							(((p.^type as VersionedTypeRef)?.^type) as BusinessObject).eContainer != p.eContainer?.eContainer) {
						=> call BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name
					}
					 
					edge InhertanceEdge for superException?.^exception {
						=> call HiddenExceptionNode for this
					} unless superException == null
				} unless !(this instanceof org.fornax.soa.serviceDsl.Exception)
			}
		'''
		fsa.generateFile("view/ServiceView.gvmap", content)
	}
	
	def generateServiceViewStyle (IFileSystemAccess fsa) {
		val content = '''
			import org.eclipse.xtext.graphview.shape.*
			import org.eclipse.xtext.graphview.layout.*  
			import org.eclipse.xtext.graphview.behavior.layout.*  
			import org.eclipse.draw2d.*
			import org.eclipse.swt.SWT
			import ServiceDiagram.*
			
			stylesheet ServiceDiagram for ServiceDiagram
			
			style ServiceDiagram {
				autoLayoutManager = new KielerAutoLayout() 
			}
			
			style ServiceNode as RoundedRectangleShape { 
				backgroundColor = color(#d8ffd8)
			}
			
			
			style ServiceNode { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD + SWT::NONE
				)
			}
			style ServiceNode.Version { 
				font = font("Helvetica", 12, SWT::CENTER 
				)
			}
			
			style ServiceNode.OperationNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			
			
			style HiddenExceptionNode as RoundedRectangleShape { 
				backgroundColor = color(#f8e8d8)
			}
			style HiddenExceptionNode { 
				font = font("Helvetica", 12, SWT::CENTER 
				)
			}
			style HiddenExceptionNode.ExceptionLabel { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD 
				)
			}
			style HiddenExceptionNode.Name { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD 
				)
			}
			style HiddenExceptionNode.PropertiesNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			
			
			style BusinessObjectNode { 
				backgroundColor = color(#dfeff8)
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD + 
					(if (element.abstract) SWT::ITALIC else SWT::NONE)
				)
			}
			style BusinessObjectNode.Version { 
				font = font("Helvetica", 12, SWT::CENTER 
				)
			}
			
			style BusinessObjectNode.PropertiesNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style BusinessObjectNode.HiddenEnumReferenceEdge {
				lineStyle = SWT::LINE_DASH
				foregroundColor = color(#cccccc)
			}
			
			style BusinessObjectNode.InhertanceEdge as ConnectionShape  {
				var arrow = new PolygonDecoration()
				arrow.setScale(8,8)
				arrow.backgroundColor = color(#ffffff)
				arrow.lineWidth = 2
				targetDecoration = arrow 
			}
			
			style EnumNode as RoundedRectangleShape { 
				backgroundColor = color(#fcefc8)
			}
			style EnumNode {
				opaque = true
				font = font("Helvetica", 12, SWT::CENTER 
				)
			}
			style EnumNode.EnumLabel { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD 
				)
			}
			style EnumNode.Name { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD 
				)
			}
			style EnumNode.EnumLiteralNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
		'''
		fsa.generateFile("view/ServiceView.gvstyle", content)
	}
	
	def generateBusinessObjectViewMap (IFileSystemAccess fsa) {
		val content = '''
			import org.fornax.soa.serviceDsl.*

			diagram BusinessObjectDiagram type SubNamespace {
				
				node BusinessObjectNode for each types.filter (typeof (BusinessObject)) {
					label Name for name
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type?.name + if (p.^type instanceof DataTypeRef && (p.^type as DataTypeRef)?.many)" []" else "") 
					} unless properties.empty
					
					
					edge ReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							((p.^type as VersionedTypeRef)?.^type as BusinessObject)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label EdgeLabel for name + if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) " *" else "" 
					}
					edge EnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.fornax.soa.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration).eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref EnumNode for ((^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)
						label EdgeLabel for name + if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) " *" else "" 
					}
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							(((p.^type as VersionedTypeRef)?.^type) as BusinessObject)?.eContainer != p?.eContainer.eContainer) {
						=> call HiddenBusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name + if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) " *" else "" 
					}
					 
					edge InhertanceEdge for superBusinessObject?.^type {
						=> call BusinessObjectNode for this
					} unless superBusinessObject == null
				}
				
				 
				node HiddenBusinessObjectNode for this as BusinessObject {
					label Name for name
					label PackageName for "from " + if (eContainer.eContainer instanceof OrganizationNamespace) {
						if ((eContainer.eContainer as OrganizationNamespace).prefix != null)
							(eContainer.eContainer as OrganizationNamespace).prefix + "." + (eContainer as SubNamespace).name
						else
							(eContainer.eContainer as OrganizationNamespace).name + "." + (eContainer as SubNamespace).name
					} else {
						(eContainer as SubNamespace).name
					}
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type.name + if (p.^type instanceof DataTypeRef && (p.^type as DataTypeRef)?.many)" []" else "")
					} unless properties.empty
					
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject)) {
						=> call HiddenBusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name + if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) " *" else "" 
					}
					hidden edge HiddenEnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.fornax.soa.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)
						label EdgeLabel for name + if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) " *" else "" 
					}
					
					hidden edge HiddenInhertanceEdge for superBusinessObject?.^type {
						=> call BusinessObjectNode for this
					} unless superBusinessObject == null
				} unless !(this instanceof BusinessObject)
			
				node ExceptionNode for each exceptions {
					label ExceptionLabel for "<<Exception>>"
					label Name for name	
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type?.name)
					} unless properties.filter (up | up.^type instanceof DataTypeRef).nullOrEmpty
					edge ReferenceEdge for each 
						properties.filter (p | (p?.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							((p.^type as VersionedTypeRef)?.^type as BusinessObject)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label EdgeLabel for name + if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) " *" else "" 
					}
					edge EnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof org.fornax.soa.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef).^type as org.fornax.soa.serviceDsl.Enumeration)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref EnumNode for ((^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)
						label EdgeLabel for name + if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) " *" else "" 
					}
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							(((p.^type as VersionedTypeRef)?.^type) as BusinessObject)?.eContainer != p.eContainer?.eContainer) {
						=> call HiddenBusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name
					}
					hidden edge HiddenEnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.fornax.soa.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)?.eContainer != p.eContainer.eContainer && 
							eContainer == p.eContainer.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef)?.^type as org.fornax.soa.serviceDsl.Enumeration)
						label EdgeLabel for name
					}
					 
					edge InhertanceEdge for superException?.^exception {
						=> call ExceptionNode for this
					} unless superException == null
				}
				
				
				node EnumNode for each types.filter(typeof (org.fornax.soa.serviceDsl.Enumeration)) {
					label EnumLabel  for "<<Enum>>"
					label Name for name
					label Version for "[v" + version?.version + ", " + state?.name + "]"
					hidden node EnumLiteralNode for literals {
						label Label for each map(lit|lit?.name)
					} unless literals.empty
				}
			}
		'''
		fsa.generateFile("view/BusinessObjectView.gvmap", content)
	}
	def generateBusinessObjectViewStyle (IFileSystemAccess fsa) {
		val content = '''
			import org.eclipse.xtext.graphview.shape.*
			import org.eclipse.xtext.graphview.layout.*  
			import org.eclipse.xtext.graphview.behavior.layout.*  
			import org.eclipse.draw2d.*
			import org.eclipse.swt.SWT
			import BusinessObjectDiagram.*
			
			stylesheet BusinessObjectDiagram for BusinessObjectDiagram
			
			style BusinessObjectDiagram {
				autoLayoutManager = new KielerAutoLayout() 
			}
			
			style BusinessObjectNode as RoundedRectangleShape { 
				backgroundColor = color(#d8e8f8)
			}
			
			
			style BusinessObjectNode { 
				font = font("Helvetica", 12, SWT::LEFT + 
					(if (element.abstract) SWT::ITALIC else SWT::NONE)
				)
			}
			style BusinessObjectNode.Name { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD	)
			}
			style BusinessObjectNode.Version { 
				font = font("Helvetica", 12, SWT::CENTER 
				)
			}
			
			style BusinessObjectNode.PropertiesNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style BusinessObjectNode.EnumReferenceEdge {
				lineStyle = SWT::LINE_DASH
				foregroundColor = color(#cccccc)
			}
			
			
			style HiddenBusinessObjectNode as RoundedRectangleShape { 
				backgroundColor = color(#d8e8f8)
			}
			style HiddenBusinessObjectNode { 
				font = font("Helvetica", 12, SWT::CENTER +
					(if (element.abstract) SWT::ITALIC else SWT::NONE)
				)
			}
			style HiddenBusinessObjectNode.Name { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD 
				)
			}
			
			style HiddenBusinessObjectNode.PropertiesNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			
			style BusinessObjectNode.HiddenReferenceEdge.HiddenEdgeLabel {
				connectionAlignment = ConnectionLocator::TARGET
			}
			style HiddenBusinessObjectNode.HiddenEnumReferenceEdge {
				lineStyle = SWT::LINE_DASH
				foregroundColor = color(#cccccc)
			}
			
			style BusinessObjectNode.InhertanceEdge as ConnectionShape  {
				var arrow = new PolygonDecoration()
				arrow.setScale(8,8)
				arrow.backgroundColor = color(#ffffff)
				arrow.lineWidth = 2
				targetDecoration = arrow 
			}
			style HiddenBusinessObjectNode.HiddenInhertanceEdge as ConnectionShape  {
				var hiddenArrow = new PolygonDecoration()
				hiddenArrow.setScale(8,8)
				hiddenArrow.backgroundColor = color(#ffffff)
				hiddenArrow.lineWidth = 2
				targetDecoration = hiddenArrow 
			}
			
			
			style EnumNode as RoundedRectangleShape { 
				backgroundColor = color(#f8e8a8)
			}
			style EnumNode { 
				font = font("Helvetica", 12, SWT::CENTER + 
					 SWT::NONE
				)
			}
			style EnumNode.Name { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD + 
					 SWT::NONE
				)
			}
			style EnumNode.EnumLabel { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD + 
					 SWT::NONE
				)
			}
			style EnumNode.EnumLiteralNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style ExceptionNode as RoundedRectangleShape { 
				backgroundColor = color(#f8e8d8)
			}
			style ExceptionNode { 
				font = font("Helvetica", 12, SWT::CENTER 
				)
			}
			style ExceptionNode.ExceptionLabel { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD 
				)
			}
			style ExceptionNode.Name { 
				font = font("Helvetica", 12, SWT::CENTER + SWT::BOLD 
				)
			}
			style ExceptionNode.PropertiesNode as RoundedRectangleShape {
				outline = false
				backgroundColor = color(#ffffff)
				font = font("Helvetica", 12, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
		'''
		fsa.generateFile("view/BusinessObjectView.gvstyle", content)
	}
	
}