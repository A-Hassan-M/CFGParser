package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class TypeIdentifier extends Node{

	public TypeIdentifier() {
		// Type  Identifier  CommaTypeIdentifier  |  λ
		takesLamda = true;
		classTokens = new ArrayList<>();
		classTokens.add(new Type());
		classTokens.add(new TerminalNode("< ID >","x"));
		classTokens.add(new CommaTypeIdentifiers());
		
	}

}
