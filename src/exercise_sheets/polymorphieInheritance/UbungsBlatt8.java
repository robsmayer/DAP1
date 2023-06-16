package exercise_sheets.polymorphieInheritance;

public class UbungsBlatt8 {

    public static void w(char p){ System.out.print("X");}
    public static void w(long p){System.out.print("L");}
    public static void w(double p){System.out.print("D");}

    public static void aufgabe1() //Define following output
    {
        w('a');
       // w(new Integer(2) + 2);
        w(8.1 / 2.0);
        w(2+10);
        w(8L / 2.0);
       // w('1'/new Integer(3));
    }

    public static class Top{
        public void m(Top p){ System.out.print(" B ");}
        public void m(Bottom p){ System.out.print(" C ");}
    }

    public static class Middle extends Top{
        public void m(Bottom p){ System.out.print(" K ");}
    }

    public static class Bottom extends Middle{
        public void m(Middle p){ System.out.print(" W ");}
        public void m(Bottom p){System.out.print(" X "); }
    }

    public static void aufgabe2()
    {
        Top tm = new Middle();
        Top tb = new Bottom();
        Middle mb =  new Bottom();

        tm.m(tb);
        tm.m(mb);

        tb.m(tm);
        tb.m(mb);

        mb.m(new Middle());
        new Bottom().m(tb);
    }




 public static void main(String[] args)
    {
        Top a = new Bottom();
        Top b = new Middle();
        // Isso ->Middle ajj = new Top();
        // nao pode da erro tipo Top ajj = new Middle(); isso pode
       aufgabe2();
    }


}


