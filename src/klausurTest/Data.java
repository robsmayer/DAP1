package klausurTest;

public class Data {
    private int[] intValues;
    public Data( int[] iV ) {
        intValues = iV;
    }
    public int doInt( IntFunction f ) {
        int result = 0;
        for ( int v : intValues ) {
            result = f.apply( v, result );
        }
        return result;
    }



    public void printData()
    {
        System.out.println();
        for(int i = 0; i < intValues.length; i++)
        {
            System.out.print(" " + intValues[i]);
        }

    }
}
