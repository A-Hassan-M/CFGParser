package Parser.NonTerminals.ExpressionStructure;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.Statement.*;

import java.util.ArrayList;

public class ExpressionStructureChecker extends Node {

    Node expressionStructure;

    @Override
    public String getValue() {
        expressionStructure.setTabs(tabs);
        return expressionStructure.getValue();
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        switch (tokens.get(0).getType()) {
            case "< EQUAL >":
                expressionStructure = new OperationalExpression();
                break;
            case "< LEFT_CURLY_B >":
                expressionStructure = new IndexExpression();
                break;
            case "< DOT >":
                expressionStructure = new DotExpression();
                break;
            default:
                return 0;
        }
        return expressionStructure.matches(tokens);
    }
}
