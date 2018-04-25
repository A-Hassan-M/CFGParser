package Parser.NonTerminals.Expression;

import Parser.NonTerminals.ExpressionDash;
import Parser.NonTerminals.Node;

import java.util.ArrayList;

public class Expression extends Node {

    public Expression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new ExpBiginning());
        classTokens.add(new ExpressionDash());
    }


    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return 0;
            }else if(matched == -1){
                classTokens.remove(i);
            }else {
                i++;
            }
        }
        return 1;
    }

}
