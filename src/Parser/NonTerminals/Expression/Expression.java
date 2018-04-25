package Parser.NonTerminals.Expression;

import Parser.NonTerminals.ExpressionDash;
import Parser.NonTerminals.Node;

import java.util.ArrayList;

public class Expression extends Node {

    public Expression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new ExpBiginning());
        classTokens.add(new ExpressionDash(true));
    }
}
