package generics;

public class SubstituteOddIntegers extends DoubleLinkedList.SubstitutuionStrategy<Integer>
{
    public Integer substitute(Integer ref) {
        if((int)ref % 2 != 0)
        {
            return 2 * ref;
        }
        return ref;
    }
}
