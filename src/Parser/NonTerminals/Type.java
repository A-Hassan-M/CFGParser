package Parser.NonTerminals;

import java.util.ArrayList;

public class Type extends Node{

	String[] dataTypes = {"< INT >"," < FLOAT >", "< STRING >","< CHAR >","< BOOLEAN >"};

	public Type() {
		classTokens = new ArrayList<>();
		classTokens.add(new ArrayBrackets());
	}

	@Override
	public int matches(ArrayList<Node> tokens) {

		Node firstToken = tokens.get(0);
		for(String dataType:dataTypes){
			if(firstToken.getType().equals(dataType)){
				classTokens.add(0,firstToken);
				break;
			}
		}
		return super.matches(tokens);
	}
}
