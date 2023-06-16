package prova;

public class testesss {

    public static void main(String[] args)
    {
        int[] lala = {12,4,6,7,7,3,126,23,44,15,5};
        int[] joey = {3,9,7,8};
        IntData thing = new IntData(lala);

        IntData vovo = new IntData(joey);
        int w = 2;
        //System.out.println("aa " + thing.compute((p,g)->g == w,g->{if(g == w)return 1;else return 0;}, w));
        System.out.println("aa " + thing.compute((p,g)->p == w,p->{return 1;}, w));

        System.out.println();
        System.out.println("sum squares " + vovo.compute((p,g)->p>w,p->{return p*p;},w));

        System.out.println("hm vielfache " + vovo.compute((p,g)-> p%w != 0, p->{return p;},w));
    }
}
