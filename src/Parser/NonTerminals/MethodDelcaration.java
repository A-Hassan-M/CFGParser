package Parser.NonTerminals;

import java.util.ArrayList;

import Parser.NonTerminals.Expression.Expression;
import Parser.NonTerminals.Statement.StatementChecker;

//TODO::Implement this class
public class MethodDelcaration extends Node{

	public MethodDelcaration() {
		classTokens = new ArrayList<>();
		classTokens.add(new Type());
		classTokens.add(new TerminalNode("< ID >", "x"));
		classTokens.add(new TerminalNode("< LEFT_ROUND_B >","("));
		classTokens.add(new TypeIdentifier());
		classTokens.add(new TerminalNode("< RIGHT_ROUND_B >",")"));
		classTokens.add(new TerminalNode("< LEFT_CURLY_B >","{"));
		classTokens.add(new VarsDeclaration());
		classTokens.add(new Statements(true));
		classTokens.add(new TerminalNode("< RETURN >", "return"));
		classTokens.add(new Expression());
		classTokens.add(new TerminalNode("< SEMICOLON >", ";"));
		classTokens.add(new TerminalNode("< RIGHT_CURLY_B >","}"));
	}
	
    @Override
	public int matches(ArrayList<Node> tokens){
        int i= 0;
        Node temp = tokens.get(0);
        switch (temp.type) {
		case "< PUBLIC >":
			classTokens.add(0,new TerminalNode("< PUBLIC >","public"));
			break;
		case "< PRIVATE >":
			classTokens.add(0, new TerminalNode("< PRIVATE >","private"));
			break;
		case "< PROTECTED >":
			classTokens.add(0, new TerminalNode("< PROTECTED >","protected"));
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
		switch (firstToken.getType()){
			case "< PUBLIC >":
				classTokens.add(0,firstToken);
				break;
			case "< PRIVATE >":
				classTokens.add(0,firstToken);
				break;
			case "< PROTECTED >":
				classTokens.add(0,firstToken);
				break;
		}
		return super.matches(tokens);
	}

}
