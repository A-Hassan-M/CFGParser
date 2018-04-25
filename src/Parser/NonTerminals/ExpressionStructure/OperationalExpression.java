package Parser.NonTerminals.ExpressionStructure;

import Parser.NonTerminals.*;
import Parser.NonTerminals.Expression.Expression;

import java.util.ArrayList;

public class OperationalExpression extends Node {

    String[] operations = {"&&", "||", "==", "!=", ">", "<", "<=", ">=", "+", "-", "*", "/"};

    public OperationalExpression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new TerminalNode("< EQUAL >","=="));
        classTokens.add(new Expression());
    }

    @Override
    public String getValue() {
        return super.getValue();
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        Node firstToken = tokens.get(0);
        int i= 1;
        int matched = checkOperation(firstToken);

        if (matched==0) return 0;

        tokens.remove(0);
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            matched = classTokens.get(i).matches(tokens);
            if(matched==0){
                return 0;
            }
            i++;
        }
        return 1;
    }

    private int checkOperation(Node firstToken) {
        for(String operation:operations){
            if(firstToken.getValue().equals(operation+" ")) {
                classTokens.get(0).setType(firstToken.getType());
                classTokens.get(0).setValue(operation);
                return 1;
            }
        }
        return 0;
    }
}
