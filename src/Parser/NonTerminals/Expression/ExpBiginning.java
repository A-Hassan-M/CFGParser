package Parser.NonTerminals.Expression;

import Parser.NonTerminals.HeapDeclaration.HeapDeclarationChecker;
import Parser.NonTerminals.Node;

import java.util.ArrayList;

public class ExpBiginning extends Node {

    String[] terminals = {"< INTEGER_LITERAL >",
                          "< FLOAT_LITERAL >", "< TRUE >","< FALSE >","< ID >","< THIS >"};

    public ExpBiginning(){
        value = "";
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public int matches(ArrayList<Node> tokens) {
        Node firstToken = tokens.get(0);
        Node expBeginning;
        for (String terminal : terminals) {
            if (firstToken.getType().equals(terminal)){
                tokens.remove(0);
                this.value = firstToken.getValue();
                return 1;
            }
        }
        switch (firstToken.getType()){
            case "< NEW >":
                tokens.remove(0);
                expBeginning = new HeapDeclarationChecker();
                this.value += "new ";
                break;
            case "< NOT >":
                tokens.remove(0);
                expBeginning = new Expression();
                this.value += "!";
                break;
            case "< LEFT_ROUND_B >":
                expBeginning = new ParenthesesExpression();
                break;
            default: return 0;
        }
        int matched = expBeginning.matches(tokens);
        if(matched >= 0)
            this.value += expBeginning.getValue();
        return matched;
    }
}
