package Parser.NonTerminals.StatementExpression;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.Statement.*;

import java.util.ArrayList;

public class StatementExpressionChecker extends Node {
    Node statement;


    public StatementExpressionChecker(){
        value = "";
    }

    @Override
    public String getValue() {
        statement.setTabs(tabs);
        return statement.getValue()+"";
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        switch (tokens.get(0).getType()) {
            case "< LEFT_SQUARE_B >":
                statement = new BracketExpression();
                break;
            case "< ASSIGNMENT >":
                statement = new EqualExpression();
                break;
            default:
                return 0;
        }
        return statement.matches(tokens);
    }
}
