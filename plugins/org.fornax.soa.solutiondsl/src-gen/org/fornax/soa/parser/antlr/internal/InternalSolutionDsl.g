/*
* generated by Xtext
*/
grammar InternalSolutionDsl;

options {
	superClass=AbstractInternalAntlrParser;
	backtrack=true;
	
}

@lexer::header {
package org.fornax.soa.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.fornax.soa.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.fornax.soa.services.SolutionDslGrammarAccess;

}

@parser::members {

/*
  This grammar contains a lot of empty actions to work around a bug in ANTLR.
  Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
*/
 
 	private SolutionDslGrammarAccess grammarAccess;
 	
    public InternalSolutionDslParser(TokenStream input, SolutionDslGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }
    
    @Override
    protected String getFirstRuleName() {
    	return "Model";	
   	}
   	
   	@Override
   	protected SolutionDslGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}
}

@rulecatch { 
    catch (RecognitionException re) { 
        recover(input,re); 
        appendSkippedTokens();
    } 
}




// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
	}
	:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	 iv_ruleModel=ruleModel 
	 { $current=$iv_ruleModel.current; } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Model
ruleModel returns [EObject current=null] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
    }
    @after { leaveRule(); }:
((
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
	    }
		lv_imports_0_0=ruleImport		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"imports",
        		lv_imports_0_0, 
        		"Import");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModelAccess().getSolutionSolutionParserRuleCall_1_0()); 
	    }
		lv_solution_1_0=ruleSolution		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModelRule());
	        }
       		add(
       			$current, 
       			"solution",
        		lv_solution_1_0, 
        		"Solution");
	        afterParserOrEnumRuleCall();
	    }

)
)*)
;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleSolution
entryRuleSolution returns [EObject current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
	}
	:
	{ newCompositeNode(grammarAccess.getSolutionRule()); }
	 iv_ruleSolution=ruleSolution 
	 { $current=$iv_ruleSolution.current; } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Solution
ruleSolution returns [EObject current=null] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
    }
    @after { leaveRule(); }:
(	otherlv_0='solution' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getSolutionAccess().getSolutionKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSolutionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
	    }
		lv_name_1_0=ruleQualifiedName		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSolutionRule());
	        }
       		set(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"QualifiedName");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getSolutionAccess().getLeftCurlyBracketKeyword_2());
    }
(	otherlv_3='domain' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getSolutionAccess().getDomainKeyword_3_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSolutionRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getSolutionAccess().getDomainDomainCrossReference_3_1_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
))?(
(
		{ 
	        newCompositeNode(grammarAccess.getSolutionAccess().getVersionVersionParserRuleCall_4_0()); 
	    }
		lv_version_5_0=ruleVersion		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSolutionRule());
	        }
       		set(
       			$current, 
       			"version",
        		lv_version_5_0, 
        		"Version");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getSolutionAccess().getProductVersionProductVersionParserRuleCall_5_0()); 
	    }
		lv_productVersion_6_0=ruleProductVersion		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSolutionRule());
	        }
       		set(
       			$current, 
       			"productVersion",
        		lv_productVersion_6_0, 
        		"ProductVersion");
	        afterParserOrEnumRuleCall();
	    }

)
)?(	otherlv_7='requires' 
    {
    	newLeafNode(otherlv_7, grammarAccess.getSolutionAccess().getRequiresKeyword_6_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getSolutionAccess().getRequiresServiceRefParserRuleCall_6_1_0()); 
	    }
		lv_requires_8_0=ruleServiceRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSolutionRule());
	        }
       		add(
       			$current, 
       			"requires",
        		lv_requires_8_0, 
        		"ServiceRef");
	        afterParserOrEnumRuleCall();
	    }

)
))*(
(
		{ 
	        newCompositeNode(grammarAccess.getSolutionAccess().getFeaturesFeatureParserRuleCall_7_0()); 
	    }
		lv_features_9_0=ruleFeature		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSolutionRule());
	        }
       		add(
       			$current, 
       			"features",
        		lv_features_9_0, 
        		"Feature");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getSolutionAccess().getModulesModuleParserRuleCall_8_0()); 
	    }
		lv_modules_10_0=ruleModule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getSolutionRule());
	        }
       		add(
       			$current, 
       			"modules",
        		lv_modules_10_0, 
        		"Module");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_11='tags' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getSolutionAccess().getTagsKeyword_9_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getSolutionRule());
	        }
        }
	otherlv_12=RULE_ID
	{
		newLeafNode(otherlv_12, grammarAccess.getSolutionAccess().getTagsTagCrossReference_9_1_0()); 
	}

)
)+)?	otherlv_13='}' 
    {
    	newLeafNode(otherlv_13, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_10());
    }
)
;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleModule
entryRuleModule returns [EObject current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
	}
	:
	{ newCompositeNode(grammarAccess.getModuleRule()); }
	 iv_ruleModule=ruleModule 
	 { $current=$iv_ruleModule.current; } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Module
