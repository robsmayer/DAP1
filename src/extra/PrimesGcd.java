package extra;

/**
 *      Simplifying the TestTools
 */

public class PrimesGcd {

    /**
            Prime number methods
     */

    /* Prime numbers */
    public static boolean[] primesTill(int n)
    {
        if(n > 0)
        {
            boolean[] primes = new boolean[n];
            int aux;
            for(int i = 1 ; i < n; i++)
            {
                aux = isPrime(i,1);
                if(aux != 0)
                    primes[i - 1] = true;
                else
                    primes[i - 1] = false;
            }

            return primes;
        }
        else
            throw new IllegalArgumentException("n positive integer != 0");
    }

    // Recursive is prime controlled by level (int l) argument
    public static int isPrime(int n, int l)
    {
        if(l > 0 && n > 0)
        {
            if(l > n)
                return n;
            else
            {
                if(n % l == 0 && l != n && l != 1)
                    return 0;
                else
                    return isPrime(n,l + 1);
            }
        }
        else
            throw new IllegalArgumentException("l and n must be positive numbers");
    }

    // Maximo divisor comum
    public static int recursiveGcd(int v1, int v2)
    {
        int i1 = Math.abs(v1), i2 = Math.abs(v2);

        if(i1 != 0 && i2 != 0)
        {
            if(i1 > i2)
            {
                return recursiveGcd(i1 % i2,i2);
            }
            else
            {
                return recursiveGcd(i1,i2 % i1);
            }
        }

        return i1 + i2;
    }

    // Prints boolean array of prime numbers ctr control loop recursiv
    public static void printPrimes(boolean[] arr)
    {
        if(arr.length > 0)
        {
            for(int i = 0; i < arr.length; i ++)
            {
                if(arr[i])
                    System.out.print(i +1 + " , ");

                if(i == 61 || i == 191 ||i == 400 || i == 700)
                    System.out.println();
            }
        }
        else
            throw new IllegalArgumentException("arr.l > 0 ou ctr < 0");
    }

}
