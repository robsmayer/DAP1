package extra;

import java.util.Random;
import java.util.Scanner;

/**
 *      Methods that are helpful and important for testing
 *      and the Exam.
 *
 *      get array user input
 *      get random array of ints, Integer,
 *      print different ArrayType
 */
public class Tools {

    //System.out.println("arr[i] = " + arr[i] + " arr[i-1] = " + arr[i-1] + " i = " + i);
    private static int lowBo =-20; // Lowerbound
    private static int uppBo = 50; // Upperbound

    public void setBounds(int l, int u){ //Works ?
        lowBo = l;
        uppBo = u;
    }
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

    public static void printArray(boolean[] arr)
    {
        if(arr != null)
        {
            System.out.println();
            for (boolean j : arr) {
                System.out.print(j + ", ");
            }
            System.out.println();
        }
        else
            throw new IllegalArgumentException();
    }

    public static int[] getArr(Scanner a)
    {
        if(a != null)
        {

            System.out.print("Get array \n Size: ");
            int l = a.nextInt();
            System.out.println("Get numbers");

            int[] arr = new int[l];

            for(int i = 0; i < l; i++)
            {
                arr[i] = a.nextInt();
            }

            return arr;
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    public static int[] getRandomArr(int size){
        if(size >= 0)
        {
            Random rand = new Random(111);
            int[] arr = new int[size];

            for(int i = 0; i < size ; i++)
            {
                arr[i] = rand.nextInt(-50, 100);
            }

            return arr;
        }else
            throw new IllegalArgumentException("Send real size");
    }

    public static int[] getRandomArr(int size, int lowerbound, int upperbound)
    {
        if(size > 0)
        {
            Random rand = new Random(30);
            int[] arr = new int[size];

            for(int i = 0; i < size ; i++)
            {
                arr[i] = rand.nextInt(lowerbound, upperbound);
            }

            return arr;
        }else
            throw new IllegalArgumentException("Send real size");
    }



    public static int[] getRandomArr(int size, int upperbound)
    {
        if(size >= 0 && upperbound < size)
            {
                Random rand = new Random(340);
                int[] arr = new int[size];

                for(int i = 0; i < size ; i++)
                {
                    arr[i] = rand.nextInt(upperbound);
                }

                return arr;
            }else
                throw new IllegalArgumentException("Send real size");

    }

    // why cant same name
    public static Integer[] getRandINTArr(int size){
        if(size > 0){
            Random rand = new Random(42);
            Integer[] arr = new Integer[size];

            for(int i = 0; i < size; i++){
                arr[i] = rand.nextInt(lowBo,uppBo);
            }
            return arr;
        }
        else
            throw new IllegalArgumentException();
    }

    // Asks if user wants an already populated by random Ints array or
    // insert the ints himself
    public static int[] randomOrNot(Scanner op)
    {
        if(op!= null)
        {
            System.out.print("Press x if random arr: ");
            String opp = op.next();

            if(opp.equals("x"))
            {
                System.out.print("Set size: ");
                int s = op.nextInt();
                return getRandomArr(s);
            }
            else
                return getArr(op);
        }
        else
            throw new IllegalArgumentException();

    }

    //TODO: descobrir o q eh static;

    // Returns 0 if n is not prime returns n if n is prime
    public static int isPrime(int n, int a){

        if(a > 0 && n > 0)
        {
            if(a >= n){
                return n;
            }
            else
            {
                if(n%a == 0 && a != n && a != 1)
                {
                    return 0;
                }
                else
                    return isPrime(n, a + 1);
            }
        }
        else
            throw new IllegalArgumentException("a and n must be positive integers != 0");
    }

    // Returns a boolean array of prime numbers until n - Auxiliary method
    // for primesTill



    public static boolean[] primesTill(int n)
    {
        if(n > 0)
        {
            boolean[] primes = new boolean[n - 1];
            int aux;
            for(int i = 1 ; i <= n; i++)
            {
                aux = isPrime(i,1);
                if(aux != 0)
                    primes[i] = true;
                else
                    primes[i] = false;
            }

            return primes;
        }
        else
            throw new IllegalArgumentException("n positive integer != 0");
    }



    //TODO ver esse method dps
    public static int recursiveGcd(int v1,int v2)
    {
        int i1 = Math.abs(v1), i2 = Math.abs(v2);
        if(i1 != 0 && i2 != 0)
        {
            if(i1 > i2)
            {
                System.out.print("i1 = " + i1 + " i2 = " + i2);
                return recursiveGcd( i1 % i2, i2);
            }
            else
            {
                System.out.print("i1 = " + i1 + " i2 = " + i2);
                return recursiveGcd(i1, i2 % i1);
            }

        }

        return i1 + i2;
    }

    public static void asciiValues()
    {
        System.out.println("A = " +(int)'A');
        System.out.println("M = " +(int)'M');
        System.out.println("Z = " +(int)'Z');
        System.out.println();
        System.out.println("a = " +(int)'a');
        System.out.println("m = " +(int)'m');
        System.out.println("z = " + (int)'z');

    }


     public static void main(String[] args){

        boolean[] arr = primesTill(13);
        printArray(arr);

    }
}


