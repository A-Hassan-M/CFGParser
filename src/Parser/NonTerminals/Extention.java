package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class Extention extends Node{

	public Extention(boolean takesLamda) {
        this.takesLamda = takesLamda;
        classTokens  =  new ArrayList<>();
		classTokens.add(new TerminalNode("< EXTENDS >", "extends"));
		classTokens.add(new TerminalNode("< ID >","x"));
	}
	
}
