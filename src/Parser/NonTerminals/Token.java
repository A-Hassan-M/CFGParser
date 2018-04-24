package Parser.NonTerminals;

public abstract class Token {
    String type;
    String value;


    public abstract boolean equals(Token token);
}
