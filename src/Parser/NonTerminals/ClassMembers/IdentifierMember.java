package Parser.NonTerminals.ClassMembers;

import Parser.NonTerminals.Node;

import java.util.ArrayList;

// Hassan will implement this class
public class IdentifierMember extends ClassMembers {

    //TODO::Create constructor and initialize classTokens with the class tokens in the word file
    @Override
    public String getValue() {
        return null;
    }

    //TODO::Implement the matching method
    //TODO: Note that if there's an nullable class(can take lamda) you return -1 in that class match method

    @Override
    public int matches(ArrayList<Node> tokens) {
        return 0;
    }
}
