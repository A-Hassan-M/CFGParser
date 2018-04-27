package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class CommaTypeIdentifiers extends Node{
  
	public CommaTypeIdentifiers() {
		// “,”  Type  Identifier  CommaTypeIdentifier  |  λ
		takesLamda = true;
		classTokens = new ArrayList<>();
		classTokens.add(new TerminalNode("< COMMA >", ","));
		classTokens.add(new Type());
		classTokens.add(new TerminalNode("< ID >","x"));
	}
	
    @Override
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        int matched = super.matches(tokens, takesLamda);
        if(!tokens.isEmpty()&&matched>0){
        	CommaTypeIdentifiers arguments = new CommaTypeIdentifiers();
            if(arguments.matches(tokens, takesLamda) > 0) // may be -1 not only 0
                classTokens.add(arguments);
            return 1;
        }else return matched;
    }
}
