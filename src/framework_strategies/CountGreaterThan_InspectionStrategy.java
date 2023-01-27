package framework_strategies;

public class CountGreaterThan_InspectionStrategy extends DoublyLList.InspectionStrategy{

    private int bound;
    private int count;
    public CountGreaterThan_InspectionStrategy(int than)
    {
        bound = than;
        count = 0;
    }

    public void inspect(Object ref) {
        if((int)ref > bound)
        {
            count ++;
        }
    }

    public int getCount(){return count;}
}
