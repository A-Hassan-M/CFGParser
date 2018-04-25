package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class VarDeclaration extends Node {

	public VarDeclaration() {
		//Type  Identifier  “;”
		classTokens = new ArrayList<>();
		classTokens.add(new Type());
		classTokens.add(new TerminalNode("< ID >", "x"));
		classTokens.add(new TerminalNode("< SEMICOLON >", ";"));
		
	}
}
