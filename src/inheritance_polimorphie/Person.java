package inheritance_polimorphie;

public class Person {

    private String firstName;
    private String lastName;
    //private int dob; // date of birth

    public Person(String fName,String  lName)
    {
        firstName = fName;
        lastName = lName;
    }

    public String toString()
    {
        return firstName + " " + lastName + " ";
    }

    public void whichMethod(Person p)
    {
        System.out.println("Person");
    }


    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }
    public void walk(){
        System.out.println();
        System.out.print(getFirstName() + " is walking");
    }
}
