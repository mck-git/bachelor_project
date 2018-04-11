package DataTypes.Variables;

public class StringVariable implements Variable{


    String name;
    String value;

    public StringVariable(String name, String value)
    {
        this.name = name;
        this.value = value;
    }


    public String getName()
    {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }


}