package Parser.NonTerminals.HeapDeclaration;

import Parser.NonTerminals.Node;
import java.util.ArrayList;

public class HeapDeclarationChecker extends Node {

    String[] terminals = {"< INT >","< FLOAT >", "< STRING >","< CHAR >","< BOOLEAN >"};

    public HeapDeclarationChecker(){
        value = "";
    }


    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        Node firstToken = tokens.get(0);
        Node var = null;
        int matched;
        for(String terminal:terminals){
            if(firstToken.getType().equals(terminal)){
                var = new PrimitiveHeap(firstToken);
                break;
            }
        }
        if(var == null && firstToken.getType().equals("< ID >"))
            var = new ObjectHeap();
        try {
            matched = var.matches(tokens, takesLamda);
        }catch (NullPointerException e){
            return 0;
        }
        if(matched > 0)
            this.value += var.getValue();
        return matched;
    }
}
