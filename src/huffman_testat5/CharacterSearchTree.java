package huffman_testat5;

public class CharacterSearchTree
{

    //--- hier ergaenzen ---
public int apply(int i)
{
    if(!isEmpty() && !isLeaf())// && content.getQuantity() != i)
    {
        if(content.getQuantity() != i && !leftChild.isEmpty() && !rightChild.isEmpty())
            return 1 + leftChild.apply(i) + rightChild.apply(i);
        else
            if(content.getQuantity() == i)
                return leftChild.apply(i) + rightChild.apply(i);
            else
                if(!leftChild.isEmpty())
                    return leftChild.apply(i);
                else
                    if(!rightChild.isEmpty())
                        return rightChild.apply(i);

        return 0;

    }
    else
        return 0;
}


    
// --- Vorgaben ---
private HuffmanTriple content;
private CharacterSearchTree leftChild, rightChild;

public CharacterSearchTree() 
{
content = null;
leftChild = null;
rightChild = null;
}

public HuffmanTriple getContent()
{
if ( !isEmpty() )
{
return content;
} else {
throw new RuntimeException();
}
}

public boolean isEmpty() 
{
return content == null;
}

public boolean isLeaf() 
{
return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
}

public void iterativeAdd( char t )
{
CharacterSearchTree current = this;
while ( !current.isEmpty() && current.content.getToken() != t )
{
if ( current.content.getToken() > t )
{
current = current.leftChild;
}
else
{
current = current.rightChild;
}
}
if ( current.isEmpty() ) 
{
current.content = new HuffmanTriple( t );
current.leftChild = new CharacterSearchTree();
current.rightChild = new CharacterSearchTree();
}
else
{
current.content.incrementQuantity();
}
}

public void show()
{
if ( !isEmpty() ) 
{
leftChild.show();
System.out.println( content.toString() );
rightChild.show();
}
}

}
