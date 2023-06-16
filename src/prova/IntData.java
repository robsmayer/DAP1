package prova;

public class IntData {
    private int[] intValues;
    public IntData( int[] p ) { intValues = p; }
    public int compute( BoolBiFunction f, IntFunction g, int x )
    {
        int result = 0;
        for ( int value : intValues )
        {
            if ( f.apply( value, x ) )
            {
                result = result + g.apply( value );
            }
        }
        return result;
    }
}
