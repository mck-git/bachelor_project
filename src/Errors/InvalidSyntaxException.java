package Errors;

public class InvalidSyntaxException extends Exception {

    int lineNumber;

    public InvalidSyntaxException(int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public String getMessage() {
        return "Syntax error at line: " + lineNumber;
    }
}