ruleModule returns [EObject current=null] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
    }
    @after { leaveRule(); }:
(	otherlv_0='module' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
    }
(
(
		lv_name_1_0=RULE_ID
		{
			newLeafNode(lv_name_1_0, grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getModuleRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_1_0, 
        		"ID");
	    }

)
)	otherlv_2='{' 
    {
    	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_2());
    }
	otherlv_3='kind' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getKindKeyword_3());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModuleAccess().getKindModuleKindEnumRuleCall_4_0()); 
	    }
		lv_kind_4_0=ruleModuleKind		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModuleRule());
	        }
       		set(
       			$current, 
       			"kind",
        		lv_kind_4_0, 
        		"ModuleKind");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_5='requires' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getModuleAccess().getRequiresKeyword_5_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getModuleAccess().getRequiresServiceRefParserRuleCall_5_1_0()); 
	    }
		lv_requires_6_0=ruleServiceRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModuleRule());
	        }
       		add(
       			$current, 
       			"requires",
        		lv_requires_6_0, 
        		"ServiceRef");
	        afterParserOrEnumRuleCall();
	    }

)
))*(
(
		{ 
	        newCompositeNode(grammarAccess.getModuleAccess().getFeaturesFeatureParserRuleCall_6_0()); 
	    }
		lv_features_7_0=ruleFeature		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModuleRule());
	        }
       		add(
       			$current, 
       			"features",
        		lv_features_7_0, 
        		"Feature");
	        afterParserOrEnumRuleCall();
	    }

)
)*(
(
		{ 
	        newCompositeNode(grammarAccess.getModuleAccess().getModulesModuleParserRuleCall_7_0()); 
	    }
		lv_modules_8_0=ruleModule		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getModuleRule());
	        }
       		add(
       			$current, 
       			"modules",
        		lv_modules_8_0, 
        		"Module");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_9='tags' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getTagsKeyword_8_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getModuleRule());
	        }
        }
	otherlv_10=RULE_ID
	{
		newLeafNode(otherlv_10, grammarAccess.getModuleAccess().getTagsTagCrossReference_8_1_0()); 
	}

)
)+)?	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_9());
    }
)
;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleFeature
entryRuleFeature returns [EObject current=null] 
	@init { 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
	}
	:
	{ newCompositeNode(grammarAccess.getFeatureRule()); }
	 iv_ruleFeature=ruleFeature 
	 { $current=$iv_ruleFeature.current; } 
	 EOF 
;
finally {
	myHiddenTokenState.restore();
}

// Rule Feature
ruleFeature returns [EObject current=null] 
    @init { enterRule(); 
		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
    }
    @after { leaveRule(); }:
((
(
		lv_nonFunctional_0_0=	'non-functional' 
    {
        newLeafNode(lv_nonFunctional_0_0, grammarAccess.getFeatureAccess().getNonFunctionalNonFunctionalKeyword_0_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureRule());
	        }
       		setWithLastConsumed($current, "nonFunctional", true, "non-functional");
	    }

)
)?	otherlv_1='feature' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getFeatureAccess().getFeatureKeyword_1());
    }
