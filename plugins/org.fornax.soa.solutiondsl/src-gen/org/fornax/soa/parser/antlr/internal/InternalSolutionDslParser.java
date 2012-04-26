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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'solution'", "'{'", "'domain'", "'requires'", "'tags'", "'}'", "'module'", "'kind'", "'non-functional'", "'feature'", "'use cases'", "'description'", "'uses capabilities'", "'subscibes-to-event'", "','", "'handling responses'", "'version'", "'product-version'", "'import'", "'.'", "'minVersion'", "'maxVersion'", "'>='", "'<'", "'majorVersion'", "'fixedVersion'", "'.*'", "'UI'", "'BusinessLogic'", "'Persistence'", "'Security'", "'Batch'", "'OTHER'"
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
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_SL_COMMENT=8;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
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

                if ( (LA1_0==29) ) {
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:140:1: ruleSolution returns [EObject current=null] : (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' ) ;
    public final EObject ruleSolution() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_7=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_productVersion_6_0 = null;

        EObject lv_requires_8_0 = null;

        EObject lv_features_9_0 = null;

        EObject lv_modules_10_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:143:28: ( (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:1: (otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:144:3: otherlv_0= 'solution' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= '{' (otherlv_3= 'domain' ( ( ruleQualifiedName ) ) )? ( (lv_version_5_0= ruleVersion ) ) ( (lv_productVersion_6_0= ruleProductVersion ) )? (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )* ( (lv_features_9_0= ruleFeature ) )* ( (lv_modules_10_0= ruleModule ) )* (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )? otherlv_13= '}'
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

            if ( (LA4_0==28) ) {
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:228:3: (otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==14) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:228:5: otherlv_7= 'requires' ( (lv_requires_8_0= ruleServiceRef ) )
            	    {
            	    otherlv_7=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleSolution374); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_7, grammarAccess.getSolutionAccess().getRequiresKeyword_6_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:232:1: ( (lv_requires_8_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:233:1: (lv_requires_8_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:233:1: (lv_requires_8_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:234:3: lv_requires_8_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getRequiresServiceRefParserRuleCall_6_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleSolution395);
            	    lv_requires_8_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
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
            	    break loop5;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:250:4: ( (lv_features_9_0= ruleFeature ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=19 && LA6_0<=20)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:251:1: (lv_features_9_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:251:1: (lv_features_9_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:252:3: lv_features_9_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getFeaturesFeatureParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleSolution418);
            	    lv_features_9_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
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
            	    break loop6;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:268:3: ( (lv_modules_10_0= ruleModule ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==17) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:269:1: (lv_modules_10_0= ruleModule )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:269:1: (lv_modules_10_0= ruleModule )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:270:3: lv_modules_10_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getSolutionAccess().getModulesModuleParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModule_in_ruleSolution440);
            	    lv_modules_10_0=ruleModule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getSolutionRule());
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
            	    break loop7;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:286:3: (otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+ )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==15) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:286:5: otherlv_11= 'tags' ( (otherlv_12= RULE_ID ) )+
                    {
                    otherlv_11=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleSolution454); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getSolutionAccess().getTagsKeyword_9_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:290:1: ( (otherlv_12= RULE_ID ) )+
                    int cnt8=0;
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:291:1: (otherlv_12= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:291:1: (otherlv_12= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:292:3: otherlv_12= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getSolutionRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_12=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleSolution478); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_12, grammarAccess.getSolutionAccess().getTagsTagCrossReference_9_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt8 >= 1 ) break loop8;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(8, input);
                                throw eee;
                        }
                        cnt8++;
                    } while (true);


                    }
                    break;

            }

            otherlv_13=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleSolution493); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_13, grammarAccess.getSolutionAccess().getRightCurlyBracketKeyword_10());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:318:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:319:2: (iv_ruleModule= ruleModule EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:320:2: iv_ruleModule= ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleModule_in_entryRuleModule529);
            iv_ruleModule=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModule; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleModule539); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:327:1: ruleModule returns [EObject current=null] : (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? (otherlv_6= 'requires' ( (lv_requires_7_0= ruleServiceRef ) ) )* ( (lv_features_8_0= ruleFeature ) )* ( (lv_modules_9_0= ruleModule ) )* (otherlv_10= 'tags' ( (otherlv_11= RULE_ID ) )+ )? otherlv_12= '}' ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Enumerator lv_kind_4_0 = null;

        EObject lv_version_5_0 = null;

        EObject lv_requires_7_0 = null;

        EObject lv_features_8_0 = null;

        EObject lv_modules_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:330:28: ( (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? (otherlv_6= 'requires' ( (lv_requires_7_0= ruleServiceRef ) ) )* ( (lv_features_8_0= ruleFeature ) )* ( (lv_modules_9_0= ruleModule ) )* (otherlv_10= 'tags' ( (otherlv_11= RULE_ID ) )+ )? otherlv_12= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:331:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? (otherlv_6= 'requires' ( (lv_requires_7_0= ruleServiceRef ) ) )* ( (lv_features_8_0= ruleFeature ) )* ( (lv_modules_9_0= ruleModule ) )* (otherlv_10= 'tags' ( (otherlv_11= RULE_ID ) )+ )? otherlv_12= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:331:1: (otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? (otherlv_6= 'requires' ( (lv_requires_7_0= ruleServiceRef ) ) )* ( (lv_features_8_0= ruleFeature ) )* ( (lv_modules_9_0= ruleModule ) )* (otherlv_10= 'tags' ( (otherlv_11= RULE_ID ) )+ )? otherlv_12= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:331:3: otherlv_0= 'module' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '{' otherlv_3= 'kind' ( (lv_kind_4_0= ruleModuleKind ) ) ( (lv_version_5_0= ruleVersion ) )? (otherlv_6= 'requires' ( (lv_requires_7_0= ruleServiceRef ) ) )* ( (lv_features_8_0= ruleFeature ) )* ( (lv_modules_9_0= ruleModule ) )* (otherlv_10= 'tags' ( (otherlv_11= RULE_ID ) )+ )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,17,FollowSets000.FOLLOW_17_in_ruleModule576); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleAccess().getModuleKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:335:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:336:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:336:1: (lv_name_1_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:337:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModule593); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleModule610); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftCurlyBracketKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,18,FollowSets000.FOLLOW_18_in_ruleModule622); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getKindKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:361:1: ( (lv_kind_4_0= ruleModuleKind ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:362:1: (lv_kind_4_0= ruleModuleKind )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:362:1: (lv_kind_4_0= ruleModuleKind )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:363:3: lv_kind_4_0= ruleModuleKind
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleAccess().getKindModuleKindEnumRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleModuleKind_in_ruleModule643);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:379:2: ( (lv_version_5_0= ruleVersion ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==27) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:380:1: (lv_version_5_0= ruleVersion )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:380:1: (lv_version_5_0= ruleVersion )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:381:3: lv_version_5_0= ruleVersion
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getVersionVersionParserRuleCall_5_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleVersion_in_ruleModule664);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:397:3: (otherlv_6= 'requires' ( (lv_requires_7_0= ruleServiceRef ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==14) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:397:5: otherlv_6= 'requires' ( (lv_requires_7_0= ruleServiceRef ) )
            	    {
            	    otherlv_6=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleModule678); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_6, grammarAccess.getModuleAccess().getRequiresKeyword_6_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:401:1: ( (lv_requires_7_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:402:1: (lv_requires_7_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:402:1: (lv_requires_7_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:403:3: lv_requires_7_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getRequiresServiceRefParserRuleCall_6_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleModule699);
            	    lv_requires_7_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_7_0, 
            	              		"ServiceRef");
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:419:4: ( (lv_features_8_0= ruleFeature ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=19 && LA12_0<=20)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:420:1: (lv_features_8_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:420:1: (lv_features_8_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:421:3: lv_features_8_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getFeaturesFeatureParserRuleCall_7_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleModule722);
            	    lv_features_8_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_8_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:437:3: ( (lv_modules_9_0= ruleModule ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==17) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:438:1: (lv_modules_9_0= ruleModule )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:438:1: (lv_modules_9_0= ruleModule )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:439:3: lv_modules_9_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleAccess().getModulesModuleParserRuleCall_8_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleModule_in_ruleModule744);
            	    lv_modules_9_0=ruleModule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modules",
            	              		lv_modules_9_0, 
            	              		"Module");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:455:3: (otherlv_10= 'tags' ( (otherlv_11= RULE_ID ) )+ )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==15) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:455:5: otherlv_10= 'tags' ( (otherlv_11= RULE_ID ) )+
                    {
                    otherlv_10=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleModule758); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getModuleAccess().getTagsKeyword_9_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:459:1: ( (otherlv_11= RULE_ID ) )+
                    int cnt14=0;
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:460:1: (otherlv_11= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:460:1: (otherlv_11= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:461:3: otherlv_11= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getModuleRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_11=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleModule782); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_11, grammarAccess.getModuleAccess().getTagsTagCrossReference_9_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt14 >= 1 ) break loop14;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(14, input);
                                throw eee;
                        }
                        cnt14++;
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleModule797); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getModuleAccess().getRightCurlyBracketKeyword_10());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:487:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:488:2: (iv_ruleFeature= ruleFeature EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:489:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFeature_in_entryRuleFeature833);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFeature843); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:496:1: ruleFeature returns [EObject current=null] : ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'uses capabilities' otherlv_9= '{' ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+ otherlv_11= '}' )? (otherlv_12= 'requires' ( (lv_requires_13_0= ruleServiceRef ) ) )* (otherlv_14= 'subscibes-to-event' ( (lv_event_15_0= ruleEventRef ) ) (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )* )? ( (lv_features_18_0= ruleFeature ) )* (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? otherlv_21= '}' ) ;
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
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        EObject lv_usesCapabilities_10_0 = null;

        EObject lv_requires_13_0 = null;

        EObject lv_event_15_0 = null;

        EObject lv_event_17_0 = null;

        EObject lv_features_18_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:499:28: ( ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'uses capabilities' otherlv_9= '{' ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+ otherlv_11= '}' )? (otherlv_12= 'requires' ( (lv_requires_13_0= ruleServiceRef ) ) )* (otherlv_14= 'subscibes-to-event' ( (lv_event_15_0= ruleEventRef ) ) (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )* )? ( (lv_features_18_0= ruleFeature ) )* (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? otherlv_21= '}' ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:500:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'uses capabilities' otherlv_9= '{' ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+ otherlv_11= '}' )? (otherlv_12= 'requires' ( (lv_requires_13_0= ruleServiceRef ) ) )* (otherlv_14= 'subscibes-to-event' ( (lv_event_15_0= ruleEventRef ) ) (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )* )? ( (lv_features_18_0= ruleFeature ) )* (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? otherlv_21= '}' )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:500:1: ( ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'uses capabilities' otherlv_9= '{' ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+ otherlv_11= '}' )? (otherlv_12= 'requires' ( (lv_requires_13_0= ruleServiceRef ) ) )* (otherlv_14= 'subscibes-to-event' ( (lv_event_15_0= ruleEventRef ) ) (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )* )? ( (lv_features_18_0= ruleFeature ) )* (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? otherlv_21= '}' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:500:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )? otherlv_1= 'feature' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' (otherlv_4= 'use cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )? (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )? (otherlv_8= 'uses capabilities' otherlv_9= '{' ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+ otherlv_11= '}' )? (otherlv_12= 'requires' ( (lv_requires_13_0= ruleServiceRef ) ) )* (otherlv_14= 'subscibes-to-event' ( (lv_event_15_0= ruleEventRef ) ) (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )* )? ( (lv_features_18_0= ruleFeature ) )* (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )? otherlv_21= '}'
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:500:2: ( (lv_nonFunctional_0_0= 'non-functional' ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==19) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:501:1: (lv_nonFunctional_0_0= 'non-functional' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:501:1: (lv_nonFunctional_0_0= 'non-functional' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:502:3: lv_nonFunctional_0_0= 'non-functional'
                    {
                    lv_nonFunctional_0_0=(Token)match(input,19,FollowSets000.FOLLOW_19_in_ruleFeature886); if (state.failed) return current;
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

            otherlv_1=(Token)match(input,20,FollowSets000.FOLLOW_20_in_ruleFeature912); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getFeatureAccess().getFeatureKeyword_1());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:519:1: ( (lv_name_2_0= RULE_ID ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:520:1: (lv_name_2_0= RULE_ID )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:520:1: (lv_name_2_0= RULE_ID )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:521:3: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFeature929); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature946); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_3());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:541:1: (otherlv_4= 'use cases' ( (lv_useCase_5_0= RULE_STRING ) )+ )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==21) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:541:3: otherlv_4= 'use cases' ( (lv_useCase_5_0= RULE_STRING ) )+
                    {
                    otherlv_4=(Token)match(input,21,FollowSets000.FOLLOW_21_in_ruleFeature959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getFeatureAccess().getUseCasesKeyword_4_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:545:1: ( (lv_useCase_5_0= RULE_STRING ) )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_STRING) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:546:1: (lv_useCase_5_0= RULE_STRING )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:546:1: (lv_useCase_5_0= RULE_STRING )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:547:3: lv_useCase_5_0= RULE_STRING
                    	    {
                    	    lv_useCase_5_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature976); if (state.failed) return current;
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
                    	    if ( cnt17 >= 1 ) break loop17;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:563:5: (otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==22) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:563:7: otherlv_6= 'description' ( (lv_description_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,22,FollowSets000.FOLLOW_22_in_ruleFeature997); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_6, grammarAccess.getFeatureAccess().getDescriptionKeyword_5_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:567:1: ( (lv_description_7_0= RULE_STRING ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:568:1: (lv_description_7_0= RULE_STRING )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:568:1: (lv_description_7_0= RULE_STRING )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:569:3: lv_description_7_0= RULE_STRING
                    {
                    lv_description_7_0=(Token)match(input,RULE_STRING,FollowSets000.FOLLOW_RULE_STRING_in_ruleFeature1014); if (state.failed) return current;
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:585:4: (otherlv_8= 'uses capabilities' otherlv_9= '{' ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+ otherlv_11= '}' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==23) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:585:6: otherlv_8= 'uses capabilities' otherlv_9= '{' ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+ otherlv_11= '}'
                    {
                    otherlv_8=(Token)match(input,23,FollowSets000.FOLLOW_23_in_ruleFeature1034); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getFeatureAccess().getUsesCapabilitiesKeyword_6_0());
                          
                    }
                    otherlv_9=(Token)match(input,12,FollowSets000.FOLLOW_12_in_ruleFeature1046); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getFeatureAccess().getLeftCurlyBracketKeyword_6_1());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:593:1: ( (lv_usesCapabilities_10_0= ruleCapabilityRef ) )+
                    int cnt20=0;
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==RULE_ID) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:594:1: (lv_usesCapabilities_10_0= ruleCapabilityRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:594:1: (lv_usesCapabilities_10_0= ruleCapabilityRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:595:3: lv_usesCapabilities_10_0= ruleCapabilityRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getUsesCapabilitiesCapabilityRefParserRuleCall_6_2_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_ruleFeature1067);
                    	    lv_usesCapabilities_10_0=ruleCapabilityRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"usesCapabilities",
                    	              		lv_usesCapabilities_10_0, 
                    	              		"CapabilityRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt20 >= 1 ) break loop20;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(20, input);
                                throw eee;
                        }
                        cnt20++;
                    } while (true);

                    otherlv_11=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFeature1080); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_6_3());
                          
                    }

                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:615:3: (otherlv_12= 'requires' ( (lv_requires_13_0= ruleServiceRef ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==14) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:615:5: otherlv_12= 'requires' ( (lv_requires_13_0= ruleServiceRef ) )
            	    {
            	    otherlv_12=(Token)match(input,14,FollowSets000.FOLLOW_14_in_ruleFeature1095); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_12, grammarAccess.getFeatureAccess().getRequiresKeyword_7_0());
            	          
            	    }
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:619:1: ( (lv_requires_13_0= ruleServiceRef ) )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:620:1: (lv_requires_13_0= ruleServiceRef )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:620:1: (lv_requires_13_0= ruleServiceRef )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:621:3: lv_requires_13_0= ruleServiceRef
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getRequiresServiceRefParserRuleCall_7_1_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_ruleFeature1116);
            	    lv_requires_13_0=ruleServiceRef();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requires",
            	              		lv_requires_13_0, 
            	              		"ServiceRef");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:637:4: (otherlv_14= 'subscibes-to-event' ( (lv_event_15_0= ruleEventRef ) ) (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )* )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==24) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:637:6: otherlv_14= 'subscibes-to-event' ( (lv_event_15_0= ruleEventRef ) ) (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )*
                    {
                    otherlv_14=(Token)match(input,24,FollowSets000.FOLLOW_24_in_ruleFeature1131); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_14, grammarAccess.getFeatureAccess().getSubscibesToEventKeyword_8_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:641:1: ( (lv_event_15_0= ruleEventRef ) )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:642:1: (lv_event_15_0= ruleEventRef )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:642:1: (lv_event_15_0= ruleEventRef )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:643:3: lv_event_15_0= ruleEventRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getFeatureAccess().getEventEventRefParserRuleCall_8_1_0()); 
                      	    
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleEventRef_in_ruleFeature1152);
                    lv_event_15_0=ruleEventRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                      	        }
                             		add(
                             			current, 
                             			"event",
                              		lv_event_15_0, 
                              		"EventRef");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:659:2: (otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) ) )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==25) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:659:4: otherlv_16= ',' ( (lv_event_17_0= ruleEventRef ) )
                    	    {
                    	    otherlv_16=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleFeature1165); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_16, grammarAccess.getFeatureAccess().getCommaKeyword_8_2_0());
                    	          
                    	    }
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:663:1: ( (lv_event_17_0= ruleEventRef ) )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:664:1: (lv_event_17_0= ruleEventRef )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:664:1: (lv_event_17_0= ruleEventRef )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:665:3: lv_event_17_0= ruleEventRef
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getFeatureAccess().getEventEventRefParserRuleCall_8_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FollowSets000.FOLLOW_ruleEventRef_in_ruleFeature1186);
                    	    lv_event_17_0=ruleEventRef();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"event",
                    	              		lv_event_17_0, 
                    	              		"EventRef");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:681:6: ( (lv_features_18_0= ruleFeature ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=19 && LA25_0<=20)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:682:1: (lv_features_18_0= ruleFeature )
            	    {
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:682:1: (lv_features_18_0= ruleFeature )
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:683:3: lv_features_18_0= ruleFeature
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getFeatureAccess().getFeaturesFeatureParserRuleCall_9_0()); 
            	      	    
            	    }
            	    pushFollow(FollowSets000.FOLLOW_ruleFeature_in_ruleFeature1211);
            	    lv_features_18_0=ruleFeature();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getFeatureRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"features",
            	              		lv_features_18_0, 
            	              		"Feature");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:699:3: (otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+ )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==15) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:699:5: otherlv_19= 'tags' ( (otherlv_20= RULE_ID ) )+
                    {
                    otherlv_19=(Token)match(input,15,FollowSets000.FOLLOW_15_in_ruleFeature1225); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_19, grammarAccess.getFeatureAccess().getTagsKeyword_10_0());
                          
                    }
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:703:1: ( (otherlv_20= RULE_ID ) )+
                    int cnt26=0;
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( (LA26_0==RULE_ID) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:704:1: (otherlv_20= RULE_ID )
                    	    {
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:704:1: (otherlv_20= RULE_ID )
                    	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:705:3: otherlv_20= RULE_ID
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      		  /* */ 
                    	      		
                    	    }
                    	    if ( state.backtracking==0 ) {

                    	      			if (current==null) {
                    	      	            current = createModelElement(grammarAccess.getFeatureRule());
                    	      	        }
                    	              
                    	    }
                    	    otherlv_20=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleFeature1249); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      		newLeafNode(otherlv_20, grammarAccess.getFeatureAccess().getTagsTagCrossReference_10_1_0()); 
                    	      	
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt26 >= 1 ) break loop26;
                    	    if (state.backtracking>0) {state.failed=true; return current;}
                                EarlyExitException eee =
                                    new EarlyExitException(26, input);
                                throw eee;
                        }
                        cnt26++;
                    } while (true);


                    }
                    break;

            }

            otherlv_21=(Token)match(input,16,FollowSets000.FOLLOW_16_in_ruleFeature1264); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_21, grammarAccess.getFeatureAccess().getRightCurlyBracketKeyword_11());
                  
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:731:1: entryRuleServiceRef returns [EObject current=null] : iv_ruleServiceRef= ruleServiceRef EOF ;
    public final EObject entryRuleServiceRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleServiceRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:732:2: (iv_ruleServiceRef= ruleServiceRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:733:2: iv_ruleServiceRef= ruleServiceRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getServiceRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleServiceRef_in_entryRuleServiceRef1300);
            iv_ruleServiceRef=ruleServiceRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleServiceRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleServiceRef1310); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:740:1: ruleServiceRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? ) ;
    public final EObject ruleServiceRef() throws RecognitionException {
        EObject current = null;

        Token lv_isResponseHandler_2_0=null;
        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:743:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:744:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:744:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:744:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ( (lv_isResponseHandler_2_0= 'handling responses' ) )?
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:744:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:745:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:745:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:746:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleServiceRef1362);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:762:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:763:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:763:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:764:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getServiceRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleServiceRef1383);
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

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:780:2: ( (lv_isResponseHandler_2_0= 'handling responses' ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==26) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:781:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:781:1: (lv_isResponseHandler_2_0= 'handling responses' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:782:3: lv_isResponseHandler_2_0= 'handling responses'
                    {
                    lv_isResponseHandler_2_0=(Token)match(input,26,FollowSets000.FOLLOW_26_in_ruleServiceRef1401); if (state.failed) return current;
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


    // $ANTLR start "entryRuleCapabilityRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:803:1: entryRuleCapabilityRef returns [EObject current=null] : iv_ruleCapabilityRef= ruleCapabilityRef EOF ;
    public final EObject entryRuleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCapabilityRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:804:2: (iv_ruleCapabilityRef= ruleCapabilityRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:805:2: iv_ruleCapabilityRef= ruleCapabilityRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCapabilityRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef1451);
            iv_ruleCapabilityRef=ruleCapabilityRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCapabilityRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleCapabilityRef1461); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:812:1: ruleCapabilityRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleCapabilityRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:815:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:816:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:816:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:816:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:816:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:817:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:817:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:818:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleCapabilityRef1513);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:834:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:835:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:835:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:836:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getCapabilityRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleCapabilityRef1534);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:860:1: entryRuleVersion returns [EObject current=null] : iv_ruleVersion= ruleVersion EOF ;
    public final EObject entryRuleVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:861:2: (iv_ruleVersion= ruleVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:862:2: iv_ruleVersion= ruleVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersion_in_entryRuleVersion1570);
            iv_ruleVersion=ruleVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersion1580); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:869:1: ruleVersion returns [EObject current=null] : (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:872:28: ( (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:873:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:873:1: (otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:873:3: otherlv_0= 'version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,27,FollowSets000.FOLLOW_27_in_ruleVersion1617); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getVersionAccess().getVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:877:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:878:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:878:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:879:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleVersion1638);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:903:1: entryRuleProductVersion returns [EObject current=null] : iv_ruleProductVersion= ruleProductVersion EOF ;
    public final EObject entryRuleProductVersion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProductVersion = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:904:2: (iv_ruleProductVersion= ruleProductVersion EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:905:2: iv_ruleProductVersion= ruleProductVersion EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProductVersionRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleProductVersion_in_entryRuleProductVersion1674);
            iv_ruleProductVersion=ruleProductVersion();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProductVersion; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleProductVersion1684); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:912:1: ruleProductVersion returns [EObject current=null] : (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleProductVersion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_version_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:915:28: ( (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:916:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:916:1: (otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:916:3: otherlv_0= 'product-version' ( (lv_version_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,28,FollowSets000.FOLLOW_28_in_ruleProductVersion1721); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getProductVersionAccess().getProductVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:920:1: ( (lv_version_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:921:1: (lv_version_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:921:1: (lv_version_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:922:3: lv_version_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getProductVersionAccess().getVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleProductVersion1742);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:946:1: entryRuleEventRef returns [EObject current=null] : iv_ruleEventRef= ruleEventRef EOF ;
    public final EObject entryRuleEventRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEventRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:947:2: (iv_ruleEventRef= ruleEventRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:948:2: iv_ruleEventRef= ruleEventRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEventRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleEventRef_in_entryRuleEventRef1778);
            iv_ruleEventRef=ruleEventRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEventRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleEventRef1788); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:955:1: ruleEventRef returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) ;
    public final EObject ruleEventRef() throws RecognitionException {
        EObject current = null;

        EObject lv_versionRef_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:958:28: ( ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:959:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:959:1: ( ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:959:2: ( ( ruleQualifiedName ) ) ( (lv_versionRef_1_0= ruleVersionRef ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:959:2: ( ( ruleQualifiedName ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:960:1: ( ruleQualifiedName )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:960:1: ( ruleQualifiedName )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:961:3: ruleQualifiedName
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
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleEventRef1840);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:977:2: ( (lv_versionRef_1_0= ruleVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:978:1: (lv_versionRef_1_0= ruleVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:978:1: (lv_versionRef_1_0= ruleVersionRef )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:979:3: lv_versionRef_1_0= ruleVersionRef
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getEventRefAccess().getVersionRefVersionRefParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_ruleEventRef1861);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1003:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1004:2: (iv_ruleImport= ruleImport EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1005:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleImport_in_entryRuleImport1897);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleImport1907); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1012:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1015:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1016:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1016:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1016:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            {
            otherlv_0=(Token)match(input,29,FollowSets000.FOLLOW_29_in_ruleImport1944); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1020:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1021:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1021:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1022:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildCard
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildCardParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport1965);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1046:1: entryRuleVersionId returns [String current=null] : iv_ruleVersionId= ruleVersionId EOF ;
    public final String entryRuleVersionId() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVersionId = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1047:2: (iv_ruleVersionId= ruleVersionId EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1048:2: iv_ruleVersionId= ruleVersionId EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionIdRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_entryRuleVersionId2002);
            iv_ruleVersionId=ruleVersionId();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionId.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionId2013); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1055:1: ruleVersionId returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* (kw= '.' this_ID_4= RULE_ID )? ) ;
    public final AntlrDatatypeRuleToken ruleVersionId() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;
        Token this_ID_4=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1058:28: ( (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* (kw= '.' this_ID_4= RULE_ID )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1059:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* (kw= '.' this_ID_4= RULE_ID )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1059:1: (this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* (kw= '.' this_ID_4= RULE_ID )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1059:6: this_INT_0= RULE_INT (kw= '.' this_INT_2= RULE_INT )* (kw= '.' this_ID_4= RULE_ID )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId2053); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_0, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1066:1: (kw= '.' this_INT_2= RULE_INT )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==30) ) {
                    int LA29_1 = input.LA(2);

                    if ( (LA29_1==RULE_INT) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1067:2: kw= '.' this_INT_2= RULE_INT
            	    {
            	    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVersionId2072); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_INT_2=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleVersionId2087); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_INT_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_INT_2, grammarAccess.getVersionIdAccess().getINTTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1079:3: (kw= '.' this_ID_4= RULE_ID )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==30) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1080:2: kw= '.' this_ID_4= RULE_ID
                    {
                    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleVersionId2108); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getVersionIdAccess().getFullStopKeyword_2_0()); 
                          
                    }
                    this_ID_4=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleVersionId2123); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_4);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_4, grammarAccess.getVersionIdAccess().getIDTerminalRuleCall_2_1()); 
                          
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
    // $ANTLR end "ruleVersionId"


    // $ANTLR start "entryRuleVersionRef"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1102:1: entryRuleVersionRef returns [EObject current=null] : iv_ruleVersionRef= ruleVersionRef EOF ;
    public final EObject entryRuleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1103:2: (iv_ruleVersionRef= ruleVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1104:2: iv_ruleVersionRef= ruleVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionRef_in_entryRuleVersionRef2172);
            iv_ruleVersionRef=ruleVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleVersionRef2182); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1111:1: ruleVersionRef returns [EObject current=null] : (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) ;
    public final EObject ruleVersionRef() throws RecognitionException {
        EObject current = null;

        EObject this_MinVersionRef_0 = null;

        EObject this_MaxVersionRef_1 = null;

        EObject this_LowerBoundRangeVersionRef_2 = null;

        EObject this_MajorVersionRef_3 = null;

        EObject this_FixedVersionRef_4 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1114:28: ( (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1115:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1115:1: (this_MinVersionRef_0= ruleMinVersionRef | this_MaxVersionRef_1= ruleMaxVersionRef | this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef | this_MajorVersionRef_3= ruleMajorVersionRef | this_FixedVersionRef_4= ruleFixedVersionRef )
            int alt31=5;
            switch ( input.LA(1) ) {
            case 31:
                {
                int LA31_1 = input.LA(2);

                if ( (LA31_1==RULE_INT) ) {
                    alt31=1;
                }
                else if ( (LA31_1==33) ) {
                    alt31=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 31, 1, input);

                    throw nvae;
                }
                }
                break;
            case 32:
                {
                alt31=2;
                }
                break;
            case 35:
                {
                alt31=4;
                }
                break;
            case 36:
                {
                alt31=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1116:2: this_MinVersionRef_0= ruleMinVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMinVersionRefParserRuleCall_0()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_ruleVersionRef2232);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1129:2: this_MaxVersionRef_1= ruleMaxVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMaxVersionRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_ruleVersionRef2262);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1142:2: this_LowerBoundRangeVersionRef_2= ruleLowerBoundRangeVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getLowerBoundRangeVersionRefParserRuleCall_2()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef2292);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1155:2: this_MajorVersionRef_3= ruleMajorVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getMajorVersionRefParserRuleCall_3()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_ruleVersionRef2322);
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
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1168:2: this_FixedVersionRef_4= ruleFixedVersionRef
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getVersionRefAccess().getFixedVersionRefParserRuleCall_4()); 
                          
                    }
                    pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_ruleVersionRef2352);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1187:1: entryRuleMinVersionRef returns [EObject current=null] : iv_ruleMinVersionRef= ruleMinVersionRef EOF ;
    public final EObject entryRuleMinVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMinVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1188:2: (iv_ruleMinVersionRef= ruleMinVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1189:2: iv_ruleMinVersionRef= ruleMinVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMinVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef2387);
            iv_ruleMinVersionRef=ruleMinVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMinVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMinVersionRef2397); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1196:1: ruleMinVersionRef returns [EObject current=null] : (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMinVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_minVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1199:28: ( (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1200:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1200:1: (otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1200:3: otherlv_0= 'minVersion' ( (lv_minVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleMinVersionRef2434); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMinVersionRefAccess().getMinVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1204:1: ( (lv_minVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1205:1: (lv_minVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1205:1: (lv_minVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1206:3: lv_minVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMinVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMinVersionRef2455);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1230:1: entryRuleMaxVersionRef returns [EObject current=null] : iv_ruleMaxVersionRef= ruleMaxVersionRef EOF ;
    public final EObject entryRuleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMaxVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1231:2: (iv_ruleMaxVersionRef= ruleMaxVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1232:2: iv_ruleMaxVersionRef= ruleMaxVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMaxVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef2491);
            iv_ruleMaxVersionRef=ruleMaxVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMaxVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMaxVersionRef2501); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1239:1: ruleMaxVersionRef returns [EObject current=null] : (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleMaxVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_maxVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1242:28: ( (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1243:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1243:1: (otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1243:3: otherlv_0= 'maxVersion' ( (lv_maxVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleMaxVersionRef2538); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMaxVersionRefAccess().getMaxVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1247:1: ( (lv_maxVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1248:1: (lv_maxVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1248:1: (lv_maxVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1249:3: lv_maxVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getMaxVersionRefAccess().getMaxVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleMaxVersionRef2559);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1273:1: entryRuleLowerBoundRangeVersionRef returns [EObject current=null] : iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF ;
    public final EObject entryRuleLowerBoundRangeVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLowerBoundRangeVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1274:2: (iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1275:2: iv_ruleLowerBoundRangeVersionRef= ruleLowerBoundRangeVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef2595);
            iv_ruleLowerBoundRangeVersionRef=ruleLowerBoundRangeVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLowerBoundRangeVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef2605); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1282:1: ruleLowerBoundRangeVersionRef returns [EObject current=null] : ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1285:28: ( ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1286:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1286:1: ( (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1286:2: (otherlv_0= 'minVersion' otherlv_1= '>=' ) ( (lv_minVersion_2_0= ruleVersionId ) ) otherlv_3= ',' (otherlv_4= 'maxVersion' otherlv_5= '<' ) ( (lv_maxVersion_6_0= ruleVersionId ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1286:2: (otherlv_0= 'minVersion' otherlv_1= '>=' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1286:4: otherlv_0= 'minVersion' otherlv_1= '>='
            {
            otherlv_0=(Token)match(input,31,FollowSets000.FOLLOW_31_in_ruleLowerBoundRangeVersionRef2643); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionKeyword_0_0());
                  
            }
            otherlv_1=(Token)match(input,33,FollowSets000.FOLLOW_33_in_ruleLowerBoundRangeVersionRef2655); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getLowerBoundRangeVersionRefAccess().getGreaterThanSignEqualsSignKeyword_0_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1294:2: ( (lv_minVersion_2_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1295:1: (lv_minVersion_2_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1295:1: (lv_minVersion_2_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1296:3: lv_minVersion_2_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMinVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2677);
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

            otherlv_3=(Token)match(input,25,FollowSets000.FOLLOW_25_in_ruleLowerBoundRangeVersionRef2689); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getLowerBoundRangeVersionRefAccess().getCommaKeyword_2());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1316:1: (otherlv_4= 'maxVersion' otherlv_5= '<' )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1316:3: otherlv_4= 'maxVersion' otherlv_5= '<'
            {
            otherlv_4=(Token)match(input,32,FollowSets000.FOLLOW_32_in_ruleLowerBoundRangeVersionRef2702); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionKeyword_3_0());
                  
            }
            otherlv_5=(Token)match(input,34,FollowSets000.FOLLOW_34_in_ruleLowerBoundRangeVersionRef2714); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getLowerBoundRangeVersionRefAccess().getLessThanSignKeyword_3_1());
                  
            }

            }

            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1324:2: ( (lv_maxVersion_6_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1325:1: (lv_maxVersion_6_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1325:1: (lv_maxVersion_6_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1326:3: lv_maxVersion_6_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getLowerBoundRangeVersionRefAccess().getMaxVersionVersionIdParserRuleCall_4_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2736);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1350:1: entryRuleMajorVersionRef returns [EObject current=null] : iv_ruleMajorVersionRef= ruleMajorVersionRef EOF ;
    public final EObject entryRuleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMajorVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1351:2: (iv_ruleMajorVersionRef= ruleMajorVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1352:2: iv_ruleMajorVersionRef= ruleMajorVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMajorVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef2772);
            iv_ruleMajorVersionRef=ruleMajorVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMajorVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleMajorVersionRef2782); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1359:1: ruleMajorVersionRef returns [EObject current=null] : (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) ;
    public final EObject ruleMajorVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_majorVersion_1_0=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1362:28: ( (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1363:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1363:1: (otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1363:3: otherlv_0= 'majorVersion' ( (lv_majorVersion_1_0= RULE_INT ) )
            {
            otherlv_0=(Token)match(input,35,FollowSets000.FOLLOW_35_in_ruleMajorVersionRef2819); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getMajorVersionRefAccess().getMajorVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1367:1: ( (lv_majorVersion_1_0= RULE_INT ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1368:1: (lv_majorVersion_1_0= RULE_INT )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1368:1: (lv_majorVersion_1_0= RULE_INT )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1369:3: lv_majorVersion_1_0= RULE_INT
            {
            lv_majorVersion_1_0=(Token)match(input,RULE_INT,FollowSets000.FOLLOW_RULE_INT_in_ruleMajorVersionRef2836); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1393:1: entryRuleFixedVersionRef returns [EObject current=null] : iv_ruleFixedVersionRef= ruleFixedVersionRef EOF ;
    public final EObject entryRuleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedVersionRef = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1394:2: (iv_ruleFixedVersionRef= ruleFixedVersionRef EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1395:2: iv_ruleFixedVersionRef= ruleFixedVersionRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFixedVersionRefRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef2877);
            iv_ruleFixedVersionRef=ruleFixedVersionRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFixedVersionRef; 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleFixedVersionRef2887); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1402:1: ruleFixedVersionRef returns [EObject current=null] : (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) ;
    public final EObject ruleFixedVersionRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_fixedVersion_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1405:28: ( (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1406:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1406:1: (otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1406:3: otherlv_0= 'fixedVersion' ( (lv_fixedVersion_1_0= ruleVersionId ) )
            {
            otherlv_0=(Token)match(input,36,FollowSets000.FOLLOW_36_in_ruleFixedVersionRef2924); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getFixedVersionRefAccess().getFixedVersionKeyword_0());
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1410:1: ( (lv_fixedVersion_1_0= ruleVersionId ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1411:1: (lv_fixedVersion_1_0= ruleVersionId )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1411:1: (lv_fixedVersion_1_0= ruleVersionId )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1412:3: lv_fixedVersion_1_0= ruleVersionId
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getFixedVersionRefAccess().getFixedVersionVersionIdParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FollowSets000.FOLLOW_ruleVersionId_in_ruleFixedVersionRef2945);
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1436:1: entryRuleQualifiedNameWithWildCard returns [String current=null] : iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF ;
    public final String entryRuleQualifiedNameWithWildCard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildCard = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1437:2: (iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1438:2: iv_ruleQualifiedNameWithWildCard= ruleQualifiedNameWithWildCard EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameWithWildCardRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard2982);
            iv_ruleQualifiedNameWithWildCard=ruleQualifiedNameWithWildCard();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedNameWithWildCard.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard2993); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1445:1: ruleQualifiedNameWithWildCard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildCard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1448:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1449:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1449:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1450:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameWithWildCardAccess().getQualifiedNameParserRuleCall_0()); 
                  
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3040);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_QualifiedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1460:1: (kw= '.*' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==37) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1461:2: kw= '.*'
                    {
                    kw=(Token)match(input,37,FollowSets000.FOLLOW_37_in_ruleQualifiedNameWithWildCard3059); if (state.failed) return current;
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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1474:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1475:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1476:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FollowSets000.FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3102);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FollowSets000.FOLLOW_EOF_in_entryRuleQualifiedName3113); if (state.failed) return current;

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
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1483:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1486:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1487:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1487:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1487:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName3153); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1494:1: (kw= '.' this_ID_2= RULE_ID )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==30) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1495:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,30,FollowSets000.FOLLOW_30_in_ruleQualifiedName3172); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FollowSets000.FOLLOW_RULE_ID_in_ruleQualifiedName3187); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop33;
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


    // $ANTLR start "ruleModuleKind"
    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1519:1: ruleModuleKind returns [Enumerator current=null] : ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) ;
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
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1521:28: ( ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) ) )
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1522:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
            {
            // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1522:1: ( (enumLiteral_0= 'UI' ) | (enumLiteral_1= 'BusinessLogic' ) | (enumLiteral_2= 'Persistence' ) | (enumLiteral_3= 'Security' ) | (enumLiteral_4= 'Batch' ) | (enumLiteral_5= 'OTHER' ) )
            int alt34=6;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt34=1;
                }
                break;
            case 39:
                {
                alt34=2;
                }
                break;
            case 40:
                {
                alt34=3;
                }
                break;
            case 41:
                {
                alt34=4;
                }
                break;
            case 42:
                {
                alt34=5;
                }
                break;
            case 43:
                {
                alt34=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1522:2: (enumLiteral_0= 'UI' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1522:2: (enumLiteral_0= 'UI' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1522:4: enumLiteral_0= 'UI'
                    {
                    enumLiteral_0=(Token)match(input,38,FollowSets000.FOLLOW_38_in_ruleModuleKind3252); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_0, grammarAccess.getModuleKindAccess().getUIEnumLiteralDeclaration_0()); 
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1528:6: (enumLiteral_1= 'BusinessLogic' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1528:6: (enumLiteral_1= 'BusinessLogic' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1528:8: enumLiteral_1= 'BusinessLogic'
                    {
                    enumLiteral_1=(Token)match(input,39,FollowSets000.FOLLOW_39_in_ruleModuleKind3269); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_1, grammarAccess.getModuleKindAccess().getBusinessLogicEnumLiteralDeclaration_1()); 
                          
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1534:6: (enumLiteral_2= 'Persistence' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1534:6: (enumLiteral_2= 'Persistence' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1534:8: enumLiteral_2= 'Persistence'
                    {
                    enumLiteral_2=(Token)match(input,40,FollowSets000.FOLLOW_40_in_ruleModuleKind3286); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_2, grammarAccess.getModuleKindAccess().getPersistenceEnumLiteralDeclaration_2()); 
                          
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1540:6: (enumLiteral_3= 'Security' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1540:6: (enumLiteral_3= 'Security' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1540:8: enumLiteral_3= 'Security'
                    {
                    enumLiteral_3=(Token)match(input,41,FollowSets000.FOLLOW_41_in_ruleModuleKind3303); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_3, grammarAccess.getModuleKindAccess().getSecurityEnumLiteralDeclaration_3()); 
                          
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1546:6: (enumLiteral_4= 'Batch' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1546:6: (enumLiteral_4= 'Batch' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1546:8: enumLiteral_4= 'Batch'
                    {
                    enumLiteral_4=(Token)match(input,42,FollowSets000.FOLLOW_42_in_ruleModuleKind3320); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current = grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                              newLeafNode(enumLiteral_4, grammarAccess.getModuleKindAccess().getBatchEnumLiteralDeclaration_4()); 
                          
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1552:6: (enumLiteral_5= 'OTHER' )
                    {
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1552:6: (enumLiteral_5= 'OTHER' )
                    // ../org.fornax.soa.solutiondsl/src-gen/org/fornax/soa/parser/antlr/internal/InternalSolutionDsl.g:1552:8: enumLiteral_5= 'OTHER'
                    {
                    enumLiteral_5=(Token)match(input,43,FollowSets000.FOLLOW_43_in_ruleModuleKind3337); if (state.failed) return current;
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

    // Delegated rules


 

    
    private static class FollowSets000 {
        public static final BitSet FOLLOW_ruleModel_in_entryRuleModel81 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModel91 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_ruleModel137 = new BitSet(new long[]{0x0000000020000802L});
        public static final BitSet FOLLOW_ruleSolution_in_ruleModel159 = new BitSet(new long[]{0x0000000000000802L});
        public static final BitSet FOLLOW_ruleSolution_in_entryRuleSolution196 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleSolution206 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_11_in_ruleSolution243 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution264 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleSolution276 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_13_in_ruleSolution289 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSolution316 = new BitSet(new long[]{0x0000000008002000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleSolution339 = new BitSet(new long[]{0x00000000101BC000L});
        public static final BitSet FOLLOW_ruleProductVersion_in_ruleSolution360 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_14_in_ruleSolution374 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleSolution395 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleSolution418 = new BitSet(new long[]{0x00000000001B8000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleSolution440 = new BitSet(new long[]{0x0000000000038000L});
        public static final BitSet FOLLOW_15_in_ruleSolution454 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleSolution478 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleSolution493 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleModule_in_entryRuleModule529 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleModule539 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_17_in_ruleModule576 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModule593 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleModule610 = new BitSet(new long[]{0x0000000000040000L});
        public static final BitSet FOLLOW_18_in_ruleModule622 = new BitSet(new long[]{0x00000FC000000000L});
        public static final BitSet FOLLOW_ruleModuleKind_in_ruleModule643 = new BitSet(new long[]{0x00000000081BE000L});
        public static final BitSet FOLLOW_ruleVersion_in_ruleModule664 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_14_in_ruleModule678 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleModule699 = new BitSet(new long[]{0x00000000001BC000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleModule722 = new BitSet(new long[]{0x00000000001B8000L});
        public static final BitSet FOLLOW_ruleModule_in_ruleModule744 = new BitSet(new long[]{0x0000000000038000L});
        public static final BitSet FOLLOW_15_in_ruleModule758 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleModule782 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleModule797 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFeature_in_entryRuleFeature833 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFeature843 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_19_in_ruleFeature886 = new BitSet(new long[]{0x0000000000100000L});
        public static final BitSet FOLLOW_20_in_ruleFeature912 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFeature929 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature946 = new BitSet(new long[]{0x0000000001F9C000L});
        public static final BitSet FOLLOW_21_in_ruleFeature959 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature976 = new BitSet(new long[]{0x0000000001D9C020L});
        public static final BitSet FOLLOW_22_in_ruleFeature997 = new BitSet(new long[]{0x0000000000000020L});
        public static final BitSet FOLLOW_RULE_STRING_in_ruleFeature1014 = new BitSet(new long[]{0x000000000199C000L});
        public static final BitSet FOLLOW_23_in_ruleFeature1034 = new BitSet(new long[]{0x0000000000001000L});
        public static final BitSet FOLLOW_12_in_ruleFeature1046 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_ruleFeature1067 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleFeature1080 = new BitSet(new long[]{0x000000000119C000L});
        public static final BitSet FOLLOW_14_in_ruleFeature1095 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleServiceRef_in_ruleFeature1116 = new BitSet(new long[]{0x000000000119C000L});
        public static final BitSet FOLLOW_24_in_ruleFeature1131 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEventRef_in_ruleFeature1152 = new BitSet(new long[]{0x0000000002198000L});
        public static final BitSet FOLLOW_25_in_ruleFeature1165 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleEventRef_in_ruleFeature1186 = new BitSet(new long[]{0x0000000002198000L});
        public static final BitSet FOLLOW_ruleFeature_in_ruleFeature1211 = new BitSet(new long[]{0x0000000000198000L});
        public static final BitSet FOLLOW_15_in_ruleFeature1225 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleFeature1249 = new BitSet(new long[]{0x0000000000010010L});
        public static final BitSet FOLLOW_16_in_ruleFeature1264 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleServiceRef_in_entryRuleServiceRef1300 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleServiceRef1310 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleServiceRef1362 = new BitSet(new long[]{0x0000001980000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleServiceRef1383 = new BitSet(new long[]{0x0000000004000002L});
        public static final BitSet FOLLOW_26_in_ruleServiceRef1401 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleCapabilityRef_in_entryRuleCapabilityRef1451 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleCapabilityRef1461 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCapabilityRef1513 = new BitSet(new long[]{0x0000001980000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleCapabilityRef1534 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersion_in_entryRuleVersion1570 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersion1580 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_27_in_ruleVersion1617 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleVersion1638 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleProductVersion_in_entryRuleProductVersion1674 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleProductVersion1684 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_28_in_ruleProductVersion1721 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleProductVersion1742 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleEventRef_in_entryRuleEventRef1778 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleEventRef1788 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleEventRef1840 = new BitSet(new long[]{0x0000001980000000L});
        public static final BitSet FOLLOW_ruleVersionRef_in_ruleEventRef1861 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleImport_in_entryRuleImport1897 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleImport1907 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_29_in_ruleImport1944 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_ruleImport1965 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionId_in_entryRuleVersionId2002 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionId2013 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId2053 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleVersionId2072 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleVersionId2087 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleVersionId2108 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleVersionId2123 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleVersionRef_in_entryRuleVersionRef2172 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleVersionRef2182 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_ruleVersionRef2232 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_ruleVersionRef2262 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_ruleVersionRef2292 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_ruleVersionRef2322 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_ruleVersionRef2352 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMinVersionRef_in_entryRuleMinVersionRef2387 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMinVersionRef2397 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleMinVersionRef2434 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMinVersionRef2455 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMaxVersionRef_in_entryRuleMaxVersionRef2491 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMaxVersionRef2501 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_32_in_ruleMaxVersionRef2538 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleMaxVersionRef2559 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleLowerBoundRangeVersionRef_in_entryRuleLowerBoundRangeVersionRef2595 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleLowerBoundRangeVersionRef2605 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_31_in_ruleLowerBoundRangeVersionRef2643 = new BitSet(new long[]{0x0000000200000000L});
        public static final BitSet FOLLOW_33_in_ruleLowerBoundRangeVersionRef2655 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2677 = new BitSet(new long[]{0x0000000002000000L});
        public static final BitSet FOLLOW_25_in_ruleLowerBoundRangeVersionRef2689 = new BitSet(new long[]{0x0000000100000000L});
        public static final BitSet FOLLOW_32_in_ruleLowerBoundRangeVersionRef2702 = new BitSet(new long[]{0x0000000400000000L});
        public static final BitSet FOLLOW_34_in_ruleLowerBoundRangeVersionRef2714 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleLowerBoundRangeVersionRef2736 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleMajorVersionRef_in_entryRuleMajorVersionRef2772 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleMajorVersionRef2782 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_35_in_ruleMajorVersionRef2819 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_RULE_INT_in_ruleMajorVersionRef2836 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleFixedVersionRef_in_entryRuleFixedVersionRef2877 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleFixedVersionRef2887 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_36_in_ruleFixedVersionRef2924 = new BitSet(new long[]{0x0000000000000040L});
        public static final BitSet FOLLOW_ruleVersionId_in_ruleFixedVersionRef2945 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedNameWithWildCard_in_entryRuleQualifiedNameWithWildCard2982 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildCard2993 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildCard3040 = new BitSet(new long[]{0x0000002000000002L});
        public static final BitSet FOLLOW_37_in_ruleQualifiedNameWithWildCard3059 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3102 = new BitSet(new long[]{0x0000000000000000L});
        public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3113 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3153 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_30_in_ruleQualifiedName3172 = new BitSet(new long[]{0x0000000000000010L});
        public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3187 = new BitSet(new long[]{0x0000000040000002L});
        public static final BitSet FOLLOW_38_in_ruleModuleKind3252 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_39_in_ruleModuleKind3269 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_40_in_ruleModuleKind3286 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_41_in_ruleModuleKind3303 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_42_in_ruleModuleKind3320 = new BitSet(new long[]{0x0000000000000002L});
        public static final BitSet FOLLOW_43_in_ruleModuleKind3337 = new BitSet(new long[]{0x0000000000000002L});
    }


}