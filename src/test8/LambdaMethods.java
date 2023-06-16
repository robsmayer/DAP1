
package test8;
public class LambdaMethods
{

    public static int makeInt( IntIntPairs p )
    {
        IntIntPairs copy = p.extract((k,v)-> k % 2 != 0);
        int n = copy.accumulate( (k,v) -> (v) );
        return n;
 
    }

    //
    public static IntIntPairs  makePairs( IntIntPairs p )
    {
        IntIntPairs a = p.extract((k,v) -> v % 2 != 0);

        return a;
 
    }

    // Store in k (keys)  double of it's value and don't changes the values in v (value)
    public static void apply( IntIntPairs p )
    {

        p.manipulate((k, v) -> 2 * k , ((k, v) -> v));

    }
 
}
