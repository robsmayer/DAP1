package framework_strategies;

public class IntSummation_InspectionStrategy extends DoublyLList.InspectionStrategy
{
    private int sum;

    public IntSummation_InspectionStrategy(){ sum = 0;}

    public void inspect(Object ref)
    {
        sum += (int)ref;
    }

    public int getSum()
    {
        return sum;
    }
}
