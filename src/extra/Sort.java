package extra;

public class Sort {

    public static void printArray(int[] arr)
    {
        if(arr != null)
        {
            System.out.println();
            for (int j : arr) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
        else
            throw new IllegalArgumentException();
    }
    public static void groupByNumber(int leftBound, int rightBound, int[] arr)
    {

        if(rightBound >= 0 && rightBound < arr.length)
        {


            if(leftBound < rightBound)
            {
                int leftOfGreaterPart = leftBound;
                System.out.print(arr[rightBound] + " , ");
                int aux = 0; // arr[rightBound] = pivo
                for(int candidate = leftBound; candidate < rightBound; candidate++)
                {
                    if(arr[rightBound] > arr[candidate])
                    {
                        aux = arr[leftOfGreaterPart];
                        arr[leftOfGreaterPart] = arr[candidate];
                        arr[candidate] = aux;
                        leftOfGreaterPart ++;
                    }
                }

                aux = arr[rightBound];
                arr[rightBound] = arr[leftOfGreaterPart];
                arr[leftOfGreaterPart] = aux;

                groupByNumber(leftBound, leftOfGreaterPart - 1, arr);
                groupByNumber(leftOfGreaterPart + 1, rightBound, arr);



            }
        }
    }


    public static void main(String[] args)
    {
        int[] arr = { 4,20,8,40,37,22,6,17,18};
        printArray(arr); System.out.println(); System.out.print("\t=> pivos = ");
        groupByNumber(0,arr.length-1, arr);System.out.println();
        printArray(arr);
    }
}
