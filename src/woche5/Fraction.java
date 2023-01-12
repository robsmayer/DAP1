package woche5;

public class Fraction {

    private int numerator;      // Zaehler
    private int denominator;    // Nenner

    public Fraction ( int num, int denom )
    {
        if ( denom != 0 )
        {
            if ( denom < 0 )
            {
                numerator = -num;
                denominator = -denom;
            }
            else
            {
                numerator = num;
                denominator = denom;
            }
            reduce();
        }
        else
        {
            // error: division by zero
            throw new IllegalArgumentException();
        }
    }

    public Fraction()
    {
        numerator = 0;
        denominator = 1;
    }

    public Fraction( int num )
    {
        numerator = num;
        denominator = 1;
    }

    public String toString()
    {
        return numerator + " / " + denominator;
    }

    public Fraction changeSign()
    {
        return new Fraction( -numerator, denominator );
    }

    public Fraction reverse()
    {
        return new Fraction( denominator, numerator );
    }

    public Fraction add( Fraction other )
    {
        int num = numerator * other.denominator + other.numerator * denominator;
        int denom = denominator * other.denominator;
        return new Fraction ( num, denom );
    }

    public Fraction subtract( Fraction other )
    {
        int num = numerator * other.denominator - other.numerator * denominator;
        int denom = denominator * other.denominator;
        return new Fraction ( num, denom );
    }

    public Fraction multiply( Fraction other )
    {
        int num = numerator * other.numerator;
        int denom = denominator * other.denominator;
        return new Fraction ( num, denom );
    }

    public Fraction divideBy( Fraction other )
    {
        return multiply ( other.reverse() );
    }

    public double toDouble()
    {
        return (double)numerator / (double)denominator;
    }

    public Fraction clone() {
        return new Fraction( numerator, denominator );
    }

    public boolean equals( Fraction other )
    {
        return numerator == other.numerator & denominator == other.denominator;
    }

    private void reduce()
    {
        if ( numerator != 0 )
        {
            int gcd = calculateGcd();
            numerator /= gcd;
            denominator /= gcd;
        }
        else
        {
            denominator = 1;
        }
    }

    public int calculateGcd()
    {
        int value1 = Math.abs( numerator );
        int value2 = denominator;
        while (value1 != 0 & value2 != 0)
        {
            if ( value1 > value2 )
            {
                value1 = value1 % value2;
            } else {
                value2 = value2 % value1;
            }
        }
        if ( value1 == 0 )
        {
            return value2;
        } else {
            return value1;
        }
    }
}
