package fraction_testat;

public class Testumgebung {

    public static void main( String args[] )
    {
        // Beispiel 1
        Fraction[] arr1 = { new Fraction(1,1), new Fraction(1,2), new Fraction(1,3), new Fraction(1,4), new Fraction(1,5), new Fraction(1,6), new Fraction(1,7) };
        System.out.println( Testat.apply( arr1, new Fraction( 1, 7 ) ).toString() );

        //Beispiel 2
        Fraction[] arr2 = { new Fraction(1,1), new Fraction(1,2), new Fraction(1,3), new Fraction(1,4), new Fraction(1,5), new Fraction(1,6) };
        System.out.println( Testat.apply( arr2,  new Fraction( 2, 7 ) ).toString() );

        //Beispiel 3
        Fraction[] arr3 = { new Fraction(1,2), new Fraction(1,3), new Fraction(1,4), new Fraction(1,5), new Fraction(1,6) };
        System.out.println( Testat.apply( arr3,  new Fraction( 6, 5 ) ).toString() );

        //Beispiel 4
        Fraction[] arr4 = { new Fraction(2,1), new Fraction(1,3), new Fraction(1,4) };
        System.out.println( Testat.apply( arr4,  new Fraction( 3, 5 ) ).toString() );

        //Beispiel 5
        Fraction[] arr5 = { new Fraction(1,5), new Fraction(1,6) };
        System.out.println( Testat.apply( arr5,  new Fraction( 1, 2 ) ).toString() );

        //Beispiel 6
        Fraction[] arr6 = { new Fraction(1,5)  };
        System.out.println( Testat.apply( arr6,  new Fraction( 2, 7 ) ).toString() );

        //Beispiel 7
        Fraction[] arr7 = {};
        System.out.println( Testat.apply( arr7,  new Fraction( 2, 7 ) ).toString() );

    }
}
