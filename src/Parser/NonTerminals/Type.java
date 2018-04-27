package Parser.NonTerminals;

import java.util.ArrayList;

public class Type extends Node{

	public Type() {
		classTokens = new ArrayList<>();
		classTokens.add(new ArrayBrackets());
	}

	@Override
	public int matches(ArrayList<Node> tokens, boolean takesLamda) {

		Node firstToken = tokens.get(0);
		switch (firstToken.type) {
			case "< INT >":
				classTokens.add(0,new TerminalNode("< INT >","int"));
				break;
			case "< BOOLEAN >":
				classTokens.add(0, new TerminalNode("< BOOLEAN >","boolean"));
				break;
			case "< FLOAT >":
				classTokens.add(0, new TerminalNode("< FLOAT >","float"));
				break;
			case "< STRING >":
				classTokens.add(0, new TerminalNode("< STRING >","string"));
				break;
			case "< CHAR >":
				classTokens.add(0, new TerminalNode("< CHAR >","char"));
				break;
			default:
				return 0;
		}
		return super.matches(tokens, takesLamda);
	}
}
