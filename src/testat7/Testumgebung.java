
package testat7;


public class Testumgebung {

    public static void main(String args[])
    {
        test();
    }

    public static void test()
    {
        DoublyLinkedList dll1 = new DoublyLinkedList();
        System.out.print( "Liste vor Aufruf von apply( 4 ):   " );
        dll1.showAll();
        dll1.apply( 4 );
        System.out.print( "Liste nach Aufruf von apply( 4 ):  " );
        dll1.showAll();
        System.out.println( "Laenge:                            " + dll1.size() + "\n\n" );
        
        Integer[] c = { 7 };
        DoublyLinkedList dll4 = build( c );
        System.out.print( "Liste vor Aufruf von apply( 4 ):   " );
        dll4.showAll();
        dll4.apply( 4 );
        System.out.print( "Liste nach Aufruf von apply( 4 ):  " );
        dll4.showAll();
        System.out.println( "Laenge:                            " + dll4.size() + "\n\n" );

        Integer[] a = { 4, 5 };
        DoublyLinkedList dll2 = build( a );
        System.out.print( "Liste vor Aufruf von apply( 4 ):   " );
        dll2.showAll();
        dll2.apply( 4 );
        System.out.print( "Liste nach Aufruf von apply( 4 ):  " );
        dll2.showAll();
        System.out.println( "Laenge:                            " + dll2.size() + "\n\n" );

        Integer[] b = { 4,8,5,9,2,6 };
        DoublyLinkedList dll3 = build( b );
        System.out.print( "Liste vor Aufruf von apply( 2 ):   " );
        dll3.showAll();
        dll3.apply( 2 );
        System.out.print( "Liste nach Aufruf von apply( 2 ):  " );
        dll3.showAll();
        System.out.println( "Laenge:                            " + dll3.size() + "\n\n" );

        Integer[] d = { 7,8,5,9,2,6,1 };
        DoublyLinkedList dll5 = build( d );
        System.out.print( "Liste vor Aufruf von apply( 1 ):   " );
        dll5.showAll();
        dll5.apply( 1 );
        System.out.print( "Liste nach Aufruf von apply( 1 ):  " );
        dll5.showAll();
        System.out.println( "Laenge:                            " + dll5.size() );

    }
    
    private static DoublyLinkedList build( Integer[] arr )
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        for( Integer i : arr )
        {
            dll.add( i );
        }
        return dll;
    }
}
