package Parser.NonTerminals;

import java.util.ArrayList;

public class Type extends Node{

	String[] dataTypes = {"< INT >"," < FLOAT >", "< STRING >","< CHAR >","< BOOLEAN >"};

	public Type() {
		classTokens = new ArrayList<>();
		classTokens.add(new ArrayBrackets());
	}
	
	@Override
	public int matches(ArrayList<Node> tokens){
        int i= 0;
        Node temp = tokens.get(0);
        switch (temp.type) {
		case "< INT >":
			classTokens.add(0,new TerminalNode("< INT >","int"));
			break;
		case "< BOOLEAN >":
			classTokens.add(0, new TerminalNode("< BOOLEAN >","boolean"));
			break;
		case "< FLOAT >":
			classTokens.add(0, new TerminalNode("< FLOAT >","float"));
			break;
		case "< STRING >":
			classTokens.add(0, new TerminalNode("< STRING >","string"));
			break;
		case "< CHAR >":
			classTokens.add(0, new TerminalNode("< CHAR >","char"));
			break;
		default:
			return 0;
		}
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


	@Override
	public int matches(ArrayList<Node> tokens) {

		Node firstToken = tokens.get(0);
		for(String dataType:dataTypes){
			if(firstToken.getType().equals(dataType)){
				classTokens.add(0,firstToken);
				break;
			}
		}
		return super.matches(tokens);
	}
}
