package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Node;
import Parser.NonTerminals.Token;

import java.util.ArrayList;

public class IdentifierStatement extends Statement {

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        return 0;
    }

}
