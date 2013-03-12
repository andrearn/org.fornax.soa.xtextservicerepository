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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'solution'", "'{'", "'domain'", "'lifecycle-state'", "'requires'", "'requires-channel'", "'contacts'", "'owner'", "'responsible'", "'budgeting'", "'subscriptions'", "'}'", "'tags'", "'module'", "'kind'", "'non-functional'", "'feature'", "'use-cases'", "'description'", "'uses-capabilities'", "'handling responses'", "'calling'", "','", "'version'", "'product-version'", "'import'", "'.'", "'-'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'additional-information'", "'location'", "'reference'", "'UI'", "'BusinessLogic'", "'Persistence'", "'Security'", "'Batch'", "'OTHER'", "'pending'", "'accepted'", "'denied'", "'specific'"
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:140:1: ruleSolution returns [EObject current=null] : (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contacts' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? )? (otherlv_28= 'tags' ( (otherlv_29= RULE_ID ) )+ )? otherlv_30= '}' ) ;
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
        Token otherlv_29=null;
        Token otherlv_30=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_productVersion_8_0 = null;

        EObject lv_additionalInfo_9_0 = null;

        EObject lv_requires_11_0 = null;

        EObject lv_features_14_0 = null;

        EObject lv_modules_15_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:143:28: ( (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contacts' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? )? (otherlv_28= 'tags' ( (otherlv_29= RULE_ID ) )+ )? otherlv_30= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contacts' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? )? (otherlv_28= 'tags' ( (otherlv_29= RULE_ID ) )+ )? otherlv_30= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contacts' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? )? (otherlv_28= 'tags' ( (otherlv_29= RULE_ID ) )+ )? otherlv_30= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:3: otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) otherlv_6= 'lifecycle-state' ( ( ruleQualifiedName ) ) ( (lv_productVersion_8_0= ruleProductVersion ) )? ( (lv_additionalInfo_9_0= ruleAdditionalInformation ) )? (otherlv_10= 'requires' ( (lv_requires_11_0= ruleServiceRef ) ) )* (otherlv_12= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_14_0= ruleFeature ) )* ( (lv_modules_15_0= ruleModule ) )* (otherlv_16= 'contacts' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? )? (otherlv_28= 'tags' ( (otherlv_29= RULE_ID ) )+ )? otherlv_30= '}'
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:348:3: (otherlv_16= 'contacts' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )? )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==17) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:348:5: otherlv_16= 'contacts' otherlv_17= '{' (otherlv_18= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_20= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_22= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )?
                    {
                    otherlv_16=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleSolution557); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_16, grammarAccess.getSolutionAccess().getContactsKeyword_13_0());
                          
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:422:4: (otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}' )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==21) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:422:6: otherlv_24= 'subscriptions' otherlv_25= '{' ( ( ruleQualifiedName ) )* otherlv_27= '}'
                            {
                            otherlv_24=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleSolution708); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_24, grammarAccess.getSolutionAccess().getSubscriptionsKeyword_13_5_0());
                                  
                            }
                            otherlv_25=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleSolution720); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_25, grammarAccess.getSolutionAccess().getLeftCurlyBracketKeyword_13_5_1());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:430:1: ( ( ruleQualifiedName ) )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_ID) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
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
                            	       
                            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getSubscriptionsUserCrossReference_13_5_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSolution747);
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
                            	    break loop13;
                                }
                            } while (true);

                            otherlv_27=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSolution760); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_27, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_13_5_3());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:452:5: (otherlv_28= 'tags' ( (otherlv_29= RULE_ID ) )+ )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==23) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:452:7: otherlv_28= 'tags' ( (otherlv_29= RULE_ID ) )+
                    {
                    otherlv_28=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleSolution777); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_28, grammarAccess.getSolutionAccess().getTagsKeyword_14_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:456:1: ( (otherlv_29= RULE_ID ) )+
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
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:457:1: (otherlv_29= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:457:1: (otherlv_29= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:458:3: otherlv_29= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getSolutionRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_29=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSolution801); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_29, grammarAccess.getSolutionAccess().getTagsTagCrossReference_14_1_0()); 
                    	      	
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

            otherlv_30=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleSolution816); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_30, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_15());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:484:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:485:2: (iv_ruleModule= ruleModule EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:486:2: iv_ruleModule= ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModule_in_entryRuleModule852);
            iv_ruleModule=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModule; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModule862); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:493:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contacts' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )? )? (otherlv_25= 'tags' ( (otherlv_26= RULE_ID ) )+ )? otherlv_27= '}' ) ;
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
        Token otherlv_26=null;
        Token otherlv_27=null;
        Enumerator lv_kind_4_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_additionalInfo_6_0 = null;

        EObject lv_requires_8_0 = null;

        EObject lv_features_11_0 = null;

        EObject lv_modules_12_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:496:28: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contacts' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )? )? (otherlv_25= 'tags' ( (otherlv_26= RULE_ID ) )+ )? otherlv_27= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:497:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contacts' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )? )? (otherlv_25= 'tags' ( (otherlv_26= RULE_ID ) )+ )? otherlv_27= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:497:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contacts' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )? )? (otherlv_25= 'tags' ( (otherlv_26= RULE_ID ) )+ )? otherlv_27= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:497:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )* ( (lv_features_11_0= ruleFeature ) )* ( (lv_modules_12_0= ruleModule ) )* (otherlv_13= 'contacts' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )? )? (otherlv_25= 'tags' ( (otherlv_26= RULE_ID ) )+ )? otherlv_27= '}'
            {
            otherlv_0=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleModule899); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:501:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:502:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:502:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:503:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModule916); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule933); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleModule945); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getKindKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:527:1: ( (lv_kind_4_0= ruleModuleKind ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:528:1: (lv_kind_4_0= ruleModuleKind )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:528:1: (lv_kind_4_0= ruleModuleKind )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:529:3: lv_kind_4_0= ruleModuleKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleAccess().getKindModuleKindEnumRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleKind_in_ruleModule966);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:545:2: ( (lv_version_5_0= ruleVersion ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==34) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:546:1: (lv_version_5_0= ruleVersion )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:546:1: (lv_version_5_0= ruleVersion )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:547:3: lv_version_5_0= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getVersionVersionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersion_in_ruleModule987);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:563:3: ( (lv_additionalInfo_6_0= ruleAdditionalInformation ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==46) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:564:1: (lv_additionalInfo_6_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:564:1: (lv_additionalInfo_6_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:565:3: lv_additionalInfo_6_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getAdditionalInfoAdditionalInformationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleModule1009);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:581:3: (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==15) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:581:5: otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) )
            	    {
            	    otherlv_7=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModule1023); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getModuleAccess().getRequiresKeyword_7_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:585:1: ( (lv_requires_8_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:586:1: (lv_requires_8_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:586:1: (lv_requires_8_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:587:3: lv_requires_8_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getRequiresServiceRefParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleModule1044);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:603:4: (otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==16) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:603:6: otherlv_9= 'requires-channel' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_9=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModule1059); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getRequiresChannelKeyword_8_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:607:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:608:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:608:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:609:3: ruleQualifiedName
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
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1086);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:625:4: ( (lv_features_11_0= ruleFeature ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0>=26 && LA22_0<=27)) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:626:1: (lv_features_11_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:626:1: (lv_features_11_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:627:3: lv_features_11_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getFeaturesFeatureParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleModule1109);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:643:3: ( (lv_modules_12_0= ruleModule ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==24) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:644:1: (lv_modules_12_0= ruleModule )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:644:1: (lv_modules_12_0= ruleModule )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:645:3: lv_modules_12_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getModulesModuleParserRuleCall_10_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModule_in_ruleModule1131);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:661:3: (otherlv_13= 'contacts' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )? )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==17) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:661:5: otherlv_13= 'contacts' otherlv_14= '{' (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )?
                    {
                    otherlv_13=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModule1145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_13, grammarAccess.getModuleAccess().getContactsKeyword_11_0());
                          
                    }
                    otherlv_14=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule1157); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_11_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:669:1: (otherlv_15= 'owner' ( ( ruleQualifiedName ) ) )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==18) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:669:3: otherlv_15= 'owner' ( ( ruleQualifiedName ) )
                            {
                            otherlv_15=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModule1170); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_15, grammarAccess.getModuleAccess().getOwnerKeyword_11_2_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:673:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:674:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:674:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:675:3: ruleQualifiedName
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
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1197);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:691:4: (otherlv_17= 'responsible' ( ( ruleQualifiedName ) ) )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==19) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:691:6: otherlv_17= 'responsible' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_17=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleModule1212); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_17, grammarAccess.getModuleAccess().getResponsibleKeyword_11_3_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:695:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:696:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:696:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:697:3: ruleQualifiedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1239);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:713:4: (otherlv_19= 'budgeting' ( ( ruleQualifiedName ) ) )?
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==20) ) {
                        alt26=1;
                    }
                    switch (alt26) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:713:6: otherlv_19= 'budgeting' ( ( ruleQualifiedName ) )
                            {
                            otherlv_19=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleModule1254); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_19, grammarAccess.getModuleAccess().getBudgetingKeyword_11_4_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:717:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:718:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:718:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:719:3: ruleQualifiedName
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
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1281);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:735:4: (otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}' )?
                    int alt28=2;
                    int LA28_0 = input.LA(1);

                    if ( (LA28_0==21) ) {
                        alt28=1;
                    }
                    switch (alt28) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:735:6: otherlv_21= 'subscriptions' otherlv_22= '{' ( ( ruleQualifiedName ) )* otherlv_24= '}'
                            {
                            otherlv_21=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleModule1296); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_21, grammarAccess.getModuleAccess().getSubscriptionsKeyword_11_5_0());
                                  
                            }
                            otherlv_22=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule1308); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_22, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_11_5_1());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:743:1: ( ( ruleQualifiedName ) )*
                            loop27:
                            do {
                                int alt27=2;
                                int LA27_0 = input.LA(1);

                                if ( (LA27_0==RULE_ID) ) {
                                    alt27=1;
                                }


                                switch (alt27) {
                            	case 1 :
                            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:744:1: ( ruleQualifiedName )
                            	    {
                            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:744:1: ( ruleQualifiedName )
                            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:745:3: ruleQualifiedName
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
                            	       
                            	      	        newCompositeNode(grammarAccess.getModuleAccess().getSubscriptionsUserCrossReference_11_5_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleModule1335);
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
                            	    break loop27;
                                }
                            } while (true);

                            otherlv_24=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleModule1348); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_24, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_11_5_3());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:765:5: (otherlv_25= 'tags' ( (otherlv_26= RULE_ID ) )+ )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==23) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:765:7: otherlv_25= 'tags' ( (otherlv_26= RULE_ID ) )+
                    {
                    otherlv_25=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleModule1365); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_25, grammarAccess.getModuleAccess().getTagsKeyword_12_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:769:1: ( (otherlv_26= RULE_ID ) )+
                    int cnt30=0;
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==RULE_ID) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:770:1: (otherlv_26= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:770:1: (otherlv_26= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:771:3: otherlv_26= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModuleRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_26=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModule1389); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_26, grammarAccess.getModuleAccess().getTagsTagCrossReference_12_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt30 >= 1 ) break loop30;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(30, input);
                                throw eee;
                        }
                        cnt30++;
                    } while (true);


                    }
                    break;

            }

            otherlv_27=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleModule1404); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_27, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_13());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:797:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:798:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:799:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature1440);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature1450); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:806:1: ruleFeature returns [EObject current=null] : ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contacts' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )? )? (otherlv_29= 'tags' ( (otherlv_30= RULE_ID ) )+ )? ( (lv_features_31_0= ruleFeature ) )* otherlv_32= '}' ) ;
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
        Token otherlv_28=null;
        Token otherlv_29=null;
        Token otherlv_30=null;
        Token otherlv_32=null;
        EObject lv_additionalInfo_8_0 = null;

        EObject lv_usesCapabilities_11_0 = null;

        EObject lv_requires_14_0 = null;

        EObject lv_features_31_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:809:28: ( ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contacts' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )? )? (otherlv_29= 'tags' ( (otherlv_30= RULE_ID ) )+ )? ( (lv_features_31_0= ruleFeature ) )* otherlv_32= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:810:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contacts' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )? )? (otherlv_29= 'tags' ( (otherlv_30= RULE_ID ) )+ )? ( (lv_features_31_0= ruleFeature ) )* otherlv_32= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:810:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contacts' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )? )? (otherlv_29= 'tags' ( (otherlv_30= RULE_ID ) )+ )? ( (lv_features_31_0= ruleFeature ) )* otherlv_32= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:810:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )? (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )? (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )* (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )* (otherlv_17= 'contacts' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )? )? (otherlv_29= 'tags' ( (otherlv_30= RULE_ID ) )+ )? ( (lv_features_31_0= ruleFeature ) )* otherlv_32= '}'
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:810:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==26) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:811:1: (lv_nonFunctional_0_0= 'non-functional' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:811:1: (lv_nonFunctional_0_0= 'non-functional' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:812:3: lv_nonFunctional_0_0= 'non-functional'
                    {
                    lv_nonFunctional_0_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleFeature1493); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleFeature1519); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureAccess().getFeatureKeyword_1());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:829:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:830:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:830:1: (lv_name_2_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:831:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFeature1536); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1553); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:851:1: (otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==28) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:851:3: otherlv_4= 'use-cases' ( (lv_useCase_5_0= RULE_STRING ) )+
                    {
                    otherlv_4=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleFeature1566); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFeatureAccess().getUseCasesKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:855:1: ( (lv_useCase_5_0= RULE_STRING ) )+
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
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:856:1: (lv_useCase_5_0= RULE_STRING )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:856:1: (lv_useCase_5_0= RULE_STRING )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:857:3: lv_useCase_5_0= RULE_STRING
                    	    {
                    	    lv_useCase_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature1583); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:873:5: (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==29) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:873:7: otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleFeature1604); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFeatureAccess().getDescriptionKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:877:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:878:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:878:1: (lv_description_7_0= RULE_STRING )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:879:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature1621); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:895:4: ( (lv_additionalInfo_8_0= ruleAdditionalInformation ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==46) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:896:1: (lv_additionalInfo_8_0= ruleAdditionalInformation )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:896:1: (lv_additionalInfo_8_0= ruleAdditionalInformation )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:897:3: lv_additionalInfo_8_0= ruleAdditionalInformation
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureAccess().getAdditionalInfoAdditionalInformationParserRuleCall_6_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_ruleFeature1649);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:913:3: (otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==30) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:913:5: otherlv_9= 'uses-capabilities' otherlv_10= '{' ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+ otherlv_12= '}'
                    {
                    otherlv_9=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleFeature1663); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFeatureAccess().getUsesCapabilitiesKeyword_7_0());
                          
                    }
                    otherlv_10=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1675); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_7_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:921:1: ( (lv_usesCapabilities_11_0= ruleCapabilityRef ) )+
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
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:922:1: (lv_usesCapabilities_11_0= ruleCapabilityRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:922:1: (lv_usesCapabilities_11_0= ruleCapabilityRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:923:3: lv_usesCapabilities_11_0= ruleCapabilityRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getUsesCapabilitiesCapabilityRefParserRuleCall_7_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_ruleFeature1696);
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

                    otherlv_12=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFeature1709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_12, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_7_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:943:3: (otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==15) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:943:5: otherlv_13= 'requires' ( (lv_requires_14_0= ruleServiceRef ) )
            	    {
            	    otherlv_13=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFeature1724); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_13, grammarAccess.getFeatureAccess().getRequiresKeyword_8_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:947:1: ( (lv_requires_14_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:948:1: (lv_requires_14_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:948:1: (lv_requires_14_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:949:3: lv_requires_14_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getRequiresServiceRefParserRuleCall_8_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleFeature1745);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:965:4: (otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==16) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:965:6: otherlv_15= 'requires-channel' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_15=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFeature1760); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_15, grammarAccess.getFeatureAccess().getRequiresChannelKeyword_9_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:969:1: ( ( ruleQualifiedName ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:970:1: ( ruleQualifiedName )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:970:1: ( ruleQualifiedName )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:971:3: ruleQualifiedName
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
            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1787);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:987:4: (otherlv_17= 'contacts' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )? )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==17) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:987:6: otherlv_17= 'contacts' otherlv_18= '{' (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )? (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )* (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )? (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )?
                    {
                    otherlv_17=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleFeature1802); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_17, grammarAccess.getFeatureAccess().getContactsKeyword_10_0());
                          
                    }
                    otherlv_18=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1814); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_18, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_10_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:995:1: (otherlv_19= 'owner' ( ( ruleQualifiedName ) ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==18) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:995:3: otherlv_19= 'owner' ( ( ruleQualifiedName ) )
                            {
                            otherlv_19=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleFeature1827); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_19, grammarAccess.getFeatureAccess().getOwnerKeyword_10_2_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:999:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1000:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1000:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1001:3: ruleQualifiedName
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
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1854);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1017:4: (otherlv_21= 'responsible' ( ( ruleQualifiedName ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==19) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1017:6: otherlv_21= 'responsible' ( ( ruleQualifiedName ) )
                    	    {
                    	    otherlv_21=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFeature1869); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_21, grammarAccess.getFeatureAccess().getResponsibleKeyword_10_3_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1021:1: ( ( ruleQualifiedName ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1022:1: ( ruleQualifiedName )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1022:1: ( ruleQualifiedName )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1023:3: ruleQualifiedName
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
                    	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1896);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1039:4: (otherlv_23= 'budgeting' ( ( ruleQualifiedName ) ) )?
                    int alt43=2;
                    int LA43_0 = input.LA(1);

                    if ( (LA43_0==20) ) {
                        alt43=1;
                    }
                    switch (alt43) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1039:6: otherlv_23= 'budgeting' ( ( ruleQualifiedName ) )
                            {
                            otherlv_23=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFeature1911); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_23, grammarAccess.getFeatureAccess().getBudgetingKeyword_10_4_0());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1043:1: ( ( ruleQualifiedName ) )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1044:1: ( ruleQualifiedName )
                            {
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1044:1: ( ruleQualifiedName )
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1045:3: ruleQualifiedName
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
                            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1938);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1061:4: (otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}' )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==21) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1061:6: otherlv_25= 'subscriptions' otherlv_26= '{' ( ( ruleQualifiedName ) )* otherlv_28= '}'
                            {
                            otherlv_25=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFeature1953); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_25, grammarAccess.getFeatureAccess().getSubscriptionsKeyword_10_5_0());
                                  
                            }
                            otherlv_26=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1965); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_26, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_10_5_1());
                                  
                            }
                            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1069:1: ( ( ruleQualifiedName ) )*
                            loop44:
                            do {
                                int alt44=2;
                                int LA44_0 = input.LA(1);

                                if ( (LA44_0==RULE_ID) ) {
                                    alt44=1;
                                }


                                switch (alt44) {
                            	case 1 :
                            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1070:1: ( ruleQualifiedName )
                            	    {
                            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1070:1: ( ruleQualifiedName )
                            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1071:3: ruleQualifiedName
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
                            	       
                            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getSubscriptionsUserCrossReference_10_5_2_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleFeature1992);
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
                            	    break loop44;
                                }
                            } while (true);

                            otherlv_28=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFeature2005); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_28, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_10_5_3());
                                  
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1091:5: (otherlv_29= 'tags' ( (otherlv_30= RULE_ID ) )+ )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==23) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1091:7: otherlv_29= 'tags' ( (otherlv_30= RULE_ID ) )+
                    {
                    otherlv_29=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFeature2022); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_29, grammarAccess.getFeatureAccess().getTagsKeyword_11_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1095:1: ( (otherlv_30= RULE_ID ) )+
                    int cnt47=0;
                    loop47:
                    do {
                        int alt47=2;
                        int LA47_0 = input.LA(1);

                        if ( (LA47_0==RULE_ID) ) {
                            alt47=1;
                        }


                        switch (alt47) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1096:1: (otherlv_30= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1096:1: (otherlv_30= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1097:3: otherlv_30= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFeatureRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_30=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFeature2046); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_30, grammarAccess.getFeatureAccess().getTagsTagCrossReference_11_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt47 >= 1 ) break loop47;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(47, input);
                                throw eee;
                        }
                        cnt47++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1111:5: ( (lv_features_31_0= ruleFeature ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( ((LA49_0>=26 && LA49_0<=27)) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1112:1: (lv_features_31_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1112:1: (lv_features_31_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1113:3: lv_features_31_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getFeaturesFeatureParserRuleCall_12_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleFeature2070);
            	    lv_features_31_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_31_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            otherlv_32=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFeature2083); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_32, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_13());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1141:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1142:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1143:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef2119);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef2129); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1150:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1153:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1154:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1154:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1154:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )?
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1154:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1155:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1155:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1156:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef2181);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1172:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1173:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1173:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1174:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef2202);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1190:2: ( (lv_isResponseHandler_2_0= 'handling responses' ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==31) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1191:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1191:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1192:3: lv_isResponseHandler_2_0= 'handling responses'
                    {
                    lv_isResponseHandler_2_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleServiceRef2220); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1205:3: (otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==32) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1205:5: otherlv_3= 'calling' ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) ) (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )*
                    {
                    otherlv_3=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleServiceRef2247); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getServiceRefAccess().getCallingKeyword_3_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1209:1: ( (lv_calledOperations_4_0= ruleSimpleOperationRef ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1210:1: (lv_calledOperations_4_0= ruleSimpleOperationRef )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1210:1: (lv_calledOperations_4_0= ruleSimpleOperationRef )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1211:3: lv_calledOperations_4_0= ruleSimpleOperationRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getServiceRefAccess().getCalledOperationsSimpleOperationRefParserRuleCall_3_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2268);
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

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1227:2: (otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==33) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1227:4: otherlv_5= ',' ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) )
                    	    {
                    	    otherlv_5=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleServiceRef2281); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_5, grammarAccess.getServiceRefAccess().getCommaKeyword_3_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1231:1: ( (lv_calledOperations_6_0= ruleSimpleOperationRef ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1232:1: (lv_calledOperations_6_0= ruleSimpleOperationRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1232:1: (lv_calledOperations_6_0= ruleSimpleOperationRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1233:3: lv_calledOperations_6_0= ruleSimpleOperationRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getServiceRefAccess().getCalledOperationsSimpleOperationRefParserRuleCall_3_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2302);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1257:1: entryRuleSimpleOperationRef returns [EObject current=null] : iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF ;
    public final EObject entryRuleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleOperationRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1258:2: (iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1259:2: iv_ruleSimpleOperationRef= ruleSimpleOperationRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSimpleOperationRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleSimpleOperationRef_in_entryRuleSimpleOperationRef2342);
            iv_ruleSimpleOperationRef=ruleSimpleOperationRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSimpleOperationRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleSimpleOperationRef2352); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1266:1: ruleSimpleOperationRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleSimpleOperationRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1269:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1270:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1270:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1271:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1271:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1272:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleSimpleOperationRef2403);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1296:1: entryRuleCapabilityRef returns [EObject current=null] : iv_ruleCapabilityRef= ruleCapabilityRef EOF ;
    public final EObject entryRuleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapabilityRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1297:2: (iv_ruleCapabilityRef= ruleCapabilityRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1298:2: iv_ruleCapabilityRef= ruleCapabilityRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapabilityRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef2438);
            iv_ruleCapabilityRef=ruleCapabilityRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapabilityRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapabilityRef2448); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1305:1: ruleCapabilityRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1308:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1309:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1309:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1309:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1309:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1310:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1310:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1311:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleCapabilityRef2500);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1327:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1328:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1328:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1329:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCapabilityRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleCapabilityRef2521);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1353:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1354:2: (iv_ruleVersion= ruleVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1355:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersion_in_entryRuleVersion2557);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersion2567); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1362:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1365:28: ( (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1366:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1366:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1366:3: otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleVersion2604); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1370:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1371:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1371:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1372:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleVersion2625);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1396:1: entryRuleProductVersion returns [EObject current=null] : iv_ruleProductVersion= ruleProductVersion EOF ;
    public final EObject entryRuleProductVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1397:2: (iv_ruleProductVersion= ruleProductVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1398:2: iv_ruleProductVersion= ruleProductVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProductVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProductVersion_in_entryRuleProductVersion2661);
            iv_ruleProductVersion=ruleProductVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProductVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProductVersion2671); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1405:1: ruleProductVersion returns [EObject current=null] : (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleProductVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1408:28: ( (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1409:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1409:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1409:3: otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleProductVersion2708); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProductVersionAccess().getProductVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1413:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1414:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1414:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1415:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProductVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleProductVersion2729);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1441:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1442:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1443:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport2767);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport2777); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1450:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1453:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1454:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1454:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1454:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleImport2814); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1458:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1459:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1459:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1460:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport2835);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1484:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1485:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1486:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId2872);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId2883); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1493:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_5=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1496:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1497:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1497:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1497:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId2923); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1504:1: (kw= '.' this_INT_2= RULE_INT )*
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
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1505:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleVersionId2942); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId2957); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1517:3: ( (kw= '.' | kw= '-' ) this_ID_5= RULE_ID )*
            loop55:
            do {
                int alt55=2;
                int LA55_0 = input.LA(1);

                if ( ((LA55_0>=37 && LA55_0<=38)) ) {
                    alt55=1;
                }


                switch (alt55) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1517:4: (kw= '.' | kw= '-' ) this_ID_5= RULE_ID
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1517:4: (kw= '.' | kw= '-' )
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
            	            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1518:2: kw= '.'
            	            {
            	            kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleVersionId2979); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0_0()); 
            	                  
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1525:2: kw= '-'
            	            {
            	            kw=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleVersionId2998); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	                      current.merge(kw);
            	                      newLeafNode(kw, grammarAccess.getVersionIdAccess().getHyphenMinusKeyword_2_0_1()); 
            	                  
            	            }

            	            }
            	            break;

            	    }

            	    this_ID_5=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId3014); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1547:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1548:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1549:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef3063);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef3073); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1556:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1559:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1560:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1560:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1561:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef3123);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1574:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef3153);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1587:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef3183);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1600:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef3213);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1613:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef3243);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1632:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1633:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1634:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef3278);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef3288); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1641:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1644:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1645:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1645:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1645:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleMinVersionRef3325); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1649:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1650:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1650:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1651:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef3346);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1675:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1676:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1677:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef3382);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef3392); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1684:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1687:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1688:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1688:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1688:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleMaxVersionRef3429); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1692:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1693:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1693:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1694:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef3450);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1718:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1719:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1720:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef3486);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef3496); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1727:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1730:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1731:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1731:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1731:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1731:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1731:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleLowerBoundRangeVersionRef3534); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleLowerBoundRangeVersionRef3546); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1739:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1740:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1740:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1741:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3568);
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

            otherlv_3=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleLowerBoundRangeVersionRef3580); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1761:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1761:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleLowerBoundRangeVersionRef3593); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleLowerBoundRangeVersionRef3605); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1769:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1770:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1770:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1771:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3627);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1795:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1796:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1797:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef3663);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef3673); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1804:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1807:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1808:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1808:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1808:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleMajorVersionRef3710); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1812:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1813:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1813:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1814:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef3727); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1838:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1839:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1840:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef3768);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef3778); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1847:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1850:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1851:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1851:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1851:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,44,FollowSets000.FOLLOW_44_in_ruleFixedVersionRef3815); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1855:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1856:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1856:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1857:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef3836);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1881:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1882:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1883:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard3873);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard3884); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1890:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1893:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1894:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1894:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1895:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3931);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1905:1: (kw= '.*' )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==45) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1906:2: kw= '.*'
                    {
                    kw=(Token)match(input,45,FollowSets000.FOLLOW_45_in_ruleQualifiedNameWithWildCard3950); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1919:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1920:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1921:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3993);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName4004); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1928:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1931:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1932:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1932:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1932:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName4044); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1939:1: (kw= '.' this_ID_2= RULE_ID )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==37) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1940:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleQualifiedName4063); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName4078); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1964:1: entryRuleAdditionalInformation returns [EObject current=null] : iv_ruleAdditionalInformation= ruleAdditionalInformation EOF ;
    public final EObject entryRuleAdditionalInformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionalInformation = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1965:2: (iv_ruleAdditionalInformation= ruleAdditionalInformation EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1966:2: iv_ruleAdditionalInformation= ruleAdditionalInformation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditionalInformationRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleAdditionalInformation_in_entryRuleAdditionalInformation4129);
            iv_ruleAdditionalInformation=ruleAdditionalInformation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditionalInformation; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleAdditionalInformation4139); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1973:1: ruleAdditionalInformation returns [EObject current=null] : (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' ) ;
    public final EObject ruleAdditionalInformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_infoItems_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1976:28: ( (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1977:1: (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1977:1: (otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1977:3: otherlv_0= 'additional-information' otherlv_1= '{' ( (lv_infoItems_2_0= ruleInfoItem ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,46,FollowSets000.FOLLOW_46_in_ruleAdditionalInformation4176); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getAdditionalInformationAccess().getAdditionalInformationKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleAdditionalInformation4188); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getAdditionalInformationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1985:1: ( (lv_infoItems_2_0= ruleInfoItem ) )+
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
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1986:1: (lv_infoItems_2_0= ruleInfoItem )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1986:1: (lv_infoItems_2_0= ruleInfoItem )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1987:3: lv_infoItems_2_0= ruleInfoItem
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getAdditionalInformationAccess().getInfoItemsInfoItemParserRuleCall_2_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_ruleAdditionalInformation4209);
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

            otherlv_3=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleAdditionalInformation4222); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2015:1: entryRuleInfoItem returns [EObject current=null] : iv_ruleInfoItem= ruleInfoItem EOF ;
    public final EObject entryRuleInfoItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfoItem = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2016:2: (iv_ruleInfoItem= ruleInfoItem EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2017:2: iv_ruleInfoItem= ruleInfoItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfoItemRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleInfoItem_in_entryRuleInfoItem4258);
            iv_ruleInfoItem=ruleInfoItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfoItem; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleInfoItem4268); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2024:1: ruleInfoItem returns [EObject current=null] : (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleInfoItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_documentLocation_1_0=null;
        Token otherlv_2=null;
        Token lv_reference_3_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2027:28: ( (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2028:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2028:1: (otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2028:3: otherlv_0= 'location' ( (lv_documentLocation_1_0= RULE_STRING ) ) (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,47,FollowSets000.FOLLOW_47_in_ruleInfoItem4305); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getInfoItemAccess().getLocationKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2032:1: ( (lv_documentLocation_1_0= RULE_STRING ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2033:1: (lv_documentLocation_1_0= RULE_STRING )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2033:1: (lv_documentLocation_1_0= RULE_STRING )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2034:3: lv_documentLocation_1_0= RULE_STRING
            {
            lv_documentLocation_1_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem4322); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2050:2: (otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==48) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2050:4: otherlv_2= 'reference' ( (lv_reference_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,48,FollowSets000.FOLLOW_48_in_ruleInfoItem4340); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getInfoItemAccess().getReferenceKeyword_2_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2054:1: ( (lv_reference_3_0= RULE_STRING ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2055:1: (lv_reference_3_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2055:1: (lv_reference_3_0= RULE_STRING )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2056:3: lv_reference_3_0= RULE_STRING
                    {
                    lv_reference_3_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleInfoItem4357); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2082:1: entryRuleRoleRef returns [EObject current=null] : iv_ruleRoleRef= ruleRoleRef EOF ;
    public final EObject entryRuleRoleRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRoleRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2083:2: (iv_ruleRoleRef= ruleRoleRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2084:2: iv_ruleRoleRef= ruleRoleRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRoleRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleRoleRef_in_entryRuleRoleRef4402);
            iv_ruleRoleRef=ruleRoleRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRoleRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleRoleRef4412); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2091:1: ruleRoleRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleRoleRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2094:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2095:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2095:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2096:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2096:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2097:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleRoleRef4463);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2123:1: entryRulePrivilegeRef returns [EObject current=null] : iv_rulePrivilegeRef= rulePrivilegeRef EOF ;
    public final EObject entryRulePrivilegeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrivilegeRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2124:2: (iv_rulePrivilegeRef= rulePrivilegeRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2125:2: iv_rulePrivilegeRef= rulePrivilegeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrivilegeRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef4500);
            iv_rulePrivilegeRef=rulePrivilegeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrivilegeRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRulePrivilegeRef4510); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2132:1: rulePrivilegeRef returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject rulePrivilegeRef() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2135:28: ( ( ( ruleQualifiedName ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2136:1: ( ( ruleQualifiedName ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2136:1: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2137:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2137:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2138:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_rulePrivilegeRef4561);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2166:1: ruleModuleKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2168:28: ( ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2169:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2169:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2169:2: (enumLiteral_0= 'UI' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2169:2: (enumLiteral_0= 'UI' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2169:4: enumLiteral_0= 'UI'
                    {
                    enumLiteral_0=(Token)match(input,49,FollowSets000.FOLLOW_49_in_ruleModuleKind4614); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2175:6: (enumLiteral_1= 'BusinessLogic' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2175:6: (enumLiteral_1= 'BusinessLogic' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2175:8: enumLiteral_1= 'BusinessLogic'
                    {
                    enumLiteral_1=(Token)match(input,50,FollowSets000.FOLLOW_50_in_ruleModuleKind4631); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2181:6: (enumLiteral_2= 'Persistence' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2181:6: (enumLiteral_2= 'Persistence' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2181:8: enumLiteral_2= 'Persistence'
                    {
                    enumLiteral_2=(Token)match(input,51,FollowSets000.FOLLOW_51_in_ruleModuleKind4648); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:6: (enumLiteral_3= 'Security' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:6: (enumLiteral_3= 'Security' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2187:8: enumLiteral_3= 'Security'
                    {
                    enumLiteral_3=(Token)match(input,52,FollowSets000.FOLLOW_52_in_ruleModuleKind4665); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2193:6: (enumLiteral_4= 'Batch' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2193:6: (enumLiteral_4= 'Batch' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2193:8: enumLiteral_4= 'Batch'
                    {
                    enumLiteral_4=(Token)match(input,53,FollowSets000.FOLLOW_53_in_ruleModuleKind4682); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2199:6: (enumLiteral_5= 'OTHER' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2199:6: (enumLiteral_5= 'OTHER' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2199:8: enumLiteral_5= 'OTHER'
                    {
                    enumLiteral_5=(Token)match(input,54,FollowSets000.FOLLOW_54_in_ruleModuleKind4699); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2209:1: ruleGovernanceDecisionResult returns [Enumerator current=null] : ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) ;
    public final Enumerator ruleGovernanceDecisionResult() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;

         enterRule(); 
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2211:28: ( ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2212:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2212:1: ( (enumLiteral_0= 'pending' ) | (enumLiteral_1= 'accepted' ) | (enumLiteral_2= 'denied' ) | (enumLiteral_3= 'specific' ) )
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2212:2: (enumLiteral_0= 'pending' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2212:2: (enumLiteral_0= 'pending' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2212:4: enumLiteral_0= 'pending'
                    {
                    enumLiteral_0=(Token)match(input,55,FollowSets000.FOLLOW_55_in_ruleGovernanceDecisionResult4744); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getGovernanceDecisionResultAccess().getPendingEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2218:6: (enumLiteral_1= 'accepted' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2218:6: (enumLiteral_1= 'accepted' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2218:8: enumLiteral_1= 'accepted'
                    {
                    enumLiteral_1=(Token)match(input,56,FollowSets000.FOLLOW_56_in_ruleGovernanceDecisionResult4761); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getGovernanceDecisionResultAccess().getAcceptedEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2224:6: (enumLiteral_2= 'denied' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2224:6: (enumLiteral_2= 'denied' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2224:8: enumLiteral_2= 'denied'
                    {
                    enumLiteral_2=(Token)match(input,57,FollowSets000.FOLLOW_57_in_ruleGovernanceDecisionResult4778); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getGovernanceDecisionResultAccess().getDeniedEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:6: (enumLiteral_3= 'specific' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:6: (enumLiteral_3= 'specific' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:2230:8: enumLiteral_3= 'specific'
                    {
                    enumLiteral_3=(Token)match(input,58,FollowSets000.FOLLOW_58_in_ruleGovernanceDecisionResult4795); if (state.failed) return current;
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
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution378 = new BitSet(new long[]{0x000040080DC38000L});
        public static final BitSet FOLLOW_ruleProductVersion_in_ruleSolution399 = new BitSet(new long[]{0x000040000DC38000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleSolution421 = new BitSet(new long[]{0x000000000DC38000L});
        public static final BitSet FOLLOW_15_in_ruleSolution435 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleSolution456 = new BitSet(new long[]{0x000000000DC38000L});
        public static final BitSet FOLLOW_16_in_ruleSolution471 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution498 = new BitSet(new long[]{0x000000000DC30000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleSolution521 = new BitSet(new long[]{0x000000000DC20000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleSolution543 = new BitSet(new long[]{0x0000000001C20000L});
        public static final BitSet FOLLOW_17_in_ruleSolution557 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSolution569 = new BitSet(new long[]{0x0000000000FC0000L});
        public static final BitSet FOLLOW_18_in_ruleSolution582 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution609 = new BitSet(new long[]{0x0000000000F80000L});
        public static final BitSet FOLLOW_19_in_ruleSolution624 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution651 = new BitSet(new long[]{0x0000000000F80000L});
        public static final BitSet FOLLOW_20_in_ruleSolution666 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution693 = new BitSet(new long[]{0x0000000000E00000L});
        public static final BitSet FOLLOW_21_in_ruleSolution708 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSolution720 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution747 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleSolution760 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleSolution777 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSolution801 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleSolution816 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModule_in_entryRuleModule852 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModule862 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_24_in_ruleModule899 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModule916 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule933 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleModule945 = new BitSet(new long[]{0x007E000000000000L});
        public static final BitSet FOLLOW_ruleModuleKind_in_ruleModule966 = new BitSet(new long[]{0x000040040DC3A000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleModule987 = new BitSet(new long[]{0x000040000DC38000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleModule1009 = new BitSet(new long[]{0x000000000DC38000L});
        public static final BitSet FOLLOW_15_in_ruleModule1023 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleModule1044 = new BitSet(new long[]{0x000000000DC38000L});
        public static final BitSet FOLLOW_16_in_ruleModule1059 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1086 = new BitSet(new long[]{0x000000000DC30000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleModule1109 = new BitSet(new long[]{0x000000000DC20000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleModule1131 = new BitSet(new long[]{0x0000000001C20000L});
        public static final BitSet FOLLOW_17_in_ruleModule1145 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule1157 = new BitSet(new long[]{0x0000000000FC0000L});
        public static final BitSet FOLLOW_18_in_ruleModule1170 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1197 = new BitSet(new long[]{0x0000000000F80000L});
        public static final BitSet FOLLOW_19_in_ruleModule1212 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1239 = new BitSet(new long[]{0x0000000000F80000L});
        public static final BitSet FOLLOW_20_in_ruleModule1254 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1281 = new BitSet(new long[]{0x0000000000E00000L});
        public static final BitSet FOLLOW_21_in_ruleModule1296 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule1308 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleModule1335 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleModule1348 = new BitSet(new long[]{0x0000000000C00000L});
        public static final BitSet FOLLOW_23_in_ruleModule1365 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModule1389 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleModule1404 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature1440 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature1450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_26_in_ruleFeature1493 = new BitSet(new long[]{0x0000000008000000L});
        public static final BitSet FOLLOW_27_in_ruleFeature1519 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFeature1536 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1553 = new BitSet(new long[]{0x000040007CC38000L});
        public static final BitSet FOLLOW_28_in_ruleFeature1566 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature1583 = new BitSet(new long[]{0x000040006CC38020L});
        public static final BitSet FOLLOW_29_in_ruleFeature1604 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature1621 = new BitSet(new long[]{0x000040004CC38000L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_ruleFeature1649 = new BitSet(new long[]{0x000000004CC38000L});
        public static final BitSet FOLLOW_30_in_ruleFeature1663 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1675 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_ruleFeature1696 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleFeature1709 = new BitSet(new long[]{0x000000000CC38000L});
        public static final BitSet FOLLOW_15_in_ruleFeature1724 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleFeature1745 = new BitSet(new long[]{0x000000000CC38000L});
        public static final BitSet FOLLOW_16_in_ruleFeature1760 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1787 = new BitSet(new long[]{0x000000000CC30000L});
        public static final BitSet FOLLOW_17_in_ruleFeature1802 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1814 = new BitSet(new long[]{0x000000000CFC0000L});
        public static final BitSet FOLLOW_18_in_ruleFeature1827 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1854 = new BitSet(new long[]{0x000000000CF80000L});
        public static final BitSet FOLLOW_19_in_ruleFeature1869 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1896 = new BitSet(new long[]{0x000000000CF80000L});
        public static final BitSet FOLLOW_20_in_ruleFeature1911 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1938 = new BitSet(new long[]{0x000000000CE00000L});
        public static final BitSet FOLLOW_21_in_ruleFeature1953 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1965 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleFeature1992 = new BitSet(new long[]{0x0000000000400010L});
        public static final BitSet FOLLOW_22_in_ruleFeature2005 = new BitSet(new long[]{0x000000000CC00000L});
        public static final BitSet FOLLOW_23_in_ruleFeature2022 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFeature2046 = new BitSet(new long[]{0x000000000C400010L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleFeature2070 = new BitSet(new long[]{0x000000000C400000L});
        public static final BitSet FOLLOW_22_in_ruleFeature2083 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef2119 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef2129 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef2181 = new BitSet(new long[]{0x0000198000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef2202 = new BitSet(new long[]{0x0000000180000002L});
        public static final BitSet FOLLOW_31_in_ruleServiceRef2220 = new BitSet(new long[]{0x0000000100000002L});
        public static final BitSet FOLLOW_32_in_ruleServiceRef2247 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2268 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_33_in_ruleServiceRef2281 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_ruleServiceRef2302 = new BitSet(new long[]{0x0000000200000002L});
        public static final BitSet FOLLOW_ruleSimpleOperationRef_in_entryRuleSimpleOperationRef2342 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSimpleOperationRef2352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSimpleOperationRef2403 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef2438 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapabilityRef2448 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCapabilityRef2500 = new BitSet(new long[]{0x0000198000000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleCapabilityRef2521 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion2557 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersion2567 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_34_in_ruleVersion2604 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleVersion2625 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductVersion_in_entryRuleProductVersion2661 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProductVersion2671 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleProductVersion2708 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleProductVersion2729 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport2767 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport2777 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleImport2814 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport2835 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId2872 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId2883 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId2923 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_37_in_ruleVersionId2942 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId2957 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_37_in_ruleVersionId2979 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_38_in_ruleVersionId2998 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId3014 = new BitSet(new long[]{0x0000006000000002L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef3063 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef3073 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef3123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef3153 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef3183 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef3213 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef3243 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef3278 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef3288 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleMinVersionRef3325 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef3346 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef3382 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef3392 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleMaxVersionRef3429 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef3450 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef3486 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef3496 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleLowerBoundRangeVersionRef3534 = new BitSet(new long[]{0x0000020000000000L});
        public static final BitSet FOLLOW_41_in_ruleLowerBoundRangeVersionRef3546 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3568 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleLowerBoundRangeVersionRef3580 = new BitSet(new long[]{0x0000010000000000L});
        public static final BitSet FOLLOW_40_in_ruleLowerBoundRangeVersionRef3593 = new BitSet(new long[]{0x0000040000000000L});
        public static final BitSet FOLLOW_42_in_ruleLowerBoundRangeVersionRef3605 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef3627 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef3663 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef3673 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleMajorVersionRef3710 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef3727 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef3768 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef3778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_44_in_ruleFixedVersionRef3815 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef3836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard3873 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard3884 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3931 = new BitSet(new long[]{0x0000200000000002L});
        public static final BitSet FOLLOW_45_in_ruleQualifiedNameWithWildCard3950 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3993 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName4004 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4044 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_37_in_ruleQualifiedName4063 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4078 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_ruleAdditionalInformation_in_entryRuleAdditionalInformation4129 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleAdditionalInformation4139 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_46_in_ruleAdditionalInformation4176 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleAdditionalInformation4188 = new BitSet(new long[]{0x0000800000000000L});
        public static final BitSet FOLLOW_ruleInfoItem_in_ruleAdditionalInformation4209 = new BitSet(new long[]{0x0000800000400000L});
        public static final BitSet FOLLOW_22_in_ruleAdditionalInformation4222 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleInfoItem_in_entryRuleInfoItem4258 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleInfoItem4268 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_47_in_ruleInfoItem4305 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem4322 = new BitSet(new long[]{0x0001000000000002L});
        public static final BitSet FOLLOW_48_in_ruleInfoItem4340 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleInfoItem4357 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleRoleRef_in_entryRuleRoleRef4402 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleRoleRef4412 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRoleRef4463 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_rulePrivilegeRef_in_entryRulePrivilegeRef4500 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRulePrivilegeRef4510 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_rulePrivilegeRef4561 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_49_in_ruleModuleKind4614 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_50_in_ruleModuleKind4631 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_51_in_ruleModuleKind4648 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_52_in_ruleModuleKind4665 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_53_in_ruleModuleKind4682 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_54_in_ruleModuleKind4699 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_55_in_ruleGovernanceDecisionResult4744 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_56_in_ruleGovernanceDecisionResult4761 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_57_in_ruleGovernanceDecisionResult4778 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_58_in_ruleGovernanceDecisionResult4795 = new BitSet(new long[]{0x0000000000000002L});
    }


}