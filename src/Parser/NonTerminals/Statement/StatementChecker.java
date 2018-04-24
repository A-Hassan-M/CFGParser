package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Node;

import java.util.ArrayList;

public class StatementChecker extends Node {
    Statement statement;


    @Override
    public String getValue() {
        return statement.getValue();
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        switch (tokens.get(0).getType()) {
            case "< IF >":
                statement = new IfStatement();
                break;
            case "< WHILE >":
                statement = new WhileStatement();
                break;
            case "< SYSTEM.OUT.PRINTLN >":
                statement = new PrintStatement();
                break;
            case "< ID >":
                statement = new IdentifierStatement();
                break;
        }
        return statement.matches(tokens);
    }
}
