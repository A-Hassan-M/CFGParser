package Parser.NonTerminals.ExpressionStructure;

import Parser.NonTerminals.Node;

import java.util.ArrayList;

public class ExpressionStructureChecker extends Node {

    Node expressionStructure;
    String[] operations = {"&&", "||", "==", "!=", ">", "<", "<=", ">=", "+", "-", "*", "/"};

    @Override
    public String getValue() {
        expressionStructure.setTabs(tabs);
        return expressionStructure.getValue();
    }

    @Override
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        int matched = checkOperation(tokens.get(0));
        if(matched > 0 )
            expressionStructure = new OperationalExpression(tokens.get(0));
        else {
            switch (tokens.get(0).getType()) {
                case "< LEFT_CURLY_B >":
                    expressionStructure = new IndexExpression();
                    break;
                case "< DOT >":
                    expressionStructure = new DotExpression();
                    break;
                default:
                    return 0;
            }
        }
        return expressionStructure.matches(tokens, takesLamda);
    }
    private int checkOperation(Node firstToken) {
        for(String operation:operations){
            if(firstToken.getValue().equals(operation+" ")) {
                return 1;
            }
        }
        return 0;
    }
}
