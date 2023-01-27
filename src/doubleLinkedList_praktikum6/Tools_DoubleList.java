package doubleLinkedList_praktikum6;
import java.util.Scanner;
/**     ---  Tools for Double linked List of Element    ---     **/


public class Tools_DoubleList extends DoublyLinkedList{

    public DoublyLinkedList scanList(){
        System.out.println("Type number + enter to add to list (type xxx to exit)");
        Scanner scan = new Scanner(System.in);
        DoublyLinkedList out = new DoublyLinkedList();
        Object a = new Object();

       do{
            out.add(scan.next());

        }while(scan.hasNext() && !scan.next().equals("xxx"));
        out.showAll();
        scan.close();
        return out;
    }
}
