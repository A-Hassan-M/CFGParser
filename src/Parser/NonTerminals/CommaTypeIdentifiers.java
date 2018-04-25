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
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return -1;
            }
            i++;
        }
        if(!tokens.isEmpty()){
        	CommaTypeIdentifiers arguments = new CommaTypeIdentifiers();
            if(arguments.matches(tokens) > 0) // may be -1 not only 0
                classTokens.add(arguments);
        }
        return 1;
    }
}
