package Parser.NonTerminals;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;

public abstract class Node {
    protected String type;
    protected String value;
    protected ArrayList<Node> classTokens;
    protected int tabs;
    public boolean takesLamda;
    public boolean parentTakesLamda;
    public static PrintWriter errorsFile;
    public static StringWriter sr;
    int i =0;

    public Node(String type, String value){
        this.type = type;
        this.value= value;
        takesLamda = false;
        parentTakesLamda = false;
        tabs = 0;
    }

    public Node() {
        value = "";
        parentTakesLamda = false;
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
                if(val.trim().equals("}")) n--;

                for(int i =0;i<n;i++){
                    value += "\t";
                }
                endline = false;
                newStatement = false;
            }
            if(val.trim().equals("{") || val.trim().equals("}")|| val.trim().equals(";") || val.charAt(val.length()-1) == '\n'){
                newStatement = true;
                endline = val.charAt(val.length()-1) != '\n';
                if(val.trim().equals("{")) n++;
            }
            value += val;

        }
        if(newStatement&&endline) value+='\n';
        return value;
    }

    /**
     * @param tokens tokens that extracted from tokenizer
     * if matched == -1 this means the classToken didn't match the passed tokens but as it takes lamda it can be removed
     * @param takesLamda
     * @return 1 if matched with all classTokens, 0 if not matched or -1 if the class takes lamda
     */
    public int matches(ArrayList<Node> tokens, boolean takesLamda){
        i= 0;
        ArrayList<Node> tempTokens = new ArrayList<>(tokens);
        while(!(tokens.isEmpty()) && i<classTokens.size()){
            int matched = classTokens.get(i).matches(tempTokens, takesLamda);
            if(matched == -1){
                // this means this token takes lamda and thus we remove it from the classTokens
                classTokens.remove(i);
            }else if(matched==0){
                return (this.takesLamda ?-1:0);
            }else{
                errorsFile.flush();
                errorsFile.close();
                try {
                    errorsFile = new PrintWriter("errors.txt");
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
        tokens.clear();
        tokens.addAll(tempTokens);
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
