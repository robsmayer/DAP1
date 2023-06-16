
package huffman_testat5;
public class Testumgebung
{
    public static void main( String[] args )
    {
        test();
    }

    public static void test()
    {

        CharacterSearchTree emptyTree = new CharacterSearchTree();
        
        CharacterSearchTree singleNode = new CharacterSearchTree();
        singleNode.iterativeAdd( 'd' );
        
        CharacterSearchTree bigTree = new CharacterSearchTree();
        bigTree.iterativeAdd( 'm' ); bigTree.iterativeAdd( 'm' );
        bigTree.iterativeAdd( 'g' );
        bigTree.iterativeAdd( 'r' ); 
        bigTree.iterativeAdd( 'f' ); bigTree.iterativeAdd( 'f' );
        bigTree.iterativeAdd( 'k' ); bigTree.iterativeAdd( 'k' );
        bigTree.iterativeAdd( 'p' ); bigTree.iterativeAdd( 'p' );
            bigTree.iterativeAdd( 'p' );
        bigTree.iterativeAdd( 't' );
        bigTree.iterativeAdd( 'b' );
        bigTree.iterativeAdd( 'h' ); bigTree.iterativeAdd( 'h' );
        bigTree.iterativeAdd( 'n' ); bigTree.iterativeAdd( 'n' );
            bigTree.iterativeAdd( 'n' ); bigTree.iterativeAdd( 'n' );
        bigTree.iterativeAdd( 'v' ); bigTree.iterativeAdd( 'v' );
            bigTree.iterativeAdd( 'v' );
        bigTree.iterativeAdd( 'u' ); bigTree.iterativeAdd( 'u' );
        bigTree.iterativeAdd( 'x' );

        System.out.print( "bigTree: " );
        bigTree.show();
        System.out.println();
        System.out.println();


        
        //--- Test apply ---
        System.out.print( "Test apply( 1 ) - emptyTree: " );
        System.out.println( emptyTree.apply( 1 ) );
        System.out.println();

        System.out.print( "Test apply( 1 ) - singleNode: " );
        System.out.println( singleNode.apply( 1 ) + " haha");
        System.out.println();
        
        System.out.print( "Test apply( 1 ) - bigTree: " );
        System.out.println( bigTree.apply( 1 ) );
        System.out.println();
        
        System.out.print( "Test apply( 1 ) - zweiter Aufruf bigTree: " );
        System.out.println( bigTree.apply( 1 ) );
        System.out.println();
        
        System.out.print( "Test apply( 3 ) - bigTree: " );
        System.out.println( bigTree.apply( 3 ) );
        System.out.println();


    }
}

