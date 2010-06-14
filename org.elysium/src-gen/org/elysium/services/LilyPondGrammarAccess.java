/*
* generated by Xtext
*/

package org.elysium.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class LilyPondGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class LilyPondElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LilyPond");
		private final Assignment cExpressionsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_0 = (RuleCall)cExpressionsAssignment.eContents().get(0);
		
		//LilyPond:
		//	expressions+=Expression*;
		public ParserRule getRule() { return rule; }

		//expressions+=Expression*
		public Assignment getExpressionsAssignment() { return cExpressionsAssignment; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_0() { return cExpressionsExpressionParserRuleCall_0; }
	}

	public class ExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Expression");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cBlockParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSchemeParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cCommandParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cTextParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cNumberParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//Expression:
		//	Block | Scheme | Command | Text | Number;
		public ParserRule getRule() { return rule; }

		//Block | Scheme | Command | Text | Number
		public Alternatives getAlternatives() { return cAlternatives; }

		//Block
		public RuleCall getBlockParserRuleCall_0() { return cBlockParserRuleCall_0; }

		//Scheme
		public RuleCall getSchemeParserRuleCall_1() { return cSchemeParserRuleCall_1; }

		//Command
		public RuleCall getCommandParserRuleCall_2() { return cCommandParserRuleCall_2; }

		//Text
		public RuleCall getTextParserRuleCall_3() { return cTextParserRuleCall_3; }

		//Number
		public RuleCall getNumberParserRuleCall_4() { return cNumberParserRuleCall_4; }
	}

	public class BlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Block");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSimpleBlockParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSimultaneousBlockParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Block:
		//	SimpleBlock | SimultaneousBlock;
		public ParserRule getRule() { return rule; }

		//SimpleBlock | SimultaneousBlock
		public Alternatives getAlternatives() { return cAlternatives; }

		//SimpleBlock
		public RuleCall getSimpleBlockParserRuleCall_0() { return cSimpleBlockParserRuleCall_0; }

		//SimultaneousBlock
		public RuleCall getSimultaneousBlockParserRuleCall_1() { return cSimultaneousBlockParserRuleCall_1; }
	}

	public class SimpleBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimpleBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSimpleBlockAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLeftCurlyBracketKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExpressionsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionsExpressionParserRuleCall_2_0 = (RuleCall)cExpressionsAssignment_2.eContents().get(0);
		private final Keyword cRightCurlyBracketKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//SimpleBlock:
		//	{SimpleBlock} "{" expressions+=Expression* "}";
		public ParserRule getRule() { return rule; }

		//{SimpleBlock} "{" expressions+=Expression* "}"
		public Group getGroup() { return cGroup; }

		//{SimpleBlock}
		public Action getSimpleBlockAction_0() { return cSimpleBlockAction_0; }

		//"{"
		public Keyword getLeftCurlyBracketKeyword_1() { return cLeftCurlyBracketKeyword_1; }

		//expressions+=Expression*
		public Assignment getExpressionsAssignment_2() { return cExpressionsAssignment_2; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_2_0() { return cExpressionsExpressionParserRuleCall_2_0; }

		//"}"
		public Keyword getRightCurlyBracketKeyword_3() { return cRightCurlyBracketKeyword_3; }
	}

	public class SimultaneousBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SimultaneousBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cSimultaneousBlockAction_0 = (Action)cGroup.eContents().get(0);
		private final Keyword cLessThanSignLessThanSignKeyword_1 = (Keyword)cGroup.eContents().get(1);
		private final Assignment cExpressionsAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cExpressionsExpressionParserRuleCall_2_0 = (RuleCall)cExpressionsAssignment_2.eContents().get(0);
		private final Keyword cGreaterThanSignGreaterThanSignKeyword_3 = (Keyword)cGroup.eContents().get(3);
		
		//SimultaneousBlock:
		//	{SimultaneousBlock} "<<" expressions+=Expression* ">>";
		public ParserRule getRule() { return rule; }

		//{SimultaneousBlock} "<<" expressions+=Expression* ">>"
		public Group getGroup() { return cGroup; }

		//{SimultaneousBlock}
		public Action getSimultaneousBlockAction_0() { return cSimultaneousBlockAction_0; }

		//"<<"
		public Keyword getLessThanSignLessThanSignKeyword_1() { return cLessThanSignLessThanSignKeyword_1; }

		//expressions+=Expression*
		public Assignment getExpressionsAssignment_2() { return cExpressionsAssignment_2; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_2_0() { return cExpressionsExpressionParserRuleCall_2_0; }

		//">>"
		public Keyword getGreaterThanSignGreaterThanSignKeyword_3() { return cGreaterThanSignGreaterThanSignKeyword_3; }
	}

	public class SchemeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Scheme");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumberSignKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSchemeExpressionParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//Scheme:
		//	"#" value=SchemeExpression;
		public ParserRule getRule() { return rule; }

		//"#" value=SchemeExpression
		public Group getGroup() { return cGroup; }

		//"#"
		public Keyword getNumberSignKeyword_0() { return cNumberSignKeyword_0; }

		//value=SchemeExpression
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//SchemeExpression
		public RuleCall getValueSchemeExpressionParserRuleCall_1_0() { return cValueSchemeExpressionParserRuleCall_1_0; }
	}

	public class SchemeExpressionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SchemeExpression");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cQuotedAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final Keyword cQuotedApostropheKeyword_0_0 = (Keyword)cQuotedAssignment_0.eContents().get(0);
		private final Assignment cValueAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cValueSchemeValueParserRuleCall_1_0 = (RuleCall)cValueAssignment_1.eContents().get(0);
		
		//SchemeExpression:
		//	quoted?="\'"? value=SchemeValue;
		public ParserRule getRule() { return rule; }

		//quoted?="\'"? value=SchemeValue
		public Group getGroup() { return cGroup; }

		//quoted?="\'"?
		public Assignment getQuotedAssignment_0() { return cQuotedAssignment_0; }

		//"\'"
		public Keyword getQuotedApostropheKeyword_0_0() { return cQuotedApostropheKeyword_0_0; }

		//value=SchemeValue
		public Assignment getValueAssignment_1() { return cValueAssignment_1; }

		//SchemeValue
		public RuleCall getValueSchemeValueParserRuleCall_1_0() { return cValueSchemeValueParserRuleCall_1_0; }
	}

	public class SchemeValueElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SchemeValue");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSchemeBooleanParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cSchemeListParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSchemeBlockParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cSchemeTextParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cNumberParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//SchemeValue:
		//	SchemeBoolean | SchemeList | SchemeBlock | SchemeText | Number;
		public ParserRule getRule() { return rule; }

		//SchemeBoolean | SchemeList | SchemeBlock | SchemeText | Number
		public Alternatives getAlternatives() { return cAlternatives; }

		//SchemeBoolean
		public RuleCall getSchemeBooleanParserRuleCall_0() { return cSchemeBooleanParserRuleCall_0; }

		//SchemeList
		public RuleCall getSchemeListParserRuleCall_1() { return cSchemeListParserRuleCall_1; }

		//SchemeBlock
		public RuleCall getSchemeBlockParserRuleCall_2() { return cSchemeBlockParserRuleCall_2; }

		//SchemeText
		public RuleCall getSchemeTextParserRuleCall_3() { return cSchemeTextParserRuleCall_3; }

		//Number
		public RuleCall getNumberParserRuleCall_4() { return cNumberParserRuleCall_4; }
	}

	public class SchemeBooleanElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SchemeBoolean");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueBOOLTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//SchemeBoolean:
		//	value=BOOL;
		public ParserRule getRule() { return rule; }

		//value=BOOL
		public Assignment getValueAssignment() { return cValueAssignment; }

		//BOOL
		public RuleCall getValueBOOLTerminalRuleCall_0() { return cValueBOOLTerminalRuleCall_0; }
	}

	public class SchemeListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SchemeList");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cLeftParenthesisKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionsSchemeExpressionParserRuleCall_1_0 = (RuleCall)cExpressionsAssignment_1.eContents().get(0);
		private final Keyword cRightParenthesisKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//SchemeList:
		//	"(" expressions+=SchemeExpression+ ")";
		public ParserRule getRule() { return rule; }

		//"(" expressions+=SchemeExpression+ ")"
		public Group getGroup() { return cGroup; }

		//"("
		public Keyword getLeftParenthesisKeyword_0() { return cLeftParenthesisKeyword_0; }

		//expressions+=SchemeExpression+
		public Assignment getExpressionsAssignment_1() { return cExpressionsAssignment_1; }

		//SchemeExpression
		public RuleCall getExpressionsSchemeExpressionParserRuleCall_1_0() { return cExpressionsSchemeExpressionParserRuleCall_1_0; }

		//")"
		public Keyword getRightParenthesisKeyword_2() { return cRightParenthesisKeyword_2; }
	}

	public class SchemeBlockElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SchemeBlock");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumberSignLeftCurlyBracketKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cExpressionsAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cExpressionsExpressionParserRuleCall_1_0 = (RuleCall)cExpressionsAssignment_1.eContents().get(0);
		private final Keyword cNumberSignRightCurlyBracketKeyword_2 = (Keyword)cGroup.eContents().get(2);
		
		//SchemeBlock:
		//	"#{" expressions+=Expression+ "#}";
		public ParserRule getRule() { return rule; }

		//"#{" expressions+=Expression+ "#}"
		public Group getGroup() { return cGroup; }

		//"#{"
		public Keyword getNumberSignLeftCurlyBracketKeyword_0() { return cNumberSignLeftCurlyBracketKeyword_0; }

		//expressions+=Expression+
		public Assignment getExpressionsAssignment_1() { return cExpressionsAssignment_1; }

		//Expression
		public RuleCall getExpressionsExpressionParserRuleCall_1_0() { return cExpressionsExpressionParserRuleCall_1_0; }

		//"#}"
		public Keyword getNumberSignRightCurlyBracketKeyword_2() { return cNumberSignRightCurlyBracketKeyword_2; }
	}

	public class SchemeTextElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SchemeText");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueSchemeTextLiteralsParserRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//SchemeText:
		//	value=SchemeTextLiterals;
		public ParserRule getRule() { return rule; }

		//value=SchemeTextLiterals
		public Assignment getValueAssignment() { return cValueAssignment; }

		//SchemeTextLiterals
		public RuleCall getValueSchemeTextLiteralsParserRuleCall_0() { return cValueSchemeTextLiteralsParserRuleCall_0; }
	}

	public class SchemeTextLiteralsElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "SchemeTextLiterals");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Keyword cReverseSolidusReverseSolidusKeyword_0 = (Keyword)cAlternatives.eContents().get(0);
		private final RuleCall cIDTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cSTRINGTerminalRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cANY_OTHERTerminalRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		
		//SchemeTextLiterals returns ecore::EString:
		//	"\\\\" | ID | STRING | ANY_OTHER;
		public ParserRule getRule() { return rule; }

		//"\\\\" | ID | STRING | ANY_OTHER
		public Alternatives getAlternatives() { return cAlternatives; }

		//"\\\\"
		public Keyword getReverseSolidusReverseSolidusKeyword_0() { return cReverseSolidusReverseSolidusKeyword_0; }

		//ID
		public RuleCall getIDTerminalRuleCall_1() { return cIDTerminalRuleCall_1; }

		//STRING
		public RuleCall getSTRINGTerminalRuleCall_2() { return cSTRINGTerminalRuleCall_2; }

		//ANY_OTHER
		public RuleCall getANY_OTHERTerminalRuleCall_3() { return cANY_OTHERTerminalRuleCall_3; }
	}

	public class CommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Command");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cCustomCommandParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cPresetCommandParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//Command:
		//	CustomCommand | PresetCommand;
		public ParserRule getRule() { return rule; }

		//CustomCommand | PresetCommand
		public Alternatives getAlternatives() { return cAlternatives; }

		//CustomCommand
		public RuleCall getCustomCommandParserRuleCall_0() { return cCustomCommandParserRuleCall_0; }

		//PresetCommand
		public RuleCall getPresetCommandParserRuleCall_1() { return cPresetCommandParserRuleCall_1; }
	}

	public class CustomCommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "CustomCommand");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cLongCommandParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cShortCommandParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//CustomCommand:
		//	LongCommand | ShortCommand;
		public ParserRule getRule() { return rule; }

		//LongCommand | ShortCommand
		public Alternatives getAlternatives() { return cAlternatives; }

		//LongCommand
		public RuleCall getLongCommandParserRuleCall_0() { return cLongCommandParserRuleCall_0; }

		//ShortCommand
		public RuleCall getShortCommandParserRuleCall_1() { return cShortCommandParserRuleCall_1; }
	}

	public class LongCommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "LongCommand");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReverseSolidusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIdAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cIdIDTerminalRuleCall_1_0 = (RuleCall)cIdAssignment_1.eContents().get(0);
		
		//LongCommand hidden():
		//	"\\" id=ID;
		public ParserRule getRule() { return rule; }

		//"\\" id=ID
		public Group getGroup() { return cGroup; }

		//"\\"
		public Keyword getReverseSolidusKeyword_0() { return cReverseSolidusKeyword_0; }

		//id=ID
		public Assignment getIdAssignment_1() { return cIdAssignment_1; }

		//ID
		public RuleCall getIdIDTerminalRuleCall_1_0() { return cIdIDTerminalRuleCall_1_0; }
	}

	public class ShortCommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "ShortCommand");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReverseSolidusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cIdAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives cIdAlternatives_1_0 = (Alternatives)cIdAssignment_1.eContents().get(0);
		private final Keyword cIdLeftParenthesisKeyword_1_0_0 = (Keyword)cIdAlternatives_1_0.eContents().get(0);
		private final Keyword cIdRightParenthesisKeyword_1_0_1 = (Keyword)cIdAlternatives_1_0.eContents().get(1);
		private final RuleCall cIdANY_OTHERTerminalRuleCall_1_0_2 = (RuleCall)cIdAlternatives_1_0.eContents().get(2);
		
		//ShortCommand hidden():
		//	"\\" id=("(" | ")" | ANY_OTHER);
		public ParserRule getRule() { return rule; }

		//"\\" id=("(" | ")" | ANY_OTHER)
		public Group getGroup() { return cGroup; }

		//"\\"
		public Keyword getReverseSolidusKeyword_0() { return cReverseSolidusKeyword_0; }

		//id=("(" | ")" | ANY_OTHER)
		public Assignment getIdAssignment_1() { return cIdAssignment_1; }

		//"(" | ")" | ANY_OTHER
		public Alternatives getIdAlternatives_1_0() { return cIdAlternatives_1_0; }

		//"("
		public Keyword getIdLeftParenthesisKeyword_1_0_0() { return cIdLeftParenthesisKeyword_1_0_0; }

		//")"
		public Keyword getIdRightParenthesisKeyword_1_0_1() { return cIdRightParenthesisKeyword_1_0_1; }

		//ANY_OTHER
		public RuleCall getIdANY_OTHERTerminalRuleCall_1_0_2() { return cIdANY_OTHERTerminalRuleCall_1_0_2; }
	}

	public class PresetCommandElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "PresetCommand");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cIncludeParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cVersionParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//PresetCommand:
		//	Include | Version;
		public ParserRule getRule() { return rule; }

		//Include | Version
		public Alternatives getAlternatives() { return cAlternatives; }

		//Include
		public RuleCall getIncludeParserRuleCall_0() { return cIncludeParserRuleCall_0; }

		//Version
		public RuleCall getVersionParserRuleCall_1() { return cVersionParserRuleCall_1; }
	}

	public class IncludeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Include");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIdAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cIdIncludeKeywordParserRuleCall_0_0 = (RuleCall)cIdAssignment_0.eContents().get(0);
		private final Assignment cImportURIAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cImportURISTRINGTerminalRuleCall_1_0 = (RuleCall)cImportURIAssignment_1.eContents().get(0);
		
		//Include:
		//	id=IncludeKeyword importURI=STRING;
		public ParserRule getRule() { return rule; }

		//id=IncludeKeyword importURI=STRING
		public Group getGroup() { return cGroup; }

		//id=IncludeKeyword
		public Assignment getIdAssignment_0() { return cIdAssignment_0; }

		//IncludeKeyword
		public RuleCall getIdIncludeKeywordParserRuleCall_0_0() { return cIdIncludeKeywordParserRuleCall_0_0; }

		//importURI=STRING
		public Assignment getImportURIAssignment_1() { return cImportURIAssignment_1; }

		//STRING
		public RuleCall getImportURISTRINGTerminalRuleCall_1_0() { return cImportURISTRINGTerminalRuleCall_1_0; }
	}

	public class IncludeKeywordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "IncludeKeyword");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReverseSolidusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cIncludeKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//IncludeKeyword returns ecore::EString hidden():
		//	"\\" "include";
		public ParserRule getRule() { return rule; }

		//"\\" "include"
		public Group getGroup() { return cGroup; }

		//"\\"
		public Keyword getReverseSolidusKeyword_0() { return cReverseSolidusKeyword_0; }

		//"include"
		public Keyword getIncludeKeyword_1() { return cIncludeKeyword_1; }
	}

	public class VersionElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Version");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cIdAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cIdVersionKeywordParserRuleCall_0_0 = (RuleCall)cIdAssignment_0.eContents().get(0);
		private final Assignment cVersionAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cVersionSTRINGTerminalRuleCall_1_0 = (RuleCall)cVersionAssignment_1.eContents().get(0);
		
		//Version:
		//	id=VersionKeyword version=STRING;
		public ParserRule getRule() { return rule; }

		//id=VersionKeyword version=STRING
		public Group getGroup() { return cGroup; }

		//id=VersionKeyword
		public Assignment getIdAssignment_0() { return cIdAssignment_0; }

		//VersionKeyword
		public RuleCall getIdVersionKeywordParserRuleCall_0_0() { return cIdVersionKeywordParserRuleCall_0_0; }

		//version=STRING
		public Assignment getVersionAssignment_1() { return cVersionAssignment_1; }

		//STRING
		public RuleCall getVersionSTRINGTerminalRuleCall_1_0() { return cVersionSTRINGTerminalRuleCall_1_0; }
	}

	public class VersionKeywordElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "VersionKeyword");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cReverseSolidusKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Keyword cVersionKeyword_1 = (Keyword)cGroup.eContents().get(1);
		
		//VersionKeyword returns ecore::EString hidden():
		//	"\\" "version";
		public ParserRule getRule() { return rule; }

		//"\\" "version"
		public Group getGroup() { return cGroup; }

		//"\\"
		public Keyword getReverseSolidusKeyword_0() { return cReverseSolidusKeyword_0; }

		//"version"
		public Keyword getVersionKeyword_1() { return cVersionKeyword_1; }
	}

	public class TextElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Text");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final Alternatives cValueAlternatives_0 = (Alternatives)cValueAssignment.eContents().get(0);
		private final RuleCall cValueSchemeTextLiteralsParserRuleCall_0_0 = (RuleCall)cValueAlternatives_0.eContents().get(0);
		private final Keyword cValueApostropheKeyword_0_1 = (Keyword)cValueAlternatives_0.eContents().get(1);
		private final Keyword cValueCommaKeyword_0_2 = (Keyword)cValueAlternatives_0.eContents().get(2);
		private final Keyword cValueLeftParenthesisKeyword_0_3 = (Keyword)cValueAlternatives_0.eContents().get(3);
		private final Keyword cValueRightParenthesisKeyword_0_4 = (Keyword)cValueAlternatives_0.eContents().get(4);
		
		//// Keywords of preset commands must be defined this way to avoid clash with commands that share a common prefix with them due to eager parsing
		//Text:
		//	value=(SchemeTextLiterals | "\'" | "," | "(" | ")");
		public ParserRule getRule() { return rule; }

		//value=(SchemeTextLiterals | "\'" | "," | "(" | ")")
		public Assignment getValueAssignment() { return cValueAssignment; }

		//SchemeTextLiterals | "\'" | "," | "(" | ")"
		public Alternatives getValueAlternatives_0() { return cValueAlternatives_0; }

		//SchemeTextLiterals
		public RuleCall getValueSchemeTextLiteralsParserRuleCall_0_0() { return cValueSchemeTextLiteralsParserRuleCall_0_0; }

		//"\'"
		public Keyword getValueApostropheKeyword_0_1() { return cValueApostropheKeyword_0_1; }

		//","
		public Keyword getValueCommaKeyword_0_2() { return cValueCommaKeyword_0_2; }

		//"("
		public Keyword getValueLeftParenthesisKeyword_0_3() { return cValueLeftParenthesisKeyword_0_3; }

		//")"
		public Keyword getValueRightParenthesisKeyword_0_4() { return cValueRightParenthesisKeyword_0_4; }
	}

	public class NumberElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Number");
		private final Assignment cValueAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cValueINTTerminalRuleCall_0 = (RuleCall)cValueAssignment.eContents().get(0);
		
		//Number:
		//	value=INT;
		public ParserRule getRule() { return rule; }

		//value=INT
		public Assignment getValueAssignment() { return cValueAssignment; }

		//INT
		public RuleCall getValueINTTerminalRuleCall_0() { return cValueINTTerminalRuleCall_0; }
	}
	
	
	private LilyPondElements pLilyPond;
	private ExpressionElements pExpression;
	private BlockElements pBlock;
	private SimpleBlockElements pSimpleBlock;
	private SimultaneousBlockElements pSimultaneousBlock;
	private SchemeElements pScheme;
	private SchemeExpressionElements pSchemeExpression;
	private SchemeValueElements pSchemeValue;
	private SchemeBooleanElements pSchemeBoolean;
	private SchemeListElements pSchemeList;
	private SchemeBlockElements pSchemeBlock;
	private SchemeTextElements pSchemeText;
	private SchemeTextLiteralsElements pSchemeTextLiterals;
	private CommandElements pCommand;
	private CustomCommandElements pCustomCommand;
	private LongCommandElements pLongCommand;
	private ShortCommandElements pShortCommand;
	private PresetCommandElements pPresetCommand;
	private IncludeElements pInclude;
	private IncludeKeywordElements pIncludeKeyword;
	private VersionElements pVersion;
	private VersionKeywordElements pVersionKeyword;
	private TextElements pText;
	private NumberElements pNumber;
	private TerminalRule tSTRING;
	private TerminalRule tINT;
	private TerminalRule tBOOL;
	private TerminalRule tID;
	private TerminalRule tWS;
	private TerminalRule tSL_COMMENT;
	private TerminalRule tML_COMMENT;
	private TerminalRule tANY_OTHER;
	
	private final GrammarProvider grammarProvider;

	@Inject
	public LilyPondGrammarAccess(GrammarProvider grammarProvider) {
		this.grammarProvider = grammarProvider;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	
	//LilyPond:
	//	expressions+=Expression*;
	public LilyPondElements getLilyPondAccess() {
		return (pLilyPond != null) ? pLilyPond : (pLilyPond = new LilyPondElements());
	}
	
	public ParserRule getLilyPondRule() {
		return getLilyPondAccess().getRule();
	}

	//Expression:
	//	Block | Scheme | Command | Text | Number;
	public ExpressionElements getExpressionAccess() {
		return (pExpression != null) ? pExpression : (pExpression = new ExpressionElements());
	}
	
	public ParserRule getExpressionRule() {
		return getExpressionAccess().getRule();
	}

	//Block:
	//	SimpleBlock | SimultaneousBlock;
	public BlockElements getBlockAccess() {
		return (pBlock != null) ? pBlock : (pBlock = new BlockElements());
	}
	
	public ParserRule getBlockRule() {
		return getBlockAccess().getRule();
	}

	//SimpleBlock:
	//	{SimpleBlock} "{" expressions+=Expression* "}";
	public SimpleBlockElements getSimpleBlockAccess() {
		return (pSimpleBlock != null) ? pSimpleBlock : (pSimpleBlock = new SimpleBlockElements());
	}
	
	public ParserRule getSimpleBlockRule() {
		return getSimpleBlockAccess().getRule();
	}

	//SimultaneousBlock:
	//	{SimultaneousBlock} "<<" expressions+=Expression* ">>";
	public SimultaneousBlockElements getSimultaneousBlockAccess() {
		return (pSimultaneousBlock != null) ? pSimultaneousBlock : (pSimultaneousBlock = new SimultaneousBlockElements());
	}
	
	public ParserRule getSimultaneousBlockRule() {
		return getSimultaneousBlockAccess().getRule();
	}

	//Scheme:
	//	"#" value=SchemeExpression;
	public SchemeElements getSchemeAccess() {
		return (pScheme != null) ? pScheme : (pScheme = new SchemeElements());
	}
	
	public ParserRule getSchemeRule() {
		return getSchemeAccess().getRule();
	}

	//SchemeExpression:
	//	quoted?="\'"? value=SchemeValue;
	public SchemeExpressionElements getSchemeExpressionAccess() {
		return (pSchemeExpression != null) ? pSchemeExpression : (pSchemeExpression = new SchemeExpressionElements());
	}
	
	public ParserRule getSchemeExpressionRule() {
		return getSchemeExpressionAccess().getRule();
	}

	//SchemeValue:
	//	SchemeBoolean | SchemeList | SchemeBlock | SchemeText | Number;
	public SchemeValueElements getSchemeValueAccess() {
		return (pSchemeValue != null) ? pSchemeValue : (pSchemeValue = new SchemeValueElements());
	}
	
	public ParserRule getSchemeValueRule() {
		return getSchemeValueAccess().getRule();
	}

	//SchemeBoolean:
	//	value=BOOL;
	public SchemeBooleanElements getSchemeBooleanAccess() {
		return (pSchemeBoolean != null) ? pSchemeBoolean : (pSchemeBoolean = new SchemeBooleanElements());
	}
	
	public ParserRule getSchemeBooleanRule() {
		return getSchemeBooleanAccess().getRule();
	}

	//SchemeList:
	//	"(" expressions+=SchemeExpression+ ")";
	public SchemeListElements getSchemeListAccess() {
		return (pSchemeList != null) ? pSchemeList : (pSchemeList = new SchemeListElements());
	}
	
	public ParserRule getSchemeListRule() {
		return getSchemeListAccess().getRule();
	}

	//SchemeBlock:
	//	"#{" expressions+=Expression+ "#}";
	public SchemeBlockElements getSchemeBlockAccess() {
		return (pSchemeBlock != null) ? pSchemeBlock : (pSchemeBlock = new SchemeBlockElements());
	}
	
	public ParserRule getSchemeBlockRule() {
		return getSchemeBlockAccess().getRule();
	}

	//SchemeText:
	//	value=SchemeTextLiterals;
	public SchemeTextElements getSchemeTextAccess() {
		return (pSchemeText != null) ? pSchemeText : (pSchemeText = new SchemeTextElements());
	}
	
	public ParserRule getSchemeTextRule() {
		return getSchemeTextAccess().getRule();
	}

	//SchemeTextLiterals returns ecore::EString:
	//	"\\\\" | ID | STRING | ANY_OTHER;
	public SchemeTextLiteralsElements getSchemeTextLiteralsAccess() {
		return (pSchemeTextLiterals != null) ? pSchemeTextLiterals : (pSchemeTextLiterals = new SchemeTextLiteralsElements());
	}
	
	public ParserRule getSchemeTextLiteralsRule() {
		return getSchemeTextLiteralsAccess().getRule();
	}

	//Command:
	//	CustomCommand | PresetCommand;
	public CommandElements getCommandAccess() {
		return (pCommand != null) ? pCommand : (pCommand = new CommandElements());
	}
	
	public ParserRule getCommandRule() {
		return getCommandAccess().getRule();
	}

	//CustomCommand:
	//	LongCommand | ShortCommand;
	public CustomCommandElements getCustomCommandAccess() {
		return (pCustomCommand != null) ? pCustomCommand : (pCustomCommand = new CustomCommandElements());
	}
	
	public ParserRule getCustomCommandRule() {
		return getCustomCommandAccess().getRule();
	}

	//LongCommand hidden():
	//	"\\" id=ID;
	public LongCommandElements getLongCommandAccess() {
		return (pLongCommand != null) ? pLongCommand : (pLongCommand = new LongCommandElements());
	}
	
	public ParserRule getLongCommandRule() {
		return getLongCommandAccess().getRule();
	}

	//ShortCommand hidden():
	//	"\\" id=("(" | ")" | ANY_OTHER);
	public ShortCommandElements getShortCommandAccess() {
		return (pShortCommand != null) ? pShortCommand : (pShortCommand = new ShortCommandElements());
	}
	
	public ParserRule getShortCommandRule() {
		return getShortCommandAccess().getRule();
	}

	//PresetCommand:
	//	Include | Version;
	public PresetCommandElements getPresetCommandAccess() {
		return (pPresetCommand != null) ? pPresetCommand : (pPresetCommand = new PresetCommandElements());
	}
	
	public ParserRule getPresetCommandRule() {
		return getPresetCommandAccess().getRule();
	}

	//Include:
	//	id=IncludeKeyword importURI=STRING;
	public IncludeElements getIncludeAccess() {
		return (pInclude != null) ? pInclude : (pInclude = new IncludeElements());
	}
	
	public ParserRule getIncludeRule() {
		return getIncludeAccess().getRule();
	}

	//IncludeKeyword returns ecore::EString hidden():
	//	"\\" "include";
	public IncludeKeywordElements getIncludeKeywordAccess() {
		return (pIncludeKeyword != null) ? pIncludeKeyword : (pIncludeKeyword = new IncludeKeywordElements());
	}
	
	public ParserRule getIncludeKeywordRule() {
		return getIncludeKeywordAccess().getRule();
	}

	//Version:
	//	id=VersionKeyword version=STRING;
	public VersionElements getVersionAccess() {
		return (pVersion != null) ? pVersion : (pVersion = new VersionElements());
	}
	
	public ParserRule getVersionRule() {
		return getVersionAccess().getRule();
	}

	//VersionKeyword returns ecore::EString hidden():
	//	"\\" "version";
	public VersionKeywordElements getVersionKeywordAccess() {
		return (pVersionKeyword != null) ? pVersionKeyword : (pVersionKeyword = new VersionKeywordElements());
	}
	
	public ParserRule getVersionKeywordRule() {
		return getVersionKeywordAccess().getRule();
	}

	//// Keywords of preset commands must be defined this way to avoid clash with commands that share a common prefix with them due to eager parsing
	//Text:
	//	value=(SchemeTextLiterals | "\'" | "," | "(" | ")");
	public TextElements getTextAccess() {
		return (pText != null) ? pText : (pText = new TextElements());
	}
	
	public ParserRule getTextRule() {
		return getTextAccess().getRule();
	}

	//Number:
	//	value=INT;
	public NumberElements getNumberAccess() {
		return (pNumber != null) ? pNumber : (pNumber = new NumberElements());
	}
	
	public ParserRule getNumberRule() {
		return getNumberAccess().getRule();
	}

	//terminal STRING:
	//	"\"" ("\\" ("b" | "t" | "n" | " f" | "r" | "\"" | "\'" | "\\") | !("\\" | "\""))* "\"";
	public TerminalRule getSTRINGRule() {
		return (tSTRING != null) ? tSTRING : (tSTRING = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	//terminal INT returns ecore::EInt:
	//	"0".."9"+;
	public TerminalRule getINTRule() {
		return (tINT != null) ? tINT : (tINT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "INT"));
	} 

	//terminal BOOL returns ecore::EBoolean:
	//	"#f" | "#t";
	public TerminalRule getBOOLRule() {
		return (tBOOL != null) ? tBOOL : (tBOOL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "BOOL"));
	} 

	//terminal ID:
	//	("a".."z" | "A".."Z") ("a".."z" | "A".."Z" | "-")*;
	public TerminalRule getIDRule() {
		return (tID != null) ? tID : (tID = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	//terminal WS:
	//	(" " | "\t" | "\r" | "\n")+;
	public TerminalRule getWSRule() {
		return (tWS != null) ? tWS : (tWS = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	//terminal SL_COMMENT:
	//	"%" !("\n" | "\r")* ("\r"? "\n")?;
	public TerminalRule getSL_COMMENTRule() {
		return (tSL_COMMENT != null) ? tSL_COMMENT : (tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	//terminal ML_COMMENT:
	//	"%{"->"%}";
	public TerminalRule getML_COMMENTRule() {
		return (tML_COMMENT != null) ? tML_COMMENT : (tML_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return (tANY_OTHER != null) ? tANY_OTHER : (tANY_OTHER = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 
}
