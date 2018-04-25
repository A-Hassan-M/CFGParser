package Parser.NonTerminals;

import java.util.ArrayList;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.Statement.StatementChecker;

//TODO::Implement this class
public class MethodDelcaration extends Node{

	public MethodDelcaration() {
		//(“public”  |  “private  |  “protected”)  Type  Identifier
		//“(“  TypeIdentifier  “)”		“{“  VarDeclaration`  Statement`  “return”  Expression  “;”  “}”
		
		// need make switch in it 
		
		classTokens = new ArrayList<>();
		classTokens.add(new Type());
		classTokens.add(new TerminalNode("< ID >", "x"));
		classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
		classTokens.add(new TypeIdentifier());
		classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
		classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
		classTokens.add(new VarsDeclaration());
		classTokens.add(new StatementChecker());
		classTokens.add(new TerminalNode("< RETURN >", "return"));
		classTokens.add(new Expression());
		classTokens.add(new TerminalNode("< SEMICOLON >", ";"));
		classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
	}

}
