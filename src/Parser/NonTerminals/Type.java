package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class Type extends Node{

	public Type() {
		// (“int”  |  “boolean”  |  “float”  |  “String”  |  “char”)  Brackets
		// make Switch 
		classTokens = new ArrayList<>();
		classTokens.add(new ArrayBrackets());
	}

}
