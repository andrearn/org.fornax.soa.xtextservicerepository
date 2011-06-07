package org.fornax.soa.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.fornax.soa.services.BindingDslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalBindingDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'bind namespace'", "'as'", "'to'", "'environment'", "'with'", "'{'", "'protocols'", "'}'", "'policies'", "'provider-policies'", "'SLAs'", "','", "';'", "'publish on'", "'provided on'", "'bind service'", "'provider-protocols'", "'bind op'", "'component'", "'implements'", "'bind to environment'", "'provided-services'", "'referenced-services'", "'implementation'", "'sourceURL'", "'SOAP'", "'style'", "'http-context-root'", "'provider-http-context-root'", "'provided-WSDL-Url'", "'SAP'", "'transport'", "'client'", "'EJB'", "'jndi-name'", "'HTTP'", "'url'", "'provider-url'", "'verb'", "'REST'", "'format'", "'JMS'", "'provider-jndi-name'", "'topic'", "'queue'", "'SCA'", "'promote'", "'reference'", "'[]'", "'FILE'", "'interval'", "'FTP'", "'access'", "'logging policy'", "'authn policy'", "'optional'", "'auth tokens'", "'hash algorithms'", "'Base64-encoded'", "'authorization rolicy'", "'signing policy'", "'encryption policy'", "'import'", "'.'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'.*'", "'BPMN'", "'BPMN2'", "'BPEL'", "'WS-HT'", "'RuleML'", "'Drools'", "'Mediation'", "'Java'", "'C#'", "'C++'", "'Scala'", "'Ruby'", "'PHP'", "'WS-Document/Literal'", "'WS-RPC/Literal'", "'WS-RPC/Encoded'", "'REST-XML'", "'REST-JSON'", "'Spring'", "'EJB2'", "'SAP/iDoc'", "'SAP/BAPI'", "'Corba'", "'Shell'", "'Siebel'", "'Tuxedo'", "'File'", "'SQL'", "'Ivy'", "'jPDL3'", "'jPDL4'", "'document/literal-wrapped'", "'rpc/literal'", "'rpc/encoded'", "'IDOC'", "'RFC'", "'JSON'", "'XML'", "'OTHER'", "'create'", "'retrieve'", "'update'", "'delete'", "'read'", "'write'", "'MD5'", "'SHA1'", "'SHA256'", "'PlainText'", "'UsernamePassword'", "'SAML'", "'SAML2'", "'Kerberos'", "'NONE'", "'HEADER'", "'ALL'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=5;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalBindingDslParser(TokenStream input) {
            super(input);
            ruleMemo = new HashMap[231+1];
         }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private BindingDslGrammarAccess grammarAccess;
     	
        public InternalBindingDslParser(TokenStream input, IAstFactory factory, BindingDslGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/fornax/soa/parser/antlr/internal/InternalBindingDsl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "BindingModel";	
       	}
       	
       	@Override
       	protected BindingDslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleBindingModel
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:84:1: entryRuleBindingModel returns [EObject current=null] : iv_ruleBindingModel= ruleBindingModel EOF ;
    public final EObject entryRuleBindingModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingModel = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:88:2: (iv_ruleBindingModel= ruleBindingModel EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:89:2: iv_ruleBindingModel= ruleBindingModel EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBindingModelRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingModel_in_entryRuleBindingModel87);
            iv_ruleBindingModel=ruleBindingModel();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBindingModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingModel97); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleBindingModel


    // $ANTLR start ruleBindingModel
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:99:1: ruleBindingModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleDomainBinding ) )* ) ;
    public final EObject ruleBindingModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_bindings_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:105:6: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleDomainBinding ) )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:106:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleDomainBinding ) )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:106:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleDomainBinding ) )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:106:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_bindings_1_0= ruleDomainBinding ) )*
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:106:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==73) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:107:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:107:1: (lv_imports_0_0= ruleImport )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:108:3: lv_imports_0_0= ruleImport
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getBindingModelAccess().getImportsImportParserRuleCall_0_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleBindingModel147);
            	    lv_imports_0_0=ruleImport();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBindingModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"imports",
            	      	        		lv_imports_0_0, 
            	      	        		"Import", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:130:3: ( (lv_bindings_1_0= ruleDomainBinding ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:131:1: (lv_bindings_1_0= ruleDomainBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:131:1: (lv_bindings_1_0= ruleDomainBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:132:3: lv_bindings_1_0= ruleDomainBinding
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getBindingModelAccess().getBindingsDomainBindingParserRuleCall_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleDomainBinding_in_ruleBindingModel169);
            	    lv_bindings_1_0=ruleDomainBinding();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getBindingModelRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"bindings",
            	      	        		lv_bindings_1_0, 
            	      	        		"DomainBinding", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleBindingModel


    // $ANTLR start entryRuleDomainBinding
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:167:1: entryRuleDomainBinding returns [EObject current=null] : iv_ruleDomainBinding= ruleDomainBinding EOF ;
    public final EObject entryRuleDomainBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDomainBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:168:2: (iv_ruleDomainBinding= ruleDomainBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:169:2: iv_ruleDomainBinding= ruleDomainBinding EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getDomainBindingRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleDomainBinding_in_entryRuleDomainBinding212);
            iv_ruleDomainBinding=ruleDomainBinding();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleDomainBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleDomainBinding222); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleDomainBinding


    // $ANTLR start ruleDomainBinding
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:176:1: ruleDomainBinding returns [EObject current=null] : ( 'bind namespace' ( ( ruleQualifiedName ) ) 'as' ( (lv_name_3_0= ruleQualifiedName ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' ( 'protocols' '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_15_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_serviceBinding_26_0= ruleServiceBinding ) )* ( (lv_components_27_0= ruleComponent ) )* '}' ) ;
    public final EObject ruleDomainBinding() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_protocol_11_0 = null;

        EObject lv_policies_15_0 = null;

        EObject lv_providerPolicies_19_0 = null;

        EObject lv_serviceBinding_26_0 = null;

        EObject lv_components_27_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:181:6: ( ( 'bind namespace' ( ( ruleQualifiedName ) ) 'as' ( (lv_name_3_0= ruleQualifiedName ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' ( 'protocols' '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_15_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_serviceBinding_26_0= ruleServiceBinding ) )* ( (lv_components_27_0= ruleComponent ) )* '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:182:1: ( 'bind namespace' ( ( ruleQualifiedName ) ) 'as' ( (lv_name_3_0= ruleQualifiedName ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' ( 'protocols' '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_15_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_serviceBinding_26_0= ruleServiceBinding ) )* ( (lv_components_27_0= ruleComponent ) )* '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:182:1: ( 'bind namespace' ( ( ruleQualifiedName ) ) 'as' ( (lv_name_3_0= ruleQualifiedName ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' ( 'protocols' '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_15_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_serviceBinding_26_0= ruleServiceBinding ) )* ( (lv_components_27_0= ruleComponent ) )* '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:182:3: 'bind namespace' ( ( ruleQualifiedName ) ) 'as' ( (lv_name_3_0= ruleQualifiedName ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' ( 'protocols' '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_15_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_serviceBinding_26_0= ruleServiceBinding ) )* ( (lv_components_27_0= ruleComponent ) )* '}'
            {
            match(input,11,FollowSets000.FOLLOW_11_in_ruleDomainBinding257); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDomainBindingAccess().getBindNamespaceKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:186:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:187:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:187:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:188:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getSubNamespaceSubNamespaceCrossReference_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding284);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,12,FollowSets000.FOLLOW_12_in_ruleDomainBinding294); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDomainBindingAccess().getAsKeyword_2(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:209:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:210:1: (lv_name_3_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:210:1: (lv_name_3_0= ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:211:3: lv_name_3_0= ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getNameQualifiedNameParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding315);
            lv_name_3_0=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_3_0, 
              	        		"QualifiedName", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,13,FollowSets000.FOLLOW_13_in_ruleDomainBinding325); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDomainBindingAccess().getToKeyword_4(), null); 
                  
            }
            match(input,14,FollowSets000.FOLLOW_14_in_ruleDomainBinding335); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDomainBindingAccess().getEnvironmentKeyword_5(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:241:1: ( ( RULE_ID ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:242:1: ( RULE_ID )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:242:1: ( RULE_ID )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:243:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleDomainBinding357); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getDomainBindingAccess().getEnvironmentEnvironmentCrossReference_6_0(), "environment"); 
              	
            }

            }


            }

            match(input,15,FollowSets000.FOLLOW_15_in_ruleDomainBinding367); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDomainBindingAccess().getWithKeyword_7(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleDomainBinding377); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_8(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:266:1: ( 'protocols' '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ '}' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:266:3: 'protocols' '{' ( (lv_protocol_11_0= ruleBindingProtocol ) )+ '}'
                    {
                    match(input,17,FollowSets000.FOLLOW_17_in_ruleDomainBinding388); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getProtocolsKeyword_9_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleDomainBinding398); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_9_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:274:1: ( (lv_protocol_11_0= ruleBindingProtocol ) )+
                    int cnt3=0;
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==36||LA3_0==41||LA3_0==44||LA3_0==46||LA3_0==50||LA3_0==52||LA3_0==56||LA3_0==60||LA3_0==62) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:275:1: (lv_protocol_11_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:275:1: (lv_protocol_11_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:276:3: lv_protocol_11_0= ruleBindingProtocol
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getProtocolBindingProtocolParserRuleCall_9_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleDomainBinding419);
                    	    lv_protocol_11_0=ruleBindingProtocol();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"protocol",
                    	      	        		lv_protocol_11_0, 
                    	      	        		"BindingProtocol", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt3 >= 1 ) break loop3;
                    	    if (backtracking>0) {failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(3, input);
                                throw eee;
                        }
                        cnt3++;
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleDomainBinding430); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_9_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:302:3: ( 'policies' '{' ( (lv_policies_15_0= rulePolicy ) )* '}' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==19) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:302:5: 'policies' '{' ( (lv_policies_15_0= rulePolicy ) )* '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleDomainBinding443); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getPoliciesKeyword_10_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleDomainBinding453); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_10_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:310:1: ( (lv_policies_15_0= rulePolicy ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=64 && LA5_0<=65)||(LA5_0>=70 && LA5_0<=72)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:311:1: (lv_policies_15_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:311:1: (lv_policies_15_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:312:3: lv_policies_15_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getPoliciesPolicyParserRuleCall_10_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleDomainBinding474);
                    	    lv_policies_15_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"policies",
                    	      	        		lv_policies_15_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleDomainBinding485); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_10_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:338:3: ( 'provider-policies' '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* '}' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:338:5: 'provider-policies' '{' ( (lv_providerPolicies_19_0= rulePolicy ) )* '}'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleDomainBinding498); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getProviderPoliciesKeyword_11_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleDomainBinding508); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getLeftCurlyBracketKeyword_11_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:346:1: ( (lv_providerPolicies_19_0= rulePolicy ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0>=64 && LA7_0<=65)||(LA7_0>=70 && LA7_0<=72)) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:347:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:347:1: (lv_providerPolicies_19_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:348:3: lv_providerPolicies_19_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getProviderPoliciesPolicyParserRuleCall_11_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleDomainBinding529);
                    	    lv_providerPolicies_19_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"providerPolicies",
                    	      	        		lv_providerPolicies_19_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleDomainBinding540); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_11_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:374:3: ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==21) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:374:5: 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleDomainBinding553); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getSLAsKeyword_12_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:378:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:379:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:379:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:380:3: ruleQualifiedName
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getSlaSLACrossReference_12_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding580);
                    ruleQualifiedName();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:397:2: ( ',' ( ( ruleQualifiedName ) ) )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==22) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:397:4: ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    match(input,22,FollowSets000.FOLLOW_22_in_ruleDomainBinding591); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getDomainBindingAccess().getCommaKeyword_12_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:401:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:402:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:402:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:403:3: ruleQualifiedName
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	              
                    	    }
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getSlaSLACrossReference_12_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleDomainBinding618);
                    	    ruleQualifiedName();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleDomainBinding630); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getDomainBindingAccess().getSemicolonKeyword_12_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:424:3: ( (lv_serviceBinding_26_0= ruleServiceBinding ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:425:1: (lv_serviceBinding_26_0= ruleServiceBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:425:1: (lv_serviceBinding_26_0= ruleServiceBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:426:3: lv_serviceBinding_26_0= ruleServiceBinding
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getServiceBindingServiceBindingParserRuleCall_13_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_ruleDomainBinding653);
            	    lv_serviceBinding_26_0=ruleServiceBinding();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"serviceBinding",
            	      	        		lv_serviceBinding_26_0, 
            	      	        		"ServiceBinding", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:448:3: ( (lv_components_27_0= ruleComponent ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==29) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:449:1: (lv_components_27_0= ruleComponent )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:449:1: (lv_components_27_0= ruleComponent )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:450:3: lv_components_27_0= ruleComponent
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getDomainBindingAccess().getComponentsComponentParserRuleCall_14_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleComponent_in_ruleDomainBinding675);
            	    lv_components_27_0=ruleComponent();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getDomainBindingRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"components",
            	      	        		lv_components_27_0, 
            	      	        		"Component", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleDomainBinding686); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getDomainBindingAccess().getRightCurlyBracketKeyword_15(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleDomainBinding


    // $ANTLR start entryRulePublisher
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:484:1: entryRulePublisher returns [EObject current=null] : iv_rulePublisher= rulePublisher EOF ;
    public final EObject entryRulePublisher() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePublisher = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:485:2: (iv_rulePublisher= rulePublisher EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:486:2: iv_rulePublisher= rulePublisher EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPublisherRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePublisher_in_entryRulePublisher722);
            iv_rulePublisher=rulePublisher();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePublisher; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePublisher732); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePublisher


    // $ANTLR start rulePublisher
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:493:1: rulePublisher returns [EObject current=null] : ( 'publish on' ( ( ruleQualifiedName ) ) ';' ) ;
    public final EObject rulePublisher() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:498:6: ( ( 'publish on' ( ( ruleQualifiedName ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:499:1: ( 'publish on' ( ( ruleQualifiedName ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:499:1: ( 'publish on' ( ( ruleQualifiedName ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:499:3: 'publish on' ( ( ruleQualifiedName ) ) ';'
            {
            match(input,24,FollowSets000.FOLLOW_24_in_rulePublisher767); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPublisherAccess().getPublishOnKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:503:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:504:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:504:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:505:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getPublisherRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getPublisherAccess().getPubServerServerCrossReference_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rulePublisher794);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_rulePublisher804); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getPublisherAccess().getSemicolonKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePublisher


    // $ANTLR start entryRuleProvider
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:534:1: entryRuleProvider returns [EObject current=null] : iv_ruleProvider= ruleProvider EOF ;
    public final EObject entryRuleProvider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProvider = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:535:2: (iv_ruleProvider= ruleProvider EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:536:2: iv_ruleProvider= ruleProvider EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getProviderRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProvider_in_entryRuleProvider840);
            iv_ruleProvider=ruleProvider();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleProvider; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProvider850); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleProvider


    // $ANTLR start ruleProvider
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:543:1: ruleProvider returns [EObject current=null] : ( 'provided on' ( ( ruleQualifiedName ) ) ';' ) ;
    public final EObject ruleProvider() throws RecognitionException {
        EObject current = null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:548:6: ( ( 'provided on' ( ( ruleQualifiedName ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:549:1: ( 'provided on' ( ( ruleQualifiedName ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:549:1: ( 'provided on' ( ( ruleQualifiedName ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:549:3: 'provided on' ( ( ruleQualifiedName ) ) ';'
            {
            match(input,25,FollowSets000.FOLLOW_25_in_ruleProvider885); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getProviderAccess().getProvidedOnKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:553:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:554:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:554:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:555:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getProviderRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getProviderAccess().getProvServerServerCrossReference_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleProvider912);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleProvider922); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getProviderAccess().getSemicolonKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleProvider


    // $ANTLR start entryRuleServiceBinding
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:584:1: entryRuleServiceBinding returns [EObject current=null] : iv_ruleServiceBinding= ruleServiceBinding EOF ;
    public final EObject entryRuleServiceBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:585:2: (iv_ruleServiceBinding= ruleServiceBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:586:2: iv_ruleServiceBinding= ruleServiceBinding EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getServiceBindingRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding958);
            iv_ruleServiceBinding=ruleServiceBinding();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleServiceBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceBinding968); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleServiceBinding


    // $ANTLR start ruleServiceBinding
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:593:1: ruleServiceBinding returns [EObject current=null] : ( 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' 'protocols' '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_17_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_21_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_operation_28_0= ruleOperationBinding ) )* '}' ) ;
    public final EObject ruleServiceBinding() throws RecognitionException {
        EObject current = null;

        EObject lv_service_1_0 = null;

        EObject lv_protocol_9_0 = null;

        EObject lv_providerProtocol_13_0 = null;

        EObject lv_policies_17_0 = null;

        EObject lv_providerPolicies_21_0 = null;

        EObject lv_operation_28_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:598:6: ( ( 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' 'protocols' '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_17_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_21_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_operation_28_0= ruleOperationBinding ) )* '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:599:1: ( 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' 'protocols' '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_17_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_21_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_operation_28_0= ruleOperationBinding ) )* '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:599:1: ( 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' 'protocols' '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_17_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_21_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_operation_28_0= ruleOperationBinding ) )* '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:599:3: 'bind service' ( (lv_service_1_0= ruleServiceRef ) ) 'to' 'environment' ( ( RULE_ID ) ) 'with' '{' 'protocols' '{' ( (lv_protocol_9_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_17_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_21_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? ( (lv_operation_28_0= ruleOperationBinding ) )* '}'
            {
            match(input,26,FollowSets000.FOLLOW_26_in_ruleServiceBinding1003); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getBindServiceKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:603:1: ( (lv_service_1_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:604:1: (lv_service_1_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:604:1: (lv_service_1_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:605:3: lv_service_1_0= ruleServiceRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getServiceServiceRefParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleServiceBinding1024);
            lv_service_1_0=ruleServiceRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"service",
              	        		lv_service_1_0, 
              	        		"ServiceRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,13,FollowSets000.FOLLOW_13_in_ruleServiceBinding1034); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getToKeyword_2(), null); 
                  
            }
            match(input,14,FollowSets000.FOLLOW_14_in_ruleServiceBinding1044); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getEnvironmentKeyword_3(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:635:1: ( ( RULE_ID ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:636:1: ( RULE_ID )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:636:1: ( RULE_ID )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:637:3: RULE_ID
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleServiceBinding1066); if (failed) return current;
            if ( backtracking==0 ) {

              		createLeafNode(grammarAccess.getServiceBindingAccess().getEnvironmentEnvironmentCrossReference_4_0(), "environment"); 
              	
            }

            }


            }

            match(input,15,FollowSets000.FOLLOW_15_in_ruleServiceBinding1076); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getWithKeyword_5(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceBinding1086); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_6(), null); 
                  
            }
            match(input,17,FollowSets000.FOLLOW_17_in_ruleServiceBinding1096); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getProtocolsKeyword_7(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceBinding1106); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_8(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:668:1: ( (lv_protocol_9_0= ruleBindingProtocol ) )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==36||LA13_0==41||LA13_0==44||LA13_0==46||LA13_0==50||LA13_0==52||LA13_0==56||LA13_0==60||LA13_0==62) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:669:1: (lv_protocol_9_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:669:1: (lv_protocol_9_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:670:3: lv_protocol_9_0= ruleBindingProtocol
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getProtocolBindingProtocolParserRuleCall_9_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1127);
            	    lv_protocol_9_0=ruleBindingProtocol();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"protocol",
            	      	        		lv_protocol_9_0, 
            	      	        		"BindingProtocol", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1138); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_10(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:696:1: ( 'provider-protocols' '{' ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+ '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:696:3: 'provider-protocols' '{' ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+ '}'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_ruleServiceBinding1149); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getProviderProtocolsKeyword_11_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceBinding1159); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_11_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:704:1: ( (lv_providerProtocol_13_0= ruleBindingProtocol ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==36||LA14_0==41||LA14_0==44||LA14_0==46||LA14_0==50||LA14_0==52||LA14_0==56||LA14_0==60||LA14_0==62) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:705:1: (lv_providerProtocol_13_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:705:1: (lv_providerProtocol_13_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:706:3: lv_providerProtocol_13_0= ruleBindingProtocol
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getProviderProtocolBindingProtocolParserRuleCall_11_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1180);
                    	    lv_providerProtocol_13_0=ruleBindingProtocol();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"providerProtocol",
                    	      	        		lv_providerProtocol_13_0, 
                    	      	        		"BindingProtocol", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                    	    if (backtracking>0) {failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1191); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_11_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:732:3: ( 'policies' '{' ( (lv_policies_17_0= rulePolicy ) )* '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==19) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:732:5: 'policies' '{' ( (lv_policies_17_0= rulePolicy ) )* '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleServiceBinding1204); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getPoliciesKeyword_12_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceBinding1214); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_12_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:740:1: ( (lv_policies_17_0= rulePolicy ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( ((LA16_0>=64 && LA16_0<=65)||(LA16_0>=70 && LA16_0<=72)) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:741:1: (lv_policies_17_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:741:1: (lv_policies_17_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:742:3: lv_policies_17_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getPoliciesPolicyParserRuleCall_12_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServiceBinding1235);
                    	    lv_policies_17_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"policies",
                    	      	        		lv_policies_17_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1246); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_12_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:768:3: ( 'provider-policies' '{' ( (lv_providerPolicies_21_0= rulePolicy ) )* '}' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==20) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:768:5: 'provider-policies' '{' ( (lv_providerPolicies_21_0= rulePolicy ) )* '}'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleServiceBinding1259); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getProviderPoliciesKeyword_13_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleServiceBinding1269); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getLeftCurlyBracketKeyword_13_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:776:1: ( (lv_providerPolicies_21_0= rulePolicy ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( ((LA18_0>=64 && LA18_0<=65)||(LA18_0>=70 && LA18_0<=72)) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:777:1: (lv_providerPolicies_21_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:777:1: (lv_providerPolicies_21_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:778:3: lv_providerPolicies_21_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getProviderPoliciesPolicyParserRuleCall_13_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleServiceBinding1290);
                    	    lv_providerPolicies_21_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"providerPolicies",
                    	      	        		lv_providerPolicies_21_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1301); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_13_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:804:3: ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==21) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:804:5: 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleServiceBinding1314); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getSLAsKeyword_14_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:808:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:809:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:809:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:810:3: ruleQualifiedName
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getSlaSLACrossReference_14_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1341);
                    ruleQualifiedName();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:827:2: ( ',' ( ( ruleQualifiedName ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==22) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:827:4: ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    match(input,22,FollowSets000.FOLLOW_22_in_ruleServiceBinding1352); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getServiceBindingAccess().getCommaKeyword_14_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:831:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:832:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:832:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:833:3: ruleQualifiedName
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	              
                    	    }
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getSlaSLACrossReference_14_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceBinding1379);
                    	    ruleQualifiedName();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleServiceBinding1391); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getServiceBindingAccess().getSemicolonKeyword_14_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:854:3: ( (lv_operation_28_0= ruleOperationBinding ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==28) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:855:1: (lv_operation_28_0= ruleOperationBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:855:1: (lv_operation_28_0= ruleOperationBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:856:3: lv_operation_28_0= ruleOperationBinding
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getServiceBindingAccess().getOperationOperationBindingParserRuleCall_15_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_ruleServiceBinding1414);
            	    lv_operation_28_0=ruleOperationBinding();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getServiceBindingRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"operation",
            	      	        		lv_operation_28_0, 
            	      	        		"OperationBinding", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleServiceBinding1425); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getServiceBindingAccess().getRightCurlyBracketKeyword_16(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleServiceBinding


    // $ANTLR start entryRuleServiceRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:890:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:891:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:892:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getServiceRefRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef1461);
            iv_ruleServiceRef=ruleServiceRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef1471); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleServiceRef


    // $ANTLR start ruleServiceRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:899:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:904:6: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:905:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:905:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:905:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:905:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:906:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:906:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:907:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getServiceRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getServiceRefAccess().getServiceServiceCrossReference_0_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef1523);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:924:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:925:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:925:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:926:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef1544);
            lv_versionRef_1_0=ruleVersionRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getServiceRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"versionRef",
              	        		lv_versionRef_1_0, 
              	        		"VersionRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleServiceRef


    // $ANTLR start entryRuleBindingProtocol
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:956:1: entryRuleBindingProtocol returns [EObject current=null] : iv_ruleBindingProtocol= ruleBindingProtocol EOF ;
    public final EObject entryRuleBindingProtocol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBindingProtocol = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:957:2: (iv_ruleBindingProtocol= ruleBindingProtocol EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:958:2: iv_ruleBindingProtocol= ruleBindingProtocol EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getBindingProtocolRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1580);
            iv_ruleBindingProtocol=ruleBindingProtocol();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleBindingProtocol; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleBindingProtocol1590); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBindingProtocol


    // $ANTLR start ruleBindingProtocol
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:965:1: ruleBindingProtocol returns [EObject current=null] : (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP ) ;
    public final EObject ruleBindingProtocol() throws RecognitionException {
        EObject current = null;

        EObject this_SCA_0 = null;

        EObject this_SOAP_1 = null;

        EObject this_EJB_2 = null;

        EObject this_HTTP_3 = null;

        EObject this_REST_4 = null;

        EObject this_SAP_5 = null;

        EObject this_JMS_6 = null;

        EObject this_FILE_7 = null;

        EObject this_FTP_8 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:970:6: ( (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:971:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:971:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP )
            int alt23=9;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt23=1;
                }
                break;
            case 36:
                {
                alt23=2;
                }
                break;
            case 44:
                {
                alt23=3;
                }
                break;
            case 46:
                {
                alt23=4;
                }
                break;
            case 50:
                {
                alt23=5;
                }
                break;
            case 41:
                {
                alt23=6;
                }
                break;
            case 52:
                {
                alt23=7;
                }
                break;
            case 60:
                {
                alt23=8;
                }
                break;
            case 62:
                {
                alt23=9;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("971:1: (this_SCA_0= ruleSCA | this_SOAP_1= ruleSOAP | this_EJB_2= ruleEJB | this_HTTP_3= ruleHTTP | this_REST_4= ruleREST | this_SAP_5= ruleSAP | this_JMS_6= ruleJMS | this_FILE_7= ruleFILE | this_FTP_8= ruleFTP )", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:972:2: this_SCA_0= ruleSCA
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getSCAParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSCA_in_ruleBindingProtocol1640);
                    this_SCA_0=ruleSCA();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SCA_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:985:2: this_SOAP_1= ruleSOAP
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getSOAPParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_ruleBindingProtocol1670);
                    this_SOAP_1=ruleSOAP();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SOAP_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:998:2: this_EJB_2= ruleEJB
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getEJBParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEJB_in_ruleBindingProtocol1700);
                    this_EJB_2=ruleEJB();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_EJB_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1011:2: this_HTTP_3= ruleHTTP
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getHTTPParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_ruleBindingProtocol1730);
                    this_HTTP_3=ruleHTTP();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_HTTP_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1024:2: this_REST_4= ruleREST
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getRESTParserRuleCall_4(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleREST_in_ruleBindingProtocol1760);
                    this_REST_4=ruleREST();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_REST_4; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1037:2: this_SAP_5= ruleSAP
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getSAPParserRuleCall_5(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAP_in_ruleBindingProtocol1790);
                    this_SAP_5=ruleSAP();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SAP_5; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1050:2: this_JMS_6= ruleJMS
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getJMSParserRuleCall_6(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleJMS_in_ruleBindingProtocol1820);
                    this_JMS_6=ruleJMS();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_JMS_6; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1063:2: this_FILE_7= ruleFILE
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getFILEParserRuleCall_7(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFILE_in_ruleBindingProtocol1850);
                    this_FILE_7=ruleFILE();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FILE_7; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1076:2: this_FTP_8= ruleFTP
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getBindingProtocolAccess().getFTPParserRuleCall_8(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFTP_in_ruleBindingProtocol1880);
                    this_FTP_8=ruleFTP();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_FTP_8; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBindingProtocol


    // $ANTLR start entryRuleOperationBinding
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1095:1: entryRuleOperationBinding returns [EObject current=null] : iv_ruleOperationBinding= ruleOperationBinding EOF ;
    public final EObject entryRuleOperationBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationBinding = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1096:2: (iv_ruleOperationBinding= ruleOperationBinding EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1097:2: iv_ruleOperationBinding= ruleOperationBinding EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getOperationBindingRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding1915);
            iv_ruleOperationBinding=ruleOperationBinding();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleOperationBinding; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleOperationBinding1925); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOperationBinding


    // $ANTLR start ruleOperationBinding
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1104:1: ruleOperationBinding returns [EObject current=null] : ( 'bind op' ( ( ruleQualifiedName ) ) '{' 'protocols' '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_13_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? '}' ) ;
    public final EObject ruleOperationBinding() throws RecognitionException {
        EObject current = null;

        EObject lv_protocol_5_0 = null;

        EObject lv_providerProtocol_9_0 = null;

        EObject lv_policies_13_0 = null;

        EObject lv_providerPolicies_17_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1109:6: ( ( 'bind op' ( ( ruleQualifiedName ) ) '{' 'protocols' '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_13_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1110:1: ( 'bind op' ( ( ruleQualifiedName ) ) '{' 'protocols' '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_13_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1110:1: ( 'bind op' ( ( ruleQualifiedName ) ) '{' 'protocols' '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_13_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1110:3: 'bind op' ( ( ruleQualifiedName ) ) '{' 'protocols' '{' ( (lv_protocol_5_0= ruleBindingProtocol ) )+ '}' ( 'provider-protocols' '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ '}' )? ( 'policies' '{' ( (lv_policies_13_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? '}'
            {
            match(input,28,FollowSets000.FOLLOW_28_in_ruleOperationBinding1960); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationBindingAccess().getBindOpKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1114:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1115:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1115:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1116:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getOperationBindingRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getOperationBindingAccess().getOperationOperationCrossReference_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding1987);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleOperationBinding1997); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            match(input,17,FollowSets000.FOLLOW_17_in_ruleOperationBinding2007); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationBindingAccess().getProtocolsKeyword_3(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleOperationBinding2017); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_4(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1145:1: ( (lv_protocol_5_0= ruleBindingProtocol ) )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==36||LA24_0==41||LA24_0==44||LA24_0==46||LA24_0==50||LA24_0==52||LA24_0==56||LA24_0==60||LA24_0==62) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1146:1: (lv_protocol_5_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1146:1: (lv_protocol_5_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1147:3: lv_protocol_5_0= ruleBindingProtocol
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getOperationBindingAccess().getProtocolBindingProtocolParserRuleCall_5_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2038);
            	    lv_protocol_5_0=ruleBindingProtocol();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getOperationBindingRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"protocol",
            	      	        		lv_protocol_5_0, 
            	      	        		"BindingProtocol", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt24 >= 1 ) break loop24;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2049); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_6(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1173:1: ( 'provider-protocols' '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ '}' )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==27) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1173:3: 'provider-protocols' '{' ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+ '}'
                    {
                    match(input,27,FollowSets000.FOLLOW_27_in_ruleOperationBinding2060); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getProviderProtocolsKeyword_7_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleOperationBinding2070); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_7_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1181:1: ( (lv_providerProtocol_9_0= ruleBindingProtocol ) )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==36||LA25_0==41||LA25_0==44||LA25_0==46||LA25_0==50||LA25_0==52||LA25_0==56||LA25_0==60||LA25_0==62) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1182:1: (lv_providerProtocol_9_0= ruleBindingProtocol )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1182:1: (lv_providerProtocol_9_0= ruleBindingProtocol )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1183:3: lv_providerProtocol_9_0= ruleBindingProtocol
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOperationBindingAccess().getProviderProtocolBindingProtocolParserRuleCall_7_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2091);
                    	    lv_providerProtocol_9_0=ruleBindingProtocol();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getOperationBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"providerProtocol",
                    	      	        		lv_providerProtocol_9_0, 
                    	      	        		"BindingProtocol", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                    	    if (backtracking>0) {failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2102); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_7_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1209:3: ( 'policies' '{' ( (lv_policies_13_0= rulePolicy ) )* '}' )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==19) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1209:5: 'policies' '{' ( (lv_policies_13_0= rulePolicy ) )* '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleOperationBinding2115); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getPoliciesKeyword_8_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleOperationBinding2125); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_8_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1217:1: ( (lv_policies_13_0= rulePolicy ) )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( ((LA27_0>=64 && LA27_0<=65)||(LA27_0>=70 && LA27_0<=72)) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1218:1: (lv_policies_13_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1218:1: (lv_policies_13_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1219:3: lv_policies_13_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOperationBindingAccess().getPoliciesPolicyParserRuleCall_8_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2146);
                    	    lv_policies_13_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getOperationBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"policies",
                    	      	        		lv_policies_13_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2157); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_8_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1245:3: ( 'provider-policies' '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* '}' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==20) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1245:5: 'provider-policies' '{' ( (lv_providerPolicies_17_0= rulePolicy ) )* '}'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleOperationBinding2170); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getProviderPoliciesKeyword_9_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleOperationBinding2180); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getLeftCurlyBracketKeyword_9_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1253:1: ( (lv_providerPolicies_17_0= rulePolicy ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( ((LA29_0>=64 && LA29_0<=65)||(LA29_0>=70 && LA29_0<=72)) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1254:1: (lv_providerPolicies_17_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1254:1: (lv_providerPolicies_17_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1255:3: lv_providerPolicies_17_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOperationBindingAccess().getProviderPoliciesPolicyParserRuleCall_9_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleOperationBinding2201);
                    	    lv_providerPolicies_17_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getOperationBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"providerPolicies",
                    	      	        		lv_providerPolicies_17_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2212); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_9_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1281:3: ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==21) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1281:5: 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleOperationBinding2225); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getSLAsKeyword_10_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1285:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1286:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1286:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1287:3: ruleQualifiedName
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getOperationBindingRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getOperationBindingAccess().getSlaSLACrossReference_10_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2252);
                    ruleQualifiedName();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1304:2: ( ',' ( ( ruleQualifiedName ) ) )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==22) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1304:4: ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    match(input,22,FollowSets000.FOLLOW_22_in_ruleOperationBinding2263); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getOperationBindingAccess().getCommaKeyword_10_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1308:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1309:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1309:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1310:3: ruleQualifiedName
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = factory.create(grammarAccess.getOperationBindingRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	              
                    	    }
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getOperationBindingAccess().getSlaSLACrossReference_10_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleOperationBinding2290);
                    	    ruleQualifiedName();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleOperationBinding2302); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getOperationBindingAccess().getSemicolonKeyword_10_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleOperationBinding2314); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getOperationBindingAccess().getRightCurlyBracketKeyword_11(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOperationBinding


    // $ANTLR start entryRuleComponent
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1343:1: entryRuleComponent returns [EObject current=null] : iv_ruleComponent= ruleComponent EOF ;
    public final EObject entryRuleComponent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponent = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1344:2: (iv_ruleComponent= ruleComponent EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1345:2: iv_ruleComponent= ruleComponent EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getComponentRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleComponent_in_entryRuleComponent2350);
            iv_ruleComponent=ruleComponent();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleComponent; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleComponent2360); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleComponent


    // $ANTLR start ruleComponent
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1352:1: ruleComponent returns [EObject current=null] : ( 'component' ( (lv_name_1_0= RULE_ID ) ) 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) '{' 'bind to environment' ( ( ruleQualifiedName ) ) 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) ( ',' ( (lv_services_10_0= ruleServiceRef ) ) )* ';' ( 'referenced-services' ( (lv_referencedServices_13_0= ruleServiceRef ) ) ( ',' )* ';' )? 'protocols' '{' ( (lv_protocol_18_0= ruleBindingProtocol ) )+ '}' ( (lv_operation_20_0= ruleOperationBinding ) )* ( 'policies' '{' ( (lv_policies_23_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_27_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? 'implementation' ( (lv_implementation_35_0= ruleImplementationType ) ) ';' ( 'sourceURL' ( (lv_source_38_0= RULE_STRING ) ) ';' )? '}' ) ;
    public final EObject ruleComponent() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_source_38_0=null;
        EObject lv_implements_3_0 = null;

        EObject lv_services_8_0 = null;

        EObject lv_services_10_0 = null;

        EObject lv_referencedServices_13_0 = null;

        EObject lv_protocol_18_0 = null;

        EObject lv_operation_20_0 = null;

        EObject lv_policies_23_0 = null;

        EObject lv_providerPolicies_27_0 = null;

        Enumerator lv_implementation_35_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1357:6: ( ( 'component' ( (lv_name_1_0= RULE_ID ) ) 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) '{' 'bind to environment' ( ( ruleQualifiedName ) ) 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) ( ',' ( (lv_services_10_0= ruleServiceRef ) ) )* ';' ( 'referenced-services' ( (lv_referencedServices_13_0= ruleServiceRef ) ) ( ',' )* ';' )? 'protocols' '{' ( (lv_protocol_18_0= ruleBindingProtocol ) )+ '}' ( (lv_operation_20_0= ruleOperationBinding ) )* ( 'policies' '{' ( (lv_policies_23_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_27_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? 'implementation' ( (lv_implementation_35_0= ruleImplementationType ) ) ';' ( 'sourceURL' ( (lv_source_38_0= RULE_STRING ) ) ';' )? '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1358:1: ( 'component' ( (lv_name_1_0= RULE_ID ) ) 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) '{' 'bind to environment' ( ( ruleQualifiedName ) ) 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) ( ',' ( (lv_services_10_0= ruleServiceRef ) ) )* ';' ( 'referenced-services' ( (lv_referencedServices_13_0= ruleServiceRef ) ) ( ',' )* ';' )? 'protocols' '{' ( (lv_protocol_18_0= ruleBindingProtocol ) )+ '}' ( (lv_operation_20_0= ruleOperationBinding ) )* ( 'policies' '{' ( (lv_policies_23_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_27_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? 'implementation' ( (lv_implementation_35_0= ruleImplementationType ) ) ';' ( 'sourceURL' ( (lv_source_38_0= RULE_STRING ) ) ';' )? '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1358:1: ( 'component' ( (lv_name_1_0= RULE_ID ) ) 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) '{' 'bind to environment' ( ( ruleQualifiedName ) ) 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) ( ',' ( (lv_services_10_0= ruleServiceRef ) ) )* ';' ( 'referenced-services' ( (lv_referencedServices_13_0= ruleServiceRef ) ) ( ',' )* ';' )? 'protocols' '{' ( (lv_protocol_18_0= ruleBindingProtocol ) )+ '}' ( (lv_operation_20_0= ruleOperationBinding ) )* ( 'policies' '{' ( (lv_policies_23_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_27_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? 'implementation' ( (lv_implementation_35_0= ruleImplementationType ) ) ';' ( 'sourceURL' ( (lv_source_38_0= RULE_STRING ) ) ';' )? '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1358:3: 'component' ( (lv_name_1_0= RULE_ID ) ) 'implements' ( (lv_implements_3_0= ruleServiceRef ) ) '{' 'bind to environment' ( ( ruleQualifiedName ) ) 'provided-services' ( (lv_services_8_0= ruleServiceRef ) ) ( ',' ( (lv_services_10_0= ruleServiceRef ) ) )* ';' ( 'referenced-services' ( (lv_referencedServices_13_0= ruleServiceRef ) ) ( ',' )* ';' )? 'protocols' '{' ( (lv_protocol_18_0= ruleBindingProtocol ) )+ '}' ( (lv_operation_20_0= ruleOperationBinding ) )* ( 'policies' '{' ( (lv_policies_23_0= rulePolicy ) )* '}' )? ( 'provider-policies' '{' ( (lv_providerPolicies_27_0= rulePolicy ) )* '}' )? ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )? 'implementation' ( (lv_implementation_35_0= ruleImplementationType ) ) ';' ( 'sourceURL' ( (lv_source_38_0= RULE_STRING ) ) ';' )? '}'
            {
            match(input,29,FollowSets000.FOLLOW_29_in_ruleComponent2395); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getComponentKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1362:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1363:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1363:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1364:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleComponent2412); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getComponentAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"ID", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,30,FollowSets000.FOLLOW_30_in_ruleComponent2427); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getImplementsKeyword_2(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1390:1: ( (lv_implements_3_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1391:1: (lv_implements_3_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1391:1: (lv_implements_3_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1392:3: lv_implements_3_0= ruleServiceRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getImplementsServiceRefParserRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent2448);
            lv_implements_3_0=ruleServiceRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"implements",
              	        		lv_implements_3_0, 
              	        		"ServiceRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleComponent2458); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_4(), null); 
                  
            }
            match(input,31,FollowSets000.FOLLOW_31_in_ruleComponent2468); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getBindToEnvironmentKeyword_5(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1422:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1423:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1423:1: ( ruleQualifiedName )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1424:3: ruleQualifiedName
            {
            if ( backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( backtracking==0 ) {

              			if (current==null) {
              	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
                      
            }
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getEnvironmentEnvironmentCrossReference_6_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleComponent2495);
            ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,32,FollowSets000.FOLLOW_32_in_ruleComponent2505); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getProvidedServicesKeyword_7(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1445:1: ( (lv_services_8_0= ruleServiceRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1446:1: (lv_services_8_0= ruleServiceRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1446:1: (lv_services_8_0= ruleServiceRef )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1447:3: lv_services_8_0= ruleServiceRef
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getServicesServiceRefParserRuleCall_8_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent2526);
            lv_services_8_0=ruleServiceRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		add(
              	       			current, 
              	       			"services",
              	        		lv_services_8_0, 
              	        		"ServiceRef", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1469:2: ( ',' ( (lv_services_10_0= ruleServiceRef ) ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==22) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1469:4: ',' ( (lv_services_10_0= ruleServiceRef ) )
            	    {
            	    match(input,22,FollowSets000.FOLLOW_22_in_ruleComponent2537); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              createLeafNode(grammarAccess.getComponentAccess().getCommaKeyword_9_0(), null); 
            	          
            	    }
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1473:1: ( (lv_services_10_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1474:1: (lv_services_10_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1474:1: (lv_services_10_0= ruleServiceRef )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1475:3: lv_services_10_0= ruleServiceRef
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getServicesServiceRefParserRuleCall_9_1_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent2558);
            	    lv_services_10_0=ruleServiceRef();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"services",
            	      	        		lv_services_10_0, 
            	      	        		"ServiceRef", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

            match(input,23,FollowSets000.FOLLOW_23_in_ruleComponent2570); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getSemicolonKeyword_10(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1501:1: ( 'referenced-services' ( (lv_referencedServices_13_0= ruleServiceRef ) ) ( ',' )* ';' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1501:3: 'referenced-services' ( (lv_referencedServices_13_0= ruleServiceRef ) ) ( ',' )* ';'
                    {
                    match(input,33,FollowSets000.FOLLOW_33_in_ruleComponent2581); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getReferencedServicesKeyword_11_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1505:1: ( (lv_referencedServices_13_0= ruleServiceRef ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1506:1: (lv_referencedServices_13_0= ruleServiceRef )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1506:1: (lv_referencedServices_13_0= ruleServiceRef )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1507:3: lv_referencedServices_13_0= ruleServiceRef
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getReferencedServicesServiceRefParserRuleCall_11_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleComponent2602);
                    lv_referencedServices_13_0=ruleServiceRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		add(
                      	       			current, 
                      	       			"referencedServices",
                      	        		lv_referencedServices_13_0, 
                      	        		"ServiceRef", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1529:2: ( ',' )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==22) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1529:4: ','
                    	    {
                    	    match(input,22,FollowSets000.FOLLOW_22_in_ruleComponent2613); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getComponentAccess().getCommaKeyword_11_2(), null); 
                    	          
                    	    }

                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleComponent2625); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getSemicolonKeyword_11_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,17,FollowSets000.FOLLOW_17_in_ruleComponent2637); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getProtocolsKeyword_12(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleComponent2647); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_13(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1545:1: ( (lv_protocol_18_0= ruleBindingProtocol ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==36||LA36_0==41||LA36_0==44||LA36_0==46||LA36_0==50||LA36_0==52||LA36_0==56||LA36_0==60||LA36_0==62) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1546:1: (lv_protocol_18_0= ruleBindingProtocol )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1546:1: (lv_protocol_18_0= ruleBindingProtocol )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1547:3: lv_protocol_18_0= ruleBindingProtocol
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getProtocolBindingProtocolParserRuleCall_14_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleBindingProtocol_in_ruleComponent2668);
            	    lv_protocol_18_0=ruleBindingProtocol();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"protocol",
            	      	        		lv_protocol_18_0, 
            	      	        		"BindingProtocol", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt36 >= 1 ) break loop36;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleComponent2679); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_15(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1573:1: ( (lv_operation_20_0= ruleOperationBinding ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==28) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1574:1: (lv_operation_20_0= ruleOperationBinding )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1574:1: (lv_operation_20_0= ruleOperationBinding )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1575:3: lv_operation_20_0= ruleOperationBinding
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getOperationOperationBindingParserRuleCall_16_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleOperationBinding_in_ruleComponent2700);
            	    lv_operation_20_0=ruleOperationBinding();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"operation",
            	      	        		lv_operation_20_0, 
            	      	        		"OperationBinding", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1597:3: ( 'policies' '{' ( (lv_policies_23_0= rulePolicy ) )* '}' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==19) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1597:5: 'policies' '{' ( (lv_policies_23_0= rulePolicy ) )* '}'
                    {
                    match(input,19,FollowSets000.FOLLOW_19_in_ruleComponent2712); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getPoliciesKeyword_17_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleComponent2722); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_17_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1605:1: ( (lv_policies_23_0= rulePolicy ) )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( ((LA38_0>=64 && LA38_0<=65)||(LA38_0>=70 && LA38_0<=72)) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1606:1: (lv_policies_23_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1606:1: (lv_policies_23_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1607:3: lv_policies_23_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getPoliciesPolicyParserRuleCall_17_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleComponent2743);
                    	    lv_policies_23_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"policies",
                    	      	        		lv_policies_23_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleComponent2754); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_17_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1633:3: ( 'provider-policies' '{' ( (lv_providerPolicies_27_0= rulePolicy ) )* '}' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==20) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1633:5: 'provider-policies' '{' ( (lv_providerPolicies_27_0= rulePolicy ) )* '}'
                    {
                    match(input,20,FollowSets000.FOLLOW_20_in_ruleComponent2767); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getProviderPoliciesKeyword_18_0(), null); 
                          
                    }
                    match(input,16,FollowSets000.FOLLOW_16_in_ruleComponent2777); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getLeftCurlyBracketKeyword_18_1(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1641:1: ( (lv_providerPolicies_27_0= rulePolicy ) )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( ((LA40_0>=64 && LA40_0<=65)||(LA40_0>=70 && LA40_0<=72)) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1642:1: (lv_providerPolicies_27_0= rulePolicy )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1642:1: (lv_providerPolicies_27_0= rulePolicy )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1643:3: lv_providerPolicies_27_0= rulePolicy
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getProviderPoliciesPolicyParserRuleCall_18_2_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_rulePolicy_in_ruleComponent2798);
                    	    lv_providerPolicies_27_0=rulePolicy();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	      	        }
                    	      	        try {
                    	      	       		add(
                    	      	       			current, 
                    	      	       			"providerPolicies",
                    	      	        		lv_providerPolicies_27_0, 
                    	      	        		"Policy", 
                    	      	        		currentNode);
                    	      	        } catch (ValueConverterException vce) {
                    	      				handleValueConverterException(vce);
                    	      	        }
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);

                    match(input,18,FollowSets000.FOLLOW_18_in_ruleComponent2809); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_18_3(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1669:3: ( 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';' )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==21) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1669:5: 'SLAs' ( ( ruleQualifiedName ) ) ( ',' ( ( ruleQualifiedName ) ) )* ';'
                    {
                    match(input,21,FollowSets000.FOLLOW_21_in_ruleComponent2822); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getSLAsKeyword_19_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1673:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1674:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1674:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1675:3: ruleQualifiedName
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getSlaSLACrossReference_19_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleComponent2849);
                    ruleQualifiedName();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1692:2: ( ',' ( ( ruleQualifiedName ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==22) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1692:4: ',' ( ( ruleQualifiedName ) )
                    	    {
                    	    match(input,22,FollowSets000.FOLLOW_22_in_ruleComponent2860); if (failed) return current;
                    	    if ( backtracking==0 ) {

                    	              createLeafNode(grammarAccess.getComponentAccess().getCommaKeyword_19_2_0(), null); 
                    	          
                    	    }
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1696:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1697:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1697:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1698:3: ruleQualifiedName
                    	    {
                    	    if ( backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
                    	      	            associateNodeWithAstElement(currentNode, current);
                    	      	        }
                    	              
                    	    }
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getSlaSLACrossReference_19_2_1_0(), currentNode); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleComponent2887);
                    	    ruleQualifiedName();
                    	    _fsp--;
                    	    if (failed) return current;
                    	    if ( backtracking==0 ) {
                    	       
                    	      	        currentNode = currentNode.getParent();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleComponent2899); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getSemicolonKeyword_19_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,34,FollowSets000.FOLLOW_34_in_ruleComponent2911); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getImplementationKeyword_20(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1723:1: ( (lv_implementation_35_0= ruleImplementationType ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1724:1: (lv_implementation_35_0= ruleImplementationType )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1724:1: (lv_implementation_35_0= ruleImplementationType )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1725:3: lv_implementation_35_0= ruleImplementationType
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getComponentAccess().getImplementationImplementationTypeEnumRuleCall_21_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleImplementationType_in_ruleComponent2932);
            lv_implementation_35_0=ruleImplementationType();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"implementation",
              	        		lv_implementation_35_0, 
              	        		"ImplementationType", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleComponent2942); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getSemicolonKeyword_22(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1751:1: ( 'sourceURL' ( (lv_source_38_0= RULE_STRING ) ) ';' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==35) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1751:3: 'sourceURL' ( (lv_source_38_0= RULE_STRING ) ) ';'
                    {
                    match(input,35,FollowSets000.FOLLOW_35_in_ruleComponent2953); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getSourceURLKeyword_23_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1755:1: ( (lv_source_38_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1756:1: (lv_source_38_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1756:1: (lv_source_38_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1757:3: lv_source_38_0= RULE_STRING
                    {
                    lv_source_38_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleComponent2970); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getComponentAccess().getSourceSTRINGTerminalRuleCall_23_1_0(), "source"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getComponentRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"source",
                      	        		lv_source_38_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleComponent2985); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getComponentAccess().getSemicolonKeyword_23_2(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleComponent2997); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getComponentAccess().getRightCurlyBracketKeyword_24(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComponent


    // $ANTLR start entryRuleSOAP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1795:1: entryRuleSOAP returns [EObject current=null] : iv_ruleSOAP= ruleSOAP EOF ;
    public final EObject entryRuleSOAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSOAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1796:2: (iv_ruleSOAP= ruleSOAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1797:2: iv_ruleSOAP= ruleSOAP EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSOAPRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSOAP_in_entryRuleSOAP3033);
            iv_ruleSOAP=ruleSOAP();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSOAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSOAP3043); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSOAP


    // $ANTLR start ruleSOAP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1804:1: ruleSOAP returns [EObject current=null] : ( 'SOAP' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) ';' )? ( 'http-context-root' ( (lv_contextRoot_9_0= RULE_STRING ) ) ';' )? ( 'provider-http-context-root' ( (lv_providerContextRoot_12_0= RULE_STRING ) ) ';' )? ( 'provided-WSDL-Url' ( (lv_providedWsdlUrl_15_0= RULE_STRING ) ) ';' )? '}' ) ;
    public final EObject ruleSOAP() throws RecognitionException {
        EObject current = null;

        Token lv_contextRoot_9_0=null;
        Token lv_providerContextRoot_12_0=null;
        Token lv_providedWsdlUrl_15_0=null;
        EObject lv_publisher_3_0 = null;

        EObject lv_provider_4_0 = null;

        Enumerator lv_style_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1809:6: ( ( 'SOAP' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) ';' )? ( 'http-context-root' ( (lv_contextRoot_9_0= RULE_STRING ) ) ';' )? ( 'provider-http-context-root' ( (lv_providerContextRoot_12_0= RULE_STRING ) ) ';' )? ( 'provided-WSDL-Url' ( (lv_providedWsdlUrl_15_0= RULE_STRING ) ) ';' )? '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1810:1: ( 'SOAP' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) ';' )? ( 'http-context-root' ( (lv_contextRoot_9_0= RULE_STRING ) ) ';' )? ( 'provider-http-context-root' ( (lv_providerContextRoot_12_0= RULE_STRING ) ) ';' )? ( 'provided-WSDL-Url' ( (lv_providedWsdlUrl_15_0= RULE_STRING ) ) ';' )? '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1810:1: ( 'SOAP' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) ';' )? ( 'http-context-root' ( (lv_contextRoot_9_0= RULE_STRING ) ) ';' )? ( 'provider-http-context-root' ( (lv_providerContextRoot_12_0= RULE_STRING ) ) ';' )? ( 'provided-WSDL-Url' ( (lv_providedWsdlUrl_15_0= RULE_STRING ) ) ';' )? '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1810:3: 'SOAP' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) ';' )? ( 'http-context-root' ( (lv_contextRoot_9_0= RULE_STRING ) ) ';' )? ( 'provider-http-context-root' ( (lv_providerContextRoot_12_0= RULE_STRING ) ) ';' )? ( 'provided-WSDL-Url' ( (lv_providedWsdlUrl_15_0= RULE_STRING ) ) ';' )? '}'
            {
            match(input,36,FollowSets000.FOLLOW_36_in_ruleSOAP3078); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSOAPAccess().getSOAPKeyword_0(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleSOAP3088); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSOAPAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1818:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1819:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getSOAPAccess().getSOAPAction_2().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getSOAPAccess().getSOAPAction_2(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1832:2: ( (lv_publisher_3_0= rulePublisher ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==24) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1833:1: (lv_publisher_3_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1833:1: (lv_publisher_3_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1834:3: lv_publisher_3_0= rulePublisher
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSOAPAccess().getPublisherPublisherParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleSOAP3121);
                    lv_publisher_3_0=rulePublisher();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSOAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"publisher",
                      	        		lv_publisher_3_0, 
                      	        		"Publisher", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1856:3: ( (lv_provider_4_0= ruleProvider ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==25) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1857:1: (lv_provider_4_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1857:1: (lv_provider_4_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1858:3: lv_provider_4_0= ruleProvider
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSOAPAccess().getProviderProviderParserRuleCall_4_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleSOAP3143);
                    lv_provider_4_0=ruleProvider();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSOAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"provider",
                      	        		lv_provider_4_0, 
                      	        		"Provider", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1880:3: ( 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) ';' )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==37) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1880:5: 'style' ( (lv_style_6_0= ruleSOAPStyle ) ) ';'
                    {
                    match(input,37,FollowSets000.FOLLOW_37_in_ruleSOAP3155); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getStyleKeyword_5_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1884:1: ( (lv_style_6_0= ruleSOAPStyle ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1885:1: (lv_style_6_0= ruleSOAPStyle )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1885:1: (lv_style_6_0= ruleSOAPStyle )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1886:3: lv_style_6_0= ruleSOAPStyle
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSOAPAccess().getStyleSOAPStyleEnumRuleCall_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSOAPStyle_in_ruleSOAP3176);
                    lv_style_6_0=ruleSOAPStyle();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSOAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"style",
                      	        		lv_style_6_0, 
                      	        		"SOAPStyle", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSOAP3186); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getSemicolonKeyword_5_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1912:3: ( 'http-context-root' ( (lv_contextRoot_9_0= RULE_STRING ) ) ';' )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==38) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1912:5: 'http-context-root' ( (lv_contextRoot_9_0= RULE_STRING ) ) ';'
                    {
                    match(input,38,FollowSets000.FOLLOW_38_in_ruleSOAP3199); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getHttpContextRootKeyword_6_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1916:1: ( (lv_contextRoot_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1917:1: (lv_contextRoot_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1917:1: (lv_contextRoot_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1918:3: lv_contextRoot_9_0= RULE_STRING
                    {
                    lv_contextRoot_9_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP3216); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getSOAPAccess().getContextRootSTRINGTerminalRuleCall_6_1_0(), "contextRoot"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSOAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"contextRoot",
                      	        		lv_contextRoot_9_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSOAP3231); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getSemicolonKeyword_6_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1944:3: ( 'provider-http-context-root' ( (lv_providerContextRoot_12_0= RULE_STRING ) ) ';' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==39) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1944:5: 'provider-http-context-root' ( (lv_providerContextRoot_12_0= RULE_STRING ) ) ';'
                    {
                    match(input,39,FollowSets000.FOLLOW_39_in_ruleSOAP3244); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getProviderHttpContextRootKeyword_7_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1948:1: ( (lv_providerContextRoot_12_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1949:1: (lv_providerContextRoot_12_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1949:1: (lv_providerContextRoot_12_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1950:3: lv_providerContextRoot_12_0= RULE_STRING
                    {
                    lv_providerContextRoot_12_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP3261); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getSOAPAccess().getProviderContextRootSTRINGTerminalRuleCall_7_1_0(), "providerContextRoot"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSOAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"providerContextRoot",
                      	        		lv_providerContextRoot_12_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSOAP3276); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getSemicolonKeyword_7_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1976:3: ( 'provided-WSDL-Url' ( (lv_providedWsdlUrl_15_0= RULE_STRING ) ) ';' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==40) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1976:5: 'provided-WSDL-Url' ( (lv_providedWsdlUrl_15_0= RULE_STRING ) ) ';'
                    {
                    match(input,40,FollowSets000.FOLLOW_40_in_ruleSOAP3289); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getProvidedWSDLUrlKeyword_8_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1980:1: ( (lv_providedWsdlUrl_15_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1981:1: (lv_providedWsdlUrl_15_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1981:1: (lv_providedWsdlUrl_15_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:1982:3: lv_providedWsdlUrl_15_0= RULE_STRING
                    {
                    lv_providedWsdlUrl_15_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSOAP3306); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getSOAPAccess().getProvidedWsdlUrlSTRINGTerminalRuleCall_8_1_0(), "providedWsdlUrl"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSOAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"providedWsdlUrl",
                      	        		lv_providedWsdlUrl_15_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSOAP3321); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSOAPAccess().getSemicolonKeyword_8_2(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleSOAP3333); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSOAPAccess().getRightCurlyBracketKeyword_9(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSOAP


    // $ANTLR start entryRuleSAP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2020:1: entryRuleSAP returns [EObject current=null] : iv_ruleSAP= ruleSAP EOF ;
    public final EObject entryRuleSAP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSAP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2021:2: (iv_ruleSAP= ruleSAP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2022:2: iv_ruleSAP= ruleSAP EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSAPRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSAP_in_entryRuleSAP3369);
            iv_ruleSAP=ruleSAP();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSAP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSAP3379); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSAP


    // $ANTLR start ruleSAP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2029:1: ruleSAP returns [EObject current=null] : ( 'SAP' '{' () ( (lv_provider_3_0= ruleProvider ) )? ( 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) ';' )? ( 'client' ( ( ruleQualifiedName ) ) ';' )? '}' ) ;
    public final EObject ruleSAP() throws RecognitionException {
        EObject current = null;

        EObject lv_provider_3_0 = null;

        Enumerator lv_transport_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2034:6: ( ( 'SAP' '{' () ( (lv_provider_3_0= ruleProvider ) )? ( 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) ';' )? ( 'client' ( ( ruleQualifiedName ) ) ';' )? '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2035:1: ( 'SAP' '{' () ( (lv_provider_3_0= ruleProvider ) )? ( 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) ';' )? ( 'client' ( ( ruleQualifiedName ) ) ';' )? '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2035:1: ( 'SAP' '{' () ( (lv_provider_3_0= ruleProvider ) )? ( 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) ';' )? ( 'client' ( ( ruleQualifiedName ) ) ';' )? '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2035:3: 'SAP' '{' () ( (lv_provider_3_0= ruleProvider ) )? ( 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) ';' )? ( 'client' ( ( ruleQualifiedName ) ) ';' )? '}'
            {
            match(input,41,FollowSets000.FOLLOW_41_in_ruleSAP3414); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSAPAccess().getSAPKeyword_0(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleSAP3424); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSAPAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2043:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2044:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getSAPAccess().getSAPAction_2().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getSAPAccess().getSAPAction_2(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2057:2: ( (lv_provider_3_0= ruleProvider ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==25) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2058:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2058:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2059:3: lv_provider_3_0= ruleProvider
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSAPAccess().getProviderProviderParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleSAP3457);
                    lv_provider_3_0=ruleProvider();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"provider",
                      	        		lv_provider_3_0, 
                      	        		"Provider", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2081:3: ( 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) ';' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==42) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2081:5: 'transport' ( (lv_transport_5_0= ruleSAPTransport ) ) ';'
                    {
                    match(input,42,FollowSets000.FOLLOW_42_in_ruleSAP3469); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSAPAccess().getTransportKeyword_4_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2085:1: ( (lv_transport_5_0= ruleSAPTransport ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2086:1: (lv_transport_5_0= ruleSAPTransport )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2086:1: (lv_transport_5_0= ruleSAPTransport )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2087:3: lv_transport_5_0= ruleSAPTransport
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSAPAccess().getTransportSAPTransportEnumRuleCall_4_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSAPTransport_in_ruleSAP3490);
                    lv_transport_5_0=ruleSAPTransport();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"transport",
                      	        		lv_transport_5_0, 
                      	        		"SAPTransport", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSAP3500); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSAPAccess().getSemicolonKeyword_4_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2113:3: ( 'client' ( ( ruleQualifiedName ) ) ';' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==43) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2113:5: 'client' ( ( ruleQualifiedName ) ) ';'
                    {
                    match(input,43,FollowSets000.FOLLOW_43_in_ruleSAP3513); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSAPAccess().getClientKeyword_5_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2117:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2118:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2118:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2119:3: ruleQualifiedName
                    {
                    if ( backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( backtracking==0 ) {

                      			if (current==null) {
                      	            current = factory.create(grammarAccess.getSAPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                              
                    }
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSAPAccess().getClientSapClientCrossReference_5_1_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSAP3540);
                    ruleQualifiedName();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSAP3550); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSAPAccess().getSemicolonKeyword_5_2(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleSAP3562); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSAPAccess().getRightCurlyBracketKeyword_6(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSAP


    // $ANTLR start entryRuleEJB
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2152:1: entryRuleEJB returns [EObject current=null] : iv_ruleEJB= ruleEJB EOF ;
    public final EObject entryRuleEJB() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEJB = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2153:2: (iv_ruleEJB= ruleEJB EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2154:2: iv_ruleEJB= ruleEJB EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEJBRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEJB_in_entryRuleEJB3598);
            iv_ruleEJB=ruleEJB();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEJB; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEJB3608); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEJB


    // $ANTLR start ruleEJB
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2161:1: ruleEJB returns [EObject current=null] : ( 'EJB' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) ';' '}' ) ;
    public final EObject ruleEJB() throws RecognitionException {
        EObject current = null;

        Token lv_jndiName_5_0=null;
        EObject lv_publisher_2_0 = null;

        EObject lv_provider_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2166:6: ( ( 'EJB' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) ';' '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2167:1: ( 'EJB' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) ';' '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2167:1: ( 'EJB' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) ';' '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2167:3: 'EJB' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'jndi-name' ( (lv_jndiName_5_0= RULE_STRING ) ) ';' '}'
            {
            match(input,44,FollowSets000.FOLLOW_44_in_ruleEJB3643); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEJBAccess().getEJBKeyword_0(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleEJB3653); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEJBAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2175:1: ( (lv_publisher_2_0= rulePublisher ) )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==24) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2176:1: (lv_publisher_2_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2176:1: (lv_publisher_2_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2177:3: lv_publisher_2_0= rulePublisher
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getEJBAccess().getPublisherPublisherParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleEJB3674);
                    lv_publisher_2_0=rulePublisher();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getEJBRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"publisher",
                      	        		lv_publisher_2_0, 
                      	        		"Publisher", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2199:3: ( (lv_provider_3_0= ruleProvider ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==25) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2200:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2200:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2201:3: lv_provider_3_0= ruleProvider
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getEJBAccess().getProviderProviderParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleEJB3696);
                    lv_provider_3_0=ruleProvider();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getEJBRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"provider",
                      	        		lv_provider_3_0, 
                      	        		"Provider", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,45,FollowSets000.FOLLOW_45_in_ruleEJB3707); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEJBAccess().getJndiNameKeyword_4(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2227:1: ( (lv_jndiName_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2228:1: (lv_jndiName_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2228:1: (lv_jndiName_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2229:3: lv_jndiName_5_0= RULE_STRING
            {
            lv_jndiName_5_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleEJB3724); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getEJBAccess().getJndiNameSTRINGTerminalRuleCall_5_0(), "jndiName"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getEJBRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"jndiName",
              	        		lv_jndiName_5_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleEJB3739); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEJBAccess().getSemicolonKeyword_6(), null); 
                  
            }
            match(input,18,FollowSets000.FOLLOW_18_in_ruleEJB3749); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getEJBAccess().getRightCurlyBracketKeyword_7(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEJB


    // $ANTLR start entryRuleHTTP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2267:1: entryRuleHTTP returns [EObject current=null] : iv_ruleHTTP= ruleHTTP EOF ;
    public final EObject entryRuleHTTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHTTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2268:2: (iv_ruleHTTP= ruleHTTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2269:2: iv_ruleHTTP= ruleHTTP EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getHTTPRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHTTP_in_entryRuleHTTP3785);
            iv_ruleHTTP=ruleHTTP();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleHTTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHTTP3795); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleHTTP


    // $ANTLR start ruleHTTP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2276:1: ruleHTTP returns [EObject current=null] : ( 'HTTP' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' '}' ) ;
    public final EObject ruleHTTP() throws RecognitionException {
        EObject current = null;

        Token lv_url_5_0=null;
        Token lv_providerUrl_8_0=null;
        EObject lv_publisher_2_0 = null;

        EObject lv_provider_3_0 = null;

        Enumerator lv_verb_11_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2281:6: ( ( 'HTTP' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2282:1: ( 'HTTP' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2282:1: ( 'HTTP' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2282:3: 'HTTP' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' '}'
            {
            match(input,46,FollowSets000.FOLLOW_46_in_ruleHTTP3830); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getHTTPKeyword_0(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleHTTP3840); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2290:1: ( (lv_publisher_2_0= rulePublisher ) )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==24) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2291:1: (lv_publisher_2_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2291:1: (lv_publisher_2_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2292:3: lv_publisher_2_0= rulePublisher
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getHTTPAccess().getPublisherPublisherParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleHTTP3861);
                    lv_publisher_2_0=rulePublisher();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getHTTPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"publisher",
                      	        		lv_publisher_2_0, 
                      	        		"Publisher", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2314:3: ( (lv_provider_3_0= ruleProvider ) )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==25) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2315:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2315:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2316:3: lv_provider_3_0= ruleProvider
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getHTTPAccess().getProviderProviderParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleHTTP3883);
                    lv_provider_3_0=ruleProvider();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getHTTPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"provider",
                      	        		lv_provider_3_0, 
                      	        		"Provider", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,47,FollowSets000.FOLLOW_47_in_ruleHTTP3894); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getUrlKeyword_4(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2342:1: ( (lv_url_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2343:1: (lv_url_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2343:1: (lv_url_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2344:3: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP3911); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getHTTPAccess().getUrlSTRINGTerminalRuleCall_5_0(), "url"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getHTTPRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"url",
              	        		lv_url_5_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleHTTP3926); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getSemicolonKeyword_6(), null); 
                  
            }
            match(input,48,FollowSets000.FOLLOW_48_in_ruleHTTP3936); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getProviderUrlKeyword_7(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2374:1: ( (lv_providerUrl_8_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2375:1: (lv_providerUrl_8_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2375:1: (lv_providerUrl_8_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2376:3: lv_providerUrl_8_0= RULE_STRING
            {
            lv_providerUrl_8_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleHTTP3953); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getHTTPAccess().getProviderUrlSTRINGTerminalRuleCall_8_0(), "providerUrl"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getHTTPRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"providerUrl",
              	        		lv_providerUrl_8_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleHTTP3968); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getSemicolonKeyword_9(), null); 
                  
            }
            match(input,49,FollowSets000.FOLLOW_49_in_ruleHTTP3978); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getVerbKeyword_10(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2406:1: ( (lv_verb_11_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2407:1: (lv_verb_11_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2407:1: (lv_verb_11_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2408:3: lv_verb_11_0= ruleVerb
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getHTTPAccess().getVerbVerbEnumRuleCall_11_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleHTTP3999);
            lv_verb_11_0=ruleVerb();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getHTTPRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"verb",
              	        		lv_verb_11_0, 
              	        		"Verb", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleHTTP4009); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getSemicolonKeyword_12(), null); 
                  
            }
            match(input,18,FollowSets000.FOLLOW_18_in_ruleHTTP4019); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHTTPAccess().getRightCurlyBracketKeyword_13(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleHTTP


    // $ANTLR start entryRuleREST
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2446:1: entryRuleREST returns [EObject current=null] : iv_ruleREST= ruleREST EOF ;
    public final EObject entryRuleREST() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleREST = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2447:2: (iv_ruleREST= ruleREST EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2448:2: iv_ruleREST= ruleREST EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getRESTRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleREST_in_entryRuleREST4055);
            iv_ruleREST=ruleREST();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleREST; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleREST4065); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleREST


    // $ANTLR start ruleREST
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2455:1: ruleREST returns [EObject current=null] : ( 'REST' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' 'format' ( (lv_format_14_0= ruleRESTFormat ) ) ';' '}' ) ;
    public final EObject ruleREST() throws RecognitionException {
        EObject current = null;

        Token lv_url_5_0=null;
        Token lv_providerUrl_8_0=null;
        EObject lv_publisher_2_0 = null;

        EObject lv_provider_3_0 = null;

        Enumerator lv_verb_11_0 = null;

        Enumerator lv_format_14_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2460:6: ( ( 'REST' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' 'format' ( (lv_format_14_0= ruleRESTFormat ) ) ';' '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2461:1: ( 'REST' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' 'format' ( (lv_format_14_0= ruleRESTFormat ) ) ';' '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2461:1: ( 'REST' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' 'format' ( (lv_format_14_0= ruleRESTFormat ) ) ';' '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2461:3: 'REST' '{' ( (lv_publisher_2_0= rulePublisher ) )? ( (lv_provider_3_0= ruleProvider ) )? 'url' ( (lv_url_5_0= RULE_STRING ) ) ';' 'provider-url' ( (lv_providerUrl_8_0= RULE_STRING ) ) ';' 'verb' ( (lv_verb_11_0= ruleVerb ) ) ';' 'format' ( (lv_format_14_0= ruleRESTFormat ) ) ';' '}'
            {
            match(input,50,FollowSets000.FOLLOW_50_in_ruleREST4100); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getRESTKeyword_0(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleREST4110); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2469:1: ( (lv_publisher_2_0= rulePublisher ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==24) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2470:1: (lv_publisher_2_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2470:1: (lv_publisher_2_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2471:3: lv_publisher_2_0= rulePublisher
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getRESTAccess().getPublisherPublisherParserRuleCall_2_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleREST4131);
                    lv_publisher_2_0=rulePublisher();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRESTRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"publisher",
                      	        		lv_publisher_2_0, 
                      	        		"Publisher", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2493:3: ( (lv_provider_3_0= ruleProvider ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==25) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2494:1: (lv_provider_3_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2494:1: (lv_provider_3_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2495:3: lv_provider_3_0= ruleProvider
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getRESTAccess().getProviderProviderParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleREST4153);
                    lv_provider_3_0=ruleProvider();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getRESTRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"provider",
                      	        		lv_provider_3_0, 
                      	        		"Provider", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,47,FollowSets000.FOLLOW_47_in_ruleREST4164); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getUrlKeyword_4(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2521:1: ( (lv_url_5_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2522:1: (lv_url_5_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2522:1: (lv_url_5_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2523:3: lv_url_5_0= RULE_STRING
            {
            lv_url_5_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST4181); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getRESTAccess().getUrlSTRINGTerminalRuleCall_5_0(), "url"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRESTRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"url",
              	        		lv_url_5_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleREST4196); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getSemicolonKeyword_6(), null); 
                  
            }
            match(input,48,FollowSets000.FOLLOW_48_in_ruleREST4206); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getProviderUrlKeyword_7(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2553:1: ( (lv_providerUrl_8_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2554:1: (lv_providerUrl_8_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2554:1: (lv_providerUrl_8_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2555:3: lv_providerUrl_8_0= RULE_STRING
            {
            lv_providerUrl_8_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleREST4223); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getRESTAccess().getProviderUrlSTRINGTerminalRuleCall_8_0(), "providerUrl"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRESTRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"providerUrl",
              	        		lv_providerUrl_8_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleREST4238); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getSemicolonKeyword_9(), null); 
                  
            }
            match(input,49,FollowSets000.FOLLOW_49_in_ruleREST4248); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getVerbKeyword_10(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2585:1: ( (lv_verb_11_0= ruleVerb ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2586:1: (lv_verb_11_0= ruleVerb )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2586:1: (lv_verb_11_0= ruleVerb )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2587:3: lv_verb_11_0= ruleVerb
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRESTAccess().getVerbVerbEnumRuleCall_11_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVerb_in_ruleREST4269);
            lv_verb_11_0=ruleVerb();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRESTRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"verb",
              	        		lv_verb_11_0, 
              	        		"Verb", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleREST4279); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getSemicolonKeyword_12(), null); 
                  
            }
            match(input,51,FollowSets000.FOLLOW_51_in_ruleREST4289); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getFormatKeyword_13(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2617:1: ( (lv_format_14_0= ruleRESTFormat ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2618:1: (lv_format_14_0= ruleRESTFormat )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2618:1: (lv_format_14_0= ruleRESTFormat )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2619:3: lv_format_14_0= ruleRESTFormat
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getRESTAccess().getFormatRESTFormatEnumRuleCall_14_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleRESTFormat_in_ruleREST4310);
            lv_format_14_0=ruleRESTFormat();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getRESTRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"format",
              	        		lv_format_14_0, 
              	        		"RESTFormat", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleREST4320); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getSemicolonKeyword_15(), null); 
                  
            }
            match(input,18,FollowSets000.FOLLOW_18_in_ruleREST4330); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getRESTAccess().getRightCurlyBracketKeyword_16(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleREST


    // $ANTLR start entryRuleJMS
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2657:1: entryRuleJMS returns [EObject current=null] : iv_ruleJMS= ruleJMS EOF ;
    public final EObject entryRuleJMS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJMS = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2658:2: (iv_ruleJMS= ruleJMS EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2659:2: iv_ruleJMS= ruleJMS EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getJMSRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleJMS_in_entryRuleJMS4366);
            iv_ruleJMS=ruleJMS();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleJMS; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleJMS4376); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleJMS


    // $ANTLR start ruleJMS
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2666:1: ruleJMS returns [EObject current=null] : ( 'JMS' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) ';' ( 'provider-jndi-name' ( (lv_providerJndi_10_0= RULE_STRING ) ) ';' )? '}' ) ;
    public final EObject ruleJMS() throws RecognitionException {
        EObject current = null;

        Token lv_jndiName_7_0=null;
        Token lv_providerJndi_10_0=null;
        EObject lv_publisher_3_0 = null;

        EObject lv_provider_4_0 = null;

        EObject lv_channel_5_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2671:6: ( ( 'JMS' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) ';' ( 'provider-jndi-name' ( (lv_providerJndi_10_0= RULE_STRING ) ) ';' )? '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2672:1: ( 'JMS' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) ';' ( 'provider-jndi-name' ( (lv_providerJndi_10_0= RULE_STRING ) ) ';' )? '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2672:1: ( 'JMS' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) ';' ( 'provider-jndi-name' ( (lv_providerJndi_10_0= RULE_STRING ) ) ';' )? '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2672:3: 'JMS' '{' () ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( (lv_channel_5_0= ruleTopicOrQueue ) )? 'jndi-name' ( (lv_jndiName_7_0= RULE_STRING ) ) ';' ( 'provider-jndi-name' ( (lv_providerJndi_10_0= RULE_STRING ) ) ';' )? '}'
            {
            match(input,52,FollowSets000.FOLLOW_52_in_ruleJMS4411); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJMSAccess().getJMSKeyword_0(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleJMS4421); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJMSAccess().getLeftCurlyBracketKeyword_1(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2680:1: ()
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2681:2: 
            {
            if ( backtracking==0 ) {
               
              	  /* */ 
              	
            }
            if ( backtracking==0 ) {
               
                      temp=factory.create(grammarAccess.getJMSAccess().getJMSAction_2().getType().getClassifier());
                      current = temp; 
                      temp = null;
                      CompositeNode newNode = createCompositeNode(grammarAccess.getJMSAccess().getJMSAction_2(), currentNode.getParent());
                  newNode.getChildren().add(currentNode);
                  moveLookaheadInfo(currentNode, newNode);
                  currentNode = newNode; 
                      associateNodeWithAstElement(currentNode, current); 
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2694:2: ( (lv_publisher_3_0= rulePublisher ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==24) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2695:1: (lv_publisher_3_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2695:1: (lv_publisher_3_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2696:3: lv_publisher_3_0= rulePublisher
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJMSAccess().getPublisherPublisherParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleJMS4454);
                    lv_publisher_3_0=rulePublisher();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJMSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"publisher",
                      	        		lv_publisher_3_0, 
                      	        		"Publisher", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2718:3: ( (lv_provider_4_0= ruleProvider ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==25) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2719:1: (lv_provider_4_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2719:1: (lv_provider_4_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2720:3: lv_provider_4_0= ruleProvider
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJMSAccess().getProviderProviderParserRuleCall_4_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleJMS4476);
                    lv_provider_4_0=ruleProvider();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJMSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"provider",
                      	        		lv_provider_4_0, 
                      	        		"Provider", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2742:3: ( (lv_channel_5_0= ruleTopicOrQueue ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( ((LA62_0>=54 && LA62_0<=55)) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2743:1: (lv_channel_5_0= ruleTopicOrQueue )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2743:1: (lv_channel_5_0= ruleTopicOrQueue )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2744:3: lv_channel_5_0= ruleTopicOrQueue
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getJMSAccess().getChannelTopicOrQueueParserRuleCall_5_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_ruleJMS4498);
                    lv_channel_5_0=ruleTopicOrQueue();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJMSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"channel",
                      	        		lv_channel_5_0, 
                      	        		"TopicOrQueue", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,45,FollowSets000.FOLLOW_45_in_ruleJMS4509); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJMSAccess().getJndiNameKeyword_6(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2770:1: ( (lv_jndiName_7_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2771:1: (lv_jndiName_7_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2771:1: (lv_jndiName_7_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2772:3: lv_jndiName_7_0= RULE_STRING
            {
            lv_jndiName_7_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4526); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getJMSAccess().getJndiNameSTRINGTerminalRuleCall_7_0(), "jndiName"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getJMSRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"jndiName",
              	        		lv_jndiName_7_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleJMS4541); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJMSAccess().getSemicolonKeyword_8(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2798:1: ( 'provider-jndi-name' ( (lv_providerJndi_10_0= RULE_STRING ) ) ';' )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==53) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2798:3: 'provider-jndi-name' ( (lv_providerJndi_10_0= RULE_STRING ) ) ';'
                    {
                    match(input,53,FollowSets000.FOLLOW_53_in_ruleJMS4552); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getJMSAccess().getProviderJndiNameKeyword_9_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2802:1: ( (lv_providerJndi_10_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2803:1: (lv_providerJndi_10_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2803:1: (lv_providerJndi_10_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2804:3: lv_providerJndi_10_0= RULE_STRING
                    {
                    lv_providerJndi_10_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleJMS4569); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getJMSAccess().getProviderJndiSTRINGTerminalRuleCall_9_1_0(), "providerJndi"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getJMSRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"providerJndi",
                      	        		lv_providerJndi_10_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleJMS4584); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getJMSAccess().getSemicolonKeyword_9_2(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleJMS4596); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getJMSAccess().getRightCurlyBracketKeyword_10(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleJMS


    // $ANTLR start entryRuleTopicOrQueue
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2842:1: entryRuleTopicOrQueue returns [EObject current=null] : iv_ruleTopicOrQueue= ruleTopicOrQueue EOF ;
    public final EObject entryRuleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopicOrQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2843:2: (iv_ruleTopicOrQueue= ruleTopicOrQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2844:2: iv_ruleTopicOrQueue= ruleTopicOrQueue EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTopicOrQueueRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4632);
            iv_ruleTopicOrQueue=ruleTopicOrQueue();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTopicOrQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopicOrQueue4642); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTopicOrQueue


    // $ANTLR start ruleTopicOrQueue
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2851:1: ruleTopicOrQueue returns [EObject current=null] : (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) ;
    public final EObject ruleTopicOrQueue() throws RecognitionException {
        EObject current = null;

        EObject this_Topic_0 = null;

        EObject this_Queue_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2856:6: ( (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2857:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2857:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==54) ) {
                alt64=1;
            }
            else if ( (LA64_0==55) ) {
                alt64=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("2857:1: (this_Topic_0= ruleTopic | this_Queue_1= ruleQueue )", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2858:2: this_Topic_0= ruleTopic
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTopicOrQueueAccess().getTopicParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleTopic_in_ruleTopicOrQueue4692);
                    this_Topic_0=ruleTopic();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Topic_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2871:2: this_Queue_1= ruleQueue
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getTopicOrQueueAccess().getQueueParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQueue_in_ruleTopicOrQueue4722);
                    this_Queue_1=ruleQueue();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_Queue_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTopicOrQueue


    // $ANTLR start entryRuleTopic
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2890:1: entryRuleTopic returns [EObject current=null] : iv_ruleTopic= ruleTopic EOF ;
    public final EObject entryRuleTopic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTopic = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2891:2: (iv_ruleTopic= ruleTopic EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2892:2: iv_ruleTopic= ruleTopic EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getTopicRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleTopic_in_entryRuleTopic4757);
            iv_ruleTopic=ruleTopic();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleTopic; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleTopic4767); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTopic


    // $ANTLR start ruleTopic
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2899:1: ruleTopic returns [EObject current=null] : ( 'topic' ( (lv_name_1_0= RULE_STRING ) ) ';' ) ;
    public final EObject ruleTopic() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2904:6: ( ( 'topic' ( (lv_name_1_0= RULE_STRING ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2905:1: ( 'topic' ( (lv_name_1_0= RULE_STRING ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2905:1: ( 'topic' ( (lv_name_1_0= RULE_STRING ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2905:3: 'topic' ( (lv_name_1_0= RULE_STRING ) ) ';'
            {
            match(input,54,FollowSets000.FOLLOW_54_in_ruleTopic4802); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTopicAccess().getTopicKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2909:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2910:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2910:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2911:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleTopic4819); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getTopicAccess().getNameSTRINGTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getTopicRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleTopic4834); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getTopicAccess().getSemicolonKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTopic


    // $ANTLR start entryRuleQueue
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2945:1: entryRuleQueue returns [EObject current=null] : iv_ruleQueue= ruleQueue EOF ;
    public final EObject entryRuleQueue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQueue = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2946:2: (iv_ruleQueue= ruleQueue EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2947:2: iv_ruleQueue= ruleQueue EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQueueRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQueue_in_entryRuleQueue4870);
            iv_ruleQueue=ruleQueue();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQueue; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQueue4880); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleQueue


    // $ANTLR start ruleQueue
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2954:1: ruleQueue returns [EObject current=null] : ( 'queue' ( (lv_name_1_0= RULE_STRING ) ) ';' ) ;
    public final EObject ruleQueue() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2959:6: ( ( 'queue' ( (lv_name_1_0= RULE_STRING ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2960:1: ( 'queue' ( (lv_name_1_0= RULE_STRING ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2960:1: ( 'queue' ( (lv_name_1_0= RULE_STRING ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2960:3: 'queue' ( (lv_name_1_0= RULE_STRING ) ) ';'
            {
            match(input,55,FollowSets000.FOLLOW_55_in_ruleQueue4915); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getQueueAccess().getQueueKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2964:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2965:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2965:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:2966:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleQueue4932); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getQueueAccess().getNameSTRINGTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getQueueRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleQueue4947); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getQueueAccess().getSemicolonKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleQueue


    // $ANTLR start entryRuleSCA
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3000:1: entryRuleSCA returns [EObject current=null] : iv_ruleSCA= ruleSCA EOF ;
    public final EObject entryRuleSCA() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSCA = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3001:2: (iv_ruleSCA= ruleSCA EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3002:2: iv_ruleSCA= ruleSCA EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSCARule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSCA_in_entryRuleSCA4983);
            iv_ruleSCA=ruleSCA();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSCA; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSCA4993); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSCA


    // $ANTLR start ruleSCA
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3009:1: ruleSCA returns [EObject current=null] : ( 'SCA' ( (lv_name_1_0= RULE_STRING ) ) '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'promote' ( (lv_promote_6_0= RULE_STRING ) ) ';' )? ( 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? ';' )? '}' ) ;
    public final EObject ruleSCA() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_promote_6_0=null;
        Token lv_reference_9_0=null;
        Token lv_isMultipleRef_10_0=null;
        EObject lv_publisher_3_0 = null;

        EObject lv_provider_4_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3014:6: ( ( 'SCA' ( (lv_name_1_0= RULE_STRING ) ) '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'promote' ( (lv_promote_6_0= RULE_STRING ) ) ';' )? ( 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? ';' )? '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3015:1: ( 'SCA' ( (lv_name_1_0= RULE_STRING ) ) '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'promote' ( (lv_promote_6_0= RULE_STRING ) ) ';' )? ( 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? ';' )? '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3015:1: ( 'SCA' ( (lv_name_1_0= RULE_STRING ) ) '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'promote' ( (lv_promote_6_0= RULE_STRING ) ) ';' )? ( 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? ';' )? '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3015:3: 'SCA' ( (lv_name_1_0= RULE_STRING ) ) '{' ( (lv_publisher_3_0= rulePublisher ) )? ( (lv_provider_4_0= ruleProvider ) )? ( 'promote' ( (lv_promote_6_0= RULE_STRING ) ) ';' )? ( 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? ';' )? '}'
            {
            match(input,56,FollowSets000.FOLLOW_56_in_ruleSCA5028); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSCAAccess().getSCAKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3019:1: ( (lv_name_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3020:1: (lv_name_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3020:1: (lv_name_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3021:3: lv_name_1_0= RULE_STRING
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA5045); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getSCAAccess().getNameSTRINGTerminalRuleCall_1_0(), "name"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getSCARule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"name",
              	        		lv_name_1_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleSCA5060); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSCAAccess().getLeftCurlyBracketKeyword_2(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3047:1: ( (lv_publisher_3_0= rulePublisher ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==24) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3048:1: (lv_publisher_3_0= rulePublisher )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3048:1: (lv_publisher_3_0= rulePublisher )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3049:3: lv_publisher_3_0= rulePublisher
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSCAAccess().getPublisherPublisherParserRuleCall_3_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_rulePublisher_in_ruleSCA5081);
                    lv_publisher_3_0=rulePublisher();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSCARule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"publisher",
                      	        		lv_publisher_3_0, 
                      	        		"Publisher", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3071:3: ( (lv_provider_4_0= ruleProvider ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==25) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3072:1: (lv_provider_4_0= ruleProvider )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3072:1: (lv_provider_4_0= ruleProvider )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3073:3: lv_provider_4_0= ruleProvider
                    {
                    if ( backtracking==0 ) {
                       
                      	        currentNode=createCompositeNode(grammarAccess.getSCAAccess().getProviderProviderParserRuleCall_4_0(), currentNode); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProvider_in_ruleSCA5103);
                    lv_provider_4_0=ruleProvider();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSCARule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode.getParent(), current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"provider",
                      	        		lv_provider_4_0, 
                      	        		"Provider", 
                      	        		currentNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	        currentNode = currentNode.getParent();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3095:3: ( 'promote' ( (lv_promote_6_0= RULE_STRING ) ) ';' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==57) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3095:5: 'promote' ( (lv_promote_6_0= RULE_STRING ) ) ';'
                    {
                    match(input,57,FollowSets000.FOLLOW_57_in_ruleSCA5115); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSCAAccess().getPromoteKeyword_5_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3099:1: ( (lv_promote_6_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3100:1: (lv_promote_6_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3100:1: (lv_promote_6_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3101:3: lv_promote_6_0= RULE_STRING
                    {
                    lv_promote_6_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA5132); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getSCAAccess().getPromoteSTRINGTerminalRuleCall_5_1_0(), "promote"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSCARule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"promote",
                      	        		lv_promote_6_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSCA5147); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSCAAccess().getSemicolonKeyword_5_2(), null); 
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3127:3: ( 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? ';' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==58) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3127:5: 'reference' ( (lv_reference_9_0= RULE_STRING ) ) ( (lv_isMultipleRef_10_0= '[]' ) )? ';'
                    {
                    match(input,58,FollowSets000.FOLLOW_58_in_ruleSCA5160); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSCAAccess().getReferenceKeyword_6_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3131:1: ( (lv_reference_9_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3132:1: (lv_reference_9_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3132:1: (lv_reference_9_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3133:3: lv_reference_9_0= RULE_STRING
                    {
                    lv_reference_9_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleSCA5177); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getSCAAccess().getReferenceSTRINGTerminalRuleCall_6_1_0(), "reference"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getSCARule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"reference",
                      	        		lv_reference_9_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3155:2: ( (lv_isMultipleRef_10_0= '[]' ) )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==59) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3156:1: (lv_isMultipleRef_10_0= '[]' )
                            {
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3156:1: (lv_isMultipleRef_10_0= '[]' )
                            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3157:3: lv_isMultipleRef_10_0= '[]'
                            {
                            lv_isMultipleRef_10_0=(Token)input.LT(1);
                            match(input,59,FollowSets000.FOLLOW_59_in_ruleSCA5200); if (failed) return current;
                            if ( backtracking==0 ) {

                                      createLeafNode(grammarAccess.getSCAAccess().getIsMultipleRefLeftSquareBracketRightSquareBracketKeyword_6_2_0(), "isMultipleRef"); 
                                  
                            }
                            if ( backtracking==0 ) {

                              	        if (current==null) {
                              	            current = factory.create(grammarAccess.getSCARule().getType().getClassifier());
                              	            associateNodeWithAstElement(currentNode, current);
                              	        }
                              	        
                              	        try {
                              	       		set(current, "isMultipleRef", true, "[]", lastConsumedNode);
                              	        } catch (ValueConverterException vce) {
                              				handleValueConverterException(vce);
                              	        }
                              	    
                            }

                            }


                            }
                            break;

                    }

                    match(input,23,FollowSets000.FOLLOW_23_in_ruleSCA5224); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getSCAAccess().getSemicolonKeyword_6_3(), null); 
                          
                    }

                    }
                    break;

            }

            match(input,18,FollowSets000.FOLLOW_18_in_ruleSCA5236); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getSCAAccess().getRightCurlyBracketKeyword_7(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSCA


    // $ANTLR start entryRuleFILE
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3192:1: entryRuleFILE returns [EObject current=null] : iv_ruleFILE= ruleFILE EOF ;
    public final EObject entryRuleFILE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFILE = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3193:2: (iv_ruleFILE= ruleFILE EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3194:2: iv_ruleFILE= ruleFILE EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFILERule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFILE_in_entryRuleFILE5272);
            iv_ruleFILE=ruleFILE();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFILE; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFILE5282); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFILE


    // $ANTLR start ruleFILE
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3201:1: ruleFILE returns [EObject current=null] : ( 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleFILE() throws RecognitionException {
        EObject current = null;

        Token lv_url_1_0=null;
        Token lv_pollIntervall_4_0=null;
        Enumerator lv_accessType_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3206:6: ( ( 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3207:1: ( 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3207:1: ( 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3207:3: 'FILE' ( (lv_url_1_0= RULE_STRING ) ) ( (lv_accessType_2_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )?
            {
            match(input,60,FollowSets000.FOLLOW_60_in_ruleFILE5317); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFILEAccess().getFILEKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3211:1: ( (lv_url_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3212:1: (lv_url_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3212:1: (lv_url_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3213:3: lv_url_1_0= RULE_STRING
            {
            lv_url_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE5334); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getFILEAccess().getUrlSTRINGTerminalRuleCall_1_0(), "url"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFILERule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"url",
              	        		lv_url_1_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3235:2: ( (lv_accessType_2_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3236:1: (lv_accessType_2_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3236:1: (lv_accessType_2_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3237:3: lv_accessType_2_0= ruleReadWrite
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getFILEAccess().getAccessTypeReadWriteEnumRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFILE5360);
            lv_accessType_2_0=ruleReadWrite();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFILERule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"accessType",
              	        		lv_accessType_2_0, 
              	        		"ReadWrite", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3259:2: ( 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==61) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3259:4: 'interval' ( (lv_pollIntervall_4_0= RULE_STRING ) )
                    {
                    match(input,61,FollowSets000.FOLLOW_61_in_ruleFILE5371); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFILEAccess().getIntervalKeyword_3_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3263:1: ( (lv_pollIntervall_4_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3264:1: (lv_pollIntervall_4_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3264:1: (lv_pollIntervall_4_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3265:3: lv_pollIntervall_4_0= RULE_STRING
                    {
                    lv_pollIntervall_4_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFILE5388); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getFILEAccess().getPollIntervallSTRINGTerminalRuleCall_3_1_0(), "pollIntervall"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFILERule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"pollIntervall",
                      	        		lv_pollIntervall_4_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFILE


    // $ANTLR start entryRuleFTP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3295:1: entryRuleFTP returns [EObject current=null] : iv_ruleFTP= ruleFTP EOF ;
    public final EObject entryRuleFTP() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFTP = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3296:2: (iv_ruleFTP= ruleFTP EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3297:2: iv_ruleFTP= ruleFTP EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getFTPRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFTP_in_entryRuleFTP5431);
            iv_ruleFTP=ruleFTP();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleFTP; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFTP5441); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleFTP


    // $ANTLR start ruleFTP
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3304:1: ruleFTP returns [EObject current=null] : ( 'FTP' ( (lv_url_1_0= RULE_STRING ) ) 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleFTP() throws RecognitionException {
        EObject current = null;

        Token lv_url_1_0=null;
        Token lv_pollIntervall_5_0=null;
        Enumerator lv_accessType_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3309:6: ( ( 'FTP' ( (lv_url_1_0= RULE_STRING ) ) 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3310:1: ( 'FTP' ( (lv_url_1_0= RULE_STRING ) ) 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3310:1: ( 'FTP' ( (lv_url_1_0= RULE_STRING ) ) 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3310:3: 'FTP' ( (lv_url_1_0= RULE_STRING ) ) 'access' ( (lv_accessType_3_0= ruleReadWrite ) ) ( 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )?
            {
            match(input,62,FollowSets000.FOLLOW_62_in_ruleFTP5476); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFTPAccess().getFTPKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3314:1: ( (lv_url_1_0= RULE_STRING ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3315:1: (lv_url_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3315:1: (lv_url_1_0= RULE_STRING )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3316:3: lv_url_1_0= RULE_STRING
            {
            lv_url_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFTP5493); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getFTPAccess().getUrlSTRINGTerminalRuleCall_1_0(), "url"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFTPRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"url",
              	        		lv_url_1_0, 
              	        		"STRING", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }

            match(input,63,FollowSets000.FOLLOW_63_in_ruleFTP5508); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getFTPAccess().getAccessKeyword_2(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3342:1: ( (lv_accessType_3_0= ruleReadWrite ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3343:1: (lv_accessType_3_0= ruleReadWrite )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3343:1: (lv_accessType_3_0= ruleReadWrite )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3344:3: lv_accessType_3_0= ruleReadWrite
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getFTPAccess().getAccessTypeReadWriteEnumRuleCall_3_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleReadWrite_in_ruleFTP5529);
            lv_accessType_3_0=ruleReadWrite();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getFTPRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"accessType",
              	        		lv_accessType_3_0, 
              	        		"ReadWrite", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3366:2: ( 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==61) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3366:4: 'interval' ( (lv_pollIntervall_5_0= RULE_STRING ) )
                    {
                    match(input,61,FollowSets000.FOLLOW_61_in_ruleFTP5540); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getFTPAccess().getIntervalKeyword_4_0(), null); 
                          
                    }
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3370:1: ( (lv_pollIntervall_5_0= RULE_STRING ) )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3371:1: (lv_pollIntervall_5_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3371:1: (lv_pollIntervall_5_0= RULE_STRING )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3372:3: lv_pollIntervall_5_0= RULE_STRING
                    {
                    lv_pollIntervall_5_0=(Token)input.LT(1);
                    match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFTP5557); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getFTPAccess().getPollIntervallSTRINGTerminalRuleCall_4_1_0(), "pollIntervall"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getFTPRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"pollIntervall",
                      	        		lv_pollIntervall_5_0, 
                      	        		"STRING", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleFTP


    // $ANTLR start entryRulePolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3402:1: entryRulePolicy returns [EObject current=null] : iv_rulePolicy= rulePolicy EOF ;
    public final EObject entryRulePolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3403:2: (iv_rulePolicy= rulePolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3404:2: iv_rulePolicy= rulePolicy EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getPolicyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePolicy_in_entryRulePolicy5600);
            iv_rulePolicy=rulePolicy();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_rulePolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePolicy5610); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePolicy


    // $ANTLR start rulePolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3411:1: rulePolicy returns [EObject current=null] : (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) ;
    public final EObject rulePolicy() throws RecognitionException {
        EObject current = null;

        EObject this_LogPolicy_0 = null;

        EObject this_SecurityPolicy_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3416:6: ( (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3417:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3417:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==64) ) {
                alt72=1;
            }
            else if ( (LA72_0==65||(LA72_0>=70 && LA72_0<=72)) ) {
                alt72=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3417:1: (this_LogPolicy_0= ruleLogPolicy | this_SecurityPolicy_1= ruleSecurityPolicy )", 72, 0, input);

                throw nvae;
            }
            switch (alt72) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3418:2: this_LogPolicy_0= ruleLogPolicy
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPolicyAccess().getLogPolicyParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_rulePolicy5660);
                    this_LogPolicy_0=ruleLogPolicy();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LogPolicy_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3431:2: this_SecurityPolicy_1= ruleSecurityPolicy
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getPolicyAccess().getSecurityPolicyParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_rulePolicy5690);
                    this_SecurityPolicy_1=ruleSecurityPolicy();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_SecurityPolicy_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePolicy


    // $ANTLR start entryRuleLogPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3450:1: entryRuleLogPolicy returns [EObject current=null] : iv_ruleLogPolicy= ruleLogPolicy EOF ;
    public final EObject entryRuleLogPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3451:2: (iv_ruleLogPolicy= ruleLogPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3452:2: iv_ruleLogPolicy= ruleLogPolicy EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLogPolicyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy5725);
            iv_ruleLogPolicy=ruleLogPolicy();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLogPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLogPolicy5735); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleLogPolicy


    // $ANTLR start ruleLogPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3459:1: ruleLogPolicy returns [EObject current=null] : ( 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ';' ) ;
    public final EObject ruleLogPolicy() throws RecognitionException {
        EObject current = null;

        Enumerator lv_logPolicy_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3464:6: ( ( 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3465:1: ( 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3465:1: ( 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3465:3: 'logging policy' ( (lv_logPolicy_1_0= ruleLogPolicyKind ) ) ';'
            {
            match(input,64,FollowSets000.FOLLOW_64_in_ruleLogPolicy5770); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLogPolicyAccess().getLoggingPolicyKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3469:1: ( (lv_logPolicy_1_0= ruleLogPolicyKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3470:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3470:1: (lv_logPolicy_1_0= ruleLogPolicyKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3471:3: lv_logPolicy_1_0= ruleLogPolicyKind
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLogPolicyAccess().getLogPolicyLogPolicyKindEnumRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy5791);
            lv_logPolicy_1_0=ruleLogPolicyKind();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLogPolicyRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"logPolicy",
              	        		lv_logPolicy_1_0, 
              	        		"LogPolicyKind", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleLogPolicy5801); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLogPolicyAccess().getSemicolonKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogPolicy


    // $ANTLR start entryRuleSecurityPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3505:1: entryRuleSecurityPolicy returns [EObject current=null] : iv_ruleSecurityPolicy= ruleSecurityPolicy EOF ;
    public final EObject entryRuleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSecurityPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3506:2: (iv_ruleSecurityPolicy= ruleSecurityPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3507:2: iv_ruleSecurityPolicy= ruleSecurityPolicy EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSecurityPolicyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy5837);
            iv_ruleSecurityPolicy=ruleSecurityPolicy();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSecurityPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSecurityPolicy5847); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSecurityPolicy


    // $ANTLR start ruleSecurityPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3514:1: ruleSecurityPolicy returns [EObject current=null] : (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy ) ;
    public final EObject ruleSecurityPolicy() throws RecognitionException {
        EObject current = null;

        EObject this_AuthenticationPolicy_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3519:6: ( (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3520:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3520:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy )
            int alt73=4;
            switch ( input.LA(1) ) {
            case 65:
                {
                alt73=1;
                }
                break;
            case 70:
                {
                alt73=2;
                }
                break;
            case 71:
                {
                alt73=3;
                }
                break;
            case 72:
                {
                alt73=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("3520:1: (this_AuthenticationPolicy_0= ruleAuthenticationPolicy | ruleAuthorizationPolicy | ruleSigningPolicy | ruleEncryptionPolicy )", 73, 0, input);

                throw nvae;
            }

            switch (alt73) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3521:2: this_AuthenticationPolicy_0= ruleAuthenticationPolicy
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthenticationPolicyParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy5897);
                    this_AuthenticationPolicy_0=ruleAuthenticationPolicy();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_AuthenticationPolicy_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3534:2: ruleAuthorizationPolicy
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSecurityPolicyAccess().getAuthorizationPolicyParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAuthorizationPolicy_in_ruleSecurityPolicy5921);
                    ruleAuthorizationPolicy();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3546:2: ruleSigningPolicy
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSecurityPolicyAccess().getSigningPolicyParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy5945);
                    ruleSigningPolicy();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3558:2: ruleEncryptionPolicy
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getSecurityPolicyAccess().getEncryptionPolicyParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy5969);
                    ruleEncryptionPolicy();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSecurityPolicy


    // $ANTLR start entryRuleAuthenticationPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3576:1: entryRuleAuthenticationPolicy returns [EObject current=null] : iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF ;
    public final EObject entryRuleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthenticationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3577:2: (iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3578:2: iv_ruleAuthenticationPolicy= ruleAuthenticationPolicy EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAuthenticationPolicyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6004);
            iv_ruleAuthenticationPolicy=ruleAuthenticationPolicy();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAuthenticationPolicy; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthenticationPolicy6014); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAuthenticationPolicy


    // $ANTLR start ruleAuthenticationPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3585:1: ruleAuthenticationPolicy returns [EObject current=null] : ( 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? '{' 'auth tokens' '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ '}' 'hash algorithms' '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* '}' '}' ) ;
    public final EObject ruleAuthenticationPolicy() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_optional_2_0=null;
        EObject lv_authTokens_6_0 = null;

        EObject lv_hashAlgorithms_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3590:6: ( ( 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? '{' 'auth tokens' '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ '}' 'hash algorithms' '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* '}' '}' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3591:1: ( 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? '{' 'auth tokens' '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ '}' 'hash algorithms' '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* '}' '}' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3591:1: ( 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? '{' 'auth tokens' '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ '}' 'hash algorithms' '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* '}' '}' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3591:3: 'authn policy' ( (lv_name_1_0= RULE_ID ) )? ( (lv_optional_2_0= 'optional' ) )? '{' 'auth tokens' '{' ( (lv_authTokens_6_0= ruleAuthToken ) )+ '}' 'hash algorithms' '{' ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )* '}' '}'
            {
            match(input,65,FollowSets000.FOLLOW_65_in_ruleAuthenticationPolicy6049); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getAuthnPolicyKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3595:1: ( (lv_name_1_0= RULE_ID ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3596:1: (lv_name_1_0= RULE_ID )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3596:1: (lv_name_1_0= RULE_ID )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3597:3: lv_name_1_0= RULE_ID
                    {
                    lv_name_1_0=(Token)input.LT(1);
                    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6066); if (failed) return current;
                    if ( backtracking==0 ) {

                      			createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
                      		
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getAuthenticationPolicyRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        try {
                      	       		set(
                      	       			current, 
                      	       			"name",
                      	        		lv_name_1_0, 
                      	        		"ID", 
                      	        		lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3619:3: ( (lv_optional_2_0= 'optional' ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==66) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3620:1: (lv_optional_2_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3620:1: (lv_optional_2_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3621:3: lv_optional_2_0= 'optional'
                    {
                    lv_optional_2_0=(Token)input.LT(1);
                    match(input,66,FollowSets000.FOLLOW_66_in_ruleAuthenticationPolicy6090); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getOptionalOptionalKeyword_2_0(), "optional"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getAuthenticationPolicyRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "optional", true, "optional", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            match(input,16,FollowSets000.FOLLOW_16_in_ruleAuthenticationPolicy6114); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_3(), null); 
                  
            }
            match(input,67,FollowSets000.FOLLOW_67_in_ruleAuthenticationPolicy6124); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getAuthTokensKeyword_4(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleAuthenticationPolicy6134); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_5(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3652:1: ( (lv_authTokens_6_0= ruleAuthToken ) )+
            int cnt76=0;
            loop76:
            do {
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==66||(LA76_0>=130 && LA76_0<=133)) ) {
                    alt76=1;
                }


                switch (alt76) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3653:1: (lv_authTokens_6_0= ruleAuthToken )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3653:1: (lv_authTokens_6_0= ruleAuthToken )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3654:3: lv_authTokens_6_0= ruleAuthToken
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getAuthTokensAuthTokenParserRuleCall_6_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6155);
            	    lv_authTokens_6_0=ruleAuthToken();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAuthenticationPolicyRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"authTokens",
            	      	        		lv_authTokens_6_0, 
            	      	        		"AuthToken", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt76 >= 1 ) break loop76;
            	    if (backtracking>0) {failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(76, input);
                        throw eee;
                }
                cnt76++;
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6166); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_7(), null); 
                  
            }
            match(input,68,FollowSets000.FOLLOW_68_in_ruleAuthenticationPolicy6176); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsKeyword_8(), null); 
                  
            }
            match(input,16,FollowSets000.FOLLOW_16_in_ruleAuthenticationPolicy6186); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getLeftCurlyBracketKeyword_9(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3688:1: ( (lv_hashAlgorithms_10_0= ruleHashAlgorithm ) )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==66||LA77_0==69||(LA77_0>=126 && LA77_0<=129)) ) {
                    alt77=1;
                }


                switch (alt77) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3689:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    {
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3689:1: (lv_hashAlgorithms_10_0= ruleHashAlgorithm )
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3690:3: lv_hashAlgorithms_10_0= ruleHashAlgorithm
            	    {
            	    if ( backtracking==0 ) {
            	       
            	      	        currentNode=createCompositeNode(grammarAccess.getAuthenticationPolicyAccess().getHashAlgorithmsHashAlgorithmParserRuleCall_10_0(), currentNode); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy6207);
            	    lv_hashAlgorithms_10_0=ruleHashAlgorithm();
            	    _fsp--;
            	    if (failed) return current;
            	    if ( backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = factory.create(grammarAccess.getAuthenticationPolicyRule().getType().getClassifier());
            	      	            associateNodeWithAstElement(currentNode.getParent(), current);
            	      	        }
            	      	        try {
            	      	       		add(
            	      	       			current, 
            	      	       			"hashAlgorithms",
            	      	        		lv_hashAlgorithms_10_0, 
            	      	        		"HashAlgorithm", 
            	      	        		currentNode);
            	      	        } catch (ValueConverterException vce) {
            	      				handleValueConverterException(vce);
            	      	        }
            	      	        currentNode = currentNode.getParent();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop77;
                }
            } while (true);

            match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6218); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_11(), null); 
                  
            }
            match(input,18,FollowSets000.FOLLOW_18_in_ruleAuthenticationPolicy6228); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthenticationPolicyAccess().getRightCurlyBracketKeyword_12(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAuthenticationPolicy


    // $ANTLR start entryRuleAuthToken
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3728:1: entryRuleAuthToken returns [EObject current=null] : iv_ruleAuthToken= ruleAuthToken EOF ;
    public final EObject entryRuleAuthToken() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAuthToken = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3729:2: (iv_ruleAuthToken= ruleAuthToken EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3730:2: iv_ruleAuthToken= ruleAuthToken EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAuthTokenRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthToken_in_entryRuleAuthToken6264);
            iv_ruleAuthToken=ruleAuthToken();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAuthToken; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthToken6274); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAuthToken


    // $ANTLR start ruleAuthToken
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3737:1: ruleAuthToken returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ';' ) ;
    public final EObject ruleAuthToken() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Enumerator lv_kind_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3742:6: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3743:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3743:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3743:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_kind_1_0= ruleAuthTokenKind ) ) ';'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3743:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==66) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3744:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3744:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3745:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)input.LT(1);
                    match(input,66,FollowSets000.FOLLOW_66_in_ruleAuthToken6317); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getAuthTokenAccess().getOptionalOptionalKeyword_0_0(), "optional"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getAuthTokenRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "optional", true, "optional", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3764:3: ( (lv_kind_1_0= ruleAuthTokenKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3765:1: (lv_kind_1_0= ruleAuthTokenKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3765:1: (lv_kind_1_0= ruleAuthTokenKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3766:3: lv_kind_1_0= ruleAuthTokenKind
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getAuthTokenAccess().getKindAuthTokenKindEnumRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthTokenKind_in_ruleAuthToken6352);
            lv_kind_1_0=ruleAuthTokenKind();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getAuthTokenRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"kind",
              	        		lv_kind_1_0, 
              	        		"AuthTokenKind", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleAuthToken6362); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getAuthTokenAccess().getSemicolonKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAuthToken


    // $ANTLR start entryRuleHashAlgorithm
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3800:1: entryRuleHashAlgorithm returns [EObject current=null] : iv_ruleHashAlgorithm= ruleHashAlgorithm EOF ;
    public final EObject entryRuleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHashAlgorithm = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3801:2: (iv_ruleHashAlgorithm= ruleHashAlgorithm EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3802:2: iv_ruleHashAlgorithm= ruleHashAlgorithm EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getHashAlgorithmRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm6398);
            iv_ruleHashAlgorithm=ruleHashAlgorithm();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleHashAlgorithm; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleHashAlgorithm6408); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleHashAlgorithm


    // $ANTLR start ruleHashAlgorithm
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3809:1: ruleHashAlgorithm returns [EObject current=null] : ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ';' ) ;
    public final EObject ruleHashAlgorithm() throws RecognitionException {
        EObject current = null;

        Token lv_optional_0_0=null;
        Token lv_useBase64_1_0=null;
        Enumerator lv_kind_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3814:6: ( ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3815:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3815:1: ( ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3815:2: ( (lv_optional_0_0= 'optional' ) )? ( (lv_useBase64_1_0= 'Base64-encoded' ) )? ( (lv_kind_2_0= ruleHashAlgKind ) ) ';'
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3815:2: ( (lv_optional_0_0= 'optional' ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==66) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3816:1: (lv_optional_0_0= 'optional' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3816:1: (lv_optional_0_0= 'optional' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3817:3: lv_optional_0_0= 'optional'
                    {
                    lv_optional_0_0=(Token)input.LT(1);
                    match(input,66,FollowSets000.FOLLOW_66_in_ruleHashAlgorithm6451); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getHashAlgorithmAccess().getOptionalOptionalKeyword_0_0(), "optional"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getHashAlgorithmRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "optional", true, "optional", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3836:3: ( (lv_useBase64_1_0= 'Base64-encoded' ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==69) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3837:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3837:1: (lv_useBase64_1_0= 'Base64-encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3838:3: lv_useBase64_1_0= 'Base64-encoded'
                    {
                    lv_useBase64_1_0=(Token)input.LT(1);
                    match(input,69,FollowSets000.FOLLOW_69_in_ruleHashAlgorithm6483); if (failed) return current;
                    if ( backtracking==0 ) {

                              createLeafNode(grammarAccess.getHashAlgorithmAccess().getUseBase64Base64EncodedKeyword_1_0(), "useBase64"); 
                          
                    }
                    if ( backtracking==0 ) {

                      	        if (current==null) {
                      	            current = factory.create(grammarAccess.getHashAlgorithmRule().getType().getClassifier());
                      	            associateNodeWithAstElement(currentNode, current);
                      	        }
                      	        
                      	        try {
                      	       		set(current, "useBase64", true, "Base64-encoded", lastConsumedNode);
                      	        } catch (ValueConverterException vce) {
                      				handleValueConverterException(vce);
                      	        }
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3857:3: ( (lv_kind_2_0= ruleHashAlgKind ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3858:1: (lv_kind_2_0= ruleHashAlgKind )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3858:1: (lv_kind_2_0= ruleHashAlgKind )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3859:3: lv_kind_2_0= ruleHashAlgKind
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getHashAlgorithmAccess().getKindHashAlgKindEnumRuleCall_2_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm6518);
            lv_kind_2_0=ruleHashAlgKind();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getHashAlgorithmRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"kind",
              	        		lv_kind_2_0, 
              	        		"HashAlgKind", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleHashAlgorithm6528); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getHashAlgorithmAccess().getSemicolonKeyword_3(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleHashAlgorithm


    // $ANTLR start entryRuleAuthorizationPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3893:1: entryRuleAuthorizationPolicy returns [String current=null] : iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF ;
    public final String entryRuleAuthorizationPolicy() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAuthorizationPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3894:2: (iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3895:2: iv_ruleAuthorizationPolicy= ruleAuthorizationPolicy EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getAuthorizationPolicyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAuthorizationPolicy_in_entryRuleAuthorizationPolicy6565);
            iv_ruleAuthorizationPolicy=ruleAuthorizationPolicy();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleAuthorizationPolicy.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAuthorizationPolicy6576); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAuthorizationPolicy


    // $ANTLR start ruleAuthorizationPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3902:1: ruleAuthorizationPolicy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'authorization rolicy' ;
    public final AntlrDatatypeRuleToken ruleAuthorizationPolicy() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3907:6: (kw= 'authorization rolicy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3909:2: kw= 'authorization rolicy'
            {
            kw=(Token)input.LT(1);
            match(input,70,FollowSets000.FOLLOW_70_in_ruleAuthorizationPolicy6613); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getAuthorizationPolicyAccess().getAuthorizationRolicyKeyword(), null); 
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAuthorizationPolicy


    // $ANTLR start entryRuleSigningPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3922:1: entryRuleSigningPolicy returns [String current=null] : iv_ruleSigningPolicy= ruleSigningPolicy EOF ;
    public final String entryRuleSigningPolicy() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleSigningPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3923:2: (iv_ruleSigningPolicy= ruleSigningPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3924:2: iv_ruleSigningPolicy= ruleSigningPolicy EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getSigningPolicyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy6653);
            iv_ruleSigningPolicy=ruleSigningPolicy();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleSigningPolicy.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSigningPolicy6664); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSigningPolicy


    // $ANTLR start ruleSigningPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3931:1: ruleSigningPolicy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'signing policy' ;
    public final AntlrDatatypeRuleToken ruleSigningPolicy() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3936:6: (kw= 'signing policy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3938:2: kw= 'signing policy'
            {
            kw=(Token)input.LT(1);
            match(input,71,FollowSets000.FOLLOW_71_in_ruleSigningPolicy6701); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getSigningPolicyAccess().getSigningPolicyKeyword(), null); 
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSigningPolicy


    // $ANTLR start entryRuleEncryptionPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3951:1: entryRuleEncryptionPolicy returns [String current=null] : iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF ;
    public final String entryRuleEncryptionPolicy() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEncryptionPolicy = null;


        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3952:2: (iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3953:2: iv_ruleEncryptionPolicy= ruleEncryptionPolicy EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getEncryptionPolicyRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy6741);
            iv_ruleEncryptionPolicy=ruleEncryptionPolicy();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleEncryptionPolicy.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEncryptionPolicy6752); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEncryptionPolicy


    // $ANTLR start ruleEncryptionPolicy
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3960:1: ruleEncryptionPolicy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= 'encryption policy' ;
    public final AntlrDatatypeRuleToken ruleEncryptionPolicy() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3965:6: (kw= 'encryption policy' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3967:2: kw= 'encryption policy'
            {
            kw=(Token)input.LT(1);
            match(input,72,FollowSets000.FOLLOW_72_in_ruleEncryptionPolicy6789); if (failed) return current;
            if ( backtracking==0 ) {

                      current.merge(kw);
                      createLeafNode(grammarAccess.getEncryptionPolicyAccess().getEncryptionPolicyKeyword(), null); 
                  
            }

            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEncryptionPolicy


    // $ANTLR start entryRuleImport
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3980:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3984:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3985:2: iv_ruleImport= ruleImport EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport6834);
            iv_ruleImport=ruleImport();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport6844); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:3995:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ';' ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4001:6: ( ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ';' ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4002:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ';' )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4002:1: ( 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ';' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4002:3: 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ';'
            {
            match(input,73,FollowSets000.FOLLOW_73_in_ruleImport6883); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4006:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4007:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4007:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4008:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport6904);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"importedNamespace",
              	        		lv_importedNamespace_1_0, 
              	        		"QualifiedNameWithWildCard", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,23,FollowSets000.FOLLOW_23_in_ruleImport6914); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getImportAccess().getSemicolonKeyword_2(), null); 
                  
            }

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleVersionId
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4045:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4049:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4050:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVersionIdRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId6961);
            iv_ruleVersionId=ruleVersionId();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId6972); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleVersionId


    // $ANTLR start ruleVersionId
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4060:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4066:6: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4067:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4067:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4067:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )*
            {
            this_INT_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7016); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4074:1: (kw= '.' this_INT_2= RULE_INT )*
            loop81:
            do {
                int alt81=2;
                int LA81_0 = input.LA(1);

                if ( (LA81_0==74) ) {
                    alt81=1;
                }


                switch (alt81) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4075:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,74,FollowSets000.FOLLOW_74_in_ruleVersionId7035); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_INT_2=(Token)input.LT(1);
            	    match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId7050); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop81;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleVersionId


    // $ANTLR start entryRuleVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4102:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4106:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4107:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getVersionRefRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef7111);
            iv_ruleVersionRef=ruleVersionRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef7121); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleVersionRef


    // $ANTLR start ruleVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4117:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4123:6: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4124:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4124:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef )
            int alt82=4;
            switch ( input.LA(1) ) {
            case 75:
                {
                int LA82_1 = input.LA(2);

                if ( (LA82_1==77) ) {
                    alt82=3;
                }
                else if ( (LA82_1==RULE_INT) ) {
                    alt82=1;
                }
                else {
                    if (backtracking>0) {failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("4124:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef )", 82, 1, input);

                    throw nvae;
                }
                }
                break;
            case 76:
                {
                alt82=2;
                }
                break;
            case 79:
                {
                alt82=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4124:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef )", 82, 0, input);

                throw nvae;
            }

            switch (alt82) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4125:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef7175);
                    this_MinVersionRef_0=ruleMinVersionRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_MinVersionRef_0; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4138:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7205);
                    this_MaxVersionRef_1=ruleMaxVersionRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_MaxVersionRef_1; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4151:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7235);
                    this_LowerBoundRangeVersionRef_2=ruleLowerBoundRangeVersionRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_LowerBoundRangeVersionRef_2; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4164:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( backtracking==0 ) {
                       
                              currentNode=createCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3(), currentNode); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7265);
                    this_MajorVersionRef_3=ruleMajorVersionRef();
                    _fsp--;
                    if (failed) return current;
                    if ( backtracking==0 ) {
                       
                              current = this_MajorVersionRef_3; 
                              currentNode = currentNode.getParent();
                          
                    }

                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleVersionRef


    // $ANTLR start entryRuleMinVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4186:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4190:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4191:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMinVersionRefRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7310);
            iv_ruleMinVersionRef=ruleMinVersionRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef7320); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleMinVersionRef


    // $ANTLR start ruleMinVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4201:1: ruleMinVersionRef returns [EObject current=null] : ( 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4207:6: ( ( 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4208:1: ( 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4208:1: ( 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4208:3: 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            match(input,75,FollowSets000.FOLLOW_75_in_ruleMinVersionRef7359); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4212:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4213:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4213:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4214:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef7380);
            lv_minVersion_1_0=ruleVersionId();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getMinVersionRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"minVersion",
              	        		lv_minVersion_1_0, 
              	        		"VersionId", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleMinVersionRef


    // $ANTLR start entryRuleMaxVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4247:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4251:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4252:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMaxVersionRefRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7426);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef7436); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleMaxVersionRef


    // $ANTLR start ruleMaxVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4262:1: ruleMaxVersionRef returns [EObject current=null] : ( 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4268:6: ( ( 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4269:1: ( 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4269:1: ( 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4269:3: 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            match(input,76,FollowSets000.FOLLOW_76_in_ruleMaxVersionRef7475); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4273:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4274:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4274:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4275:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef7496);
            lv_maxVersion_1_0=ruleVersionId();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getMaxVersionRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"maxVersion",
              	        		lv_maxVersion_1_0, 
              	        		"VersionId", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleMaxVersionRef


    // $ANTLR start entryRuleLowerBoundRangeVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4308:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4312:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4313:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7542);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7552); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleLowerBoundRangeVersionRef


    // $ANTLR start ruleLowerBoundRangeVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4323:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( ( 'minVersion' '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) ',' ( 'maxVersion' '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
    public final EObject ruleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_minVersion_2_0 = null;

        AntlrDatatypeRuleToken lv_maxVersion_6_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4329:6: ( ( ( 'minVersion' '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) ',' ( 'maxVersion' '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:1: ( ( 'minVersion' '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) ',' ( 'maxVersion' '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:1: ( ( 'minVersion' '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) ',' ( 'maxVersion' '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:2: ( 'minVersion' '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) ',' ( 'maxVersion' '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:2: ( 'minVersion' '>=' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4330:4: 'minVersion' '>='
            {
            match(input,75,FollowSets000.FOLLOW_75_in_ruleLowerBoundRangeVersionRef7592); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0(), null); 
                  
            }
            match(input,77,FollowSets000.FOLLOW_77_in_ruleLowerBoundRangeVersionRef7602); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1(), null); 
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4338:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4339:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4339:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4340:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7624);
            lv_minVersion_2_0=ruleVersionId();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLowerBoundRangeVersionRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"minVersion",
              	        		lv_minVersion_2_0, 
              	        		"VersionId", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }

            match(input,22,FollowSets000.FOLLOW_22_in_ruleLowerBoundRangeVersionRef7634); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4366:1: ( 'maxVersion' '<' )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4366:3: 'maxVersion' '<'
            {
            match(input,76,FollowSets000.FOLLOW_76_in_ruleLowerBoundRangeVersionRef7645); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0(), null); 
                  
            }
            match(input,78,FollowSets000.FOLLOW_78_in_ruleLowerBoundRangeVersionRef7655); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1(), null); 
                  
            }

            }

            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4374:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4375:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4375:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4376:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( backtracking==0 ) {
               
              	        currentNode=createCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0(), currentNode); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7677);
            lv_maxVersion_6_0=ruleVersionId();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getLowerBoundRangeVersionRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode.getParent(), current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"maxVersion",
              	        		lv_maxVersion_6_0, 
              	        		"VersionId", 
              	        		currentNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	        currentNode = currentNode.getParent();
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleLowerBoundRangeVersionRef


    // $ANTLR start entryRuleMajorVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4409:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4413:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4414:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getMajorVersionRefRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef7723);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef7733); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleMajorVersionRef


    // $ANTLR start ruleMajorVersionRef
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4424:1: ruleMajorVersionRef returns [EObject current=null] : ( 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token lv_majorVersion_1_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4430:6: ( ( 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4431:1: ( 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4431:1: ( 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4431:3: 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            match(input,79,FollowSets000.FOLLOW_79_in_ruleMajorVersionRef7772); if (failed) return current;
            if ( backtracking==0 ) {

                      createLeafNode(grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4435:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4436:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4436:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4437:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)input.LT(1);
            match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef7789); if (failed) return current;
            if ( backtracking==0 ) {

              			createLeafNode(grammarAccess.getMajorVersionRefAccess().getMajorVersionINTTerminalRuleCall_1_0(), "majorVersion"); 
              		
            }
            if ( backtracking==0 ) {

              	        if (current==null) {
              	            current = factory.create(grammarAccess.getMajorVersionRefRule().getType().getClassifier());
              	            associateNodeWithAstElement(currentNode, current);
              	        }
              	        try {
              	       		set(
              	       			current, 
              	       			"majorVersion",
              	        		lv_majorVersion_1_0, 
              	        		"INT", 
              	        		lastConsumedNode);
              	        } catch (ValueConverterException vce) {
              				handleValueConverterException(vce);
              	        }
              	    
            }

            }


            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleMajorVersionRef


    // $ANTLR start entryRuleQualifiedNameWithWildCard
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4470:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4474:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4475:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard7841);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard7852); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleQualifiedNameWithWildCard


    // $ANTLR start ruleQualifiedNameWithWildCard
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4485:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4491:6: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4492:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4492:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4493:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( backtracking==0 ) {
               
                      currentNode=createCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0(), currentNode); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard7903);
            this_QualifiedName_0=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( backtracking==0 ) {
               
                      currentNode = currentNode.getParent();
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4503:1: (kw= '.*' )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==80) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4504:2: kw= '.*'
                    {
                    kw=(Token)input.LT(1);
                    match(input,80,FollowSets000.FOLLOW_80_in_ruleQualifiedNameWithWildCard7922); if (failed) return current;
                    if ( backtracking==0 ) {

                              current.merge(kw);
                              createLeafNode(grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1(), null); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleQualifiedNameWithWildCard


    // $ANTLR start entryRuleQualifiedName
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4520:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
        	
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4524:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4525:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( backtracking==0 ) {
               currentNode = createCompositeNode(grammarAccess.getQualifiedNameRule(), currentNode); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7975);
            iv_ruleQualifiedName=ruleQualifiedName();
            _fsp--;
            if (failed) return current;
            if ( backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName7986); if (failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end entryRuleQualifiedName


    // $ANTLR start ruleQualifiedName
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4535:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         setCurrentLookahead(); resetLookahead(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS");
            
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4541:6: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4542:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4542:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4542:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)input.LT(1);
            match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8030); if (failed) return current;
            if ( backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( backtracking==0 ) {
               
                  createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0(), null); 
                  
            }
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4549:1: (kw= '.' this_ID_2= RULE_ID )*
            loop84:
            do {
                int alt84=2;
                int LA84_0 = input.LA(1);

                if ( (LA84_0==74) ) {
                    alt84=1;
                }


                switch (alt84) {
            	case 1 :
            	    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4550:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)input.LT(1);
            	    match(input,74,FollowSets000.FOLLOW_74_in_ruleQualifiedName8049); if (failed) return current;
            	    if ( backtracking==0 ) {

            	              current.merge(kw);
            	              createLeafNode(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0(), null); 
            	          
            	    }
            	    this_ID_2=(Token)input.LT(1);
            	    match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName8064); if (failed) return current;
            	    if ( backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( backtracking==0 ) {
            	       
            	          createLeafNode(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1(), null); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop84;
                }
            } while (true);


            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
              	    lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end ruleQualifiedName


    // $ANTLR start ruleImplementationType
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4575:1: ruleImplementationType returns [Enumerator current=null] : ( ( 'BPMN' ) | ( 'BPMN2' ) | ( 'BPEL' ) | ( 'WS-HT' ) | ( 'RuleML' ) | ( 'Drools' ) | ( 'Mediation' ) | ( 'Java' ) | ( 'C#' ) | ( 'C++' ) | ( 'Scala' ) | ( 'Ruby' ) | ( 'PHP' ) | ( 'WS-Document/Literal' ) | ( 'WS-RPC/Literal' ) | ( 'WS-RPC/Encoded' ) | ( 'REST-XML' ) | ( 'REST-JSON' ) | ( 'EJB' ) | ( 'Spring' ) | ( 'EJB2' ) | ( 'SAP' ) | ( 'SAP/iDoc' ) | ( 'SAP/BAPI' ) | ( 'Corba' ) | ( 'Shell' ) | ( 'Siebel' ) | ( 'Tuxedo' ) | ( 'File' ) | ( 'SQL' ) | ( 'Ivy' ) | ( 'jPDL3' ) | ( 'jPDL4' ) ) ;
    public final Enumerator ruleImplementationType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4579:6: ( ( ( 'BPMN' ) | ( 'BPMN2' ) | ( 'BPEL' ) | ( 'WS-HT' ) | ( 'RuleML' ) | ( 'Drools' ) | ( 'Mediation' ) | ( 'Java' ) | ( 'C#' ) | ( 'C++' ) | ( 'Scala' ) | ( 'Ruby' ) | ( 'PHP' ) | ( 'WS-Document/Literal' ) | ( 'WS-RPC/Literal' ) | ( 'WS-RPC/Encoded' ) | ( 'REST-XML' ) | ( 'REST-JSON' ) | ( 'EJB' ) | ( 'Spring' ) | ( 'EJB2' ) | ( 'SAP' ) | ( 'SAP/iDoc' ) | ( 'SAP/BAPI' ) | ( 'Corba' ) | ( 'Shell' ) | ( 'Siebel' ) | ( 'Tuxedo' ) | ( 'File' ) | ( 'SQL' ) | ( 'Ivy' ) | ( 'jPDL3' ) | ( 'jPDL4' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4580:1: ( ( 'BPMN' ) | ( 'BPMN2' ) | ( 'BPEL' ) | ( 'WS-HT' ) | ( 'RuleML' ) | ( 'Drools' ) | ( 'Mediation' ) | ( 'Java' ) | ( 'C#' ) | ( 'C++' ) | ( 'Scala' ) | ( 'Ruby' ) | ( 'PHP' ) | ( 'WS-Document/Literal' ) | ( 'WS-RPC/Literal' ) | ( 'WS-RPC/Encoded' ) | ( 'REST-XML' ) | ( 'REST-JSON' ) | ( 'EJB' ) | ( 'Spring' ) | ( 'EJB2' ) | ( 'SAP' ) | ( 'SAP/iDoc' ) | ( 'SAP/BAPI' ) | ( 'Corba' ) | ( 'Shell' ) | ( 'Siebel' ) | ( 'Tuxedo' ) | ( 'File' ) | ( 'SQL' ) | ( 'Ivy' ) | ( 'jPDL3' ) | ( 'jPDL4' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4580:1: ( ( 'BPMN' ) | ( 'BPMN2' ) | ( 'BPEL' ) | ( 'WS-HT' ) | ( 'RuleML' ) | ( 'Drools' ) | ( 'Mediation' ) | ( 'Java' ) | ( 'C#' ) | ( 'C++' ) | ( 'Scala' ) | ( 'Ruby' ) | ( 'PHP' ) | ( 'WS-Document/Literal' ) | ( 'WS-RPC/Literal' ) | ( 'WS-RPC/Encoded' ) | ( 'REST-XML' ) | ( 'REST-JSON' ) | ( 'EJB' ) | ( 'Spring' ) | ( 'EJB2' ) | ( 'SAP' ) | ( 'SAP/iDoc' ) | ( 'SAP/BAPI' ) | ( 'Corba' ) | ( 'Shell' ) | ( 'Siebel' ) | ( 'Tuxedo' ) | ( 'File' ) | ( 'SQL' ) | ( 'Ivy' ) | ( 'jPDL3' ) | ( 'jPDL4' ) )
            int alt85=33;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt85=1;
                }
                break;
            case 82:
                {
                alt85=2;
                }
                break;
            case 83:
                {
                alt85=3;
                }
                break;
            case 84:
                {
                alt85=4;
                }
                break;
            case 85:
                {
                alt85=5;
                }
                break;
            case 86:
                {
                alt85=6;
                }
                break;
            case 87:
                {
                alt85=7;
                }
                break;
            case 88:
                {
                alt85=8;
                }
                break;
            case 89:
                {
                alt85=9;
                }
                break;
            case 90:
                {
                alt85=10;
                }
                break;
            case 91:
                {
                alt85=11;
                }
                break;
            case 92:
                {
                alt85=12;
                }
                break;
            case 93:
                {
                alt85=13;
                }
                break;
            case 94:
                {
                alt85=14;
                }
                break;
            case 95:
                {
                alt85=15;
                }
                break;
            case 96:
                {
                alt85=16;
                }
                break;
            case 97:
                {
                alt85=17;
                }
                break;
            case 98:
                {
                alt85=18;
                }
                break;
            case 44:
                {
                alt85=19;
                }
                break;
            case 99:
                {
                alt85=20;
                }
                break;
            case 100:
                {
                alt85=21;
                }
                break;
            case 41:
                {
                alt85=22;
                }
                break;
            case 101:
                {
                alt85=23;
                }
                break;
            case 102:
                {
                alt85=24;
                }
                break;
            case 103:
                {
                alt85=25;
                }
                break;
            case 104:
                {
                alt85=26;
                }
                break;
            case 105:
                {
                alt85=27;
                }
                break;
            case 106:
                {
                alt85=28;
                }
                break;
            case 107:
                {
                alt85=29;
                }
                break;
            case 108:
                {
                alt85=30;
                }
                break;
            case 109:
                {
                alt85=31;
                }
                break;
            case 110:
                {
                alt85=32;
                }
                break;
            case 111:
                {
                alt85=33;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4580:1: ( ( 'BPMN' ) | ( 'BPMN2' ) | ( 'BPEL' ) | ( 'WS-HT' ) | ( 'RuleML' ) | ( 'Drools' ) | ( 'Mediation' ) | ( 'Java' ) | ( 'C#' ) | ( 'C++' ) | ( 'Scala' ) | ( 'Ruby' ) | ( 'PHP' ) | ( 'WS-Document/Literal' ) | ( 'WS-RPC/Literal' ) | ( 'WS-RPC/Encoded' ) | ( 'REST-XML' ) | ( 'REST-JSON' ) | ( 'EJB' ) | ( 'Spring' ) | ( 'EJB2' ) | ( 'SAP' ) | ( 'SAP/iDoc' ) | ( 'SAP/BAPI' ) | ( 'Corba' ) | ( 'Shell' ) | ( 'Siebel' ) | ( 'Tuxedo' ) | ( 'File' ) | ( 'SQL' ) | ( 'Ivy' ) | ( 'jPDL3' ) | ( 'jPDL4' ) )", 85, 0, input);

                throw nvae;
            }

            switch (alt85) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4580:2: ( 'BPMN' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4580:2: ( 'BPMN' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4580:4: 'BPMN'
                    {
                    match(input,81,FollowSets000.FOLLOW_81_in_ruleImplementationType8129); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getBPMNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getBPMNEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4586:6: ( 'BPMN2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4586:6: ( 'BPMN2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4586:8: 'BPMN2'
                    {
                    match(input,82,FollowSets000.FOLLOW_82_in_ruleImplementationType8144); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getBPMN2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getBPMN2EnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4592:6: ( 'BPEL' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4592:6: ( 'BPEL' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4592:8: 'BPEL'
                    {
                    match(input,83,FollowSets000.FOLLOW_83_in_ruleImplementationType8159); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getBPELEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getBPELEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4598:6: ( 'WS-HT' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4598:6: ( 'WS-HT' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4598:8: 'WS-HT'
                    {
                    match(input,84,FollowSets000.FOLLOW_84_in_ruleImplementationType8174); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSHTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getWSHTEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4604:6: ( 'RuleML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4604:6: ( 'RuleML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4604:8: 'RuleML'
                    {
                    match(input,85,FollowSets000.FOLLOW_85_in_ruleImplementationType8189); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getRuleMLEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getRuleMLEnumLiteralDeclaration_4(), null); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4610:6: ( 'Drools' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4610:6: ( 'Drools' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4610:8: 'Drools'
                    {
                    match(input,86,FollowSets000.FOLLOW_86_in_ruleImplementationType8204); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getDroolsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getDroolsEnumLiteralDeclaration_5(), null); 
                          
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4616:6: ( 'Mediation' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4616:6: ( 'Mediation' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4616:8: 'Mediation'
                    {
                    match(input,87,FollowSets000.FOLLOW_87_in_ruleImplementationType8219); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getMediationEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getMediationEnumLiteralDeclaration_6(), null); 
                          
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4622:6: ( 'Java' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4622:6: ( 'Java' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4622:8: 'Java'
                    {
                    match(input,88,FollowSets000.FOLLOW_88_in_ruleImplementationType8234); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getJavaEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getJavaEnumLiteralDeclaration_7(), null); 
                          
                    }

                    }


                    }
                    break;
                case 9 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4628:6: ( 'C#' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4628:6: ( 'C#' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4628:8: 'C#'
                    {
                    match(input,89,FollowSets000.FOLLOW_89_in_ruleImplementationType8249); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getCSEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getCSEnumLiteralDeclaration_8(), null); 
                          
                    }

                    }


                    }
                    break;
                case 10 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4634:6: ( 'C++' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4634:6: ( 'C++' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4634:8: 'C++'
                    {
                    match(input,90,FollowSets000.FOLLOW_90_in_ruleImplementationType8264); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getCPPEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getCPPEnumLiteralDeclaration_9(), null); 
                          
                    }

                    }


                    }
                    break;
                case 11 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4640:6: ( 'Scala' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4640:6: ( 'Scala' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4640:8: 'Scala'
                    {
                    match(input,91,FollowSets000.FOLLOW_91_in_ruleImplementationType8279); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getScalaEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getScalaEnumLiteralDeclaration_10(), null); 
                          
                    }

                    }


                    }
                    break;
                case 12 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4646:6: ( 'Ruby' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4646:6: ( 'Ruby' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4646:8: 'Ruby'
                    {
                    match(input,92,FollowSets000.FOLLOW_92_in_ruleImplementationType8294); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getRubyEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getRubyEnumLiteralDeclaration_11(), null); 
                          
                    }

                    }


                    }
                    break;
                case 13 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4652:6: ( 'PHP' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4652:6: ( 'PHP' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4652:8: 'PHP'
                    {
                    match(input,93,FollowSets000.FOLLOW_93_in_ruleImplementationType8309); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getPHPEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getPHPEnumLiteralDeclaration_12(), null); 
                          
                    }

                    }


                    }
                    break;
                case 14 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4658:6: ( 'WS-Document/Literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4658:6: ( 'WS-Document/Literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4658:8: 'WS-Document/Literal'
                    {
                    match(input,94,FollowSets000.FOLLOW_94_in_ruleImplementationType8324); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSDocLitEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getWSDocLitEnumLiteralDeclaration_13(), null); 
                          
                    }

                    }


                    }
                    break;
                case 15 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4664:6: ( 'WS-RPC/Literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4664:6: ( 'WS-RPC/Literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4664:8: 'WS-RPC/Literal'
                    {
                    match(input,95,FollowSets000.FOLLOW_95_in_ruleImplementationType8339); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSRPCEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getWSRPCEnumLiteralDeclaration_14(), null); 
                          
                    }

                    }


                    }
                    break;
                case 16 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4670:6: ( 'WS-RPC/Encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4670:6: ( 'WS-RPC/Encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4670:8: 'WS-RPC/Encoded'
                    {
                    match(input,96,FollowSets000.FOLLOW_96_in_ruleImplementationType8354); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getWSRPCEncEnumLiteralDeclaration_15().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getWSRPCEncEnumLiteralDeclaration_15(), null); 
                          
                    }

                    }


                    }
                    break;
                case 17 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4676:6: ( 'REST-XML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4676:6: ( 'REST-XML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4676:8: 'REST-XML'
                    {
                    match(input,97,FollowSets000.FOLLOW_97_in_ruleImplementationType8369); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getREST_XMLEnumLiteralDeclaration_16().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getREST_XMLEnumLiteralDeclaration_16(), null); 
                          
                    }

                    }


                    }
                    break;
                case 18 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4682:6: ( 'REST-JSON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4682:6: ( 'REST-JSON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4682:8: 'REST-JSON'
                    {
                    match(input,98,FollowSets000.FOLLOW_98_in_ruleImplementationType8384); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getREST_JSONEnumLiteralDeclaration_17().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getREST_JSONEnumLiteralDeclaration_17(), null); 
                          
                    }

                    }


                    }
                    break;
                case 19 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4688:6: ( 'EJB' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4688:6: ( 'EJB' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4688:8: 'EJB'
                    {
                    match(input,44,FollowSets000.FOLLOW_44_in_ruleImplementationType8399); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getEJBEnumLiteralDeclaration_18().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getEJBEnumLiteralDeclaration_18(), null); 
                          
                    }

                    }


                    }
                    break;
                case 20 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4694:6: ( 'Spring' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4694:6: ( 'Spring' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4694:8: 'Spring'
                    {
                    match(input,99,FollowSets000.FOLLOW_99_in_ruleImplementationType8414); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSpringEnumLiteralDeclaration_19().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getSpringEnumLiteralDeclaration_19(), null); 
                          
                    }

                    }


                    }
                    break;
                case 21 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4700:6: ( 'EJB2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4700:6: ( 'EJB2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4700:8: 'EJB2'
                    {
                    match(input,100,FollowSets000.FOLLOW_100_in_ruleImplementationType8429); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getEJB2EnumLiteralDeclaration_20().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getEJB2EnumLiteralDeclaration_20(), null); 
                          
                    }

                    }


                    }
                    break;
                case 22 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4706:6: ( 'SAP' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4706:6: ( 'SAP' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4706:8: 'SAP'
                    {
                    match(input,41,FollowSets000.FOLLOW_41_in_ruleImplementationType8444); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSAPEnumLiteralDeclaration_21().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getSAPEnumLiteralDeclaration_21(), null); 
                          
                    }

                    }


                    }
                    break;
                case 23 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4712:6: ( 'SAP/iDoc' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4712:6: ( 'SAP/iDoc' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4712:8: 'SAP/iDoc'
                    {
                    match(input,101,FollowSets000.FOLLOW_101_in_ruleImplementationType8459); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSAP_IDOCEnumLiteralDeclaration_22().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getSAP_IDOCEnumLiteralDeclaration_22(), null); 
                          
                    }

                    }


                    }
                    break;
                case 24 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4718:6: ( 'SAP/BAPI' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4718:6: ( 'SAP/BAPI' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4718:8: 'SAP/BAPI'
                    {
                    match(input,102,FollowSets000.FOLLOW_102_in_ruleImplementationType8474); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSAP_BAPIEnumLiteralDeclaration_23().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getSAP_BAPIEnumLiteralDeclaration_23(), null); 
                          
                    }

                    }


                    }
                    break;
                case 25 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4724:6: ( 'Corba' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4724:6: ( 'Corba' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4724:8: 'Corba'
                    {
                    match(input,103,FollowSets000.FOLLOW_103_in_ruleImplementationType8489); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getCorbaEnumLiteralDeclaration_24().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getCorbaEnumLiteralDeclaration_24(), null); 
                          
                    }

                    }


                    }
                    break;
                case 26 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4730:6: ( 'Shell' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4730:6: ( 'Shell' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4730:8: 'Shell'
                    {
                    match(input,104,FollowSets000.FOLLOW_104_in_ruleImplementationType8504); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getShellEnumLiteralDeclaration_25().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getShellEnumLiteralDeclaration_25(), null); 
                          
                    }

                    }


                    }
                    break;
                case 27 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4736:6: ( 'Siebel' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4736:6: ( 'Siebel' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4736:8: 'Siebel'
                    {
                    match(input,105,FollowSets000.FOLLOW_105_in_ruleImplementationType8519); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSiebelEnumLiteralDeclaration_26().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getSiebelEnumLiteralDeclaration_26(), null); 
                          
                    }

                    }


                    }
                    break;
                case 28 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4742:6: ( 'Tuxedo' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4742:6: ( 'Tuxedo' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4742:8: 'Tuxedo'
                    {
                    match(input,106,FollowSets000.FOLLOW_106_in_ruleImplementationType8534); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getTuxedoEnumLiteralDeclaration_27().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getTuxedoEnumLiteralDeclaration_27(), null); 
                          
                    }

                    }


                    }
                    break;
                case 29 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4748:6: ( 'File' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4748:6: ( 'File' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4748:8: 'File'
                    {
                    match(input,107,FollowSets000.FOLLOW_107_in_ruleImplementationType8549); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getFileEnumLiteralDeclaration_28().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getFileEnumLiteralDeclaration_28(), null); 
                          
                    }

                    }


                    }
                    break;
                case 30 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4754:6: ( 'SQL' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4754:6: ( 'SQL' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4754:8: 'SQL'
                    {
                    match(input,108,FollowSets000.FOLLOW_108_in_ruleImplementationType8564); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getSQLEnumLiteralDeclaration_29().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getSQLEnumLiteralDeclaration_29(), null); 
                          
                    }

                    }


                    }
                    break;
                case 31 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4760:6: ( 'Ivy' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4760:6: ( 'Ivy' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4760:8: 'Ivy'
                    {
                    match(input,109,FollowSets000.FOLLOW_109_in_ruleImplementationType8579); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getIvyEnumLiteralDeclaration_30().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getIvyEnumLiteralDeclaration_30(), null); 
                          
                    }

                    }


                    }
                    break;
                case 32 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:6: ( 'jPDL3' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:6: ( 'jPDL3' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4766:8: 'jPDL3'
                    {
                    match(input,110,FollowSets000.FOLLOW_110_in_ruleImplementationType8594); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getJPDL3EnumLiteralDeclaration_31().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getJPDL3EnumLiteralDeclaration_31(), null); 
                          
                    }

                    }


                    }
                    break;
                case 33 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4772:6: ( 'jPDL4' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4772:6: ( 'jPDL4' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4772:8: 'jPDL4'
                    {
                    match(input,111,FollowSets000.FOLLOW_111_in_ruleImplementationType8609); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getImplementationTypeAccess().getJPDL4EnumLiteralDeclaration_32().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getImplementationTypeAccess().getJPDL4EnumLiteralDeclaration_32(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleImplementationType


    // $ANTLR start ruleSOAPStyle
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4782:1: ruleSOAPStyle returns [Enumerator current=null] : ( ( 'document/literal-wrapped' ) | ( 'rpc/literal' ) | ( 'rpc/encoded' ) ) ;
    public final Enumerator ruleSOAPStyle() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4786:6: ( ( ( 'document/literal-wrapped' ) | ( 'rpc/literal' ) | ( 'rpc/encoded' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4787:1: ( ( 'document/literal-wrapped' ) | ( 'rpc/literal' ) | ( 'rpc/encoded' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4787:1: ( ( 'document/literal-wrapped' ) | ( 'rpc/literal' ) | ( 'rpc/encoded' ) )
            int alt86=3;
            switch ( input.LA(1) ) {
            case 112:
                {
                alt86=1;
                }
                break;
            case 113:
                {
                alt86=2;
                }
                break;
            case 114:
                {
                alt86=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4787:1: ( ( 'document/literal-wrapped' ) | ( 'rpc/literal' ) | ( 'rpc/encoded' ) )", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4787:2: ( 'document/literal-wrapped' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4787:2: ( 'document/literal-wrapped' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4787:4: 'document/literal-wrapped'
                    {
                    match(input,112,FollowSets000.FOLLOW_112_in_ruleSOAPStyle8652); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getSOAPStyleAccess().getDoclitwrapEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4793:6: ( 'rpc/literal' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4793:6: ( 'rpc/literal' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4793:8: 'rpc/literal'
                    {
                    match(input,113,FollowSets000.FOLLOW_113_in_ruleSOAPStyle8667); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getSOAPStyleAccess().getRpclitEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4799:6: ( 'rpc/encoded' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4799:6: ( 'rpc/encoded' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4799:8: 'rpc/encoded'
                    {
                    match(input,114,FollowSets000.FOLLOW_114_in_ruleSOAPStyle8682); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getSOAPStyleAccess().getRpcencEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getSOAPStyleAccess().getRpcencEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSOAPStyle


    // $ANTLR start ruleSAPTransport
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4809:1: ruleSAPTransport returns [Enumerator current=null] : ( ( 'IDOC' ) | ( 'RFC' ) ) ;
    public final Enumerator ruleSAPTransport() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4813:6: ( ( ( 'IDOC' ) | ( 'RFC' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4814:1: ( ( 'IDOC' ) | ( 'RFC' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4814:1: ( ( 'IDOC' ) | ( 'RFC' ) )
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==115) ) {
                alt87=1;
            }
            else if ( (LA87_0==116) ) {
                alt87=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4814:1: ( ( 'IDOC' ) | ( 'RFC' ) )", 87, 0, input);

                throw nvae;
            }
            switch (alt87) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4814:2: ( 'IDOC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4814:2: ( 'IDOC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4814:4: 'IDOC'
                    {
                    match(input,115,FollowSets000.FOLLOW_115_in_ruleSAPTransport8725); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getSAPTransportAccess().getIDOCEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4820:6: ( 'RFC' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4820:6: ( 'RFC' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4820:8: 'RFC'
                    {
                    match(input,116,FollowSets000.FOLLOW_116_in_ruleSAPTransport8740); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getSAPTransportAccess().getRFCEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getSAPTransportAccess().getRFCEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSAPTransport


    // $ANTLR start ruleRESTFormat
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4830:1: ruleRESTFormat returns [Enumerator current=null] : ( ( 'JSON' ) | ( 'XML' ) | ( 'OTHER' ) ) ;
    public final Enumerator ruleRESTFormat() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4834:6: ( ( ( 'JSON' ) | ( 'XML' ) | ( 'OTHER' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4835:1: ( ( 'JSON' ) | ( 'XML' ) | ( 'OTHER' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4835:1: ( ( 'JSON' ) | ( 'XML' ) | ( 'OTHER' ) )
            int alt88=3;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt88=1;
                }
                break;
            case 118:
                {
                alt88=2;
                }
                break;
            case 119:
                {
                alt88=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4835:1: ( ( 'JSON' ) | ( 'XML' ) | ( 'OTHER' ) )", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4835:2: ( 'JSON' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4835:2: ( 'JSON' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4835:4: 'JSON'
                    {
                    match(input,117,FollowSets000.FOLLOW_117_in_ruleRESTFormat8783); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getRESTFormatAccess().getJSONEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4841:6: ( 'XML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4841:6: ( 'XML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4841:8: 'XML'
                    {
                    match(input,118,FollowSets000.FOLLOW_118_in_ruleRESTFormat8798); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getRESTFormatAccess().getXMLEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:6: ( 'OTHER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:6: ( 'OTHER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4847:8: 'OTHER'
                    {
                    match(input,119,FollowSets000.FOLLOW_119_in_ruleRESTFormat8813); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getRESTFormatAccess().getOTHEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getRESTFormatAccess().getOTHEREnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleRESTFormat


    // $ANTLR start ruleVerb
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4857:1: ruleVerb returns [Enumerator current=null] : ( ( 'create' ) | ( 'retrieve' ) | ( 'update' ) | ( 'delete' ) ) ;
    public final Enumerator ruleVerb() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4861:6: ( ( ( 'create' ) | ( 'retrieve' ) | ( 'update' ) | ( 'delete' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4862:1: ( ( 'create' ) | ( 'retrieve' ) | ( 'update' ) | ( 'delete' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4862:1: ( ( 'create' ) | ( 'retrieve' ) | ( 'update' ) | ( 'delete' ) )
            int alt89=4;
            switch ( input.LA(1) ) {
            case 120:
                {
                alt89=1;
                }
                break;
            case 121:
                {
                alt89=2;
                }
                break;
            case 122:
                {
                alt89=3;
                }
                break;
            case 123:
                {
                alt89=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4862:1: ( ( 'create' ) | ( 'retrieve' ) | ( 'update' ) | ( 'delete' ) )", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4862:2: ( 'create' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4862:2: ( 'create' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4862:4: 'create'
                    {
                    match(input,120,FollowSets000.FOLLOW_120_in_ruleVerb8856); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getCreateEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getVerbAccess().getCreateEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4868:6: ( 'retrieve' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4868:6: ( 'retrieve' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4868:8: 'retrieve'
                    {
                    match(input,121,FollowSets000.FOLLOW_121_in_ruleVerb8871); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getRetrieveEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getVerbAccess().getRetrieveEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4874:6: ( 'update' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4874:6: ( 'update' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4874:8: 'update'
                    {
                    match(input,122,FollowSets000.FOLLOW_122_in_ruleVerb8886); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getUpdateEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getVerbAccess().getUpdateEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4880:6: ( 'delete' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4880:6: ( 'delete' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4880:8: 'delete'
                    {
                    match(input,123,FollowSets000.FOLLOW_123_in_ruleVerb8901); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getVerbAccess().getDeleteEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getVerbAccess().getDeleteEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleVerb


    // $ANTLR start ruleReadWrite
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4890:1: ruleReadWrite returns [Enumerator current=null] : ( ( 'read' ) | ( 'write' ) ) ;
    public final Enumerator ruleReadWrite() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4894:6: ( ( ( 'read' ) | ( 'write' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4895:1: ( ( 'read' ) | ( 'write' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4895:1: ( ( 'read' ) | ( 'write' ) )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==124) ) {
                alt90=1;
            }
            else if ( (LA90_0==125) ) {
                alt90=2;
            }
            else {
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4895:1: ( ( 'read' ) | ( 'write' ) )", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4895:2: ( 'read' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4895:2: ( 'read' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4895:4: 'read'
                    {
                    match(input,124,FollowSets000.FOLLOW_124_in_ruleReadWrite8944); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getReadWriteAccess().getReadEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4901:6: ( 'write' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4901:6: ( 'write' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4901:8: 'write'
                    {
                    match(input,125,FollowSets000.FOLLOW_125_in_ruleReadWrite8959); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getReadWriteAccess().getWriteEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getReadWriteAccess().getWriteEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleReadWrite


    // $ANTLR start ruleHashAlgKind
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4911:1: ruleHashAlgKind returns [Enumerator current=null] : ( ( 'MD5' ) | ( 'SHA1' ) | ( 'SHA256' ) | ( 'PlainText' ) ) ;
    public final Enumerator ruleHashAlgKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4915:6: ( ( ( 'MD5' ) | ( 'SHA1' ) | ( 'SHA256' ) | ( 'PlainText' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:1: ( ( 'MD5' ) | ( 'SHA1' ) | ( 'SHA256' ) | ( 'PlainText' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:1: ( ( 'MD5' ) | ( 'SHA1' ) | ( 'SHA256' ) | ( 'PlainText' ) )
            int alt91=4;
            switch ( input.LA(1) ) {
            case 126:
                {
                alt91=1;
                }
                break;
            case 127:
                {
                alt91=2;
                }
                break;
            case 128:
                {
                alt91=3;
                }
                break;
            case 129:
                {
                alt91=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4916:1: ( ( 'MD5' ) | ( 'SHA1' ) | ( 'SHA256' ) | ( 'PlainText' ) )", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:2: ( 'MD5' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:2: ( 'MD5' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4916:4: 'MD5'
                    {
                    match(input,126,FollowSets000.FOLLOW_126_in_ruleHashAlgKind9002); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getHashAlgKindAccess().getMD5EnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4922:6: ( 'SHA1' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4922:6: ( 'SHA1' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4922:8: 'SHA1'
                    {
                    match(input,127,FollowSets000.FOLLOW_127_in_ruleHashAlgKind9017); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getHashAlgKindAccess().getSHA1EnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4928:6: ( 'SHA256' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4928:6: ( 'SHA256' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4928:8: 'SHA256'
                    {
                    match(input,128,FollowSets000.FOLLOW_128_in_ruleHashAlgKind9032); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getHashAlgKindAccess().getSHA256EnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4934:6: ( 'PlainText' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4934:6: ( 'PlainText' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4934:8: 'PlainText'
                    {
                    match(input,129,FollowSets000.FOLLOW_129_in_ruleHashAlgKind9047); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getHashAlgKindAccess().getPlainTextEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getHashAlgKindAccess().getPlainTextEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleHashAlgKind


    // $ANTLR start ruleAuthTokenKind
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4944:1: ruleAuthTokenKind returns [Enumerator current=null] : ( ( 'UsernamePassword' ) | ( 'SAML' ) | ( 'SAML2' ) | ( 'Kerberos' ) ) ;
    public final Enumerator ruleAuthTokenKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4948:6: ( ( ( 'UsernamePassword' ) | ( 'SAML' ) | ( 'SAML2' ) | ( 'Kerberos' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4949:1: ( ( 'UsernamePassword' ) | ( 'SAML' ) | ( 'SAML2' ) | ( 'Kerberos' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4949:1: ( ( 'UsernamePassword' ) | ( 'SAML' ) | ( 'SAML2' ) | ( 'Kerberos' ) )
            int alt92=4;
            switch ( input.LA(1) ) {
            case 130:
                {
                alt92=1;
                }
                break;
            case 131:
                {
                alt92=2;
                }
                break;
            case 132:
                {
                alt92=3;
                }
                break;
            case 133:
                {
                alt92=4;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4949:1: ( ( 'UsernamePassword' ) | ( 'SAML' ) | ( 'SAML2' ) | ( 'Kerberos' ) )", 92, 0, input);

                throw nvae;
            }

            switch (alt92) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4949:2: ( 'UsernamePassword' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4949:2: ( 'UsernamePassword' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4949:4: 'UsernamePassword'
                    {
                    match(input,130,FollowSets000.FOLLOW_130_in_ruleAuthTokenKind9090); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getAuthTokenKindAccess().getUsernamePasswordEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4955:6: ( 'SAML' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4955:6: ( 'SAML' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4955:8: 'SAML'
                    {
                    match(input,131,FollowSets000.FOLLOW_131_in_ruleAuthTokenKind9105); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getAuthTokenKindAccess().getSAMLEnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4961:6: ( 'SAML2' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4961:6: ( 'SAML2' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4961:8: 'SAML2'
                    {
                    match(input,132,FollowSets000.FOLLOW_132_in_ruleAuthTokenKind9120); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getAuthTokenKindAccess().getSAML2EnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4967:6: ( 'Kerberos' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4967:6: ( 'Kerberos' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4967:8: 'Kerberos'
                    {
                    match(input,133,FollowSets000.FOLLOW_133_in_ruleAuthTokenKind9135); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getAuthTokenKindAccess().getKerberosEnumLiteralDeclaration_3(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAuthTokenKind


    // $ANTLR start ruleLogPolicyKind
    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4977:1: ruleLogPolicyKind returns [Enumerator current=null] : ( ( 'NONE' ) | ( 'HEADER' ) | ( 'ALL' ) ) ;
    public final Enumerator ruleLogPolicyKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4981:6: ( ( ( 'NONE' ) | ( 'HEADER' ) | ( 'ALL' ) ) )
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4982:1: ( ( 'NONE' ) | ( 'HEADER' ) | ( 'ALL' ) )
            {
            // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4982:1: ( ( 'NONE' ) | ( 'HEADER' ) | ( 'ALL' ) )
            int alt93=3;
            switch ( input.LA(1) ) {
            case 134:
                {
                alt93=1;
                }
                break;
            case 135:
                {
                alt93=2;
                }
                break;
            case 136:
                {
                alt93=3;
                }
                break;
            default:
                if (backtracking>0) {failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("4982:1: ( ( 'NONE' ) | ( 'HEADER' ) | ( 'ALL' ) )", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4982:2: ( 'NONE' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4982:2: ( 'NONE' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4982:4: 'NONE'
                    {
                    match(input,134,FollowSets000.FOLLOW_134_in_ruleLogPolicyKind9178); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getNONEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getLogPolicyKindAccess().getNONEEnumLiteralDeclaration_0(), null); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4988:6: ( 'HEADER' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4988:6: ( 'HEADER' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4988:8: 'HEADER'
                    {
                    match(input,135,FollowSets000.FOLLOW_135_in_ruleLogPolicyKind9193); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getHEADEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getLogPolicyKindAccess().getHEADEREnumLiteralDeclaration_1(), null); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4994:6: ( 'ALL' )
                    {
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4994:6: ( 'ALL' )
                    // ../org.fornax.soa.bindingdsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalBindingDsl.g:4994:8: 'ALL'
                    {
                    match(input,136,FollowSets000.FOLLOW_136_in_ruleLogPolicyKind9208); if (failed) return current;
                    if ( backtracking==0 ) {

                              current = grammarAccess.getLogPolicyKindAccess().getALLEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              createLeafNode(grammarAccess.getLogPolicyKindAccess().getALLEnumLiteralDeclaration_2(), null); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( backtracking==0 ) {
               resetLookahead(); 
                  	lastConsumedNode = currentNode;
                  
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleLogPolicyKind


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleBindingModel_in_entryRuleBindingModel87 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingModel97 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleBindingModel147 = new BitSet(new long[]{0x0000000000000802L,0x0000000000000200L});
        public static final BitSet FOLLOW_ruleDomainBinding_in_ruleBindingModel169 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleDomainBinding_in_entryRuleDomainBinding212 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleDomainBinding222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleDomainBinding257 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding284 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleDomainBinding294 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding315 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleDomainBinding325 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleDomainBinding335 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleDomainBinding357 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleDomainBinding367 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDomainBinding377 = new BitSet(new long[]{0x00000000243E0000L});
        public static final BitSet FOLLOW_17_in_ruleDomainBinding388 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDomainBinding398 = new BitSet(new long[]{0x5114521000000000L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleDomainBinding419 = new BitSet(new long[]{0x5114521000040000L});
        public static final BitSet FOLLOW_18_in_ruleDomainBinding430 = new BitSet(new long[]{0x00000000243C0000L});
        public static final BitSet FOLLOW_19_in_ruleDomainBinding443 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDomainBinding453 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleDomainBinding474 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleDomainBinding485 = new BitSet(new long[]{0x0000000024340000L});
        public static final BitSet FOLLOW_20_in_ruleDomainBinding498 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleDomainBinding508 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleDomainBinding529 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleDomainBinding540 = new BitSet(new long[]{0x0000000024240000L});
        public static final BitSet FOLLOW_21_in_ruleDomainBinding553 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding580 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleDomainBinding591 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleDomainBinding618 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleDomainBinding630 = new BitSet(new long[]{0x0000000024040000L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_ruleDomainBinding653 = new BitSet(new long[]{0x0000000024040000L});
        public static final BitSet FOLLOW_ruleComponent_in_ruleDomainBinding675 = new BitSet(new long[]{0x0000000020040000L});
        public static final BitSet FOLLOW_18_in_ruleDomainBinding686 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePublisher_in_entryRulePublisher722 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePublisher732 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_rulePublisher767 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rulePublisher794 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_rulePublisher804 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProvider_in_entryRuleProvider840 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProvider850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_25_in_ruleProvider885 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleProvider912 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleProvider922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceBinding_in_entryRuleServiceBinding958 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceBinding968 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleServiceBinding1003 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleServiceBinding1024 = new BitSet(new long[]{0x0000000000002000L});
        public static final BitSet FOLLOW_13_in_ruleServiceBinding1034 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleServiceBinding1044 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleServiceBinding1066 = new BitSet(new long[]{0x0000000000008000L});
        public static final BitSet FOLLOW_15_in_ruleServiceBinding1076 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleServiceBinding1086 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleServiceBinding1096 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleServiceBinding1106 = new BitSet(new long[]{0x5114521000000000L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1127 = new BitSet(new long[]{0x5114521000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1138 = new BitSet(new long[]{0x00000000183C0000L});
        public static final BitSet FOLLOW_27_in_ruleServiceBinding1149 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleServiceBinding1159 = new BitSet(new long[]{0x5114521000000000L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleServiceBinding1180 = new BitSet(new long[]{0x5114521000040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1191 = new BitSet(new long[]{0x00000000103C0000L});
        public static final BitSet FOLLOW_19_in_ruleServiceBinding1204 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleServiceBinding1214 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServiceBinding1235 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1246 = new BitSet(new long[]{0x0000000010340000L});
        public static final BitSet FOLLOW_20_in_ruleServiceBinding1259 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleServiceBinding1269 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleServiceBinding1290 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1301 = new BitSet(new long[]{0x0000000010240000L});
        public static final BitSet FOLLOW_21_in_ruleServiceBinding1314 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1341 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleServiceBinding1352 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceBinding1379 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleServiceBinding1391 = new BitSet(new long[]{0x0000000010040000L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_ruleServiceBinding1414 = new BitSet(new long[]{0x0000000010040000L});
        public static final BitSet FOLLOW_18_in_ruleServiceBinding1425 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef1461 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef1471 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef1523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000009800L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef1544 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_entryRuleBindingProtocol1580 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleBindingProtocol1590 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_ruleBindingProtocol1640 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_ruleBindingProtocol1670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_ruleBindingProtocol1700 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_ruleBindingProtocol1730 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_ruleBindingProtocol1760 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_ruleBindingProtocol1790 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_ruleBindingProtocol1820 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_ruleBindingProtocol1850 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_ruleBindingProtocol1880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_entryRuleOperationBinding1915 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleOperationBinding1925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleOperationBinding1960 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding1987 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOperationBinding1997 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleOperationBinding2007 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOperationBinding2017 = new BitSet(new long[]{0x5114521000000000L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2038 = new BitSet(new long[]{0x5114521000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2049 = new BitSet(new long[]{0x00000000083C0000L});
        public static final BitSet FOLLOW_27_in_ruleOperationBinding2060 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOperationBinding2070 = new BitSet(new long[]{0x5114521000000000L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleOperationBinding2091 = new BitSet(new long[]{0x5114521000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2102 = new BitSet(new long[]{0x00000000003C0000L});
        public static final BitSet FOLLOW_19_in_ruleOperationBinding2115 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOperationBinding2125 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2146 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2157 = new BitSet(new long[]{0x0000000000340000L});
        public static final BitSet FOLLOW_20_in_ruleOperationBinding2170 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleOperationBinding2180 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleOperationBinding2201 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2212 = new BitSet(new long[]{0x0000000000240000L});
        public static final BitSet FOLLOW_21_in_ruleOperationBinding2225 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2252 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleOperationBinding2263 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationBinding2290 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleOperationBinding2302 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleOperationBinding2314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleComponent_in_entryRuleComponent2350 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleComponent2360 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleComponent2395 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleComponent2412 = new BitSet(new long[]{0x0000000040000000L});
        public static final BitSet FOLLOW_30_in_ruleComponent2427 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent2448 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleComponent2458 = new BitSet(new long[]{0x0000000080000000L});
        public static final BitSet FOLLOW_31_in_ruleComponent2468 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleComponent2495 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleComponent2505 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent2526 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleComponent2537 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent2558 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleComponent2570 = new BitSet(new long[]{0x0000000200020000L});
        public static final BitSet FOLLOW_33_in_ruleComponent2581 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleComponent2602 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleComponent2613 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleComponent2625 = new BitSet(new long[]{0x0000000000020000L});
        public static final BitSet FOLLOW_17_in_ruleComponent2637 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleComponent2647 = new BitSet(new long[]{0x5114521000000000L});
        public static final BitSet FOLLOW_ruleBindingProtocol_in_ruleComponent2668 = new BitSet(new long[]{0x5114521000040000L});
        public static final BitSet FOLLOW_18_in_ruleComponent2679 = new BitSet(new long[]{0x0000000410380000L});
        public static final BitSet FOLLOW_ruleOperationBinding_in_ruleComponent2700 = new BitSet(new long[]{0x0000000410380000L});
        public static final BitSet FOLLOW_19_in_ruleComponent2712 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleComponent2722 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleComponent2743 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleComponent2754 = new BitSet(new long[]{0x0000000400300000L});
        public static final BitSet FOLLOW_20_in_ruleComponent2767 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleComponent2777 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_rulePolicy_in_ruleComponent2798 = new BitSet(new long[]{0x0000000000040000L,0x00000000000001C3L});
        public static final BitSet FOLLOW_18_in_ruleComponent2809 = new BitSet(new long[]{0x0000000400200000L});
        public static final BitSet FOLLOW_21_in_ruleComponent2822 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleComponent2849 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_22_in_ruleComponent2860 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleComponent2887 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleComponent2899 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleComponent2911 = new BitSet(new long[]{0x0000120000000000L,0x0000FFFFFFFE0000L});
        public static final BitSet FOLLOW_ruleImplementationType_in_ruleComponent2932 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleComponent2942 = new BitSet(new long[]{0x0000000800040000L});
        public static final BitSet FOLLOW_35_in_ruleComponent2953 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleComponent2970 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleComponent2985 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleComponent2997 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSOAP_in_entryRuleSOAP3033 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSOAP3043 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleSOAP3078 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSOAP3088 = new BitSet(new long[]{0x000001E003040000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleSOAP3121 = new BitSet(new long[]{0x000001E002040000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleSOAP3143 = new BitSet(new long[]{0x000001E000040000L});
        public static final BitSet FOLLOW_37_in_ruleSOAP3155 = new BitSet(new long[]{0x0000000000000000L,0x0007000000000000L});
        public static final BitSet FOLLOW_ruleSOAPStyle_in_ruleSOAP3176 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSOAP3186 = new BitSet(new long[]{0x000001C000040000L});
        public static final BitSet FOLLOW_38_in_ruleSOAP3199 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP3216 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSOAP3231 = new BitSet(new long[]{0x0000018000040000L});
        public static final BitSet FOLLOW_39_in_ruleSOAP3244 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP3261 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSOAP3276 = new BitSet(new long[]{0x0000010000040000L});
        public static final BitSet FOLLOW_40_in_ruleSOAP3289 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSOAP3306 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSOAP3321 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSOAP3333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSAP_in_entryRuleSAP3369 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSAP3379 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleSAP3414 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSAP3424 = new BitSet(new long[]{0x00000C0002040000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleSAP3457 = new BitSet(new long[]{0x00000C0000040000L});
        public static final BitSet FOLLOW_42_in_ruleSAP3469 = new BitSet(new long[]{0x0000000000000000L,0x0018000000000000L});
        public static final BitSet FOLLOW_ruleSAPTransport_in_ruleSAP3490 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSAP3500 = new BitSet(new long[]{0x0000080000040000L});
        public static final BitSet FOLLOW_43_in_ruleSAP3513 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSAP3540 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSAP3550 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSAP3562 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEJB_in_entryRuleEJB3598 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEJB3608 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleEJB3643 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleEJB3653 = new BitSet(new long[]{0x0000200003000000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleEJB3674 = new BitSet(new long[]{0x0000200002000000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleEJB3696 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleEJB3707 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleEJB3724 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleEJB3739 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleEJB3749 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHTTP_in_entryRuleHTTP3785 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHTTP3795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleHTTP3830 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleHTTP3840 = new BitSet(new long[]{0x0000800003000000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleHTTP3861 = new BitSet(new long[]{0x0000800002000000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleHTTP3883 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleHTTP3894 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP3911 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleHTTP3926 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleHTTP3936 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleHTTP3953 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleHTTP3968 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleHTTP3978 = new BitSet(new long[]{0x0000000000000000L,0x0F00000000000000L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleHTTP3999 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleHTTP4009 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleHTTP4019 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleREST_in_entryRuleREST4055 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleREST4065 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleREST4100 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleREST4110 = new BitSet(new long[]{0x0000800003000000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleREST4131 = new BitSet(new long[]{0x0000800002000000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleREST4153 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_47_in_ruleREST4164 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST4181 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleREST4196 = new BitSet(new long[]{0x0001000000000000L});
        public static final BitSet FOLLOW_48_in_ruleREST4206 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleREST4223 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleREST4238 = new BitSet(new long[]{0x0002000000000000L});
        public static final BitSet FOLLOW_49_in_ruleREST4248 = new BitSet(new long[]{0x0000000000000000L,0x0F00000000000000L});
        public static final BitSet FOLLOW_ruleVerb_in_ruleREST4269 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleREST4279 = new BitSet(new long[]{0x0008000000000000L});
        public static final BitSet FOLLOW_51_in_ruleREST4289 = new BitSet(new long[]{0x0000000000000000L,0x00E0000000000000L});
        public static final BitSet FOLLOW_ruleRESTFormat_in_ruleREST4310 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleREST4320 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleREST4330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleJMS_in_entryRuleJMS4366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleJMS4376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleJMS4411 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleJMS4421 = new BitSet(new long[]{0x00C0200003000000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleJMS4454 = new BitSet(new long[]{0x00C0200002000000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleJMS4476 = new BitSet(new long[]{0x00C0200000000000L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_ruleJMS4498 = new BitSet(new long[]{0x0000200000000000L});
        public static final BitSet FOLLOW_45_in_ruleJMS4509 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4526 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleJMS4541 = new BitSet(new long[]{0x0020000000040000L});
        public static final BitSet FOLLOW_53_in_ruleJMS4552 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleJMS4569 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleJMS4584 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleJMS4596 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopicOrQueue_in_entryRuleTopicOrQueue4632 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopicOrQueue4642 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_ruleTopicOrQueue4692 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_ruleTopicOrQueue4722 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleTopic_in_entryRuleTopic4757 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleTopic4767 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleTopic4802 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleTopic4819 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleTopic4834 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQueue_in_entryRuleQueue4870 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQueue4880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleQueue4915 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleQueue4932 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleQueue4947 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSCA_in_entryRuleSCA4983 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSCA4993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleSCA5028 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA5045 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleSCA5060 = new BitSet(new long[]{0x0600000003040000L});
        public static final BitSet FOLLOW_rulePublisher_in_ruleSCA5081 = new BitSet(new long[]{0x0600000002040000L});
        public static final BitSet FOLLOW_ruleProvider_in_ruleSCA5103 = new BitSet(new long[]{0x0600000000040000L});
        public static final BitSet FOLLOW_57_in_ruleSCA5115 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA5132 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSCA5147 = new BitSet(new long[]{0x0400000000040000L});
        public static final BitSet FOLLOW_58_in_ruleSCA5160 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleSCA5177 = new BitSet(new long[]{0x0800000000800000L});
        public static final BitSet FOLLOW_59_in_ruleSCA5200 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleSCA5224 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleSCA5236 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFILE_in_entryRuleFILE5272 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFILE5282 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_60_in_ruleFILE5317 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE5334 = new BitSet(new long[]{0x0000000000000000L,0x3000000000000000L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFILE5360 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleFILE5371 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFILE5388 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFTP_in_entryRuleFTP5431 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFTP5441 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_62_in_ruleFTP5476 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFTP5493 = new BitSet(new long[]{0x8000000000000000L});
        public static final BitSet FOLLOW_63_in_ruleFTP5508 = new BitSet(new long[]{0x0000000000000000L,0x3000000000000000L});
        public static final BitSet FOLLOW_ruleReadWrite_in_ruleFTP5529 = new BitSet(new long[]{0x2000000000000002L});
        public static final BitSet FOLLOW_61_in_ruleFTP5540 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFTP5557 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePolicy_in_entryRulePolicy5600 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePolicy5610 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_rulePolicy5660 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_rulePolicy5690 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLogPolicy_in_entryRuleLogPolicy5725 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLogPolicy5735 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_64_in_ruleLogPolicy5770 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000001C0L});
        public static final BitSet FOLLOW_ruleLogPolicyKind_in_ruleLogPolicy5791 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleLogPolicy5801 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSecurityPolicy_in_entryRuleSecurityPolicy5837 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSecurityPolicy5847 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_ruleSecurityPolicy5897 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthorizationPolicy_in_ruleSecurityPolicy5921 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_ruleSecurityPolicy5945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_ruleSecurityPolicy5969 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthenticationPolicy_in_entryRuleAuthenticationPolicy6004 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthenticationPolicy6014 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_65_in_ruleAuthenticationPolicy6049 = new BitSet(new long[]{0x0000000000010010L,0x0000000000000004L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleAuthenticationPolicy6066 = new BitSet(new long[]{0x0000000000010000L,0x0000000000000004L});
        public static final BitSet FOLLOW_66_in_ruleAuthenticationPolicy6090 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleAuthenticationPolicy6114 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
        public static final BitSet FOLLOW_67_in_ruleAuthenticationPolicy6124 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleAuthenticationPolicy6134 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L,0x000000000000003CL});
        public static final BitSet FOLLOW_ruleAuthToken_in_ruleAuthenticationPolicy6155 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000004L,0x000000000000003CL});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6166 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
        public static final BitSet FOLLOW_68_in_ruleAuthenticationPolicy6176 = new BitSet(new long[]{0x0000000000010000L});
        public static final BitSet FOLLOW_16_in_ruleAuthenticationPolicy6186 = new BitSet(new long[]{0x0000000000040000L,0xC000000000000024L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_ruleAuthenticationPolicy6207 = new BitSet(new long[]{0x0000000000040000L,0xC000000000000024L,0x0000000000000003L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6218 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleAuthenticationPolicy6228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthToken_in_entryRuleAuthToken6264 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthToken6274 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleAuthToken6317 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x000000000000003CL});
        public static final BitSet FOLLOW_ruleAuthTokenKind_in_ruleAuthToken6352 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleAuthToken6362 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleHashAlgorithm_in_entryRuleHashAlgorithm6398 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleHashAlgorithm6408 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_66_in_ruleHashAlgorithm6451 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000020L,0x0000000000000003L});
        public static final BitSet FOLLOW_69_in_ruleHashAlgorithm6483 = new BitSet(new long[]{0x0000000000000000L,0xC000000000000000L,0x0000000000000003L});
        public static final BitSet FOLLOW_ruleHashAlgKind_in_ruleHashAlgorithm6518 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleHashAlgorithm6528 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleAuthorizationPolicy_in_entryRuleAuthorizationPolicy6565 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAuthorizationPolicy6576 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_70_in_ruleAuthorizationPolicy6613 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleSigningPolicy_in_entryRuleSigningPolicy6653 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSigningPolicy6664 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_71_in_ruleSigningPolicy6701 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEncryptionPolicy_in_entryRuleEncryptionPolicy6741 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEncryptionPolicy6752 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_72_in_ruleEncryptionPolicy6789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport6834 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport6844 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_73_in_ruleImport6883 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport6904 = new BitSet(new long[]{0x0000000000800000L});
        public static final BitSet FOLLOW_23_in_ruleImport6914 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId6961 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId6972 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7016 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleVersionId7035 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId7050 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef7111 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef7121 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef7175 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef7205 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef7235 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef7265 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef7310 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef7320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleMinVersionRef7359 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef7380 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef7426 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef7436 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_76_in_ruleMaxVersionRef7475 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef7496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef7542 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef7552 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_75_in_ruleLowerBoundRangeVersionRef7592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
        public static final BitSet FOLLOW_77_in_ruleLowerBoundRangeVersionRef7602 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7624 = new BitSet(new long[]{0x0000000000400000L});
        public static final BitSet FOLLOW_22_in_ruleLowerBoundRangeVersionRef7634 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
        public static final BitSet FOLLOW_76_in_ruleLowerBoundRangeVersionRef7645 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
        public static final BitSet FOLLOW_78_in_ruleLowerBoundRangeVersionRef7655 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef7677 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef7723 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef7733 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_79_in_ruleMajorVersionRef7772 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef7789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard7841 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard7852 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard7903 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
        public static final BitSet FOLLOW_80_in_ruleQualifiedNameWithWildCard7922 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName7975 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName7986 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8030 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_74_in_ruleQualifiedName8049 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName8064 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000400L});
        public static final BitSet FOLLOW_81_in_ruleImplementationType8129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_82_in_ruleImplementationType8144 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_83_in_ruleImplementationType8159 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_84_in_ruleImplementationType8174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_85_in_ruleImplementationType8189 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_86_in_ruleImplementationType8204 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_87_in_ruleImplementationType8219 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_88_in_ruleImplementationType8234 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_89_in_ruleImplementationType8249 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_90_in_ruleImplementationType8264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_91_in_ruleImplementationType8279 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_92_in_ruleImplementationType8294 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_93_in_ruleImplementationType8309 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_94_in_ruleImplementationType8324 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_95_in_ruleImplementationType8339 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_96_in_ruleImplementationType8354 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_97_in_ruleImplementationType8369 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_98_in_ruleImplementationType8384 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleImplementationType8399 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_99_in_ruleImplementationType8414 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_100_in_ruleImplementationType8429 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleImplementationType8444 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_101_in_ruleImplementationType8459 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_102_in_ruleImplementationType8474 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_103_in_ruleImplementationType8489 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_104_in_ruleImplementationType8504 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_105_in_ruleImplementationType8519 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_106_in_ruleImplementationType8534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_107_in_ruleImplementationType8549 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_108_in_ruleImplementationType8564 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_109_in_ruleImplementationType8579 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_110_in_ruleImplementationType8594 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_111_in_ruleImplementationType8609 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_112_in_ruleSOAPStyle8652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_113_in_ruleSOAPStyle8667 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_114_in_ruleSOAPStyle8682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_115_in_ruleSAPTransport8725 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_116_in_ruleSAPTransport8740 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_117_in_ruleRESTFormat8783 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_118_in_ruleRESTFormat8798 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_119_in_ruleRESTFormat8813 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_120_in_ruleVerb8856 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_121_in_ruleVerb8871 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_122_in_ruleVerb8886 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_123_in_ruleVerb8901 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_124_in_ruleReadWrite8944 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_125_in_ruleReadWrite8959 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_126_in_ruleHashAlgKind9002 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_127_in_ruleHashAlgKind9017 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_128_in_ruleHashAlgKind9032 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_129_in_ruleHashAlgKind9047 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_130_in_ruleAuthTokenKind9090 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_131_in_ruleAuthTokenKind9105 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_132_in_ruleAuthTokenKind9120 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_133_in_ruleAuthTokenKind9135 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_134_in_ruleLogPolicyKind9178 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_135_in_ruleLogPolicyKind9193 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_136_in_ruleLogPolicyKind9208 = new BitSet(new long[]{0x0000000000000002L});
    }


}