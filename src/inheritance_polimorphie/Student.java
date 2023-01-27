package inheritance_polimorphie;

public class Student extends Person{

    private int regNumber;
    private String subject;

    public Student(String fn, String ln, String sub, int rn)
    {
        super(fn,ln);
        subject = sub;
        regNumber = rn;
    }

    public String toString()
    {
        return super.toString() + " - " + regNumber + " - " + subject;
    }

    public void walk()
    {
        super.walk();
        System.out.print(" very fast");
    }

    public void whichMethod(Person p){
        System.out.println("Overridden in Student()");
    }
    public void whichMethod(Student s)
    {
        System.out.println("Student");
    }
}