(
(
		lv_name_2_0=RULE_ID
		{
			newLeafNode(lv_name_2_0, grammarAccess.getFeatureAccess().getNameIDTerminalRuleCall_2_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"name",
        		lv_name_2_0, 
        		"ID");
	    }

)
)	otherlv_3='{' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_3());
    }
(	otherlv_4='use cases' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getFeatureAccess().getUseCasesKeyword_4_0());
    }
(
(
		lv_useCase_5_0=RULE_STRING
		{
			newLeafNode(lv_useCase_5_0, grammarAccess.getFeatureAccess().getUseCaseSTRINGTerminalRuleCall_4_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureRule());
	        }
       		addWithLastConsumed(
       			$current, 
       			"useCase",
        		lv_useCase_5_0, 
        		"STRING");
	    }

)
)+)?(	otherlv_6='description' 
    {
    	newLeafNode(otherlv_6, grammarAccess.getFeatureAccess().getDescriptionKeyword_5_0());
    }
(
(
		lv_description_7_0=RULE_STRING
		{
			newLeafNode(lv_description_7_0, grammarAccess.getFeatureAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"description",
        		lv_description_7_0, 
        		"STRING");
	    }

)
))?(	otherlv_8='uses capabilities' 
    {
    	newLeafNode(otherlv_8, grammarAccess.getFeatureAccess().getUsesCapabilitiesKeyword_6_0());
    }
	otherlv_9='{' 
    {
    	newLeafNode(otherlv_9, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_6_1());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureAccess().getUsesCapabilitiesCapabilityRefParserRuleCall_6_2_0()); 
	    }
		lv_usesCapabilities_10_0=ruleCapabilityRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureRule());
	        }
       		add(
       			$current, 
       			"usesCapabilities",
        		lv_usesCapabilities_10_0, 
        		"CapabilityRef");
	        afterParserOrEnumRuleCall();
	    }

)
)+	otherlv_11='}' 
    {
    	newLeafNode(otherlv_11, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_6_3());
    }
)?(	otherlv_12='requires' 
    {
    	newLeafNode(otherlv_12, grammarAccess.getFeatureAccess().getRequiresKeyword_7_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureAccess().getRequiresServiceRefParserRuleCall_7_1_0()); 
	    }
		lv_requires_13_0=ruleServiceRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureRule());
	        }
       		add(
       			$current, 
       			"requires",
        		lv_requires_13_0, 
        		"ServiceRef");
	        afterParserOrEnumRuleCall();
	    }

)
))*(	otherlv_14='subscibes-to-event' 
    {
    	newLeafNode(otherlv_14, grammarAccess.getFeatureAccess().getSubscibesToEventKeyword_8_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureAccess().getEventEventRefParserRuleCall_8_1_0()); 
	    }
		lv_event_15_0=ruleEventRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureRule());
	        }
       		add(
       			$current, 
       			"event",
        		lv_event_15_0, 
        		"EventRef");
	        afterParserOrEnumRuleCall();
	    }

)
)(	otherlv_16=',' 
    {
    	newLeafNode(otherlv_16, grammarAccess.getFeatureAccess().getCommaKeyword_8_2_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureAccess().getEventEventRefParserRuleCall_8_2_1_0()); 
	    }
		lv_event_17_0=ruleEventRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureRule());
	        }
       		add(
       			$current, 
       			"event",
        		lv_event_17_0, 
        		"EventRef");
	        afterParserOrEnumRuleCall();
	    }

)
))*)?(
(
		{ 
	        newCompositeNode(grammarAccess.getFeatureAccess().getFeaturesFeatureParserRuleCall_9_0()); 
	    }
		lv_features_18_0=ruleFeature		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFeatureRule());
	        }
       		add(
       			$current, 
       			"features",
        		lv_features_18_0, 
        		"Feature");
	        afterParserOrEnumRuleCall();
	    }

)
)*(	otherlv_19='tags' 
    {
    	newLeafNode(otherlv_19, grammarAccess.getFeatureAccess().getTagsKeyword_10_0());
    }
(
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getFeatureRule());
	        }
        }
	otherlv_20=RULE_ID
	{
		newLeafNode(otherlv_20, grammarAccess.getFeatureAccess().getTagsTagCrossReference_10_1_0()); 
	}

)
)+)?	otherlv_21='}' 
    {
    	newLeafNode(otherlv_21, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_11());
    }
)
;
finally {
	myHiddenTokenState.restore();
}





