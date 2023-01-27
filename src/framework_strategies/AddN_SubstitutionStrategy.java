package framework_strategies;

public class AddN_SubstitutionStrategy extends DoublyLList.SubstitutionStrategy{
    private int n;
    public AddN_SubstitutionStrategy(int increment){
        n = increment;
    }

    public Object substitute(Object ref){
        return (int)ref + n;
    }
}
