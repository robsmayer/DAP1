package klausurTest;

public class Testing {

    public static void main(String args[])
    {
        int[] lala = {2,47,1,66,3,4,8,9,5,5,5,5,5};
        Data d = new Data(lala);
        d.printData();

        System.out.println(moreThan(d,3,5));

        System.out.println(mostAreSmaller(d,6));
        System.out.println(addIf(d,18));

        System.out.println(smt(d));

    }

    public static boolean moreThan(Data d, int i1, int i2)
    {
        int more1 = d.doInt((x,y)-> {if(x == i1){return y + 1;}else{return y;}});
        int more2 = d.doInt((x,y) -> {if(x == i2){return y + 1;}else{return y;}});

        System.out.println("\n" + more1 + "    " + more2);
        return more1 > more2;
    }

    public static int addIf(Data d, int limit)
    {
        int size = d.doInt((x,y) -> {return y + 1;});
        System.out.println("size " + size);
        if(size < limit)
        {
            int sum = d.doInt((x,y)->{return y + x;});

            return sum;
        }
        return 0;
    }

    public static boolean mostAreSmaller(Data d, int p)
    {
        int size = d.doInt((x,y) -> {return y + 1;});

        int smaller = d.doInt((x,y) -> {if(x < p) return y + 1; else return y;});

        return smaller > size/2;
    }

    public static int smt(Data d)
    {
        System.out.println();
        return d.doInt((x, y) -> {if(y % 2 == 0){System.out.println("y " +y +" x " + x);
        }else {System.out.print("y " +y +" x " + x);
        }
            return 0;
        });
}
}