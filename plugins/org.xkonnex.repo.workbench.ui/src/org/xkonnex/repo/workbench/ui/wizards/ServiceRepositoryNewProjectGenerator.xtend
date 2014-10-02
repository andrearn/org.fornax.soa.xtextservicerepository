package org.xkonnex.repo.workbench.ui.wizards

import org.eclipse.xtext.generator.IFileSystemAccess

class ServiceRepositoryNewProjectGenerator {
	
	def generateProject (IFileSystemAccess fsa) {
		generateProfile (fsa)
		generateBusinessObjectViewMap (fsa)
		generateBusinessObjectViewStyle (fsa)
		generateServiceViewMap (fsa)
		generateServiceViewStyle (fsa)
		generateSolutionViewMap(fsa)
		generateSolutionViewStyle(fsa)
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
						requires-approval
						freezes-asset
						qualifies-for Local-Environment, Development-Environment, Test-Environment, Staging-Environment, Production-Environment
						-> deprecated
						-> test
						-> proposed
					}
					state deprecated {
						requires-approval
						freezes-asset
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
						version-evolution {
							extendible-properties
							extendible-XML-attributes
						}
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
	
	def generateServiceViewMap (IFileSystemAccess fsa) {
		val content='''
			/*******************************************************************************
			 * Copyright (c) 2012 developers of XtextServiceRepository and others.
			 * All rights reserved. This script and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 * 
			 * initial contribution:	André Arnold
			 *******************************************************************************/
			import org.xkonnex.repo.dsl.bindingdsl.serviceDsl.*
			
			diagram ServiceDiagram type SubNamespace {
				
				node ServiceNode for each services {
					label Name for name
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					node OperationNode for operations {
						label Name for each map (op|op.name + "(" + {if (op.parameters?.size < 4) {op.parameters.map(p|p.name).join(",")} else "..."} + ")")
					}
					hidden edge BOEdge for each 
						operations.map(op | op.parameters).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof BusinessObject)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call BusinessObjectNode for (this as BusinessObject)
					}
					hidden edge QOEdge for each 
						operations.map(op | op.parameters).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof QueryObject)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call QueryObjectNode for (this as QueryObject)
					}
					hidden edge EnumEdge for each 
						operations.map(op | op.parameters).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call EnumNode for (this as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
					}
					
					hidden edge BOReturnEdge for each 
						operations.map(op | op.^return).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof BusinessObject)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call BusinessObjectNode for (this as BusinessObject)
					}
					hidden edge QOReturnEdge for each 
						operations.map(op | op.^return).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof QueryObject)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call QueryObjectNode for (this as QueryObject)
					}
					hidden edge EnumReturnEdge for each 
						operations.map(op | op.^return).flatten.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)).map (r|(r.^type as VersionedTypeRef).^type).toSet {
						=> call EnumNode for (this as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
					}
					edge ExceptionEdge for each 
						operations.map(op | op.^throws).flatten.filter(t|t.eContainer.eContainer.eContainer.eContainer == t.exception.eContainer).map(e|e.exception).toSet {
						=> ref HiddenExceptionNode for this
					}
					hidden edge HiddenExceptionEdge for each
						operations.map(op | op.^throws).flatten.filter(t|t.eContainer.eContainer.eContainer.eContainer != t.exception.eContainer).map(e|e.exception).toSet {
						=> call HiddenExceptionNode for this
					}
					
					hidden edge RequiredServiceEdge for each operations.map(op | op.requires).flatten.map(req|req.service) {
						=> call ServiceNode for this
						label RequiresLabel for "requires"
					}
				}
			
				node BusinessObjectNode for this as BusinessObject {
					label Name for name
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type.name)
					} unless properties.empty
					
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) &&
							eContainer == p.eContainer?.eContainer) {
						=> call BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name
					} 
					hidden edge HiddenEnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							eContainer == p.eContainer.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef).^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name
					}
					
					hidden edge InhertanceEdge for superObject?.^type {
						=> call BusinessObjectNode for this
					} unless superObject == null
					
					
				} unless !(this instanceof BusinessObject)
				
				node QueryObjectNode for this as QueryObject {
					label Name for name
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type.name)
					} unless properties.empty
					
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof QueryObject) &&
							eContainer == p.eContainer?.eContainer) {
						=> call QueryObjectNode for ((^type as VersionedTypeRef)?.^type as QueryObject)
						label HiddenEdgeLabel for name
					} 
					hidden edge HiddenEnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							eContainer == p.eContainer.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef).^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name
					}
					
					hidden edge InhertanceEdge for superObject?.^type {
						=> call QueryObjectNode for this
					} unless superObject == null
					
					
				} unless !(this instanceof BusinessObject)
			
			
				node EnumNode for this as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration {
					label EnumLabel  for "<<Enum>>"
					label Name for name
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					hidden node EnumLiteralNode for literals {
						label Label for each map(lit|lit.name)
					} unless literals.empty
				} unless !(this instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
				
				node HiddenExceptionNode for this as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Exception {
					label ExceptionLabel for "<<Exception>>"
					label Name for name	
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
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
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration).eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
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
				} unless !(this instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Exception)
			}
		'''
		fsa.generateFile("view/ServiceView.gvmap", content)
	}
	
	def generateServiceViewStyle (IFileSystemAccess fsa) {
		val content = '''
			/*******************************************************************************
			 * Copyright (c) 2012 developers of XtextServiceRepository and others.
			 * All rights reserved. This style sheet and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 * 
			 * initial contribution:	André Arnold
			 *******************************************************************************/
			import org.eclipse.xtext.graphview.lib.shape.*
			import org.eclipse.xtext.graphview.lib.layout.*
			import org.eclipse.draw2d.*
			import org.eclipse.swt.SWT
			import ServiceDiagram.*
			
			stylesheet ServiceDiagram for ServiceDiagram
			
			style ServiceDiagram {
				this.autoLayoutManager = new KielerAutoLayout() 
			}
			
			style ServiceNode as RoundedRectangleShape { 
				this.backgroundColor = color(#d8ffd8)
			}
			
			
			style ServiceNode { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + SWT::NONE
				)
			}
			style ServiceDiagram.ServiceNode.Version { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			
			style ServiceDiagram.ServiceNode.OperationNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style ServiceDiagram.ServiceNode.RequiredServiceEdge {
				this.lineStyle = SWT::LINE_DASH
				this.foregroundColor = color(#cccccc)
			}
			
			
			
			style HiddenExceptionNode as RoundedRectangleShape { 
				this.backgroundColor = color(#f8e8d8)
			}
			style HiddenExceptionNode { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			style ServiceDiagram.HiddenExceptionNode.ExceptionLabel { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD 
				)
			}
			style ServiceDiagram.HiddenExceptionNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD 
				)
			}
			style ServiceDiagram.HiddenExceptionNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			
			
			style BusinessObjectNode { 
				this.backgroundColor = color(#dfeff8)
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + 
					(if (element.abstract) SWT::ITALIC else SWT::NONE)
				)
			}
			style ServiceDiagram.BusinessObjectNode.Version { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			
			style ServiceDiagram.BusinessObjectNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style ServiceDiagram.BusinessObjectNode.HiddenEnumReferenceEdge {
				this.lineStyle = SWT::LINE_DASH
				this.foregroundColor = color(#cccccc)
			}
			
			style ServiceDiagram.BusinessObjectNode.InhertanceEdge as ConnectionShape  {
				var arrow = new PolygonDecoration()
				arrow.setScale(8,8)
				arrow.backgroundColor = color(#ffffff)
				arrow.lineWidth = 2
				this.targetDecoration = arrow 
			}
			
			style QueryObjectNode { 
				this.backgroundColor = color(#eeeeee)
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD
				)
			}
			style ServiceDiagram.QueryObjectNode.Version { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			
			style ServiceDiagram.QueryObjectNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style EnumNode as RoundedRectangleShape { 
				this.backgroundColor = color(#fcefc8)
			}
			style EnumNode {
				this.opaque = true
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			style ServiceDiagram.EnumNode.EnumLabel { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD 
				)
			}
			style ServiceDiagram.EnumNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD 
				)
			}
			style ServiceDiagram.EnumNode.EnumLiteralNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
		'''
		fsa.generateFile("view/ServiceView.gvstyle", content)
	}
	
	def generateBusinessObjectViewMap (IFileSystemAccess fsa) {
		val content = '''
			/*******************************************************************************
			 * Copyright (c) 2012 developers of XtextServiceRepository and others.
			 * All rights reserved. This style sheet and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 * 
			 * initial contribution:	André Arnold
			 *******************************************************************************/
			import org.xkonnex.repo.dsl.bindingdsl.serviceDsl.*
			
			diagram BusinessObjectDiagram type SubNamespace {
				
				node BusinessObjectNode for each types.filter (typeof (BusinessObject)) {
					label Name for name
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type?.name + " {" +
							{if (p.optional) "0" else "1"} +
							{if (p.^type instanceof DataTypeRef && (p.^type as DataTypeRef)?.many) "..*" else "..1"} + "}"
						) 
					} unless properties.empty
					
					
					edge ReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							((p.^type as VersionedTypeRef)?.^type as BusinessObject)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
							
					}
					edge EnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration).eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref EnumNode for ((^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
					}
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							(((p.^type as VersionedTypeRef)?.^type) as BusinessObject)?.eContainer != p?.eContainer.eContainer) {
						=> call HiddenBusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}" 
					}
					 
					edge InhertanceEdge for superObject?.^type {
						=> ref BusinessObjectNode for this
					} unless superObject == null || superObject?.^type.eContainer != eContainer
					
					hidden edge HiddenInhertanceEdge for superObject?.^type {
						=> call HiddenBusinessObjectNode for this
					} unless superObject == null || superObject?.^type.eContainer == eContainer
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
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type.name + " {" +
							{if (p.optional) "0" else "1"} +
							{if (p.^type instanceof DataTypeRef && (p.^type as DataTypeRef)?.many) "..*" else "..1"} + "}"
						)
					} unless properties.empty
					
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject)) {
						=> call HiddenBusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label HiddenEdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}" 
					}
					hidden edge HiddenEnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
					}
					
					hidden edge HiddenInhertanceEdge for superObject?.^type {
						=> call BusinessObjectNode for this
					} unless superObject == null
				} unless !(this instanceof BusinessObject)
			
			
				
				node QueryObjectNode for each types.filter (typeof (QueryObject)) {
					label Name for name
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type?.name + " {" +
							{if (p.optional) "0" else "1"} +
							{if (p.^type instanceof DataTypeRef && (p.^type as DataTypeRef)?.many) "..*" else "..1"} + "}"
						) 
					} unless properties.empty
					
					
					edge ReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof QueryObject) && 
							((p.^type as VersionedTypeRef)?.^type as QueryObject)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref QueryObjectNode for ((^type as VersionedTypeRef)?.^type as QueryObject)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
							
					}
					edge EnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration).eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref EnumNode for ((^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
					}
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof QueryObject) && 
							(((p.^type as VersionedTypeRef)?.^type) as QueryObject)?.eContainer != p?.eContainer.eContainer) {
						=> call HiddenQueryObjectNode for ((^type as VersionedTypeRef)?.^type as QueryObject)
						label HiddenEdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}" 
					}
					 
					edge InhertanceEdge for superObject?.^type {
						=> ref QueryObjectNode for this
					} unless superObject == null || superObject?.^type.eContainer != eContainer
					
					hidden edge HiddenInhertanceEdge for superObject?.^type {
						=> call HiddenQueryObjectNode for this
					} unless superObject == null || superObject?.^type.eContainer == eContainer
				}
				 
				node HiddenQueryObjectNode for this as QueryObject {
					label Name for name
					label PackageName for "from " + if (eContainer.eContainer instanceof OrganizationNamespace) {
						if ((eContainer.eContainer as OrganizationNamespace).prefix != null)
							(eContainer.eContainer as OrganizationNamespace).prefix + "." + (eContainer as SubNamespace).name
						else
							(eContainer.eContainer as OrganizationNamespace).name + "." + (eContainer as SubNamespace).name
					} else {
						(eContainer as SubNamespace).name
					}
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type.name + " {" +
							{if (p.optional) "0" else "1"} +
							{if (p.^type instanceof DataTypeRef && (p.^type as DataTypeRef)?.many) "..*" else "..1"} + "}"
						)
					} unless properties.empty
					
					
					hidden edge HiddenReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof QueryObject)) {
						=> call HiddenQueryObjectNode for ((^type as VersionedTypeRef)?.^type as QueryObject)
						label HiddenEdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}" 
					}
					hidden edge HiddenEnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
					}
					
					hidden edge HiddenInhertanceEdge for superObject?.^type {
						=> call QueryObjectNode for this
					} unless superObject == null
				} unless !(this instanceof QueryObject)
			
			
				node ExceptionNode for each exceptions {
					label ExceptionLabel for "<<Exception>>"
					label Name for name	
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
					
					hidden node PropertiesNode for properties.filter (p | p.^type instanceof DataTypeRef) {
						label Label for each map(p|p.name + " : " + (p.^type as DataTypeRef)?.^type?.name)
					} unless properties.filter (up | up.^type instanceof DataTypeRef).nullOrEmpty
					edge ReferenceEdge for each 
						properties.filter (p | (p?.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef)?.^type instanceof BusinessObject) && 
							((p.^type as VersionedTypeRef)?.^type as BusinessObject)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref BusinessObjectNode for ((^type as VersionedTypeRef)?.^type as BusinessObject)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
					}
					edge EnumReferenceEdge for each 
						properties.filter (p | (p.^type instanceof VersionedTypeRef && 
							(p.^type as VersionedTypeRef).^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef).^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)?.eContainer == p.eContainer?.eContainer && 
							eContainer == p.eContainer?.eContainer) {
						=> ref EnumNode for ((^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name + " {" +
							{if (optional) "0" else "1"} +
							{if (^type instanceof VersionedTypeRef && (^type as VersionedTypeRef)?.many) "..*" else "..1"} + "}"
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
							(p.^type as VersionedTypeRef)?.^type instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration) && 
							((p.^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)?.eContainer != p.eContainer.eContainer && 
							eContainer == p.eContainer.eContainer) {
						=> call EnumNode for ((^type as VersionedTypeRef)?.^type as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)
						label EdgeLabel for name
					}
					 
					edge InhertanceEdge for superException?.^exception {
						=> call ExceptionNode for this
					} unless superException == null
				}
				
				
				node EnumNode for each types.filter(typeof (org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Enumeration)) {
					label EnumLabel  for "<<Enum>>"
					label Name for name
					label Version for "[v" + version?.version + {if (state != null) {", " +  state.name} else ""} + "]"
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
			/*******************************************************************************
			 * Copyright (c) 2012 developers of XtextServiceRepository and others.
			 * All rights reserved. This script and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 * 
			 * initial contribution:	André Arnold
			 *******************************************************************************/
			import org.eclipse.xtext.graphview.lib.shape.*
			import org.eclipse.xtext.graphview.lib.layout.*
			import org.eclipse.draw2d.*
			import org.eclipse.swt.SWT
			import BusinessObjectDiagram.*
			
			stylesheet BusinessObjectDiagram for BusinessObjectDiagram
			
			style BusinessObjectDiagram {
				autoLayoutManager = new KielerAutoLayout()
			}
			
			style BusinessObjectNode as RoundedRectangleShape { 
				this.backgroundColor = color(#d8e8f8)
			}
			
			
			style BusinessObjectNode { 
				this.font = font("Helvetica", 10, SWT::LEFT + 
					(if (element.abstract) SWT::ITALIC else SWT::NONE)
				)
			}
			style BusinessObjectDiagram.BusinessObjectNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD	)
			}
			style BusinessObjectDiagram.BusinessObjectNode.Version { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			
			style BusinessObjectDiagram.BusinessObjectNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style BusinessObjectDiagram.BusinessObjectNode.EnumReferenceEdge {
				this.lineStyle = SWT::LINE_DASH
				this.foregroundColor = color(#cccccc)
			}
			
			
			//Q
			style QueryObjectNode as RoundedRectangleShape { 
				this.backgroundColor = color(#eeeeee)
			}
			
			
			style QueryObjectNode { 
				this.font = font("Helvetica", 10, SWT::LEFT 
				)
			}
			style BusinessObjectDiagram.QueryObjectNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD	)
			}
			style BusinessObjectDiagram.QueryObjectNode.Version { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			
			style BusinessObjectDiagram.QueryObjectNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style BusinessObjectDiagram.QueryObjectNode.EnumReferenceEdge {
				this.lineStyle = SWT::LINE_DASH
				this.foregroundColor = color(#cccccc)
			}
			
			style HiddenQueryObjectNode as RoundedRectangleShape { 
				this.backgroundColor = color(#eeeeee)
			}
			style HiddenQueryObjectNode { 
				this.font = font("Helvetica", 10, SWT::LEFT 
				)
			}
			style BusinessObjectDiagram.HiddenQueryObjectNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD	)
			}
			style BusinessObjectDiagram.HiddenQueryObjectNode.Version { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			
			style BusinessObjectDiagram.HiddenQueryObjectNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			
			
			
			
			style HiddenBusinessObjectNode as RoundedRectangleShape { 
				this.backgroundColor = color(#d8e8f8)
			}
			style HiddenBusinessObjectNode { 
				this.font = font("Helvetica", 10, SWT::CENTER +
					(if (element.abstract) SWT::ITALIC else SWT::NONE)
				)
			}
			style BusinessObjectDiagram.HiddenBusinessObjectNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD 
				)
			}
			
			style BusinessObjectDiagram.HiddenBusinessObjectNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			
			style BusinessObjectDiagram.BusinessObjectNode.HiddenReferenceEdge.HiddenEdgeLabel {
				this.connectionAlignment = ConnectionLocator::TARGET
			}
			style BusinessObjectDiagram.HiddenBusinessObjectNode.HiddenEnumReferenceEdge {
				this.lineStyle = SWT::LINE_DASH
				this.foregroundColor = color(#cccccc)
			}
			
			style BusinessObjectDiagram.BusinessObjectNode.InhertanceEdge as ConnectionShape  {
				var arrow = new PolygonDecoration()
				arrow.setScale(8,8)
				arrow.backgroundColor = color(#ffffff)
				arrow.lineWidth = 2
				this.targetDecoration = arrow 
			}
			style BusinessObjectDiagram.BusinessObjectNode.HiddenInhertanceEdge as ConnectionShape  {
				var hiddenarrow = new PolygonDecoration()
				hiddenarrow.setScale(8,8)
				hiddenarrow.backgroundColor = color(#ffffff)
				hiddenarrow.lineWidth = 2
				this.targetDecoration = hiddenarrow 
			}
			style BusinessObjectDiagram.HiddenQueryObjectNode.HiddenInhertanceEdge as ConnectionShape  {
				var hiddenQueryArrow = new PolygonDecoration()
				hiddenQueryArrow.setScale(8,8)
				hiddenQueryArrow.backgroundColor = color(#ffffff)
				hiddenQueryArrow.lineWidth = 2
				this.targetDecoration = hiddenQueryArrow 
			}
			
			
			style BusinessObjectDiagram.BusinessObjectNode.HiddenReferenceEdge.HiddenEdgeLabel {
				this.connectionAlignment = ConnectionLocator::TARGET
			}
			style BusinessObjectDiagram.HiddenBusinessObjectNode.HiddenEnumReferenceEdge {
				this.lineStyle = SWT::LINE_DASH
				this.foregroundColor = color(#cccccc)
			}
			
			style BusinessObjectDiagram.QueryObjectNode.InhertanceEdge as ConnectionShape  {
				var queryArrow = new PolygonDecoration()
				queryArrow.setScale(8,8)
				queryArrow.backgroundColor = color(#ffffff)
				queryArrow.lineWidth = 2
				this.targetDecoration = queryArrow 
			}
			style BusinessObjectDiagram.QueryObjectNode.HiddenInhertanceEdge as ConnectionShape  {
				var hiddenQueryArrow2 = new PolygonDecoration()
				hiddenQueryArrow2.setScale(8,8)
				hiddenQueryArrow2.backgroundColor = color(#ffffff)
				hiddenQueryArrow2.lineWidth = 2
				this.targetDecoration = hiddenQueryArrow2 
			}
			style BusinessObjectDiagram.HiddenQueryObjectNode.HiddenInhertanceEdge as ConnectionShape  {
				var hiddenArrow2 = new PolygonDecoration()
				hiddenArrow2.setScale(8,8)
				hiddenArrow2.backgroundColor = color(#ffffff)
				hiddenArrow2.lineWidth = 2
				this.targetDecoration = hiddenArrow2 
			}
			
			
			style EnumNode as RoundedRectangleShape { 
				this.backgroundColor = color(#f8e8a8)
			}
			style EnumNode { 
				this.font = font("Helvetica", 10, SWT::CENTER + 
					 SWT::NONE
				)
			}
			style BusinessObjectDiagram.EnumNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + 
					 SWT::NONE
				)
			}
			style BusinessObjectDiagram.EnumNode.EnumLabel { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + 
					 SWT::NONE
				)
			}
			style BusinessObjectDiagram.EnumNode.EnumLiteralNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
			
			style ExceptionNode as RoundedRectangleShape { 
				this.backgroundColor = color(#f8e8d8)
			}
			style ExceptionNode { 
				this.font = font("Helvetica", 10, SWT::CENTER 
				)
			}
			style BusinessObjectDiagram.ExceptionNode.ExceptionLabel { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD 
				)
			}
			style BusinessObjectDiagram.ExceptionNode.Name { 
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD 
				)
			}
			style BusinessObjectDiagram.ExceptionNode.PropertiesNode as RoundedRectangleShape {
				this.outline = false
				this.backgroundColor = color(#ffffff)
				this.font = font("Helvetica", 10, SWT::LEAD + SWT::LEFT+ 
					(SWT::NONE)
				)
			}
		'''
		fsa.generateFile("view/BusinessObjectView.gvstyle", content)
	}
	
	def generateSolutionViewMap (IFileSystemAccess fsa) {
		val content='''
			import org.xkonnex.repo.dsl.bindingdsl.solutionDsl.*
			import org.xkonnex.repo.dsl.bindingdsl.serviceDsl.*
			import org.xkonnex.repo.dsl.bindingdsl.profiledsl.sOAProfileDsl.*
			
			diagram SolutionDiagram type Solution {
				
				node FeatureNode for each this.features {
					label FeatureLabel for "<<Feature>>"
					label FeatureNameLabel for this.name
					hidden edge NestedFeatureEdge for each features {
						=> call NestedFeatureNode for this 
					} 
					edge RequiredServiceEdge for each requires {
						=> ref RequiredServiceNode for this.service 
						label RequiresEdgeLabel for "requires"
					} 
				}
				
				node ModuleNode for each this.modules {
					label ModuleLabel for "<<Module>>"
					label ModuleNameLabel for this.name
					hidden edge NestedFeatureEdge for each this.features {
						=> call NestedFeatureNode for this 
					} 
					edge RequiredServiceEdge for each requires {
						=> ref RequiredServiceNode for this
						label RequiresEdgeLabel for "requires"
					} 
				} 
				
				
				hidden node NestedFeatureNode for each features {
					label FeatureLabel for "<<Feature>>"
					label FeatureNameLabel for this.name
					hidden edge NestedFeatureEdge for each features {
						=> call NestedFeatureNode for this 
					} 
					hidden edge RequiredServiceEdge for each requires.map (r|r.service) {
						=> call HiddenRequiredServiceNode for this
						label RequiresEdgeLabel for "requires"
					} 
				} unless !(this instanceof Feature)
				
				node RequiredServiceNode for each requires.map(r|r.service) {
					label ServiceLabel for "<<Service>>"
					label ServiceNameLabel for name
					label Version for "[v" + version?.version+"]"
					
				}
				
				hidden node HiddenRequiredServiceNode for this  as org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Service {
					label ServiceLabel for "<<Service>>"
					label ServiceNameLabel for this.name
					label Version for "[v" + this.version?.version+"]"
					
				} unless !(this instanceof org.xkonnex.repo.dsl.bindingdsl.serviceDsl.Service)
			}
		'''
		fsa.generateFile("view/SolutionView.gvmap", content)
	}

	def generateSolutionViewStyle (IFileSystemAccess fsa) {
		val content = '''
			import org.eclipse.xtext.graphview.lib.shape.*
			import org.eclipse.xtext.graphview.lib.layout.*
			import org.eclipse.draw2d.*
			import org.eclipse.swt.SWT
			import SolutionDiagram.*
			
			stylesheet SolutionDiagram for SolutionDiagram
			
			style SolutionDiagram {
				this.autoLayoutManager = new KielerAutoLayout() 
			}
			
			style ModuleNode as RectangleShape { 
				this.backgroundColor = color(#fff8b8)
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + SWT::NONE
				)
			}
			style FeatureNode as RoundedRectangleShape { 
				this.backgroundColor = color(#c8f8b8)
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + SWT::NONE
				)
			}
			style NestedFeatureNode as RoundedRectangleShape { 
				this.backgroundColor = color(#d8ffc8)
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + SWT::NONE
				)
			}
			
			style RequiredServiceNode as RoundedRectangleShape {
				this.backgroundColor = color(#eeeeee)
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + SWT::NONE
				)
			}
			style HiddenRequiredServiceNode as RoundedRectangleShape {
				this.backgroundColor = color(#eeeeee)
				this.font = font("Helvetica", 10, SWT::CENTER + SWT::BOLD + SWT::NONE
				)
			}
		'''
		fsa.generateFile("view/SolutionView.gvstyle", content)
	}
	
}