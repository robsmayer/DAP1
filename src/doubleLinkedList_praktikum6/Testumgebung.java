
package doubleLinkedList_praktikum6;
public class Testumgebung
{
    public static void main( String[] args )
    {
        testToolsDll();
    }

    public static void testToolsDll()
    {
        Tools_DoubleList a = new Tools_DoubleList();
        DoublyLinkedList b = a.scanList();

    }
    public static void testDoublyLinkedList()
    {
        DoublyLinkedList integers = new DoublyLinkedList();
        integers.add( 4 );
        integers.add( 5 );
        integers.add( 6 );
        integers.add( 9 );
        integers.add( 7 );
        integers.add( 17 );
        integers.add( 11 );
        integers.add( 4 );
        integers.showAll();
    }
}
