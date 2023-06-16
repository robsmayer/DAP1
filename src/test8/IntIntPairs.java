package test8;

public class IntIntPairs
{
    private boolean[] valids;
    private int[] keys;
    private int[] values;
    private int size;
    private int cap;

    public IntIntPairs( int c )
    { 
        cap = c;
        valids = new boolean[cap];
        keys = new int[cap];
        values = new int[cap];
    }

    public boolean uncomplete()
    {
        return size < cap;
    }

    public void put( int k, int v )
    {
        if ( uncomplete() )
        {
            for ( int i = 0; i < cap ; i++ )
            {
                if ( !valids[i] )
                {
                    valids [i] = true;
                    keys[i] = k;
                    values[i] = v;
                    size++;
                    break;
                }
            }
        }
    }

    public void combine( IntIntPairs other )
    {
        for ( int i = 0; i < other.cap ; i++ )
        {
            if ( other.valids[i] )
            {
                put( other.keys[i], other.values[i] );
            }
        }
    }
    
    public String toString()
    {
        String s = "";
        for ( int i = 0; i < cap ; i++ )
        {
            if ( valids[i] )
            {
                s += "("+ keys[i] + "," + values[i] + ") ";
            }
        }
        return s;
    }
    
    public void show()
    {
        System.out.println( toString() );
    }
    
    public int accumulate( IntFunction func )
    {
        int acc = 0;
        for ( int i = 0; i < cap ; i++ )
        {
            if ( valids[i] )
            {
                acc += func.apply( keys[i], values[i] );
            }
        }
        return acc;
    }

    public void manipulate( IntFunction keyFunc, IntFunction valueFunc )
    {
        for ( int i = 0; i < cap ; i++ )
        {
            if ( valids[i] )
            {
                keys[i] = keyFunc.apply( keys[i], values[i] );
                values[i] = valueFunc.apply( keys[i], values[i] );
            }
        }
    }

    public void remove( BoolFunction validFunc )
    {
        for ( int i = 0; i < cap ; i++ )
        {
            if ( valids[i] && validFunc.apply( keys[i], values[i] ) )
            {
                valids[i] = false;
                size--;
            }
        }
    }

    public IntIntPairs extract( BoolFunction exFunc )
    {
        BoolFunction a = (k, v) -> k % 2 != 0;
        IntIntPairs result = new IntIntPairs( size );
        for ( int i = 0; i < cap ; i++ )
        {
            if ( valids[i] && exFunc.apply( keys[i], values[i] ) )
            {
                result.put( keys[i], values[i] );
            }
        }
        return result;
    }

}

