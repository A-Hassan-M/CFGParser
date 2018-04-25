package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class Extention extends Node{

	public Extention() {
		classTokens  =  new ArrayList<>();
		classTokens.add(new TerminalNode("< EXTENDS >", "extends"));
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
        return 1;
    }

}
