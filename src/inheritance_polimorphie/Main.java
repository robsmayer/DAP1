package inheritance_polimorphie;


/**
 *  In Java, polymorphism refers to the ability of class to provide different
 *  implementations of a method, depending on the type of object that is
 *  passed to the method.
 *
 *  Same action in different ways
 *  (From mygreatlearning.com)
 * **/

public class Main {

    private static void display( String opt, String ort, String pdt, String prt )
    {
        System.out.print( "\t" + opt + "\t\t\t" + ort + "\t\t\t" + pdt + "\t\t\t" + prt + "\t\t\t" );
    }

    public static void header()
    {
        System.out.println();
        System.out.println( "calling object\t\targument" );
        System.out.println( "declared type\truntime type\tdeclared type\truntime type\tmethod from" );
        System.out.println( "------------------------------------------------------------------------" );
    }

    public static void walk() {
        Student stuWithStu = new Student("Melina","Lala","Kulturwissenschaft", 666);
        Person pWithStu = stuWithStu; // declared Person , runtime student - overriding / upcasting
        Student guara = new Student("Guara","Haha", "Architecture",303);
        System.out.println(pWithStu.toString()); // Person.toString() was overwritten
        pWithStu.walk();
        guara.walk();
    }
    public static void main(String[] args)
    {
        testFolie();
    }

    public static void testFolie() // method from student was called only one time - student student student student
    {
        Person pWithP = new Person("Roger","Salles");
        Student stuWithStu = new Student("Melina","Lala","Kulturwissenschaft", 666);
        Person pWithStu = stuWithStu; // declared Person , runtime student - overriding / upcasting

        header();

        display("Person","Person","Person","Person"); pWithP.whichMethod(pWithP);
        display("Person","Person","Person","Student"); pWithP.whichMethod(pWithStu);
        display("Person","Person","Student","Student"); pWithP.whichMethod(stuWithStu);
        System.out.println();
        display("Person","Student","Person","Person"); pWithStu.whichMethod(pWithP);
        display("Person","Student","Person","Student");pWithStu.whichMethod(pWithStu);
        display("Person","Student","Student","Student");pWithStu.whichMethod(stuWithStu);
        System.out.println();
        display("Student","Student","Person","Person");stuWithStu.whichMethod(pWithP);
        display("Student","Student","Person","Student");stuWithStu.whichMethod(pWithStu);
        display("Student","Student","Student","Student");stuWithStu.whichMethod(stuWithStu);
    }
}
