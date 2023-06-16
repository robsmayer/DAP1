package framework_strategies;

public class SubstituirPorJohny implements DoublyLList.SubstituirStrategia{

    private String algumaString;

    public SubstituirPorJohny()
    {
        algumaString = "oi meu nome eh johny";
    }

    public SubstituirPorJohny(String a)
    {
        algumaString = a;
    }
    @Override
    public Object substituir(Object ref) {
        return algumaString;
    }
}
