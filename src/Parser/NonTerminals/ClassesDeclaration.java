package Parser.NonTerminals;

import java.util.ArrayList;

//TODO::Implement this class
public class ClassesDeclaration extends Node{
	
	public ClassesDeclaration() {
		// ClassDeclaration  ClassDeclaration`  |  λ
		takesLamda = true;
		classTokens = new ArrayList<>();
		classTokens.add(new ClassDeclaration());
	}
	   @Override
	    public int matches(ArrayList<Node> tokens) {
	        int i= 0;
	        while(!(tokens.isEmpty()) && i<classTokens.size()){
	            int matched = classTokens.get(i).matches(tokens);
	            if(matched==0){
	                return -1;
	            }
	            i++;
	        }
	        if(!tokens.isEmpty()){
	        	ClassesDeclaration arguments = new ClassesDeclaration();
	            if(arguments.matches(tokens) > 0)
	                classTokens.add(arguments);
	        }
	        return 1;
	    }

}
