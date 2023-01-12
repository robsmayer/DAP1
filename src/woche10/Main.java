package woche10;
import extra.TestTools;
public class Main {

    public static void testInteger(){
        DoubleLinkedListOBJ l = new DoubleLinkedListOBJ();

        Integer[] arr = TestTools.getRandArr(10);
        for(int i= 0; i < arr.length ;i++){
            System.out.println(arr[i]);
        }
        l.addArr(arr);
        l.showAll(); // if arr integer prints memory address of Integer
    }

    public static void testIntObject(){


        IntObject[] arr = new IntObject[10];
        int[] aux = TestTools.getRandomArr(arr.length,-10, 66);

        for(int i = 0; i < arr.length; i++){
            arr[i] = new IntObject(aux[i]);
        }

        DoubleLinkedListOBJ l = new DoubleLinkedListOBJ();
        l.addArr(arr);
        l.showAll();
    }
    public static void main(String[] args){
        testInteger();

    }
}
