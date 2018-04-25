package Parser.NonTerminals;

import java.util.ArrayList;

public abstract class Node {
    protected String type;
    protected String value;
    protected ArrayList<Node> classTokens;
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

    public String getValue(){
        int n = tabs;
        boolean newStatement = false,endline = false;
        for(Node classToken:classTokens){
            classToken.setTabs(n);
            String val = classToken.getValue();
            if(newStatement){
                if(endline) value += "\n";
                if(val.equals("} ")) n--;
                for(int i =0;i<n;i++){
                    value += "\t";
                }
                endline = false;
                newStatement = false;
            }
            value += val;
            if(val.equals("{ ") || val.equals("} ")|| val.equals("; ") || val.charAt(val.length()-1) == '\n'){
                newStatement = true;
                endline = val.charAt(val.length()-1) != '\n';
                if(val.equals("{ ")) n++;
            }

        }
        if(newStatement&&endline) value+='\n';
        return value;
    }
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

    public void setType(String type) {
        this.type = type;
    }
}
