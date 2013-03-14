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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'solution'", "'{'", "'domain'", "'lifecycle-state'", "'requires'", "'requires-channel'", "'contact-info'", "'owner'", "'responsible'", "'budgeting'", "'}'", "'tags'", "'subscriptions'", "'module'", "'kind'", "'non-functional'", "'feature'", "'use-cases'", "'description'", "'uses-capabilities'", "'handling responses'", "'calling'", "','", "'version'", "'product-version'", "'import'", "'.'", "'-'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'additional-information'", "'location'", "'reference'", "'UI'", "'BusinessLogic'", "'Persistence'", "'Security'", "'Batch'", "'OTHER'", "'pending'", "'accepted'", "'denied'", "'specific'"
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
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__16=16;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
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

                if ( (LA1_0==36) ) {
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:140:1: ruleSolution returns [EObject current=null] : (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contact-info' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_24= '}' )? (otherlv_25= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_27= 'subscriptions' otherlv_28= '{' ( ( ruleQualifiedName ) )* otherlv_30= '}' )? otherlv_31= '}' ) ;
    public final EObject ruleSolution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_16=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Token otherlv_30=null;
        Token otherlv_31=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_productVersion_8_0 = null;

        EObject lv_additionalInfo_9_0 = null;

        EObject lv_requires_11_0 = null;

        EObject lv_features_14_0 = null;

        EObject lv_modules_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:143:28: ( (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contact-info' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_24= '}' )? (otherlv_25= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_27= 'subscriptions' otherlv_28= '{' ( ( ruleQualifiedName ) )* otherlv_30= '}' )? otherlv_31= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contact-info' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_24= '}' )? (otherlv_25= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_27= 'subscriptions' otherlv_28= '{' ( ( ruleQualifiedName ) )* otherlv_30= '}' )? otherlv_31= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contact-info' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_24= '}' )? (otherlv_25= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_27= 'subscriptions' otherlv_28= '{' ( ( ruleQualifiedName ) )* otherlv_30= '}' )? otherlv_31= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:3: otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contact-info' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_24= '}' )? (otherlv_25= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_27= 'subscriptions' otherlv_28= '{' ( ( ruleQualifiedName ) )* otherlv_30= '}' )? otherlv_31= '}'
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

            otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSolution351); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getSolutionAccess().getLifecycleStateKeyword_5());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:214:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:215:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:215:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:216:3: ruleQualifiedName
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
               
              	        newCompositeNode(grammarAccess.getSolutionAccess().getStateLifecycleStateCrossReference_6_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution378);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:232:2: ( (lv_productVersion_8_0= ruleProductVersion ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==35) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:233:1: (lv_productVersion_8_0= ruleProductVersion )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:233:1: (lv_productVersion_8_0= ruleProductVersion )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:234:3: lv_productVersion_8_0= ruleProductVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSolutionAccess().getProductVersionProductVersionParserRuleCall_7_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleProductVersion_in_ruleSolution399);
                    lv_productVersion_8_0=ruleProductVersion();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
                      	        }
                             		set(
                             			current, 
                             			"productVersion",
                              		lv_productVersion_8_0, 
                              		"ProductVersion");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:250:3: ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==46) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:251:1: (lv_additionalInfo_9_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:251:1: (lv_additionalInfo_9_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:252:3: lv_additionalInfo_9_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getSolutionAccess().getAdditionalInfoAdditionalInformationParserRuleCall_8_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleSolution421);
                    lv_additionalInfo_9_0=ruleAdditionalInformation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
                      	        }
                             		set(
                             			current, 
                             			"additionalInfo",
                              		lv_additionalInfo_9_0, 
                              		"AdditionalInformation");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:268:3: (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==15) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:268:5: otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) )
            	    {
            	    otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSolution435); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_10, grammarAccess.getSolutionAccess().getRequiresKeyword_9_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:272:1: ( (lv_requires_11_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:273:1: (lv_requires_11_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:273:1: (lv_requires_11_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:274:3: lv_requires_11_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getRequiresServiceRefParserRuleCall_9_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleSolution456);
            	    lv_requires_11_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_11_0, 
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:290:4: (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==16) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:290:6: otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_12=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSolution471); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_12, grammarAccess.getSolutionAccess().getRequiresChannelKeyword_10_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:294:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:295:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:295:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:296:3: ruleQualifiedName
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
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getRequiresChannelChannelCrossReference_10_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution498);
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

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:312:4: ( (lv_features_14_0= ruleFeature ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=26 && LA8_0<=27)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:313:1: (lv_features_14_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:313:1: (lv_features_14_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:314:3: lv_features_14_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getFeaturesFeatureParserRuleCall_11_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleSolution521);
            	    lv_features_14_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_14_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:330:3: ( (lv_modules_15_0= ruleModule ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==24) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:331:1: (lv_modules_15_0= ruleModule )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:331:1: (lv_modules_15_0= ruleModule )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:332:3: lv_modules_15_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getModulesModuleParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModule_in_ruleSolution543);
            	    lv_modules_15_0=ruleModule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modules",
            	              		lv_modules_15_0, 
            	              		"Module");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:348:3: (otherlv_16= 'contact-info' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_24= '}' )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==17) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:348:5: otherlv_16= 'contact-info' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_24= '}'
                    {
                    otherlv_16=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSolution557); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getSolutionAccess().getContactInfoKeyword_13_0());
                          
                    }
                    otherlv_17=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSolution569); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getSolutionAccess().getLeftCurlyBracketKeyword_13_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:356:1: (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==18) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:356:3: otherlv_18= 'owner' ( ( ruleQualifiedName ) )
                            {
                            otherlv_18=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleSolution582); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_18, grammarAccess.getSolutionAccess().getOwnerKeyword_13_2_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:360:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:361:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:361:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:362:3: ruleQualifiedName
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
                               
                              	        newCompositeNode(grammarAccess.getSolutionAccess().getOwnerUserCrossReference_13_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution609);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:378:4: (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==19) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:378:6: otherlv_20= 'responsible' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_20=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleSolution624); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_20, grammarAccess.getSolutionAccess().getResponsibleKeyword_13_3_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:382:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:383:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:383:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:384:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getSolutionAccess().getResponsibleUserCrossReference_13_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution651);
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

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:400:4: (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==20) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:400:6: otherlv_22= 'budgeting' ( ( ruleQualifiedName ) )
                            {
                            otherlv_22=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleSolution666); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_22, grammarAccess.getSolutionAccess().getBudgetingKeyword_13_4_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:404:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:405:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:405:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:406:3: ruleQualifiedName
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
                               
                              	        newCompositeNode(grammarAccess.getSolutionAccess().getBudgetingUserCrossReference_13_4_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution693);
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

                    otherlv_24=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSolution707); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_13_5());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:426:3: (otherlv_25= 'tags' ( ( ruleQualifiedName ) )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==22) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:426:5: otherlv_25= 'tags' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_25=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSolution722); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getSolutionAccess().getTagsKeyword_14_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:430:1: ( ( ruleQualifiedName ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:431:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:431:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:432:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getSolutionAccess().getTagsTagCrossReference_14_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution749);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:448:5: (otherlv_27= 'subscriptions' otherlv_28= '{' ( ( ruleQualifiedName ) )* otherlv_30= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:448:7: otherlv_27= 'subscriptions' otherlv_28= '{' ( ( ruleQualifiedName ) )* otherlv_30= '}'
                    {
                    otherlv_27=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSolution765); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getSolutionAccess().getSubscriptionsKeyword_15_0());
                          
                    }
                    otherlv_28=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSolution777); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getSolutionAccess().getLeftCurlyBracketKeyword_15_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:456:1: ( ( ruleQualifiedName ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:457:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:457:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:458:3: ruleQualifiedName
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
                    	       
                    	      	        newCompositeNode(grammarAccess.getSolutionAccess().getSubscriptionsUserCrossReference_15_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution804);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_30=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSolution817); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_15_3());
                          
                    }

                    }
                    break;

            }

            otherlv_31=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSolution831); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_31, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_16());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:490:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:491:2: (iv_ruleModule= ruleModule EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:492:2: iv_ruleModule= ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModule_in_entryRuleModule867);
            iv_ruleModule=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModule; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModule877); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:499:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contact-info' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_21= '}' )? (otherlv_22= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? otherlv_28= '}' ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_22=null;
        Token otherlv_24=null;
        Token otherlv_25=null;
        Token otherlv_27=null;
        Token otherlv_28=null;
        Enumerator lv_kind_4_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_additionalInfo_6_0 = null;

        EObject lv_requires_8_0 = null;

        EObject lv_features_11_0 = null;

        EObject lv_modules_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:502:28: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contact-info' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_21= '}' )? (otherlv_22= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? otherlv_28= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:503:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contact-info' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_21= '}' )? (otherlv_22= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? otherlv_28= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:503:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contact-info' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_21= '}' )? (otherlv_22= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? otherlv_28= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:503:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contact-info' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_21= '}' )? (otherlv_22= 'tags' ( ( ruleQualifiedName ) )* )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? otherlv_28= '}'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleModule914); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:507:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:508:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:508:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:509:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModule931); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule948); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleModule960); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getKindKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:533:1: ( (lv_kind_4_0= ruleModuleKind ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:534:1: (lv_kind_4_0= ruleModuleKind )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:534:1: (lv_kind_4_0= ruleModuleKind )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:535:3: lv_kind_4_0= ruleModuleKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleAccess().getKindModuleKindEnumRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleKind_in_ruleModule981);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:551:2: ( (lv_version_5_0= ruleVersion ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:552:1: (lv_version_5_0= ruleVersion )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:552:1: (lv_version_5_0= ruleVersion )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:553:3: lv_version_5_0= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getVersionVersionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersion_in_ruleModule1002);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:569:3: ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==46) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:570:1: (lv_additionalInfo_6_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:570:1: (lv_additionalInfo_6_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:571:3: lv_additionalInfo_6_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getAdditionalInfoAdditionalInformationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleModule1024);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:587:3: (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==15) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:587:5: otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModule1038); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getModuleAccess().getRequiresKeyword_7_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:591:1: ( (lv_requires_8_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:592:1: (lv_requires_8_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:592:1: (lv_requires_8_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:593:3: lv_requires_8_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getRequiresServiceRefParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleModule1059);
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
            	    break loop20;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:609:4: (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==16) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:609:6: otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModule1074); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getRequiresChannelKeyword_8_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:613:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:614:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:614:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:615:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getModuleRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getRequiresChannelChannelCrossReference_8_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1101);
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

            	default :
            	    break loop21;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:631:4: ( (lv_features_11_0= ruleFeature ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=26 && LA22_0<=27)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:632:1: (lv_features_11_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:632:1: (lv_features_11_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:633:3: lv_features_11_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getFeaturesFeatureParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleModule1124);
            	    lv_features_11_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_11_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:649:3: ( (lv_modules_12_0= ruleModule ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:650:1: (lv_modules_12_0= ruleModule )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:650:1: (lv_modules_12_0= ruleModule )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:651:3: lv_modules_12_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getModulesModuleParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModule_in_ruleModule1146);
            	    lv_modules_12_0=ruleModule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modules",
            	              		lv_modules_12_0, 
            	              		"Module");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:667:3: (otherlv_13= 'contact-info' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_21= '}' )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==17) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:667:5: otherlv_13= 'contact-info' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_21= '}'
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModule1160); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getModuleAccess().getContactInfoKeyword_11_0());
                          
                    }
                    otherlv_14=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule1172); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:675:1: (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==18) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:675:3: otherlv_15= 'owner' ( ( ruleQualifiedName ) )
                            {
                            otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModule1185); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_15, grammarAccess.getModuleAccess().getOwnerKeyword_11_2_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:679:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:680:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:680:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:681:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getModuleRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getModuleAccess().getOwnerUserCrossReference_11_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1212);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:697:4: (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==19) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:697:6: otherlv_17= 'responsible' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModule1227); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_17, grammarAccess.getModuleAccess().getResponsibleKeyword_11_3_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:701:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:702:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:702:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:703:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModuleRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleAccess().getResponsibleUserCrossReference_11_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1254);
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

                    	default :
                    	    break loop25;
                        }
                    } while (true);

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:719:4: (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==20) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:719:6: otherlv_19= 'budgeting' ( ( ruleQualifiedName ) )
                            {
                            otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModule1269); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_19, grammarAccess.getModuleAccess().getBudgetingKeyword_11_4_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:723:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:724:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:724:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:725:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getModuleRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getModuleAccess().getBudgetingUserCrossReference_11_4_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1296);
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

                    otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModule1310); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_21, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_11_5());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:745:3: (otherlv_22= 'tags' ( ( ruleQualifiedName ) )* )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==22) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:745:5: otherlv_22= 'tags' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_22=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleModule1325); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_22, grammarAccess.getModuleAccess().getTagsKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:749:1: ( ( ruleQualifiedName ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==RULE_ID) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:750:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:750:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:751:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModuleRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleAccess().getTagsTagCrossReference_12_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1352);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:767:5: (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==23) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:767:7: otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}'
                    {
                    otherlv_24=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModule1368); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_24, grammarAccess.getModuleAccess().getSubscriptionsKeyword_13_0());
                          
                    }
                    otherlv_25=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule1380); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_13_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:775:1: ( ( ruleQualifiedName ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:776:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:776:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:777:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModuleRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleAccess().getSubscriptionsUserCrossReference_13_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1407);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_27=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModule1420); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_27, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_13_3());
                          
                    }

                    }
                    break;

            }

            otherlv_28=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModule1434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_28, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_14());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:809:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:810:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:811:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature1470);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature1480); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:818:1: ruleFeature returns [EObject current=null] : ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contact-info' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_25= '}' )? (otherlv_26= 'tags' ( ( ruleQualifiedName ) )* )? ( (lv_features_28_0= ruleFeature ) )* (otherlv_29= 'subscriptions' otherlv_30= '{' ( ( ruleQualifiedName ) )* otherlv_32= '}' )? otherlv_33= '}' ) ;
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
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        Token otherlv_23=null;
        Token otherlv_25=null;
        Token otherlv_26=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        Token otherlv_33=null;
        EObject lv_additionalInfo_8_0 = null;

        EObject lv_usesCapabilities_11_0 = null;

        EObject lv_requires_14_0 = null;

        EObject lv_features_28_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:821:28: ( ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contact-info' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_25= '}' )? (otherlv_26= 'tags' ( ( ruleQualifiedName ) )* )? ( (lv_features_28_0= ruleFeature ) )* (otherlv_29= 'subscriptions' otherlv_30= '{' ( ( ruleQualifiedName ) )* otherlv_32= '}' )? otherlv_33= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:822:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contact-info' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_25= '}' )? (otherlv_26= 'tags' ( ( ruleQualifiedName ) )* )? ( (lv_features_28_0= ruleFeature ) )* (otherlv_29= 'subscriptions' otherlv_30= '{' ( ( ruleQualifiedName ) )* otherlv_32= '}' )? otherlv_33= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:822:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contact-info' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_25= '}' )? (otherlv_26= 'tags' ( ( ruleQualifiedName ) )* )? ( (lv_features_28_0= ruleFeature ) )* (otherlv_29= 'subscriptions' otherlv_30= '{' ( ( ruleQualifiedName ) )* otherlv_32= '}' )? otherlv_33= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:822:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contact-info' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_25= '}' )? (otherlv_26= 'tags' ( ( ruleQualifiedName ) )* )? ( (lv_features_28_0= ruleFeature ) )* (otherlv_29= 'subscriptions' otherlv_30= '{' ( ( ruleQualifiedName ) )* otherlv_32= '}' )? otherlv_33= '}'
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:822:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==26) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:823:1: (lv_nonFunctional_0_0= 'non-functional' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:823:1: (lv_nonFunctional_0_0= 'non-functional' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:824:3: lv_nonFunctional_0_0= 'non-functional'
                    {
                    lv_nonFunctional_0_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleFeature1523); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleFeature1549); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureAccess().getFeatureKeyword_1());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:841:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:842:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:842:1: (lv_name_2_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:843:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFeature1566); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:863:1: (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==28) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:863:3: otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+
                    {
                    otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleFeature1596); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFeatureAccess().getUseCasesKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:867:1: ( (lv_useCase_5_0= RULE_STRING ) )+
                    int cnt33=0;
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==RULE_STRING) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:868:1: (lv_useCase_5_0= RULE_STRING )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:868:1: (lv_useCase_5_0= RULE_STRING )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:869:3: lv_useCase_5_0= RULE_STRING
                    	    {
                    	    lv_useCase_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature1613); if (state.failed) return current;
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
                    	    if ( cnt33 >= 1 ) break loop33;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(33, input);
                                throw eee;
                        }
                        cnt33++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:885:5: (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==29) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:885:7: otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleFeature1634); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFeatureAccess().getDescriptionKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:889:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:890:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:890:1: (lv_description_7_0= RULE_STRING )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:891:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature1651); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:907:4: ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==46) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:908:1: (lv_additionalInfo_8_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:908:1: (lv_additionalInfo_8_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:909:3: lv_additionalInfo_8_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureAccess().getAdditionalInfoAdditionalInformationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleFeature1679);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:925:3: (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:925:5: otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleFeature1693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFeatureAccess().getUsesCapabilitiesKeyword_7_0());
                          
                    }
                    otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1705); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_7_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:933:1: ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+
                    int cnt37=0;
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==RULE_ID) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:934:1: (lv_usesCapabilities_11_0= ruleCapabilityRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:934:1: (lv_usesCapabilities_11_0= ruleCapabilityRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:935:3: lv_usesCapabilities_11_0= ruleCapabilityRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getUsesCapabilitiesCapabilityRefParserRuleCall_7_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_ruleFeature1726);
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
                    	    if ( cnt37 >= 1 ) break loop37;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(37, input);
                                throw eee;
                        }
                        cnt37++;
                    } while (true);

                    otherlv_12=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFeature1739); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_7_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:955:3: (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==15) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:955:5: otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) )
            	    {
            	    otherlv_13=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFeature1754); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_13, grammarAccess.getFeatureAccess().getRequiresKeyword_8_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:959:1: ( (lv_requires_14_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:960:1: (lv_requires_14_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:960:1: (lv_requires_14_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:961:3: lv_requires_14_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getRequiresServiceRefParserRuleCall_8_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleFeature1775);
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
            	    break loop39;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:977:4: (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==16) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:977:6: otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_15=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFeature1790); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_15, grammarAccess.getFeatureAccess().getRequiresChannelKeyword_9_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:981:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:982:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:982:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:983:3: ruleQualifiedName
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getFeatureRule());
            	      	        }
            	              
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getRequiresChannelChannelCrossReference_9_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1817);
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

            	default :
            	    break loop40;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:999:4: (otherlv_17= 'contact-info' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_25= '}' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==17) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:999:6: otherlv_17= 'contact-info' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? otherlv_25= '}'
                    {
                    otherlv_17=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFeature1832); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getFeatureAccess().getContactInfoKeyword_10_0());
                          
                    }
                    otherlv_18=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1844); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1007:1: (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==18) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1007:3: otherlv_19= 'owner' ( ( ruleQualifiedName ) )
                            {
                            otherlv_19=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFeature1857); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_19, grammarAccess.getFeatureAccess().getOwnerKeyword_10_2_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1011:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1012:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1012:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1013:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getFeatureRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getFeatureAccess().getOwnerUserCrossReference_10_2_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1884);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1029:4: (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==19) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1029:6: otherlv_21= 'responsible' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFeature1899); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_21, grammarAccess.getFeatureAccess().getResponsibleKeyword_10_3_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1033:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1034:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1034:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1035:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFeatureRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getResponsibleUserCrossReference_10_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1926);
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

                    	default :
                    	    break loop42;
                        }
                    } while (true);

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1051:4: (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==20) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1051:6: otherlv_23= 'budgeting' ( ( ruleQualifiedName ) )
                            {
                            otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFeature1941); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_23, grammarAccess.getFeatureAccess().getBudgetingKeyword_10_4_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1055:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1056:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1056:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1057:3: ruleQualifiedName
                            {
                            if ( state.backtracking==0 ) {
                               
                              		  /* */ 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              			if (current==null) {
                              	            current = createModelElement(grammarAccess.getFeatureRule());
                              	        }
                                      
                            }
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getFeatureAccess().getBudgetingUserCrossReference_10_4_1_0()); 
                              	    
                            }
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1968);
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

                    otherlv_25=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFeature1982); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_10_5());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1077:3: (otherlv_26= 'tags' ( ( ruleQualifiedName ) )* )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==22) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1077:5: otherlv_26= 'tags' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_26=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFeature1997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_26, grammarAccess.getFeatureAccess().getTagsKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1081:1: ( ( ruleQualifiedName ) )*
                    loop45:
                    do {
                        int alt45=2;
                        int LA45_0 = input.LA(1);

                        if ( (LA45_0==RULE_ID) ) {
                            alt45=1;
                        }


                        switch (alt45) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1082:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1082:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1083:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFeatureRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getTagsTagCrossReference_11_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature2024);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1099:5: ( (lv_features_28_0= ruleFeature ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( ((LA47_0>=26 && LA47_0<=27)) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1100:1: (lv_features_28_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1100:1: (lv_features_28_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1101:3: lv_features_28_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getFeaturesFeatureParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleFeature2048);
            	    lv_features_28_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_28_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1117:3: (otherlv_29= 'subscriptions' otherlv_30= '{' ( ( ruleQualifiedName ) )* otherlv_32= '}' )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==23) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1117:5: otherlv_29= 'subscriptions' otherlv_30= '{' ( ( ruleQualifiedName ) )* otherlv_32= '}'
                    {
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFeature2062); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getFeatureAccess().getSubscriptionsKeyword_13_0());
                          
                    }
                    otherlv_30=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature2074); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_30, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_13_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1125:1: ( ( ruleQualifiedName ) )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1126:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1126:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1127:3: ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFeatureRule());
                    	      	        }
                    	              
                    	    }
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getSubscriptionsUserCrossReference_13_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature2101);
                    	    ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    otherlv_32=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFeature2114); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_32, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_13_3());
                          
                    }

                    }
                    break;

            }

            otherlv_33=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFeature2128); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_33, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_14());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1159:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1160:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1161:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef2164);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef2174); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1168:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1171:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1172:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1172:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1172:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )?
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1172:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1173:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1173:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1174:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef2226);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1190:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1191:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1191:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1192:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef2247);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1208:2: ( (lv_isResponseHandler_2_0= 'handling responses' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==31) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1209:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1209:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1210:3: lv_isResponseHandler_2_0= 'handling responses'
                    {
                    lv_isResponseHandler_2_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleServiceRef2265); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1223:3: (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==32) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1223:5: otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )*
                    {
                    otherlv_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleServiceRef2292); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getServiceRefAccess().getCallingKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1227:1: ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1228:1: (lv_calledOperations_4_0= ruleSimpleOperationRef )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1228:1: (lv_calledOperations_4_0= ruleSimpleOperationRef )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1229:3: lv_calledOperations_4_0= ruleSimpleOperationRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceRefAccess().getCalledOperationsSimpleOperationRefParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2313);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1245:2: (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==33) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1245:4: otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) )
                    	    {
                    	    otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleServiceRef2326); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getServiceRefAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1249:1: ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1250:1: (lv_calledOperations_6_0= ruleSimpleOperationRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1250:1: (lv_calledOperations_6_0= ruleSimpleOperationRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1251:3: lv_calledOperations_6_0= ruleSimpleOperationRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceRefAccess().getCalledOperationsSimpleOperationRefParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2347);
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
                    	    break loop51;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1275:1: entryRuleSimpleOperationRef returns [EObject current=null] : iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF ;
    public final EObject entryRuleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleOperationRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1276:2: (iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1277:2: iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleOperationRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_entryRuleSimpleOperationRef2387);
            iv_ruleSimpleOperationRef=ruleSimpleOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleOperationRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleOperationRef2397); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1284:1: ruleSimpleOperationRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1287:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1288:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1288:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1289:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1289:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1290:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSimpleOperationRef2448);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1314:1: entryRuleCapabilityRef returns [EObject current=null] : iv_ruleCapabilityRef= ruleCapabilityRef EOF ;
    public final EObject entryRuleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapabilityRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1315:2: (iv_ruleCapabilityRef= ruleCapabilityRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1316:2: iv_ruleCapabilityRef= ruleCapabilityRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapabilityRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef2483);
            iv_ruleCapabilityRef=ruleCapabilityRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapabilityRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapabilityRef2493); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1323:1: ruleCapabilityRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1326:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1327:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1327:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1327:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1327:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1328:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1328:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1329:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleCapabilityRef2545);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1345:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1346:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1346:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1347:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCapabilityRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleCapabilityRef2566);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1371:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1372:2: (iv_ruleVersion= ruleVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1373:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersion_in_entryRuleVersion2602);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersion2612); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1380:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1383:28: ( (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1384:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1384:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1384:3: otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleVersion2649); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1388:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1389:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1389:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1390:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleVersion2670);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1414:1: entryRuleProductVersion returns [EObject current=null] : iv_ruleProductVersion= ruleProductVersion EOF ;
    public final EObject entryRuleProductVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1415:2: (iv_ruleProductVersion= ruleProductVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1416:2: iv_ruleProductVersion= ruleProductVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProductVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProductVersion_in_entryRuleProductVersion2706);
            iv_ruleProductVersion=ruleProductVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProductVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProductVersion2716); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1423:1: ruleProductVersion returns [EObject current=null] : (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleProductVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1426:28: ( (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1427:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1427:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1427:3: otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleProductVersion2753); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProductVersionAccess().getProductVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1431:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1432:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1432:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1433:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProductVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleProductVersion2774);
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


    // $ANTLR start "entryRuleImport"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1459:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1460:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1461:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport2812);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport2822); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1468:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1471:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1472:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1472:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1472:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleImport2859); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1476:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1477:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1477:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1478:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport2880);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1502:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1503:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1504:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId2917);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId2928); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1511:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1514:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1515:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1515:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1515:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId2968); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1522:1: (kw= '.' this_INT_2= RULE_INT )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==37) ) {
                    int LA53_1 = input.LA(2);

                    if ( (LA53_1==RULE_INT) ) {
                        alt53=1;
                    }


                }


                switch (alt53) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1523:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleVersionId2987); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId3002); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1535:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=37 && LA55_0<=38)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1535:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1535:4: (kw= '.' | kw= '-' )
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==37) ) {
            	        alt54=1;
            	    }
            	    else if ( (LA54_0==38) ) {
            	        alt54=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 54, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1536:2: kw= '.'
            	            {
            	            kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleVersionId3024); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1543:2: kw= '-'
            	            {
            	            kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleVersionId3043); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId3059); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_5);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_5, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop55;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1565:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1566:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1567:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef3108);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef3118); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1574:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1577:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1578:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1578:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt56=5;
            switch ( input.LA(1) ) {
            case 39:
                {
                int LA56_1 = input.LA(2);

                if ( (LA56_1==41) ) {
                    alt56=3;
                }
                else if ( (LA56_1==RULE_INT) ) {
                    alt56=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 56, 1, input);

                    throw nvae;
                }
                }
                break;
            case 40:
                {
                alt56=2;
                }
                break;
            case 43:
                {
                alt56=4;
                }
                break;
            case 44:
                {
                alt56=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1579:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef3168);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1592:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef3198);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1605:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef3228);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1618:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef3258);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1631:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef3288);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1650:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1651:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1652:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef3323);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef3333); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1659:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1662:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1663:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1663:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1663:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleMinVersionRef3370); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1667:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1668:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1668:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1669:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef3391);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1693:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1694:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1695:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef3427);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef3437); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1702:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1705:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1706:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1706:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1706:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleMaxVersionRef3474); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1710:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1711:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1711:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1712:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef3495);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1736:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1737:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1738:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef3531);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef3541); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1745:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1748:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1749:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1749:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1749:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1749:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1749:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLowerBoundRangeVersionRef3579); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLowerBoundRangeVersionRef3591); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1757:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1758:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1758:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1759:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3613);
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

            otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleLowerBoundRangeVersionRef3625); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1779:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1779:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleLowerBoundRangeVersionRef3638); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLowerBoundRangeVersionRef3650); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1787:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1788:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1788:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1789:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3672);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1813:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1814:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1815:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef3708);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef3718); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1822:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1825:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1826:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1826:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1826:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleMajorVersionRef3755); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1830:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1831:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1831:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1832:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef3772); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1856:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1857:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1858:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef3813);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef3823); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1865:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1868:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1869:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1869:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1869:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleFixedVersionRef3860); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1873:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1874:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1874:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1875:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef3881);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1899:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1900:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1901:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard3918);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard3929); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1908:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1911:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1912:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1912:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1913:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3976);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1923:1: (kw= '.*' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==45) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1924:2: kw= '.*'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleQualifiedNameWithWildCard3995); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1937:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1938:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1939:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4038);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName4049); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1946:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1949:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1950:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1950:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1950:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName4089); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1957:1: (kw= '.' this_ID_2= RULE_ID )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==37) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1958:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleQualifiedName4108); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName4123); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop58;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1982:1: entryRuleAdditionalInformation returns [EObject current=null] : iv_ruleAdditionalInformation= ruleAdditionalInformation EOF ;
    public final EObject entryRuleAdditionalInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionalInformation = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1983:2: (iv_ruleAdditionalInformation= ruleAdditionalInformation EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1984:2: iv_ruleAdditionalInformation= ruleAdditionalInformation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionalInformationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_entryRuleAdditionalInformation4174);
            iv_ruleAdditionalInformation=ruleAdditionalInformation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditionalInformation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdditionalInformation4184); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1991:1: ruleAdditionalInformation returns [EObject current=null] : (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' ) ;
    public final EObject ruleAdditionalInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_infoItems_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1994:28: ( (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1995:1: (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1995:1: (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1995:3: otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleAdditionalInformation4221); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdditionalInformationAccess().getAdditionalInformationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAdditionalInformation4233); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdditionalInformationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2003:1: ( (lv_infoItems_2_0= ruleInfoItem ) )+
            int cnt59=0;
            loop59:
            do {
                int alt59=2;
                int LA59_0 = input.LA(1);

                if ( (LA59_0==47) ) {
                    alt59=1;
                }


                switch (alt59) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2004:1: (lv_infoItems_2_0= ruleInfoItem )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2004:1: (lv_infoItems_2_0= ruleInfoItem )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2005:3: lv_infoItems_2_0= ruleInfoItem
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionalInformationAccess().getInfoItemsInfoItemParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_ruleAdditionalInformation4254);
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
            	    if ( cnt59 >= 1 ) break loop59;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(59, input);
                        throw eee;
                }
                cnt59++;
            } while (true);

            otherlv_3=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleAdditionalInformation4267); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2033:1: entryRuleInfoItem returns [EObject current=null] : iv_ruleInfoItem= ruleInfoItem EOF ;
    public final EObject entryRuleInfoItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfoItem = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2034:2: (iv_ruleInfoItem= ruleInfoItem EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2035:2: iv_ruleInfoItem= ruleInfoItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfoItemRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_entryRuleInfoItem4303);
            iv_ruleInfoItem=ruleInfoItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfoItem; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfoItem4313); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2042:1: ruleInfoItem returns [EObject current=null] : (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleInfoItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_documentLocation_1_0=null;
        Token otherlv_2=null;
        Token lv_reference_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2045:28: ( (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2046:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2046:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2046:3: otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleInfoItem4350); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInfoItemAccess().getLocationKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2050:1: ( (lv_documentLocation_1_0= RULE_STRING ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2051:1: (lv_documentLocation_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2051:1: (lv_documentLocation_1_0= RULE_STRING )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2052:3: lv_documentLocation_1_0= RULE_STRING
            {
            lv_documentLocation_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem4367); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2068:2: (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==48) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2068:4: otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleInfoItem4385); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInfoItemAccess().getReferenceKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2072:1: ( (lv_reference_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2073:1: (lv_reference_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2073:1: (lv_reference_3_0= RULE_STRING )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2074:3: lv_reference_3_0= RULE_STRING
                    {
                    lv_reference_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem4402); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_reference_3_0, grammarAccess.getInfoItemAccess().getReferenceSTRINGTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getInfoItemRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"reference",
                              		lv_reference_3_0, 
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


    // $ANTLR start "entryRuleRoleRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2100:1: entryRuleRoleRef returns [EObject current=null] : iv_ruleRoleRef= ruleRoleRef EOF ;
    public final EObject entryRuleRoleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoleRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2101:2: (iv_ruleRoleRef= ruleRoleRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2102:2: iv_ruleRoleRef= ruleRoleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoleRef_in_entryRuleRoleRef4447);
            iv_ruleRoleRef=ruleRoleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoleRef4457); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRoleRef"


    // $ANTLR start "ruleRoleRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2109:1: ruleRoleRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleRoleRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2112:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2113:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2113:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2114:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2114:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2115:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getRoleRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRoleRefAccess().getRoleRoleCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleRoleRef4508);
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
    // $ANTLR end "ruleRoleRef"


    // $ANTLR start "entryRulePrivilegeRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2141:1: entryRulePrivilegeRef returns [EObject current=null] : iv_rulePrivilegeRef= rulePrivilegeRef EOF ;
    public final EObject entryRulePrivilegeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivilegeRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2142:2: (iv_rulePrivilegeRef= rulePrivilegeRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2143:2: iv_rulePrivilegeRef= rulePrivilegeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivilegeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef4545);
            iv_rulePrivilegeRef=rulePrivilegeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivilegeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrivilegeRef4555); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrivilegeRef"


    // $ANTLR start "rulePrivilegeRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2150:1: rulePrivilegeRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject rulePrivilegeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2153:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2154:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2154:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2155:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2155:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2156:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getPrivilegeRefRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getPrivilegeRefAccess().getPrivilegePrivilegeCrossReference_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rulePrivilegeRef4606);
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
    // $ANTLR end "rulePrivilegeRef"


    // $ANTLR start "ruleModuleKind"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2184:1: ruleModuleKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2186:28: ( ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
            int alt61=6;
            switch ( input.LA(1) ) {
            case 49:
                {
                alt61=1;
                }
                break;
            case 50:
                {
                alt61=2;
                }
                break;
            case 51:
                {
                alt61=3;
                }
                break;
            case 52:
                {
                alt61=4;
                }
                break;
            case 53:
                {
                alt61=5;
                }
                break;
            case 54:
                {
                alt61=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:2: (enumLiteral_0= 'UI' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:2: (enumLiteral_0= 'UI' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:4: enumLiteral_0= 'UI'
                    {
                    enumLiteral_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModuleKind4659); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2193:6: (enumLiteral_1= 'BusinessLogic' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2193:6: (enumLiteral_1= 'BusinessLogic' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2193:8: enumLiteral_1= 'BusinessLogic'
                    {
                    enumLiteral_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleModuleKind4676); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2199:6: (enumLiteral_2= 'Persistence' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2199:6: (enumLiteral_2= 'Persistence' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2199:8: enumLiteral_2= 'Persistence'
                    {
                    enumLiteral_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleModuleKind4693); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2205:6: (enumLiteral_3= 'Security' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2205:6: (enumLiteral_3= 'Security' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2205:8: enumLiteral_3= 'Security'
                    {
                    enumLiteral_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleModuleKind4710); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2211:6: (enumLiteral_4= 'Batch' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2211:6: (enumLiteral_4= 'Batch' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2211:8: enumLiteral_4= 'Batch'
                    {
                    enumLiteral_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleModuleKind4727); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2217:6: (enumLiteral_5= 'OTHER' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2217:6: (enumLiteral_5= 'OTHER' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2217:8: enumLiteral_5= 'OTHER'
                    {
                    enumLiteral_5=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleModuleKind4744); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2227:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2229:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            int alt62=4;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt62=1;
                }
                break;
            case 56:
                {
                alt62=2;
                }
                break;
            case 57:
                {
                alt62=3;
                }
                break;
            case 58:
                {
                alt62=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }

            switch (alt62) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleGovernanceDecisionResult4789); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2236:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2236:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2236:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleGovernanceDecisionResult4806); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2242:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2242:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2242:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleGovernanceDecisionResult4823); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2248:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2248:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2248:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleGovernanceDecisionResult4840); if (state.failed) return current;
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
        public static final BitSet FOLLOW_ruleImport_in_ruleModel137 = new BitSet(new long[]{0x0000001000000802L});
        public static final BitSet FOLLOW_ruleSolution_in_ruleModel159 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleSolution_in_entryRuleSolution196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSolution206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSolution243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution264 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSolution276 = new BitSet(new long[]{0x0000000400002000L});
        public static final BitSet FOLLOW_13_in_ruleSolution289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution316 = new BitSet(new long[]{0x0000000400002000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleSolution339 = new BitSet(new long[]{0x0000000000004000L});
        public static final BitSet FOLLOW_14_in_ruleSolution351 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution378 = new BitSet(new long[]{0x000040080DE38000L});
        public static final BitSet FOLLOW_ruleProductVersion_in_ruleSolution399 = new BitSet(new long[]{0x000040000DE38000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleSolution421 = new BitSet(new long[]{0x000000000DE38000L});
        public static final BitSet FOLLOW_15_in_ruleSolution435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleSolution456 = new BitSet(new long[]{0x000000000DE38000L});
        public static final BitSet FOLLOW_16_in_ruleSolution471 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution498 = new BitSet(new long[]{0x000000000DE30000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleSolution521 = new BitSet(new long[]{0x000000000DE20000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleSolution543 = new BitSet(new long[]{0x0000000001E20000L});
        public static final BitSet FOLLOW_17_in_ruleSolution557 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSolution569 = new BitSet(new long[]{0x00000000003C0000L});
        public static final BitSet FOLLOW_18_in_ruleSolution582 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution609 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_19_in_ruleSolution624 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution651 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_20_in_ruleSolution666 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution693 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSolution707 = new BitSet(new long[]{0x0000000000E00000L});
        public static final BitSet FOLLOW_22_in_ruleSolution722 = new BitSet(new long[]{0x0000000000A00010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution749 = new BitSet(new long[]{0x0000000000A00010L});
        public static final BitSet FOLLOW_23_in_ruleSolution765 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSolution777 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution804 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleSolution817 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleSolution831 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModule_in_entryRuleModule867 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModule877 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleModule914 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModule931 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule948 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleModule960 = new BitSet(new long[]{0x007E000000000000L});
        public static final BitSet FOLLOW_ruleModuleKind_in_ruleModule981 = new BitSet(new long[]{0x000040040DE3A000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleModule1002 = new BitSet(new long[]{0x000040000DE38000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleModule1024 = new BitSet(new long[]{0x000000000DE38000L});
        public static final BitSet FOLLOW_15_in_ruleModule1038 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleModule1059 = new BitSet(new long[]{0x000000000DE38000L});
        public static final BitSet FOLLOW_16_in_ruleModule1074 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1101 = new BitSet(new long[]{0x000000000DE30000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleModule1124 = new BitSet(new long[]{0x000000000DE20000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleModule1146 = new BitSet(new long[]{0x0000000001E20000L});
        public static final BitSet FOLLOW_17_in_ruleModule1160 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule1172 = new BitSet(new long[]{0x00000000003C0000L});
        public static final BitSet FOLLOW_18_in_ruleModule1185 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1212 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_19_in_ruleModule1227 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1254 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_20_in_ruleModule1269 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1296 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleModule1310 = new BitSet(new long[]{0x0000000000E00000L});
        public static final BitSet FOLLOW_22_in_ruleModule1325 = new BitSet(new long[]{0x0000000000A00010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1352 = new BitSet(new long[]{0x0000000000A00010L});
        public static final BitSet FOLLOW_23_in_ruleModule1368 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule1380 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1407 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleModule1420 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleModule1434 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1470 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature1480 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleFeature1523 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleFeature1549 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFeature1566 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1583 = new BitSet(new long[]{0x000040007CE38000L});
        public static final BitSet FOLLOW_28_in_ruleFeature1596 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature1613 = new BitSet(new long[]{0x000040006CE38020L});
        public static final BitSet FOLLOW_29_in_ruleFeature1634 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature1651 = new BitSet(new long[]{0x000040004CE38000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleFeature1679 = new BitSet(new long[]{0x000000004CE38000L});
        public static final BitSet FOLLOW_30_in_ruleFeature1693 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1705 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_ruleFeature1726 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleFeature1739 = new BitSet(new long[]{0x000000000CE38000L});
        public static final BitSet FOLLOW_15_in_ruleFeature1754 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleFeature1775 = new BitSet(new long[]{0x000000000CE38000L});
        public static final BitSet FOLLOW_16_in_ruleFeature1790 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1817 = new BitSet(new long[]{0x000000000CE30000L});
        public static final BitSet FOLLOW_17_in_ruleFeature1832 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1844 = new BitSet(new long[]{0x00000000003C0000L});
        public static final BitSet FOLLOW_18_in_ruleFeature1857 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1884 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_19_in_ruleFeature1899 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1926 = new BitSet(new long[]{0x0000000000380000L});
        public static final BitSet FOLLOW_20_in_ruleFeature1941 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1968 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleFeature1982 = new BitSet(new long[]{0x000000000CE00000L});
        public static final BitSet FOLLOW_22_in_ruleFeature1997 = new BitSet(new long[]{0x000000000CA00010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature2024 = new BitSet(new long[]{0x000000000CA00010L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleFeature2048 = new BitSet(new long[]{0x000000000CA00000L});
        public static final BitSet FOLLOW_23_in_ruleFeature2062 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature2074 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature2101 = new BitSet(new long[]{0x0000000000200010L});
        public static final BitSet FOLLOW_21_in_ruleFeature2114 = new BitSet(new long[]{0x0000000000200000L});
        public static final BitSet FOLLOW_21_in_ruleFeature2128 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef2164 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef2174 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef2226 = new BitSet(new long[]{0x0000198000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef2247 = new BitSet(new long[]{0x0000000180000002L});
        public static final BitSet FOLLOW_31_in_ruleServiceRef2265 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleServiceRef2292 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2313 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleServiceRef2326 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2347 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_entryRuleSimpleOperationRef2387 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleOperationRef2397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleOperationRef2448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef2483 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapabilityRef2493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCapabilityRef2545 = new BitSet(new long[]{0x0000198000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleCapabilityRef2566 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion2602 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersion2612 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleVersion2649 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleVersion2670 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductVersion_in_entryRuleProductVersion2706 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProductVersion2716 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleProductVersion2753 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleProductVersion2774 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport2812 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport2822 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleImport2859 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport2880 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId2917 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId2928 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId2968 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_37_in_ruleVersionId2987 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId3002 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_37_in_ruleVersionId3024 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_38_in_ruleVersionId3043 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId3059 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef3108 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef3118 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef3168 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef3198 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef3228 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef3258 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef3288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef3323 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef3333 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleMinVersionRef3370 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef3391 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef3427 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef3437 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleMaxVersionRef3474 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef3495 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef3531 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef3541 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleLowerBoundRangeVersionRef3579 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleLowerBoundRangeVersionRef3591 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3613 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleLowerBoundRangeVersionRef3625 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleLowerBoundRangeVersionRef3638 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleLowerBoundRangeVersionRef3650 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3672 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef3708 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef3718 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleMajorVersionRef3755 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef3772 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef3813 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef3823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleFixedVersionRef3860 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef3881 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard3918 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard3929 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3976 = new BitSet(new long[]{0x0000200000000002L});
        public static final BitSet FOLLOW_45_in_ruleQualifiedNameWithWildCard3995 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4038 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName4049 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4089 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_37_in_ruleQualifiedName4108 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4123 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_entryRuleAdditionalInformation4174 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdditionalInformation4184 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleAdditionalInformation4221 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAdditionalInformation4233 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_ruleInfoItem_in_ruleAdditionalInformation4254 = new BitSet(new long[]{0x0000800000200000L});
        public static final BitSet FOLLOW_21_in_ruleAdditionalInformation4267 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfoItem_in_entryRuleInfoItem4303 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfoItem4313 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleInfoItem4350 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem4367 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleInfoItem4385 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem4402 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoleRef_in_entryRuleRoleRef4447 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoleRef4457 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRoleRef4508 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef4545 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrivilegeRef4555 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rulePrivilegeRef4606 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleModuleKind4659 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleModuleKind4676 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleModuleKind4693 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleModuleKind4710 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleModuleKind4727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleModuleKind4744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleGovernanceDecisionResult4789 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleGovernanceDecisionResult4806 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleGovernanceDecisionResult4823 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleGovernanceDecisionResult4840 = new BitSet(new long[]{0x0000000000000002L});
    }


}