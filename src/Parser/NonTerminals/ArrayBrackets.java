package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class ArrayBrackets extends Node{
    
	public ArrayBrackets() {
		takesLamda = true;
		classTokens = new ArrayList<>();
		classTokens.add(new TerminalNode("< LEFT_SQUARE_B >", "["));
		classTokens.add(new TerminalNode("RIGHT_SQUARE_B", "]"));
	}
}
