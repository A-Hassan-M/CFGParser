package Parser.NonTerminals.StatementExpression;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.Token;

import java.util.ArrayList;

public class BracketExpression extends StatementExpression {

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        return 0;
    }
}
