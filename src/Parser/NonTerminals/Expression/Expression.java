package Parser.NonTerminals.Expression;

import Parser.NonTerminals.ExpressionDash;
import Parser.NonTerminals.Node;
import Parser.NonTerminals.NodeWithLamda;

import java.util.ArrayList;

public class Expression extends NodeWithLamda {

    public Expression(){
        value = "";
        classTokens = new ArrayList<>();
        classTokens.add(new ExpBiginning());
        classTokens.add(new ExpressionDash());
    }


    @Override
    public String getValue() {
        return super.getValue();
    }
}
