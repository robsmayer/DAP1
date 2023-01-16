package woche10;

import extra.Tools;

public class TestW10 {

    // George is a DoubleLinkedListOBJ populated with random Integers
    public static DoubleLinkedListOBJ randInt(int size)
    {
        Integer[] ints = Tools.getRandINTArr(size);
        DoubleLinkedListOBJ george = new DoubleLinkedListOBJ();

        for(Integer i : ints)
        {
            george.add(i);
        }

        return george;
    }

    public static void testForwardIT()
    {

        DoubleLinkedListOBJ majo =randInt(10);
        int sum = 0;

        ForwardIterator intsIterator = majo.iterator();

         while(intsIterator.hasNext())
        {

            sum += (int)intsIterator.next();
        }
        System.out.println("Sum = " + sum);
    }
    public static void main(String[] args)
    {
        DoubleLinkedListOBJ lala = new DoubleLinkedListOBJ();
        lala.add(12); lala.add(14); lala.add(12); lala.add(-33); lala.add(43);lala.add(12); lala.add(3);

        lala.showAll();
        System.out.println("llala = " + countFirst(lala));
    }

    public static void testReverseIT()
    {
        DoubleLinkedListOBJ melina = randInt(8);

        ReverseIterator jojo = melina.revIterator();


    }

    public static int countFirst(DoubleLinkedListOBJ structure)
    {
        int count = 0;
        ForwardIterator it = structure.iterator();

        if(it.hasNext())
        {
            Object ref = it.current;
            System.out.println("ref " + ref);
            ///_______________________
            Object s = it.next();
            while(it.hasNext())
            {

            }

        }
        return count;
    }

}
