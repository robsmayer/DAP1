package woche6;

import extra.Tools;

import java.util.Scanner;

public class Ubungsblatt5 {

    public static void quicksort(int [] arr, int low, int high)
    {
        if(low < high)
        {
            int part = partition(arr,low,high);
            Tools.printArray(arr);
            quicksort(arr, low, part - 1);
            quicksort(arr, part + 1, high);
        }


    }

    public static int partition(int[] arr, int low, int high)
    {
        int i = low - 1;
        int pivot = arr[high];
        System.out.println("pivot = " + pivot);
        for(int j = low; j < high; j++) // <= high ?
        {
            if(arr[j] < pivot)
            {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i+1,high);
        return i + 1;
    }

    public static void swap(int[] arr, int a, int b)
    {
        int aux = arr[a];

        arr[a] = arr[b];
        arr[b] = aux;

    }

    // calculations of arr elements that lead to 0
    // a balance equilibrium solution -> result must be always 0
    public static boolean addCalcExists(int[] arr,int position, int result)
    {
        if(position == arr.length-1) {

            if (result - arr[position] == 0)
                return true;
            else if (result + arr[position] == 0)
                return true;
            else
                return false;
        }

        else
        {
            int sub = result - arr[position];
            int sum = result + arr[position];
            if(sub == 0)
                return addCalcExists(arr,position,sub);
            else
                if(sum == 0)
                    return addCalcExists(arr,position,sum);
                else
                    if(sub > sum)
                        return addCalcExists(arr,position,sum);
                    else
                        return addCalcExists(arr, position, sub);
        }

    }
    // Very bad method of roman numbers conversion - 3AM work
    public static String toRoman(int x) {
        StringBuilder ans = new StringBuilder();
        int aux = x;

        if(aux > 3999) {
            while (aux >= 1000000) {
                ans.append("M");
                aux -= 1000000;
            }

            ans.append(" ");

            if (aux >= 900000) {
                ans.append("CM");
                aux -= 900000;
            } else if (aux >= 500000) {
                ans.append("D");

                while (aux > 500000) {
                    ans.append("C");
                    aux -= 100000;
                }

                aux -= 500000;
            }
            ans.append(" ");

            if (aux >= 400000) {
                ans.append("CD");
                aux -= 400000;
            } else {
                while (aux >= 100000) {
                    ans.append("C");
                    aux -= 100000;
                }
            }
            ans.append(" ");
            if (aux >= 90000) {
                ans.append("XC");
                aux -= 90000;
            } else {
                ans.append("L");

                while (aux > 50000) {
                    ans.append("X");
                    aux -= 10000;
                }


                aux -= 50000;
            }

            if (aux >= 40000) {
                ans.append("XL");
                aux -= 40000;
            }

            while (aux >= 10000) {
                ans.append("X");
                aux -= 10000;
            }

            ans.append(" ");

            if (aux > 9000) {
                ans.append("MX");
                aux -= 9000;
            }

            if (aux >= 5000) {
                ans.append("V");
                while (aux > 5000) {
                    ans.append("M");
                    aux -= 1000;
                }
                aux -= 5000;
            }

            if (aux >= 4000) {
                ans.append("MV");
                aux -= 4000;
            }

            ans.append("_");
        }


            while (aux >= 1000) {
                aux -= 1000;
                ans.append("M");
            }

            if (aux >= 900) {
                ans.append("MC ");
                aux -= 900;
            }
            if (aux >= 500) {
                ans.append(" D");

                while (aux >= 600) {
                    ans.append("C");
                    aux -= 100;
                }
                System.out.println(aux);
                aux -= 500;

            }

            if(aux >= 400)
            {
                ans.append("CD");
                aux -= 100;
            }
            ans.append(" ");
            while (aux >= 100) {
                ans.append("C");
                aux -= 100;
            }


                if (aux >= 90) {
                    ans.append(" CX ");
                    aux -= 90;
                }
        if (aux >= 50) {
            ans.append("L");
                while (aux >= 60) {
                    ans.append("X");
                    aux -= 10;
                }


                aux -= 50;

            }

            if (aux >= 10) {
                if (aux >= 40) {
                    ans.append(" XL ");
                    aux -= 40;
                }

                while (aux >= 10) {
                    ans.append("X");
                    aux -= 10;
                }
            }

            if (aux > 0) {
                switch (aux) {
                    case 1 -> ans.append("I");
                    case 2 -> ans.append("II");
                    case 3 -> ans.append("III");
                    case 4 -> ans.append("IV");
                    case 5 -> ans.append("V");
                    case 6 -> ans.append("VI");
                    case 7 -> ans.append("VII");
                    case 8 -> ans.append("VIII");
                    case 9 -> ans.append("IX");
                }
            }


            return ans.toString();

    }
    public static void testQuicksort(){
        int[] arr = {1,5,2,7,6,9};
        Tools.printArray(arr);
        quicksort(arr, 1, arr.length - 1);
    }

    // Count how many decimal houses a number has
    public static int howManyDec(int n)
    {
        if(n == 0)
            return 0;
        else
        {
            int aux = n % 10;
            n -= aux;

            return 1 + howManyDec(n/10);
        }
    }

    public static void repeat(Scanner myScan)
    {
        System.out.println("To roman numbers");
        System.out.print("Gimme number: ");
        int x;
        do
        {
            if(myScan.hasNextInt())
            {
                x = myScan.nextInt();

                System.out.print("\n" + x + " is in roman " + toRoman(x));
                System.out.print("\n(end to exit) Gimme number: ");
            }
        }
        while(!myScan.nextLine().equals("end"));
    }
    public static void main(String[] args)
    {

        Scanner myScan = new Scanner(System.in);

        repeat(myScan);

        myScan.close();


    }
}
