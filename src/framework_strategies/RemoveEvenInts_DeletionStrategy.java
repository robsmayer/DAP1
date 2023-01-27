package framework_strategies;

/**
 * Maybe a better name would be conditional strategy because this one works with
 * comparisons of the remove
 * but the use of this class is to delete so - well ok is the Professor's decision
 * **/
public class RemoveEvenInts_DeletionStrategy extends DoublyLList.DeletionStrategy{
    public boolean select(Object ref)
    {
        return (int)ref % 2 == 0;
    }
}
