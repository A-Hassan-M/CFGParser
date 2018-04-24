package Parser.NonTerminals;

import java.util.ArrayList;

public abstract class Node {
    protected String type;
    protected String value;
    protected int tabs;

    public Node(String type, String value){
        this.type = type;
        this.value= value;
        tabs = 0;
    }

    public Node() {
        tabs = 0;
    }

    public String getType() {
        return type;
    }

    public abstract String getValue();
    public abstract int matches(ArrayList<Node> tokens);

    public void setValue(String value) {
        this.value = value;
    }
    int x ;

    public void setTabs(int tabs){
        x = 5;
        this.tabs = tabs;
    }

    public int getTabs() {
        System.out.println(x);
        return tabs;
    }
}
