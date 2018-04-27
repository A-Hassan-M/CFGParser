package Parser.NonTerminals;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TerminalNode extends Node {

    public TerminalNode(String type, String value) {
        super(type, value);
    }

    @Override
    public String getValue() {
        return this.value + " ";
    }

    @Override
    public int matches(ArrayList<Node> tokens, boolean takesLamda) {
        String s = tokens.get(0).type;
        if(this.type.equals(tokens.get(0).type)){
            this.value = tokens.get(0).value;
            tokens.remove(0);
            return 1;
        }else if(!takesLamda){
            errorsFile.println("Syntax error expected "+this.value+" but found "+tokens.get(0).value);
        }
        return 0;
    }
}
