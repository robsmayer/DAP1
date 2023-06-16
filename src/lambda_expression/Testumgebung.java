package lambda_expression;

import javax.swing.plaf.basic.BasicColorChooserUI;

public class Testumgebung
{
    public static void main( String[] args )
    {
        IntIntPairs testPairs = new IntIntPairs( 20 );
        testPairs.put(7,3); testPairs.put(4,3); testPairs.put(1,-9); testPairs.put(6,6); testPairs.put(2,8); 
        testPairs.put(41,12); testPairs.put(9,-11); testPairs.put(8,12); testPairs.put(5,-60); testPairs.put(14,18);
        testPairs.put(0,12); testPairs.put(-9,-16); testPairs.put(0,0); testPairs.put(17,-32); testPairs.put(1,1);

        System.out.println("Beispiel: " + testPairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } ) );

        System.out.print("Beispiel: " + sumUp( testPairs ) ); System.out.println();

        System.out.println("Normal IntIntPairs: ");testPairs.show();System.out.println();
        System.out.print("     >  After addNToValue(IntIntPairs, int):  "); addNToValue(testPairs,12);
        System.out.println(); testPairs.show();

        // Number of even keys
        System.out.println("     >  Number of even keys: " + testPairs.accumulate((k,v) ->{ if(k % 2 ==0) {return 1;} else {return 0;} } ) );

        // Has only one n
        System.out.println("     >  Is n unique (n = 4) : " + uniqueKey(testPairs,4));

        // Erase all Pairs that have k = 6
        System.out.println("     >  Erase all k = 6: ");testPairs.remove((k,v) -> k == 6); testPairs.show();

        // double Greater N
        System.out.println("     >  Double Greater N"); doubleGreaterN(testPairs,5); testPairs.show();

    /*
        Test concatenation
     */
        System.out.println();
        IntIntPairs abu = new IntIntPairs(4); abu.put(1,2); abu.put(12,5); abu.put(45,90);abu.put(19,43);
        System.out.println("Abu the concatenated"); abu.show();
        System.out.println("Joey the concatenation");
        IntIntPairs joey = concat(testPairs,abu); joey.show();

        // Keys 10 up
        System.out.print("     >  Add 10 in keys \n");
        System.out.print("Abu before "); abu.show();
        System.out.print("Abu after ");
        abu.manipulate((k,v) -> k + 10, (k,v) -> v); abu.show();

        //IntIntPairs +5 if All dividable by 3
        System.out.print("     >  Elements of Abu Divisible by 3 ");
        IntIntPairs div3 = abu.extract((k,v) -> v % 3 == 0); div3.show();

        System.out.println();
        System.out.println("     >  Number of Pairs value > 10: " + joey.accumulate((k,v) -> {if(v > 10) {return 1;} {return 0; } } ) );
        System.out.println("     >  if values > 3 key + 5");
        System.out.print("Before: "); testPairs.show();
        testPairs.manipulate((k,v) -> { if(v > 5) k += 5;
            return k;   // interessante dizer o return
        }, (k, v) -> v); // cuidar com ordem do k v
        System.out.print("After: ");
        testPairs.show();
        System.out.println();
        System.out.print("     >  Remove all negative values (v) ");
        System.out.print("Before: "); joey.show();
        joey.remove((k,v)-> v < 0); System.out.print("After: ");joey.show();
        System.out.println("\tSum of all values of abu : " + abu.accumulate((k,v) -> v));
        System.out.print("Abu "); abu.show();


        System.out.print("Copy of all pairs bigger than v > 39: "); IntIntPairs jojo = joey.extract((k,v)-> v > 39);jojo.show();


    }
    
    public static int sumUp(IntIntPairs pairs)
    {
        return pairs.accumulate( (k,v) -> { if (k==0) { return v; } else { return 0; } } );
    }
    
     public static void addNToValue( IntIntPairs pairs, int n )
     {
         pairs.manipulate((k,v)-> k, (k,v)->  v + n);
     }
//      int n == k (only one time)
     public static boolean uniqueKey( IntIntPairs pairs, int n )
     {
         int howMany = pairs.accumulate((k,v) -> { if(k % 2 ==0) {return 1;} else {return 0;} });

         if(howMany != 1)
             return false;
         else
             return true;
     }
// If k > n inserts another pair with (k, v*2) if has space
     public static void doubleGreaterN( IntIntPairs pairs, int n )
     {
         if(pairs.uncomplete())
         {
             IntIntPairs greaterThanN = pairs.extract((k,v) -> k > n);
             greaterThanN.manipulate((k,v) -> k, (k,v) -> v*2);
             pairs.combine(greaterThanN);
         }

     }
//     
     public static IntIntPairs concat(IntIntPairs first, IntIntPairs second)
     {
         // Joey is the combined pairs
         int sizeOfFirst = first.accumulate((k,v) -> v), sizeOfSnd = second.accumulate((k,v) -> v);
         int sizeOfJoey = sizeOfFirst + sizeOfSnd;
         IntIntPairs joey = new IntIntPairs(sizeOfJoey);
         joey.combine(first);
         joey.combine(second);
         return joey;
     }
}
