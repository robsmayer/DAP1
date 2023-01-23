package fraction_testat;

public class Testat {

    public static Fraction apply( Fraction[] arr, Fraction x )
    {

        if(arr.length < 3)
        {
            return x.add(x);
        }
        else
        {
            return x.add(arr[0].add(arr[1]));
        }

    }

}
