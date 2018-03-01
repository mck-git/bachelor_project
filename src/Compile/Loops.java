package Compile;

import DataTypes.Token;
import Errors.InvalidSyntaxException;
import SharedResources.ExecutionType;

import java.util.ArrayList;

public class Loops {
    private static ArrayList<Token> conditionalTokens = new ArrayList<>();

    private static ArrayList< ArrayList<Token> > loopTokens = new ArrayList<>();

    public static void initiateWhile(ArrayList<Token> tokens) throws InvalidSyntaxException
    {
        if ( ! Conditionals.evaluateConditionalLine(tokens) )
        {
            MainCompiler.setExecutionType(ExecutionType.IF_FALSE);
            return;
        }

        conditionalTokens = (ArrayList<Token>) tokens.clone();

        MainCompiler.setExecutionType(ExecutionType.WHILE);
        loopTokens.clear();
    }


    public static void saveLine(ArrayList<Token> tokens)
    {
        loopTokens.add((ArrayList<Token>) tokens.clone());
    }

    public static void executeLoop() throws InvalidSyntaxException
    {
        MainCompiler.setExecutionType(ExecutionType.NORMAL);
        while (Conditionals.evaluateConditionalLine(conditionalTokens) ) // && count < 2
        {
            for (ArrayList<Token> t : loopTokens) {
                MainCompiler.handleLine(t);
            }
        }
    }

}