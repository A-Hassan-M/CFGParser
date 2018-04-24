package Parser.NonTerminals;

import java.util.ArrayList;

public class Expression extends Node{
    @Override
    public String getValue() {
        return null;
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        return 1;
    }

}
