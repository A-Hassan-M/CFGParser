package Parser.NonTerminals;

import java.util.ArrayList;

public abstract class Node {
    protected String type;
    protected String value;
    protected ArrayList<Node> classTokens;
    protected int tabs;
    public boolean takesLamda;

    public Node(String type, String value){
        this.type = type;
        this.value= value;
        takesLamda = false;
        tabs = 0;
    }

    public Node() {
        takesLamda = false;
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

    /**
     * @param tokens tokens that extracted from tokenizer
     * @return 1 if matched with all classTokens, 0 if not matched or -1 if the class takes lamda
     */
    public int matches(ArrayList<Node> tokens){
        int i= 0;
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tokens);
            if(matched == -1){
                // this means this token takes lamda and thus we remove it from the classTokens
                classTokens.remove(i);
            }else if(matched==0){
                return (takesLamda?-1:0);
            }else{
                i++;
            }
        }
        return 1;
    }

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
