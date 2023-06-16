package klausurTest;

public class PolimorphieTest {

    private static int[] arr;

    public static void exemplo(){
        int[] a = {1,4,5,7,2,33,9};
        arr = a;
        for(int i: arr)
        {
            System.out.println(i);
        }
    }
    public static class All {}

    public static class Most extends All { }
    public static class Normal extends Most{}
    public static class Special extends Normal { /* ... */ }
    public static class Top {
        public void m( All p ) { System.out.print("A "); }
    }

    public static class Upper extends Top{
        public void m(Normal p) {System.out.print("L ");}
    }
    public static class Middle extends Upper {
        public void m( Most p ) { System.out.print("S "); }
        public void m( Normal p ) { System.out.print("T "); }
    }
    public static class Bottom extends Middle {
        public void m( Most p ) { System.out.print("X "); }
        public void m( Special p ) { System.out.print("Z "); }
    }
    public static void run2()
        {
            All all = new Most();
            Most most = new Most();
            Normal normal = new Special();
            Special special = new Special();

            Top tu = new Upper();
            Top tm =  new Middle();
            Middle mm = new Middle();
            Middle mb = new Bottom();


            tu.m( most );
            tu.m( special);
            tm.m( normal );
            tm.m( special );
            mm.m( normal );
            mm.m( special );
            mb.m( most );
            mb.m( normal );
        }


    public static void main(String[] args)
    {
        run2();
    }

    public static void m( double p ) { System.out.print( "A " ); }
    public static void m( int p ) { System.out.print( "L " ); }
    public static void m( char p ) { System.out.print( "X " ); }

    public static void run()
    {
        exemplo();
        m( 'a' );
        m( 7 / 3.0 );
        m( 'a' / 'b' );
        m('q'/'i');
        //m( new Integer( 5 ) );
    }
}
