package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Node;

import java.util.ArrayList;

public class StatementChecker extends Node {
    Node statement;


    @Override
    public String getValue() {
        System.out.println("tabs " +tabs);
        statement.setTabs(tabs);
        return statement.getValue()+"";
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        switch (tokens.get(0).getType()) {
            case "< LEFT_CURLY_B >":
                statement = new ScopeStatement();
                break;
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