// Entry rule entryRuleServiceRef
entryRuleServiceRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getServiceRefRule()); }
	 iv_ruleServiceRef=ruleServiceRef 
	 { $current=$iv_ruleServiceRef.current; } 
	 EOF 
;

// Rule ServiceRef
ruleServiceRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getServiceRefRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getServiceRefAccess().getServiceServiceCrossReference_0_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
	    }
		lv_versionRef_1_0=ruleVersionRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getServiceRefRule());
	        }
       		set(
       			$current, 
       			"versionRef",
        		lv_versionRef_1_0, 
        		"VersionRef");
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		lv_isResponseHandler_2_0=	'handling responses' 
    {
        newLeafNode(lv_isResponseHandler_2_0, grammarAccess.getServiceRefAccess().getIsResponseHandlerHandlingResponsesKeyword_2_0());
    }
 
	    {
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getServiceRefRule());
	        }
       		setWithLastConsumed($current, "isResponseHandler", true, "handling responses");
	    }

)
)?)
;





// Entry rule entryRuleCapabilityRef
entryRuleCapabilityRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getCapabilityRefRule()); }
	 iv_ruleCapabilityRef=ruleCapabilityRef 
	 { $current=$iv_ruleCapabilityRef.current; } 
	 EOF 
;

// Rule CapabilityRef
ruleCapabilityRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getCapabilityRefRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getCapabilityRefAccess().getCapabilityCapabilityCrossReference_0_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getCapabilityRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
	    }
		lv_versionRef_1_0=ruleVersionRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getCapabilityRefRule());
	        }
       		set(
       			$current, 
       			"versionRef",
        		lv_versionRef_1_0, 
        		"VersionRef");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleVersion
entryRuleVersion returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVersionRule()); }
	 iv_ruleVersion=ruleVersion 
	 { $current=$iv_ruleVersion.current; } 
	 EOF 
;

// Rule Version
ruleVersion returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='version' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
	    }
		lv_version_1_0=ruleVersionId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getVersionRule());
	        }
       		set(
       			$current, 
       			"version",
        		lv_version_1_0, 
        		"VersionId");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleProductVersion
entryRuleProductVersion returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getProductVersionRule()); }
	 iv_ruleProductVersion=ruleProductVersion 
	 { $current=$iv_ruleProductVersion.current; } 
	 EOF 
;

// Rule ProductVersion
ruleProductVersion returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='product-version' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getProductVersionAccess().getProductVersionKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getProductVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
	    }
		lv_version_1_0=ruleVersionId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getProductVersionRule());
	        }
       		set(
       			$current, 
       			"version",
        		lv_version_1_0, 
        		"VersionId");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleEventRef
entryRuleEventRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getEventRefRule()); }
	 iv_ruleEventRef=ruleEventRef 
	 { $current=$iv_ruleEventRef.current; } 
	 EOF 
;

// Rule EventRef
ruleEventRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((
(
		{ 
		  /* */ 
		}
		{
			if ($current==null) {
	            $current = createModelElement(grammarAccess.getEventRefRule());
	        }
        }
		{ 
	        newCompositeNode(grammarAccess.getEventRefAccess().getEventEventCrossReference_0_0()); 
	    }
		ruleQualifiedName		{ 
	        afterParserOrEnumRuleCall();
	    }

)
)(
(
		{ 
	        newCompositeNode(grammarAccess.getEventRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
	    }
		lv_versionRef_1_0=ruleVersionRef		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getEventRefRule());
	        }
       		set(
       			$current, 
       			"versionRef",
        		lv_versionRef_1_0, 
        		"VersionRef");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getImportRule()); }
	 iv_ruleImport=ruleImport 
	 { $current=$iv_ruleImport.current; } 
	 EOF 
;

// Rule Import
ruleImport returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='import' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
	    }
		lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getImportRule());
	        }
       		set(
       			$current, 
       			"importedNamespace",
        		lv_importedNamespace_1_0, 
        		"QualifiedNameWithWildCard");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleVersionId
