package Compile;

import DataTypes.Token;
import SharedResources.ExecutionType;
import com.sun.org.apache.xalan.internal.xsltc.cmdline.Compile;

import java.util.ArrayList;

public class Conditionals {


    public static void handleIf(ArrayList<Token> tokens)
    {

        int conditionalStart = 0;
        String token;

        for (int i = 0; i < tokens.size(); i++)
        {
            token = tokens.get(i).getContent();


            if (token.equals("("))
                conditionalStart = i;

            else if (token.equals(")"))
            {
                if (Declarations.evaluateBoolean(new ArrayList<>(tokens.subList(conditionalStart,i))))
                    MainCompiler.setExecutionType(ExecutionType.IF_TRUE);
                else
                    MainCompiler.setExecutionType(ExecutionType.IF_FALSE);
            }
        }

    }

}