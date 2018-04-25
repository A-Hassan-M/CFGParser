package Parser.NonTerminals;

import java.util.ArrayList;

public class NodeWithLamda extends Node{

    /**
     * @param tokens tokens that extracted from tokenizer
     * this method overrides the main method in node in case if there's any nullable tokens in class tokens
     * (token that can take lamda)
     * @return 1 if matched with all classTokens, 0 if not matched or -1 if the class is nullable
     */
    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return 0;
            }else if (matched == -1){
                //this means the token is lamda and removed from the classTokens
                classTokens.remove(i);
            }else {
                i++;
            }
        }
        return 1;
    }
}
