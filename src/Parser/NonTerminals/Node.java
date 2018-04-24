package Parser.NonTerminals;

import java.util.ArrayList;

public abstract class Node {
    String type;
    String value;

    public Node(String type, String value){
        this.type = type;
        this.value= value;
    }

    public Node() {

    }

    public String getType() {
        return type;
    }

    public abstract String getValue();
    public abstract int matches(ArrayList<Node> tokens);
}
