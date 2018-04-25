package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class ArrayBrackets extends Node{
    
	public ArrayBrackets() {
		classTokens = new ArrayList<>();
		classTokens.add(new TerminalNode("< LEFT_SQUARE_B >", "["));
		classTokens.add(new TerminalNode("RIGHT_SQUARE_B", "]"));
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
