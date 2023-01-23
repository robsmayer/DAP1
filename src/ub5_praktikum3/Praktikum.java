package ub5_praktikum3;
import extra.Tools;
import java.util.*;

// Praktikum 3

public class Praktikum {

    public static int digitSum(int n){
        // Quersumme soma os digitos 123 1 +2 +3

        if( n == 0)
            return 0;
        else
        {
            int aux = n % 10;

            n = (n - aux)/10;

            return aux + digitSum(n);
        }
    }

    public static int potenz(int a, int n)
    {
        if(a == 0)
            return 1;
        else
        {
            return n * potenz(a - 1, n);
        }
    }

    public static int sumUpTheNegatives(int[] arr, int n)
    {
        if(n == 0)
            if(arr[0] < 0)
                return arr[0];
            else
                return 0;
        else
        {
            if(arr[n] < 0)
            {
                return arr[n] + sumUpTheNegatives(arr,n-1);
            }
            else
                return sumUpTheNegatives(arr, n-1);
        }
    }

    public static int countPositives(int[] arr, int n)
    {
        if(n == 0)
        {
            if(arr[0] > 0)
                return 1;
            else
                return 0;
        }
        else
        {
            if(arr[n] > 0)
                return 1 + countPositives(arr, n - 1);
            else
                return countPositives(arr, n-1);
        }
    }

    // indexes
    public static int countPositives(int[] arr, int start, int end)
    {
        if(start == end)
        {
            if(arr[start] > 0)
                return 1;
            else
                return 0;
        }
        else
        {
            if(arr[start + end] > 0)
            {
                return 1 + countPositives(arr,start,end-1);
            }
            else
                return countPositives(arr,start,end-1);
        }
    }

    public static int getMax(int[] arr,int i)
    {

        if(i == 1) // or == 0?
        {
            return arr[0];
        }
        else
        {
            if(getMax(arr, i-1) > arr[i-1])
            {
                return getMax(arr, i-1);
            }
            else
                return arr[i-1];
        }
    }

    public static boolean isSorted(int[] arr, int i)
    {
        if(i == 0)
        {
            return true;
        }
        else if(i>0)
        {
            if(arr[i-1] > arr[i])
                return false;

            return(isSorted(arr,i-1));
        }

        return false;
    }



    public static boolean contains(int[] arr, int i, int x) //contains x == true
    {
        if(i == 0 && arr[i] != x)
            return false;
        else
        {
            if(arr[i] == x)
                return true;
            else
                return contains(arr, i-1 ,x);
        }

    }
    // Get smallest index of x
    public static int getIndex(int[] arr, int i, int x)
    {
        if(i < arr.length)
        {
            if(arr[i] == x)
                return i;

            return getIndex(arr, i + 1, x);
        }
        else
            return -1;

    }

    // int[] to String until index i
    public static String toString(int[] arr, int i)
    {
        if(i < arr.length && i >= 0)
        {
            int a = arr[i];
            if(i != 0)
                return toString(arr, i - 1)+ " , "  + a ;
            else
                return a + toString(arr, i - 1);
        }
        else
            return "";
    }
    public static void menu()
    {
        System.out.print("(1) digitSum ");
        System.out.print("(2) Potenz ");
        System.out.print("(3) SumUpNegatives,countPositives");
        System.out.print(" (4) getRandomArr + getMax");
        System.out.print("\n(5) getArr + isSorted + contains + smallest index + toString");

        System.out.print("\nOption: ");
    }

    public static void main(String[] args)
    {
        menu();

        Scanner myScan = new Scanner(System.in);

        int select = myScan.nextInt();
        Tools tool = new Tools();

        switch (select) {
            case 1 -> {
                System.out.print("DigitSum give int ");
                int lala = myScan.nextInt();
                System.out.println(" -> " + digitSum(lala));
            }
            case 2 -> {
                System.out.print("Potenz \n Base: ");
                int base = myScan.nextInt();
                System.out.print(" Exponent: ");
                int exponent = myScan.nextInt();
                System.out.println(base + " ^ " + exponent + " = " + potenz(exponent, base));
            }
            case 3 -> { //get arr + sum negatives + ...
                int[] arr = tool.getArr(myScan);
                tool.printArray(arr);

                System.out.println("Sum of negatives is " + sumUpTheNegatives(arr, arr.length - 1));
                System.out.println("Number of positive numbers is " + countPositives(arr, arr.length - 1));

                System.out.println("Set indexes from : ");
                int ind1 = myScan.nextInt();
                System.out.print(" to ");
                int ind2 = myScan.nextInt();

                if (ind1 == ind2 || ind1 > arr.length || ind2 > arr.length || ind1 + ind2 > arr.length)
                    throw new ArrayIndexOutOfBoundsException();
                else if (ind1 < 0 || ind2 < 0)
                    throw new IllegalArgumentException();
                else {
                    if (ind1 < ind2) {
                        System.out.println("Positive numbers from "+ ind1 + " to " + ind2 +" = " + countPositives(arr, ind1, ind2));
                    } else
                        System.out.println("Positive numbers from "+ ind1 + " to " + ind2 +" = " + countPositives(arr, ind2, ind1));
                }


            }
            case 4 -> { // Get Max + get random arr

                System.out.print("Set size: ");
                int size = myScan.nextInt();
                int[] randomArr = Tools.getRandomArr(size);
                Tools.printArray(randomArr);
                System.out.println();
                System.out.println("Max = " + getMax(randomArr, randomArr.length)); // Get Max -TODO reduce complexity
            }

            case 5 -> {
                int[] arr = Tools.randomOrNot(myScan);
                Tools.printArray(arr);

                if(isSorted(arr,arr.length-1))
                    System.out.print("is sorted");
                else
                    System.out.print("is not sorted");

                System.out.println("\nContains x");
                System.out.print("x = ");
                int x = myScan.nextInt();

                if(contains(arr,arr.length-1, x))
                    System.out.println("The array contains " +x);
                else
                    System.out.println("Not contains " + x);

                //System.out.println();
                System.out.print("-> Get Index of: ");
                x = myScan.nextInt();

                //System.out.println();
                System.out.print("The smallest index of " + x +" is " + getIndex(arr,0,x));

                System.out.println();
                System.out.print("-> Arr int[] to String - Set index end of string: ");
                x = myScan.nextInt();

                if(x < arr.length)
                    System.out.println(toString(arr, x));
                else
                    throw new ArrayIndexOutOfBoundsException("fuck u");
            }


            default -> System.out.print("life sux");
        }

        myScan.close();

    }
}
