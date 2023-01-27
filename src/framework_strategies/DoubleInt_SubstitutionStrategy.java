package framework_strategies;

public class DoubleInt_SubstitutionStrategy extends DoublyLList.SubstitutionStrategy
{
    public Object substitute( Object ref )
    {
        return 2 * (int)ref;
    }
}