entryRuleVersionId returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getVersionIdRule()); } 
	 iv_ruleVersionId=ruleVersionId 
	 { $current=$iv_ruleVersionId.current.getText(); }  
	 EOF 
;

// Rule VersionId
ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_INT_0=RULE_INT    {
		$current.merge(this_INT_0);
    }

    { 
    newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
    }
    this_INT_2=RULE_INT    {
		$current.merge(this_INT_2);
    }

    { 
    newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
    }
)*(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0()); 
    }
    this_ID_4=RULE_ID    {
		$current.merge(this_ID_4);
    }

    { 
    newLeafNode(this_ID_4, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
    }
)?)
    ;







// Entry rule entryRuleVersionRef
entryRuleVersionRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getVersionRefRule()); }
	 iv_ruleVersionRef=ruleVersionRef 
	 { $current=$iv_ruleVersionRef.current; } 
	 EOF 
;

// Rule VersionRef
ruleVersionRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
    }
    this_MinVersionRef_0=ruleMinVersionRef
    { 
        $current = $this_MinVersionRef_0.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
    }
    this_MaxVersionRef_1=ruleMaxVersionRef
    { 
        $current = $this_MaxVersionRef_1.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
    }
    this_LowerBoundRangeVersionRef_2=ruleLowerBoundRangeVersionRef
    { 
        $current = $this_LowerBoundRangeVersionRef_2.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
    }
    this_MajorVersionRef_3=ruleMajorVersionRef
    { 
        $current = $this_MajorVersionRef_3.current; 
        afterParserOrEnumRuleCall();
    }

    |
	{ 
	  /* */ 
	}
    { 
        newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
    }
    this_FixedVersionRef_4=ruleFixedVersionRef
    { 
        $current = $this_FixedVersionRef_4.current; 
        afterParserOrEnumRuleCall();
    }
)
;





// Entry rule entryRuleMinVersionRef
entryRuleMinVersionRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMinVersionRefRule()); }
	 iv_ruleMinVersionRef=ruleMinVersionRef 
	 { $current=$iv_ruleMinVersionRef.current; } 
	 EOF 
;

// Rule MinVersionRef
ruleMinVersionRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='minVersion' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
	    }
		lv_minVersion_1_0=ruleVersionId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMinVersionRefRule());
	        }
       		set(
       			$current, 
       			"minVersion",
        		lv_minVersion_1_0, 
        		"VersionId");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleMaxVersionRef
entryRuleMaxVersionRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMaxVersionRefRule()); }
	 iv_ruleMaxVersionRef=ruleMaxVersionRef 
	 { $current=$iv_ruleMaxVersionRef.current; } 
	 EOF 
;

// Rule MaxVersionRef
ruleMaxVersionRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='maxVersion' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
	    }
		lv_maxVersion_1_0=ruleVersionId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getMaxVersionRefRule());
	        }
       		set(
       			$current, 
       			"maxVersion",
        		lv_maxVersion_1_0, 
        		"VersionId");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleLowerBoundRangeVersionRef
entryRuleLowerBoundRangeVersionRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); }
	 iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef 
	 { $current=$iv_ruleLowerBoundRangeVersionRef.current; } 
	 EOF 
;

// Rule LowerBoundRangeVersionRef
ruleLowerBoundRangeVersionRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
((	otherlv_0='minVersion' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
    }
	otherlv_1='>=' 
    {
    	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
	    }
		lv_minVersion_2_0=ruleVersionId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLowerBoundRangeVersionRefRule());
	        }
       		set(
       			$current, 
       			"minVersion",
        		lv_minVersion_2_0, 
        		"VersionId");
	        afterParserOrEnumRuleCall();
	    }

)
)	otherlv_3=',' 
    {
    	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
    }
(	otherlv_4='maxVersion' 
    {
    	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
    }
	otherlv_5='<' 
    {
    	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
    }
)(
(
		{ 
	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
	    }
		lv_maxVersion_6_0=ruleVersionId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getLowerBoundRangeVersionRefRule());
	        }
       		set(
       			$current, 
       			"maxVersion",
        		lv_maxVersion_6_0, 
        		"VersionId");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleMajorVersionRef
entryRuleMajorVersionRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getMajorVersionRefRule()); }
	 iv_ruleMajorVersionRef=ruleMajorVersionRef 
	 { $current=$iv_ruleMajorVersionRef.current; } 
	 EOF 
;

// Rule MajorVersionRef
ruleMajorVersionRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='majorVersion' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
    }
(
(
		lv_majorVersion_1_0=RULE_INT
		{
			newLeafNode(lv_majorVersion_1_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionINTTerminalRuleCall_1_0()); 
		}
		{
	        if ($current==null) {
	            $current = createModelElement(grammarAccess.getMajorVersionRefRule());
	        }
       		setWithLastConsumed(
       			$current, 
       			"majorVersion",
        		lv_majorVersion_1_0, 
        		"INT");
	    }

)
))
;





// Entry rule entryRuleFixedVersionRef
entryRuleFixedVersionRef returns [EObject current=null] 
	:
	{ newCompositeNode(grammarAccess.getFixedVersionRefRule()); }
	 iv_ruleFixedVersionRef=ruleFixedVersionRef 
	 { $current=$iv_ruleFixedVersionRef.current; } 
	 EOF 
;

// Rule FixedVersionRef
ruleFixedVersionRef returns [EObject current=null] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(	otherlv_0='fixedVersion' 
    {
    	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
    }
(
(
		{ 
	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
	    }
		lv_fixedVersion_1_0=ruleVersionId		{
	        if ($current==null) {
	            $current = createModelElementForParent(grammarAccess.getFixedVersionRefRule());
	        }
       		set(
       			$current, 
       			"fixedVersion",
        		lv_fixedVersion_1_0, 
        		"VersionId");
	        afterParserOrEnumRuleCall();
	    }

)
))
;





// Entry rule entryRuleQualifiedNameWithWildCard
entryRuleQualifiedNameWithWildCard returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); } 
	 iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard 
	 { $current=$iv_ruleQualifiedNameWithWildCard.current.getText(); }  
	 EOF 
;

// Rule QualifiedNameWithWildCard
ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(
    { 
        newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
    }
    this_QualifiedName_0=ruleQualifiedName    {
		$current.merge(this_QualifiedName_0);
    }

    { 
        afterParserOrEnumRuleCall();
    }
(
	kw='.*' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
    }
)?)
    ;





// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null] 
	:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); } 
	 iv_ruleQualifiedName=ruleQualifiedName 
	 { $current=$iv_ruleQualifiedName.current.getText(); }  
	 EOF 
;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] 
    @init { enterRule(); 
    }
    @after { leaveRule(); }:
(    this_ID_0=RULE_ID    {
		$current.merge(this_ID_0);
    }

    { 
    newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
    }
(
	kw='.' 
    {
        $current.merge(kw);
        newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
    }
    this_ID_2=RULE_ID    {
		$current.merge(this_ID_2);
    }

    { 
    newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
    }
)*)
    ;









// Rule ModuleKind
ruleModuleKind returns [Enumerator current=null] 
    @init { enterRule(); }
    @after { leaveRule(); }:
((	enumLiteral_0='UI' 
	{
        $current = grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_0, grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0()); 
    }
)
    |(	enumLiteral_1='BusinessLogic' 
	{
        $current = grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_1, grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1()); 
    }
)
    |(	enumLiteral_2='Persistence' 
	{
        $current = grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_2, grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2()); 
    }
)
    |(	enumLiteral_3='Security' 
	{
        $current = grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_3, grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3()); 
    }
)
    |(	enumLiteral_4='Batch' 
	{
        $current = grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_4, grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4()); 
    }
)
    |(	enumLiteral_5='OTHER' 
	{
        $current = grammarAccess.getModuleKindAccess().getOTHEREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
        newLeafNode(enumLiteral_5, grammarAccess.getModuleKindAccess().getOTHEREnumLiteralDeclaration_5()); 
    }
));



RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'u'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;


