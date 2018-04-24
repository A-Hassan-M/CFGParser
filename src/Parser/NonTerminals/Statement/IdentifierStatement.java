package Parser.NonTerminals.Statement;

import Parser.NonTerminals.Node;

import java.util.ArrayList;

public class IdentifierStatement extends Node {

    @Override
    public String getValue() {
        return null;
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        return 0;
    }

}
