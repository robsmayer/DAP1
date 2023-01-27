package framework_strategies;

public class Main {

    public static void main(String[] args)
    {
        deletionStrategy();
    }

    public static void deletionStrategy()
    {
        DoublyLList list = new DoublyLList(); int[] a = {67,41,90,4,5,6,55};  list.addIntArr(a) ;list.show();
        RemoveEvenInts_DeletionStrategy odd = new RemoveEvenInts_DeletionStrategy();
        list.deleteSelected(odd);
        list.show();
    }
    public static void inspectionStrategy()
    {
        /* Summation */
        DoublyLList list = new DoublyLList(); int[] a = {12,4,5,6,55};  list.addIntArr(a) ;list.show();
        IntSummation_InspectionStrategy sumUp = new IntSummation_InspectionStrategy();
        list.inspectAll(sumUp);
        System.out.println(sumUp.getSum());

        CountGreaterThan_InspectionStrategy counted = new CountGreaterThan_InspectionStrategy(30);
        list.inspectAll(counted);
        System.out.println(counted.getCount());
    }

    public static void substStrategy()
    {
        DoublyLList list = new DoublyLList(); int[] a = {12,4,5,6,55};  list.addIntArr(a) ;list.show();
        DoubleInt_SubstitutionStrategy manip = new DoubleInt_SubstitutionStrategy();
        list.substituteAll(manip);
        list.show();
        AddN_SubstitutionStrategy addedN = new AddN_SubstitutionStrategy(12);
        list.substituteAll(addedN);
        list.show();



    }

    public static void randomTests(){
        DoublyLList list = new DoublyLList();
        list.add(12);list.add(14);
        int[] ints = {7,5,9,99,23,2};
        list.show();
        list.addIntArr(ints);
        list.show();
    }
}
