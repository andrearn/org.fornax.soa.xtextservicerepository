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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalSolutionDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'solution'", "'{'", "'domain'", "'requires'", "'tags'", "'}'", "'module'", "'kind'", "'non-functional'", "'feature'", "'use-cases'", "'description'", "'uses-capabilities'", "'subscribes-to-event'", "','", "'handling responses'", "'calling'", "'version'", "'product-version'", "'import'", "'.'", "'-'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'additional-information'", "'location'", "'section'", "'UI'", "'BusinessLogic'", "'Persistence'", "'Security'", "'Batch'", "'OTHER'", "'pending'", "'accepted'", "'denied'", "'specific'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalSolutionDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSolutionDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSolutionDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g"; }



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



    // $ANTLR start "entryRuleModel"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:74:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:75:2: (iv_ruleModel= ruleModel EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:76:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModel_in_entryRuleModel81);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModel91); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:83:1: ruleModel returns [EObject current=null] : ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_solution_1_0= ruleSolution ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_0_0 = null;

        EObject lv_solution_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:86:28: ( ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_solution_1_0= ruleSolution ) )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_solution_1_0= ruleSolution ) )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:87:1: ( ( (lv_imports_0_0= ruleImport ) )* ( (lv_solution_1_0= ruleSolution ) )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:87:2: ( (lv_imports_0_0= ruleImport ) )* ( (lv_solution_1_0= ruleSolution ) )*
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:87:2: ( (lv_imports_0_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==30) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:88:1: (lv_imports_0_0= ruleImport )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:88:1: (lv_imports_0_0= ruleImport )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:89:3: lv_imports_0_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_0_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleImport_in_ruleModel137);
            	    lv_imports_0_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"imports",
            	              		lv_imports_0_0, 
            	              		"Import");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:105:3: ( (lv_solution_1_0= ruleSolution ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==11) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:106:1: (lv_solution_1_0= ruleSolution )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:106:1: (lv_solution_1_0= ruleSolution )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:107:3: lv_solution_1_0= ruleSolution
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModelAccess().getSolutionSolutionParserRuleCall_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleSolution_in_ruleModel159);
            	    lv_solution_1_0=ruleSolution();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModelRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"solution",
            	              		lv_solution_1_0, 
            	              		"Solution");
            	      	        afterParserOrEnumRuleCall();
            	      	    
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

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleSolution"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:131:1: entryRuleSolution returns [EObject current=null] : iv_ruleSolution= ruleSolution EOF ;
    public final EObject entryRuleSolution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSolution = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:132:2: (iv_ruleSolution= ruleSolution EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:133:2: iv_ruleSolution= ruleSolution EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSolutionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSolution_in_entryRuleSolution196);
            iv_ruleSolution=ruleSolution();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSolution; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSolution206); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSolution"


    // $ANTLR start "ruleSolution"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:140:1: ruleSolution returns [EObject current=null] : (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? ( (lv_additionalInfo_7_0= ruleAdditionalInformation ) )? (otherlv_8= 'requires' ( (lv_requires_9_0= ruleServiceRef ) ) )* ( (lv_features_10_0= ruleFeature ) )* ( (lv_modules_11_0= ruleModule ) )* (otherlv_12= 'tags' ( (otherlv_13= RULE_ID ) )+ )? otherlv_14= '}' ) ;
    public final EObject ruleSolution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_productVersion_6_0 = null;

        EObject lv_additionalInfo_7_0 = null;

        EObject lv_requires_9_0 = null;

        EObject lv_features_10_0 = null;

        EObject lv_modules_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:143:28: ( (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? ( (lv_additionalInfo_7_0= ruleAdditionalInformation ) )? (otherlv_8= 'requires' ( (lv_requires_9_0= ruleServiceRef ) ) )* ( (lv_features_10_0= ruleFeature ) )* ( (lv_modules_11_0= ruleModule ) )* (otherlv_12= 'tags' ( (otherlv_13= RULE_ID ) )+ )? otherlv_14= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? ( (lv_additionalInfo_7_0= ruleAdditionalInformation ) )? (otherlv_8= 'requires' ( (lv_requires_9_0= ruleServiceRef ) ) )* ( (lv_features_10_0= ruleFeature ) )* ( (lv_modules_11_0= ruleModule ) )* (otherlv_12= 'tags' ( (otherlv_13= RULE_ID ) )+ )? otherlv_14= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? ( (lv_additionalInfo_7_0= ruleAdditionalInformation ) )? (otherlv_8= 'requires' ( (lv_requires_9_0= ruleServiceRef ) ) )* ( (lv_features_10_0= ruleFeature ) )* ( (lv_modules_11_0= ruleModule ) )* (otherlv_12= 'tags' ( (otherlv_13= RULE_ID ) )+ )? otherlv_14= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:3: otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? ( (lv_additionalInfo_7_0= ruleAdditionalInformation ) )? (otherlv_8= 'requires' ( (lv_requires_9_0= ruleServiceRef ) ) )* ( (lv_features_10_0= ruleFeature ) )* ( (lv_modules_11_0= ruleModule ) )* (otherlv_12= 'tags' ( (otherlv_13= RULE_ID ) )+ )? otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,11,FollowSets000.FOLLOW_11_in_ruleSolution243); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getSolutionAccess().getSolutionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:148:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:149:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:149:1: (lv_name_1_0= ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:150:3: lv_name_1_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSolutionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution264);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSolutionRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"QualifiedName");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSolution276); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getSolutionAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:170:1: (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==13) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:170:3: otherlv_3= 'domain' ( ( ruleQualifiedName ) )
                    {
                    otherlv_3=(Token)match(input,13,FollowSets000.FOLLOW_13_in_ruleSolution289); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getSolutionAccess().getDomainKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:174:1: ( ( ruleQualifiedName ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:175:1: ( ruleQualifiedName )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:175:1: ( ruleQualifiedName )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:176:3: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {
                       
                      		  /* */ 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			if (current==null) {
                      	            current = createModelElement(grammarAccess.getSolutionRule());
                      	        }
                              
                    }
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSolutionAccess().getDomainDomainCrossReference_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution316);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:192:4: ( (lv_version_5_0= ruleVersion ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:193:1: (lv_version_5_0= ruleVersion )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:193:1: (lv_version_5_0= ruleVersion )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:194:3: lv_version_5_0= ruleVersion
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSolutionAccess().getVersionVersionParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersion_in_ruleSolution339);
            lv_version_5_0=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getSolutionRule());
              	        }
                     		set(
                     			current, 
                     			"version",
                      		lv_version_5_0, 
                      		"Version");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:210:2: ( (lv_productVersion_6_0= ruleProductVersion ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==29) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:211:1: (lv_productVersion_6_0= ruleProductVersion )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:211:1: (lv_productVersion_6_0= ruleProductVersion )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:212:3: lv_productVersion_6_0= ruleProductVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSolutionAccess().getProductVersionProductVersionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProductVersion_in_ruleSolution360);
                    lv_productVersion_6_0=ruleProductVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
                      	        }
                             		set(
                             			current, 
                             			"productVersion",
                              		lv_productVersion_6_0, 
                              		"ProductVersion");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:228:3: ( (lv_additionalInfo_7_0= ruleAdditionalInformation ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==40) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:229:1: (lv_additionalInfo_7_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:229:1: (lv_additionalInfo_7_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:230:3: lv_additionalInfo_7_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSolutionAccess().getAdditionalInfoAdditionalInformationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleSolution382);
                    lv_additionalInfo_7_0=ruleAdditionalInformation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
                      	        }
                             		set(
                             			current, 
                             			"additionalInfo",
                              		lv_additionalInfo_7_0, 
                              		"AdditionalInformation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:246:3: (otherlv_8= 'requires' ( (lv_requires_9_0= ruleServiceRef ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==14) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:246:5: otherlv_8= 'requires' ( (lv_requires_9_0= ruleServiceRef ) )
            	    {
            	    otherlv_8=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSolution396); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getSolutionAccess().getRequiresKeyword_7_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:250:1: ( (lv_requires_9_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:251:1: (lv_requires_9_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:251:1: (lv_requires_9_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:252:3: lv_requires_9_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getRequiresServiceRefParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleSolution417);
            	    lv_requires_9_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_9_0, 
            	              		"ServiceRef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:268:4: ( (lv_features_10_0= ruleFeature ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>=19 && LA7_0<=20)) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:269:1: (lv_features_10_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:269:1: (lv_features_10_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:270:3: lv_features_10_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getFeaturesFeatureParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleSolution440);
            	    lv_features_10_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_10_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:286:3: ( (lv_modules_11_0= ruleModule ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==17) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:287:1: (lv_modules_11_0= ruleModule )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:287:1: (lv_modules_11_0= ruleModule )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:288:3: lv_modules_11_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getModulesModuleParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModule_in_ruleSolution462);
            	    lv_modules_11_0=ruleModule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modules",
            	              		lv_modules_11_0, 
            	              		"Module");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:304:3: (otherlv_12= 'tags' ( (otherlv_13= RULE_ID ) )+ )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==15) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:304:5: otherlv_12= 'tags' ( (otherlv_13= RULE_ID ) )+
                    {
                    otherlv_12=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSolution476); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getSolutionAccess().getTagsKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:308:1: ( (otherlv_13= RULE_ID ) )+
                    int cnt9=0;
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==RULE_ID) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:309:1: (otherlv_13= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:309:1: (otherlv_13= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:310:3: otherlv_13= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getSolutionRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_13=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSolution500); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_13, grammarAccess.getSolutionAccess().getTagsTagCrossReference_10_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt9 >= 1 ) break loop9;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(9, input);
                                throw eee;
                        }
                        cnt9++;
                    } while (true);


                    }
                    break;

            }

            otherlv_14=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSolution515); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_11());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleSolution"


    // $ANTLR start "entryRuleModule"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:336:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:337:2: (iv_ruleModule= ruleModule EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:338:2: iv_ruleModule= ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModule_in_entryRuleModule551);
            iv_ruleModule=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModule; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModule561); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:345:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Enumerator lv_kind_4_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_additionalInfo_6_0 = null;

        EObject lv_requires_8_0 = null;

        EObject lv_features_9_0 = null;

        EObject lv_modules_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:348:28: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:349:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:349:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:349:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModule598); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:353:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:354:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:354:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:355:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModule615); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_1_0, grammarAccess.getModuleAccess().getNameIDTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getModuleRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_1_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule632); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModule644); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getKindKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:379:1: ( (lv_kind_4_0= ruleModuleKind ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:380:1: (lv_kind_4_0= ruleModuleKind )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:380:1: (lv_kind_4_0= ruleModuleKind )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:381:3: lv_kind_4_0= ruleModuleKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleAccess().getKindModuleKindEnumRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleKind_in_ruleModule665);
            lv_kind_4_0=ruleModuleKind();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleRule());
              	        }
                     		set(
                     			current, 
                     			"kind",
                      		lv_kind_4_0, 
                      		"ModuleKind");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:397:2: ( (lv_version_5_0= ruleVersion ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==28) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:398:1: (lv_version_5_0= ruleVersion )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:398:1: (lv_version_5_0= ruleVersion )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:399:3: lv_version_5_0= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getVersionVersionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersion_in_ruleModule686);
                    lv_version_5_0=ruleVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModuleRule());
                      	        }
                             		set(
                             			current, 
                             			"version",
                              		lv_version_5_0, 
                              		"Version");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:415:3: ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==40) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:416:1: (lv_additionalInfo_6_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:416:1: (lv_additionalInfo_6_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:417:3: lv_additionalInfo_6_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getAdditionalInfoAdditionalInformationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleModule708);
                    lv_additionalInfo_6_0=ruleAdditionalInformation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModuleRule());
                      	        }
                             		set(
                             			current, 
                             			"additionalInfo",
                              		lv_additionalInfo_6_0, 
                              		"AdditionalInformation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:433:3: (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==14) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:433:5: otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) )
            	    {
            	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModule722); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getModuleAccess().getRequiresKeyword_7_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:437:1: ( (lv_requires_8_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:438:1: (lv_requires_8_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:438:1: (lv_requires_8_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:439:3: lv_requires_8_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getRequiresServiceRefParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleModule743);
            	    lv_requires_8_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_8_0, 
            	              		"ServiceRef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:455:4: ( (lv_features_9_0= ruleFeature ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=19 && LA14_0<=20)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:456:1: (lv_features_9_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:456:1: (lv_features_9_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:457:3: lv_features_9_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getFeaturesFeatureParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleModule766);
            	    lv_features_9_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_9_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:473:3: ( (lv_modules_10_0= ruleModule ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==17) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:474:1: (lv_modules_10_0= ruleModule )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:474:1: (lv_modules_10_0= ruleModule )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:475:3: lv_modules_10_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getModulesModuleParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModule_in_ruleModule788);
            	    lv_modules_10_0=ruleModule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modules",
            	              		lv_modules_10_0, 
            	              		"Module");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:491:3: (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==15) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:491:5: otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+
                    {
                    otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModule802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getModuleAccess().getTagsKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:495:1: ( (otherlv_12= RULE_ID ) )+
                    int cnt16=0;
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:496:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:496:1: (otherlv_12= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:497:3: otherlv_12= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModuleRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModule826); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_12, grammarAccess.getModuleAccess().getTagsTagCrossReference_10_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt16 >= 1 ) break loop16;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(16, input);
                                throw eee;
                        }
                        cnt16++;
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModule841); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_11());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleFeature"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:523:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:524:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:525:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature877);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature887); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:532:1: ruleFeature returns [EObject current=null] : ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'subscribes-to-event' ( (lv_event_16_0= ruleEventRef ) ) (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )* )? (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? ( (lv_features_21_0= ruleFeature ) )* otherlv_22= '}' ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        Token lv_nonFunctional_0_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_useCase_5_0=null;
        Token otherlv_6=null;
        Token lv_description_7_0=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        EObject lv_additionalInfo_8_0 = null;

        EObject lv_usesCapabilities_11_0 = null;

        EObject lv_requires_14_0 = null;

        EObject lv_event_16_0 = null;

        EObject lv_event_18_0 = null;

        EObject lv_features_21_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:535:28: ( ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'subscribes-to-event' ( (lv_event_16_0= ruleEventRef ) ) (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )* )? (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? ( (lv_features_21_0= ruleFeature ) )* otherlv_22= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:536:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'subscribes-to-event' ( (lv_event_16_0= ruleEventRef ) ) (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )* )? (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? ( (lv_features_21_0= ruleFeature ) )* otherlv_22= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:536:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'subscribes-to-event' ( (lv_event_16_0= ruleEventRef ) ) (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )* )? (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? ( (lv_features_21_0= ruleFeature ) )* otherlv_22= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:536:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'subscribes-to-event' ( (lv_event_16_0= ruleEventRef ) ) (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )* )? (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? ( (lv_features_21_0= ruleFeature ) )* otherlv_22= '}'
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:536:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==19) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:537:1: (lv_nonFunctional_0_0= 'non-functional' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:537:1: (lv_nonFunctional_0_0= 'non-functional' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:538:3: lv_nonFunctional_0_0= 'non-functional'
                    {
                    lv_nonFunctional_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFeature930); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_nonFunctional_0_0, grammarAccess.getFeatureAccess().getNonFunctionalNonFunctionalKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeatureRule());
                      	        }
                             		setWithLastConsumed(current, "nonFunctional", true, "non-functional");
                      	    
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFeature956); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureAccess().getFeatureKeyword_1());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:555:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:556:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:556:1: (lv_name_2_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:557:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFeature973); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_name_2_0, grammarAccess.getFeatureAccess().getNameIDTerminalRuleCall_2_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getFeatureRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"name",
                      		lv_name_2_0, 
                      		"ID");
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature990); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:577:1: (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==21) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:577:3: otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+
                    {
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFeature1003); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFeatureAccess().getUseCasesKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:581:1: ( (lv_useCase_5_0= RULE_STRING ) )+
                    int cnt19=0;
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_STRING) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:582:1: (lv_useCase_5_0= RULE_STRING )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:582:1: (lv_useCase_5_0= RULE_STRING )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:583:3: lv_useCase_5_0= RULE_STRING
                    	    {
                    	    lv_useCase_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature1020); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      			newLeafNode(lv_useCase_5_0, grammarAccess.getFeatureAccess().getUseCaseSTRINGTerminalRuleCall_4_1_0()); 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFeatureRule());
                    	      	        }
                    	             		addWithLastConsumed(
                    	             			current, 
                    	             			"useCase",
                    	              		lv_useCase_5_0, 
                    	              		"STRING");
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt19 >= 1 ) break loop19;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(19, input);
                                throw eee;
                        }
                        cnt19++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:599:5: (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==22) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:599:7: otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFeature1041); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFeatureAccess().getDescriptionKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:603:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:604:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:604:1: (lv_description_7_0= RULE_STRING )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:605:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature1058); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_description_7_0, grammarAccess.getFeatureAccess().getDescriptionSTRINGTerminalRuleCall_5_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getFeatureRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"description",
                              		lv_description_7_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:621:4: ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==40) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:622:1: (lv_additionalInfo_8_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:622:1: (lv_additionalInfo_8_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:623:3: lv_additionalInfo_8_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureAccess().getAdditionalInfoAdditionalInformationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleFeature1086);
                    lv_additionalInfo_8_0=ruleAdditionalInformation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                      	        }
                             		set(
                             			current, 
                             			"additionalInfo",
                              		lv_additionalInfo_8_0, 
                              		"AdditionalInformation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:639:3: (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==23) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:639:5: otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFeature1100); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFeatureAccess().getUsesCapabilitiesKeyword_7_0());
                          
                    }
                    otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1112); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_7_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:647:1: ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_ID) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:648:1: (lv_usesCapabilities_11_0= ruleCapabilityRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:648:1: (lv_usesCapabilities_11_0= ruleCapabilityRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:649:3: lv_usesCapabilities_11_0= ruleCapabilityRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getUsesCapabilitiesCapabilityRefParserRuleCall_7_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_ruleFeature1133);
                    	    lv_usesCapabilities_11_0=ruleCapabilityRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"usesCapabilities",
                    	              		lv_usesCapabilities_11_0, 
                    	              		"CapabilityRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt23 >= 1 ) break loop23;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(23, input);
                                throw eee;
                        }
                        cnt23++;
                    } while (true);

                    otherlv_12=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFeature1146); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_7_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:669:3: (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==14) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:669:5: otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) )
            	    {
            	    otherlv_13=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleFeature1161); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_13, grammarAccess.getFeatureAccess().getRequiresKeyword_8_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:673:1: ( (lv_requires_14_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:674:1: (lv_requires_14_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:674:1: (lv_requires_14_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:675:3: lv_requires_14_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getRequiresServiceRefParserRuleCall_8_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleFeature1182);
            	    lv_requires_14_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_14_0, 
            	              		"ServiceRef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:691:4: (otherlv_15= 'subscribes-to-event' ( (lv_event_16_0= ruleEventRef ) ) (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )* )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==24) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:691:6: otherlv_15= 'subscribes-to-event' ( (lv_event_16_0= ruleEventRef ) ) (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )*
                    {
                    otherlv_15=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleFeature1197); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_15, grammarAccess.getFeatureAccess().getSubscribesToEventKeyword_9_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:695:1: ( (lv_event_16_0= ruleEventRef ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:696:1: (lv_event_16_0= ruleEventRef )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:696:1: (lv_event_16_0= ruleEventRef )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:697:3: lv_event_16_0= ruleEventRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureAccess().getEventEventRefParserRuleCall_9_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEventRef_in_ruleFeature1218);
                    lv_event_16_0=ruleEventRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                      	        }
                             		add(
                             			current, 
                             			"event",
                              		lv_event_16_0, 
                              		"EventRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:713:2: (otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==25) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:713:4: otherlv_17= ',' ( (lv_event_18_0= ruleEventRef ) )
                    	    {
                    	    otherlv_17=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleFeature1231); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_17, grammarAccess.getFeatureAccess().getCommaKeyword_9_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:717:1: ( (lv_event_18_0= ruleEventRef ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:718:1: (lv_event_18_0= ruleEventRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:718:1: (lv_event_18_0= ruleEventRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:719:3: lv_event_18_0= ruleEventRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getEventEventRefParserRuleCall_9_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleEventRef_in_ruleFeature1252);
                    	    lv_event_18_0=ruleEventRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"event",
                    	              		lv_event_18_0, 
                    	              		"EventRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:735:6: (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==15) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:735:8: otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+
                    {
                    otherlv_19=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFeature1269); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getFeatureAccess().getTagsKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:739:1: ( (otherlv_20= RULE_ID ) )+
                    int cnt28=0;
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:740:1: (otherlv_20= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:740:1: (otherlv_20= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:741:3: otherlv_20= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFeatureRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_20=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFeature1293); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_20, grammarAccess.getFeatureAccess().getTagsTagCrossReference_10_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt28 >= 1 ) break loop28;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(28, input);
                                throw eee;
                        }
                        cnt28++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:755:5: ( (lv_features_21_0= ruleFeature ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( ((LA30_0>=19 && LA30_0<=20)) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:756:1: (lv_features_21_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:756:1: (lv_features_21_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:757:3: lv_features_21_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getFeaturesFeatureParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleFeature1317);
            	    lv_features_21_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_21_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_22=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFeature1330); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_22, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_12());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleServiceRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:785:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:786:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:787:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef1366);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef1376); if (state.failed) return current;

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
    // $ANTLR end "entryRuleServiceRef"


    // $ANTLR start "ruleServiceRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:794:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? ) ;
    public final EObject ruleServiceRef() throws RecognitionException {
        EObject current = null;

        Token lv_isResponseHandler_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_versionRef_1_0 = null;

        EObject lv_calledOperations_4_0 = null;

        EObject lv_calledOperations_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:797:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:798:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:798:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:798:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )?
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:798:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:799:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:799:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:800:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getServiceRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getServiceServiceCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef1428);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:816:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:817:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:817:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:818:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef1449);
            lv_versionRef_1_0=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getServiceRefRule());
              	        }
                     		set(
                     			current, 
                     			"versionRef",
                      		lv_versionRef_1_0, 
                      		"VersionRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:834:2: ( (lv_isResponseHandler_2_0= 'handling responses' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==26) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:835:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:835:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:836:3: lv_isResponseHandler_2_0= 'handling responses'
                    {
                    lv_isResponseHandler_2_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleServiceRef1467); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_isResponseHandler_2_0, grammarAccess.getServiceRefAccess().getIsResponseHandlerHandlingResponsesKeyword_2_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getServiceRefRule());
                      	        }
                             		setWithLastConsumed(current, "isResponseHandler", true, "handling responses");
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:849:3: (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==27) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:849:5: otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )*
                    {
                    otherlv_3=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleServiceRef1494); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getServiceRefAccess().getCallingKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:853:1: ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:854:1: (lv_calledOperations_4_0= ruleSimpleOperationRef )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:854:1: (lv_calledOperations_4_0= ruleSimpleOperationRef )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:855:3: lv_calledOperations_4_0= ruleSimpleOperationRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceRefAccess().getCalledOperationsSimpleOperationRefParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef1515);
                    lv_calledOperations_4_0=ruleSimpleOperationRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getServiceRefRule());
                      	        }
                             		add(
                             			current, 
                             			"calledOperations",
                              		lv_calledOperations_4_0, 
                              		"SimpleOperationRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:871:2: (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==25) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:871:4: otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) )
                    	    {
                    	    otherlv_5=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleServiceRef1528); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getServiceRefAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:875:1: ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:876:1: (lv_calledOperations_6_0= ruleSimpleOperationRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:876:1: (lv_calledOperations_6_0= ruleSimpleOperationRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:877:3: lv_calledOperations_6_0= ruleSimpleOperationRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceRefAccess().getCalledOperationsSimpleOperationRefParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef1549);
                    	    lv_calledOperations_6_0=ruleSimpleOperationRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getServiceRefRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"calledOperations",
                    	              		lv_calledOperations_6_0, 
                    	              		"SimpleOperationRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleServiceRef"


    // $ANTLR start "entryRuleSimpleOperationRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:901:1: entryRuleSimpleOperationRef returns [EObject current=null] : iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF ;
    public final EObject entryRuleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleOperationRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:902:2: (iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:903:2: iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleOperationRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_entryRuleSimpleOperationRef1589);
            iv_ruleSimpleOperationRef=ruleSimpleOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleOperationRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleOperationRef1599); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSimpleOperationRef"


    // $ANTLR start "ruleSimpleOperationRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:910:1: ruleSimpleOperationRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:913:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:914:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:914:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:915:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:915:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:916:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getSimpleOperationRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getSimpleOperationRefAccess().getOperationOperationCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSimpleOperationRef1650);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleSimpleOperationRef"


    // $ANTLR start "entryRuleCapabilityRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:940:1: entryRuleCapabilityRef returns [EObject current=null] : iv_ruleCapabilityRef= ruleCapabilityRef EOF ;
    public final EObject entryRuleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapabilityRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:941:2: (iv_ruleCapabilityRef= ruleCapabilityRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:942:2: iv_ruleCapabilityRef= ruleCapabilityRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapabilityRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef1685);
            iv_ruleCapabilityRef=ruleCapabilityRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapabilityRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapabilityRef1695); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCapabilityRef"


    // $ANTLR start "ruleCapabilityRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:949:1: ruleCapabilityRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:952:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:953:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:953:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:953:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:953:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:954:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:954:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:955:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getCapabilityRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCapabilityRefAccess().getCapabilityCapabilityCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleCapabilityRef1747);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:971:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:972:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:972:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:973:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCapabilityRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleCapabilityRef1768);
            lv_versionRef_1_0=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getCapabilityRefRule());
              	        }
                     		set(
                     			current, 
                     			"versionRef",
                      		lv_versionRef_1_0, 
                      		"VersionRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleCapabilityRef"


    // $ANTLR start "entryRuleVersion"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:997:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:998:2: (iv_ruleVersion= ruleVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:999:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersion_in_entryRuleVersion1804);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersion1814); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVersion"


    // $ANTLR start "ruleVersion"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1006:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1009:28: ( (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1010:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1010:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1010:3: otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleVersion1851); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1014:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1015:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1015:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1016:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleVersion1872);
            lv_version_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getVersionRule());
              	        }
                     		set(
                     			current, 
                     			"version",
                      		lv_version_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleVersion"


    // $ANTLR start "entryRuleProductVersion"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1040:1: entryRuleProductVersion returns [EObject current=null] : iv_ruleProductVersion= ruleProductVersion EOF ;
    public final EObject entryRuleProductVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1041:2: (iv_ruleProductVersion= ruleProductVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1042:2: iv_ruleProductVersion= ruleProductVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProductVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProductVersion_in_entryRuleProductVersion1908);
            iv_ruleProductVersion=ruleProductVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProductVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProductVersion1918); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProductVersion"


    // $ANTLR start "ruleProductVersion"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1049:1: ruleProductVersion returns [EObject current=null] : (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleProductVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1052:28: ( (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1053:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1053:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1053:3: otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleProductVersion1955); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProductVersionAccess().getProductVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1057:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1058:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1058:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1059:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProductVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleProductVersion1976);
            lv_version_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getProductVersionRule());
              	        }
                     		set(
                     			current, 
                     			"version",
                      		lv_version_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleProductVersion"


    // $ANTLR start "entryRuleEventRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1083:1: entryRuleEventRef returns [EObject current=null] : iv_ruleEventRef= ruleEventRef EOF ;
    public final EObject entryRuleEventRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1084:2: (iv_ruleEventRef= ruleEventRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1085:2: iv_ruleEventRef= ruleEventRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEventRef_in_entryRuleEventRef2012);
            iv_ruleEventRef=ruleEventRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEventRef2022); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEventRef"


    // $ANTLR start "ruleEventRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1092:1: ruleEventRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleEventRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1095:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1096:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1096:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1096:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1096:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1097:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1097:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1098:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getEventRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventRefAccess().getEventEventCrossReference_0_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEventRef2074);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1114:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1115:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1115:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1116:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleEventRef2095);
            lv_versionRef_1_0=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getEventRefRule());
              	        }
                     		set(
                     			current, 
                     			"versionRef",
                      		lv_versionRef_1_0, 
                      		"VersionRef");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleEventRef"


    // $ANTLR start "entryRuleImport"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1140:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1141:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1142:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport2131);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport2141); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1149:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1152:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1153:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1153:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1153:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleImport2178); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1157:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1158:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1158:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1159:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport2199);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getImportRule());
              	        }
                     		set(
                     			current, 
                     			"importedNamespace",
                      		lv_importedNamespace_1_0, 
                      		"QualifiedNameWithWildCard");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleVersionId"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1183:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1184:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1185:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId2236);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId2247); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVersionId"


    // $ANTLR start "ruleVersionId"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1192:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1195:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1196:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1196:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1196:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId2287); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1203:1: (kw= '.' this_INT_2= RULE_INT )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==31) ) {
                    int LA34_1 = input.LA(2);

                    if ( (LA34_1==RULE_INT) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1204:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVersionId2306); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId2321); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1216:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=31 && LA36_0<=32)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1216:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1216:4: (kw= '.' | kw= '-' )
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==31) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==32) ) {
            	        alt35=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1217:2: kw= '.'
            	            {
            	            kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleVersionId2343); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1224:2: kw= '-'
            	            {
            	            kw=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleVersionId2362); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId2378); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleVersionId"


    // $ANTLR start "entryRuleVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1246:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1247:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1248:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef2427);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef2437); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVersionRef"


    // $ANTLR start "ruleVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1255:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1258:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1259:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1259:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt37=5;
            switch ( input.LA(1) ) {
            case 33:
                {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==RULE_INT) ) {
                    alt37=1;
                }
                else if ( (LA37_1==35) ) {
                    alt37=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
                }
                break;
            case 34:
                {
                alt37=2;
                }
                break;
            case 37:
                {
                alt37=4;
                }
                break;
            case 38:
                {
                alt37=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1260:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef2487);
                    this_MinVersionRef_0=ruleMinVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MinVersionRef_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1273:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef2517);
                    this_MaxVersionRef_1=ruleMaxVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MaxVersionRef_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1286:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef2547);
                    this_LowerBoundRangeVersionRef_2=ruleLowerBoundRangeVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_LowerBoundRangeVersionRef_2; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1299:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef2577);
                    this_MajorVersionRef_3=ruleMajorVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_MajorVersionRef_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1312:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef2607);
                    this_FixedVersionRef_4=ruleFixedVersionRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_FixedVersionRef_4; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleVersionRef"


    // $ANTLR start "entryRuleMinVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1331:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1332:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1333:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef2642);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef2652); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMinVersionRef"


    // $ANTLR start "ruleMinVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1340:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1343:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1344:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1344:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1344:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleMinVersionRef2689); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1348:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1349:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1349:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1350:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef2710);
            lv_minVersion_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMinVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"minVersion",
                      		lv_minVersion_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMinVersionRef"


    // $ANTLR start "entryRuleMaxVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1374:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1375:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1376:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef2746);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef2756); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMaxVersionRef"


    // $ANTLR start "ruleMaxVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1383:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1386:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1387:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1387:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1387:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleMaxVersionRef2793); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1391:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1392:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1392:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1393:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef2814);
            lv_maxVersion_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getMaxVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"maxVersion",
                      		lv_maxVersion_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMaxVersionRef"


    // $ANTLR start "entryRuleLowerBoundRangeVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1417:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1418:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1419:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef2850);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef2860); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLowerBoundRangeVersionRef"


    // $ANTLR start "ruleLowerBoundRangeVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1426:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
    public final EObject ruleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_minVersion_2_0 = null;

        AntlrDatatypeRuleToken lv_maxVersion_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1429:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1430:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1430:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1430:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1430:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1430:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleLowerBoundRangeVersionRef2898); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleLowerBoundRangeVersionRef2910); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1438:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1439:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1439:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1440:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2932);
            lv_minVersion_2_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLowerBoundRangeVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"minVersion",
                      		lv_minVersion_2_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLowerBoundRangeVersionRef2944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1460:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1460:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleLowerBoundRangeVersionRef2957); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleLowerBoundRangeVersionRef2969); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1468:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1469:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1469:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1470:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2991);
            lv_maxVersion_6_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getLowerBoundRangeVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"maxVersion",
                      		lv_maxVersion_6_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleLowerBoundRangeVersionRef"


    // $ANTLR start "entryRuleMajorVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1494:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1495:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1496:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef3027);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef3037); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMajorVersionRef"


    // $ANTLR start "ruleMajorVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1503:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1506:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1507:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1507:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1507:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleMajorVersionRef3074); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1511:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1512:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1512:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1513:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef3091); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_majorVersion_1_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionINTTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getMajorVersionRefRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"majorVersion",
                      		lv_majorVersion_1_0, 
                      		"INT");
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleMajorVersionRef"


    // $ANTLR start "entryRuleFixedVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1537:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1538:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1539:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef3132);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef3142); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFixedVersionRef"


    // $ANTLR start "ruleFixedVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1546:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1549:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1550:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1550:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1550:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleFixedVersionRef3179); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1554:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1555:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1555:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1556:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef3200);
            lv_fixedVersion_1_0=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getFixedVersionRefRule());
              	        }
                     		set(
                     			current, 
                     			"fixedVersion",
                      		lv_fixedVersion_1_0, 
                      		"VersionId");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleFixedVersionRef"


    // $ANTLR start "entryRuleQualifiedNameWithWildCard"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1580:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1581:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1582:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard3237);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard3248); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedNameWithWildCard"


    // $ANTLR start "ruleQualifiedNameWithWildCard"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1589:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1592:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1593:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1593:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1594:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3295);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1604:1: (kw= '.*' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==39) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1605:2: kw= '.*'
                    {
                    kw=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleQualifiedNameWithWildCard3314); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getQualifiedNameWithWildCardAccess().getFullStopAsteriskKeyword_1()); 
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedNameWithWildCard"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1618:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1619:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1620:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3357);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName3368); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1627:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1630:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1631:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1631:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1631:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName3408); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1638:1: (kw= '.' this_ID_2= RULE_ID )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==31) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1639:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleQualifiedName3427); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName3442); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleAdditionalInformation"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1663:1: entryRuleAdditionalInformation returns [EObject current=null] : iv_ruleAdditionalInformation= ruleAdditionalInformation EOF ;
    public final EObject entryRuleAdditionalInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionalInformation = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1664:2: (iv_ruleAdditionalInformation= ruleAdditionalInformation EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1665:2: iv_ruleAdditionalInformation= ruleAdditionalInformation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionalInformationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_entryRuleAdditionalInformation3493);
            iv_ruleAdditionalInformation=ruleAdditionalInformation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditionalInformation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdditionalInformation3503); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAdditionalInformation"


    // $ANTLR start "ruleAdditionalInformation"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1672:1: ruleAdditionalInformation returns [EObject current=null] : (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' ) ;
    public final EObject ruleAdditionalInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_infoItems_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1675:28: ( (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1676:1: (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1676:1: (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1676:3: otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleAdditionalInformation3540); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdditionalInformationAccess().getAdditionalInformationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAdditionalInformation3552); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdditionalInformationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1684:1: ( (lv_infoItems_2_0= ruleInfoItem ) )+
            int cnt40=0;
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==41) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1685:1: (lv_infoItems_2_0= ruleInfoItem )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1685:1: (lv_infoItems_2_0= ruleInfoItem )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1686:3: lv_infoItems_2_0= ruleInfoItem
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionalInformationAccess().getInfoItemsInfoItemParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_ruleAdditionalInformation3573);
            	    lv_infoItems_2_0=ruleInfoItem();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getAdditionalInformationRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"infoItems",
            	              		lv_infoItems_2_0, 
            	              		"InfoItem");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt40 >= 1 ) break loop40;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(40, input);
                        throw eee;
                }
                cnt40++;
            } while (true);

            otherlv_3=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleAdditionalInformation3586); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getAdditionalInformationAccess().getRightCurlyBracketKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleAdditionalInformation"


    // $ANTLR start "entryRuleInfoItem"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1714:1: entryRuleInfoItem returns [EObject current=null] : iv_ruleInfoItem= ruleInfoItem EOF ;
    public final EObject entryRuleInfoItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfoItem = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1715:2: (iv_ruleInfoItem= ruleInfoItem EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1716:2: iv_ruleInfoItem= ruleInfoItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfoItemRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_entryRuleInfoItem3622);
            iv_ruleInfoItem=ruleInfoItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfoItem; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfoItem3632); if (state.failed) return current;

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
    // $ANTLR end "entryRuleInfoItem"


    // $ANTLR start "ruleInfoItem"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1723:1: ruleInfoItem returns [EObject current=null] : (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'section' ( (lv_section_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleInfoItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_documentLocation_1_0=null;
        Token otherlv_2=null;
        Token lv_section_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1726:28: ( (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'section' ( (lv_section_3_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1727:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'section' ( (lv_section_3_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1727:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'section' ( (lv_section_3_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1727:3: otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'section' ( (lv_section_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleInfoItem3669); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInfoItemAccess().getLocationKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1731:1: ( (lv_documentLocation_1_0= RULE_STRING ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1732:1: (lv_documentLocation_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1732:1: (lv_documentLocation_1_0= RULE_STRING )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1733:3: lv_documentLocation_1_0= RULE_STRING
            {
            lv_documentLocation_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem3686); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_documentLocation_1_0, grammarAccess.getInfoItemAccess().getDocumentLocationSTRINGTerminalRuleCall_1_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getInfoItemRule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"documentLocation",
                      		lv_documentLocation_1_0, 
                      		"STRING");
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1749:2: (otherlv_2= 'section' ( (lv_section_3_0= RULE_STRING ) ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==42) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1749:4: otherlv_2= 'section' ( (lv_section_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleInfoItem3704); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInfoItemAccess().getSectionKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1753:1: ( (lv_section_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1754:1: (lv_section_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1754:1: (lv_section_3_0= RULE_STRING )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1755:3: lv_section_3_0= RULE_STRING
                    {
                    lv_section_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem3721); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_section_3_0, grammarAccess.getInfoItemAccess().getSectionSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInfoItemRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"section",
                              		lv_section_3_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleInfoItem"


    // $ANTLR start "ruleModuleKind"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1779:1: ruleModuleKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) ;
    public final Enumerator ruleModuleKind() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1781:28: ( ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1782:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1782:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
            int alt42=6;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt42=1;
                }
                break;
            case 44:
                {
                alt42=2;
                }
                break;
            case 45:
                {
                alt42=3;
                }
                break;
            case 46:
                {
                alt42=4;
                }
                break;
            case 47:
                {
                alt42=5;
                }
                break;
            case 48:
                {
                alt42=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 42, 0, input);

                throw nvae;
            }

            switch (alt42) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1782:2: (enumLiteral_0= 'UI' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1782:2: (enumLiteral_0= 'UI' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1782:4: enumLiteral_0= 'UI'
                    {
                    enumLiteral_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleModuleKind3778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1788:6: (enumLiteral_1= 'BusinessLogic' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1788:6: (enumLiteral_1= 'BusinessLogic' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1788:8: enumLiteral_1= 'BusinessLogic'
                    {
                    enumLiteral_1=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleModuleKind3795); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1794:6: (enumLiteral_2= 'Persistence' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1794:6: (enumLiteral_2= 'Persistence' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1794:8: enumLiteral_2= 'Persistence'
                    {
                    enumLiteral_2=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleModuleKind3812); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1800:6: (enumLiteral_3= 'Security' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1800:6: (enumLiteral_3= 'Security' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1800:8: enumLiteral_3= 'Security'
                    {
                    enumLiteral_3=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleModuleKind3829); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1806:6: (enumLiteral_4= 'Batch' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1806:6: (enumLiteral_4= 'Batch' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1806:8: enumLiteral_4= 'Batch'
                    {
                    enumLiteral_4=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleModuleKind3846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1812:6: (enumLiteral_5= 'OTHER' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1812:6: (enumLiteral_5= 'OTHER' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1812:8: enumLiteral_5= 'OTHER'
                    {
                    enumLiteral_5=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleModuleKind3863); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getOTHEREnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_5, grammarAccess.getModuleKindAccess().getOTHEREnumLiteralDeclaration_5()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleModuleKind"


    // $ANTLR start "ruleGovernanceDecisionResult"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1822:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1824:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1825:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1825:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt43=4;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt43=1;
                }
                break;
            case 50:
                {
                alt43=2;
                }
                break;
            case 51:
                {
                alt43=3;
                }
                break;
            case 52:
                {
                alt43=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1825:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1825:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1825:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleGovernanceDecisionResult3908); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1831:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1831:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1831:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleGovernanceDecisionResult3925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1837:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1837:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1837:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleGovernanceDecisionResult3942); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1843:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1843:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1843:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleGovernanceDecisionResult3959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getSpecificEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getGovernanceDecisionResultAccess().getSpecificEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleGovernanceDecisionResult"

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel137 = new BitSet(new long[]{0x0000000040000802L});
        public static final BitSet FOLLOW_ruleSolution_in_ruleModel159 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleSolution_in_entryRuleSolution196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSolution206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSolution243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution264 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSolution276 = new BitSet(new long[]{0x0000000010002000L});
        public static final BitSet FOLLOW_13_in_ruleSolution289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution316 = new BitSet(new long[]{0x0000000010002000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleSolution339 = new BitSet(new long[]{0x00000100201BC000L});
        public static final BitSet FOLLOW_ruleProductVersion_in_ruleSolution360 = new BitSet(new long[]{0x00000100001BC000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleSolution382 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_14_in_ruleSolution396 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleSolution417 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleSolution440 = new BitSet(new long[]{0x00000000001B8000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleSolution462 = new BitSet(new long[]{0x0000000000038000L});
        public static final BitSet FOLLOW_15_in_ruleSolution476 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSolution500 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleSolution515 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModule_in_entryRuleModule551 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModule561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModule598 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModule615 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule632 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModule644 = new BitSet(new long[]{0x0001F80000000000L});
        public static final BitSet FOLLOW_ruleModuleKind_in_ruleModule665 = new BitSet(new long[]{0x00000100101BE000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleModule686 = new BitSet(new long[]{0x00000100001BC000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleModule708 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_14_in_ruleModule722 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleModule743 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleModule766 = new BitSet(new long[]{0x00000000001B8000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleModule788 = new BitSet(new long[]{0x0000000000038000L});
        public static final BitSet FOLLOW_15_in_ruleModule802 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModule826 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleModule841 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature877 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleFeature930 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleFeature956 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFeature973 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature990 = new BitSet(new long[]{0x0000010001F9C000L});
        public static final BitSet FOLLOW_21_in_ruleFeature1003 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature1020 = new BitSet(new long[]{0x0000010001D9C020L});
        public static final BitSet FOLLOW_22_in_ruleFeature1041 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature1058 = new BitSet(new long[]{0x000001000199C000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleFeature1086 = new BitSet(new long[]{0x000000000199C000L});
        public static final BitSet FOLLOW_23_in_ruleFeature1100 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1112 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_ruleFeature1133 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleFeature1146 = new BitSet(new long[]{0x000000000119C000L});
        public static final BitSet FOLLOW_14_in_ruleFeature1161 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleFeature1182 = new BitSet(new long[]{0x000000000119C000L});
        public static final BitSet FOLLOW_24_in_ruleFeature1197 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEventRef_in_ruleFeature1218 = new BitSet(new long[]{0x0000000002198000L});
        public static final BitSet FOLLOW_25_in_ruleFeature1231 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEventRef_in_ruleFeature1252 = new BitSet(new long[]{0x0000000002198000L});
        public static final BitSet FOLLOW_15_in_ruleFeature1269 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFeature1293 = new BitSet(new long[]{0x0000000000190010L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleFeature1317 = new BitSet(new long[]{0x0000000000190000L});
        public static final BitSet FOLLOW_16_in_ruleFeature1330 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef1366 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef1376 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef1428 = new BitSet(new long[]{0x0000006600000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef1449 = new BitSet(new long[]{0x000000000C000002L});
        public static final BitSet FOLLOW_26_in_ruleServiceRef1467 = new BitSet(new long[]{0x0000000008000002L});
        public static final BitSet FOLLOW_27_in_ruleServiceRef1494 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef1515 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_25_in_ruleServiceRef1528 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef1549 = new BitSet(new long[]{0x0000000002000002L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_entryRuleSimpleOperationRef1589 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleOperationRef1599 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleOperationRef1650 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef1685 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapabilityRef1695 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCapabilityRef1747 = new BitSet(new long[]{0x0000006600000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleCapabilityRef1768 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion1804 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersion1814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleVersion1851 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleVersion1872 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductVersion_in_entryRuleProductVersion1908 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProductVersion1918 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleProductVersion1955 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleProductVersion1976 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEventRef_in_entryRuleEventRef2012 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEventRef2022 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEventRef2074 = new BitSet(new long[]{0x0000006600000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleEventRef2095 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport2131 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport2141 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_30_in_ruleImport2178 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport2199 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId2236 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId2247 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId2287 = new BitSet(new long[]{0x0000000180000002L});
        public static final BitSet FOLLOW_31_in_ruleVersionId2306 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId2321 = new BitSet(new long[]{0x0000000180000002L});
        public static final BitSet FOLLOW_31_in_ruleVersionId2343 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_32_in_ruleVersionId2362 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId2378 = new BitSet(new long[]{0x0000000180000002L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef2427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef2437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef2487 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef2517 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef2547 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef2577 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef2607 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef2642 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef2652 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleMinVersionRef2689 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef2710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef2746 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef2756 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleMaxVersionRef2793 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef2814 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef2850 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef2860 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_33_in_ruleLowerBoundRangeVersionRef2898 = new BitSet(new long[]{0x0000000800000000L});
        public static final BitSet FOLLOW_35_in_ruleLowerBoundRangeVersionRef2910 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2932 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLowerBoundRangeVersionRef2944 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleLowerBoundRangeVersionRef2957 = new BitSet(new long[]{0x0000001000000000L});
        public static final BitSet FOLLOW_36_in_ruleLowerBoundRangeVersionRef2969 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2991 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef3027 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef3037 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_37_in_ruleMajorVersionRef3074 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef3091 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef3132 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef3142 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_38_in_ruleFixedVersionRef3179 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef3200 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard3237 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard3248 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3295 = new BitSet(new long[]{0x0000008000000002L});
        public static final BitSet FOLLOW_39_in_ruleQualifiedNameWithWildCard3314 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3357 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3368 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3408 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_31_in_ruleQualifiedName3427 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3442 = new BitSet(new long[]{0x0000000080000002L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_entryRuleAdditionalInformation3493 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdditionalInformation3503 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleAdditionalInformation3540 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAdditionalInformation3552 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_ruleInfoItem_in_ruleAdditionalInformation3573 = new BitSet(new long[]{0x0000020000010000L});
        public static final BitSet FOLLOW_16_in_ruleAdditionalInformation3586 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfoItem_in_entryRuleInfoItem3622 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfoItem3632 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleInfoItem3669 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem3686 = new BitSet(new long[]{0x0000040000000002L});
        public static final BitSet FOLLOW_42_in_ruleInfoItem3704 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem3721 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleModuleKind3778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleModuleKind3795 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_45_in_ruleModuleKind3812 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleModuleKind3829 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleModuleKind3846 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_48_in_ruleModuleKind3863 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleGovernanceDecisionResult3908 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleGovernanceDecisionResult3925 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleGovernanceDecisionResult3942 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleGovernanceDecisionResult3959 = new BitSet(new long[]{0x0000000000000002L});
    }


}