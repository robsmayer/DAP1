package generics;

import doubleLinkedL_Vorlesung.ForwardIterator;
import framework_strategies.DoubleInt_SubstitutionStrategy;

public class TestEnviroment {

    public static void option() {
        System.out.println("Generics");
        System.out.println("(1) Iterator Double Linked List");
        System.out.println("(2) Double Linked List Entwurfmuster");
    }

    public static void main(String[] args) {

        testFrameworkGenerics();

    }

    public static void testFrameworkGenerics() {

        DoubleLinkedList<Integer> ints = new DoubleLinkedList<>();
        ints.add(12);
        ints.add(33);
        ints.add(17);
        ints.add(122);
        ints.add(1);

        SubstituteOddIntegers manipulated = new SubstituteOddIntegers();
        ints.substituteAll(manipulated);
        Iterator<Integer> lala = ints.forwardInterator();

        while (lala.hasNext()) {
            Integer gorbachov = lala.next();
            System.out.println((int) gorbachov);
        }

    }


    public static void testDoubleIterator() {
        DoubleLinkedList<Double> doubles = new DoubleLinkedList<Double>();
        doubles.add(12.1);
        doubles.add(2.09);
        doubles.add(0.002);
        doubles.add(5.0);
        double sum = 0.0;

        Iterator<Double> it = doubles.reverseIterator();
        Iterator<Double> forward = doubles.forwardInterator();
        //System.out.print("\t");
        while (it.hasNext()) {
            double johny = it.next();   // Johny = next element
            System.out.print(johny + " \t;\t ");
            sum += johny;
            double jojo = forward.next();
            System.out.println("F " + jojo);
        }
        System.out.println("Sum = " + sum);
    }
}