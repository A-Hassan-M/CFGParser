package Parser.NonTerminals;

import java.util.ArrayList;

import Parser.NonTerminals.Statement.StatementChecker;

//TODO::Implement this class
public class ConstructorDeclaration extends Node{

	public ConstructorDeclaration() {
		//Identifier“(“  TypeIdentifier “)”	“{“  VarDeclaration`  Statement`  “}”
		classTokens = new ArrayList<>();
		classTokens.add(new TerminalNode("< ID >", "x"));
		classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
		classTokens.add(new TypeIdentifier());
		classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
		classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
		classTokens.add(new VarsDeclaration());
		classTokens.add(new StatementChecker());
        classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
		
	}

}
