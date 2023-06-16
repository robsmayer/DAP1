package exercise_sheets.BinarySearchTree;

import binarySearchTree_praktikum.HuffmanTriple;

/**
 *      Methods implemented from
 *          CharacterSearchTree biggestInLeft();
 *          void delete() - will use biggestInLeft - biggest token
 * **/
public class CharacterSearchTree
{
    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree biggestInLeft()
    {
        if(!leftChild.isEmpty())
        {
            CharacterSearchTree biggest = this.leftChild;
            while(!biggest.rightChild.isEmpty())
            {
                biggest = rightChild;
            }
            return rightChild;
        }
        else
            return leftChild;
    }
    public CharacterSearchTree(char c)
    {
        iterativeAdd(c);
    }
    public CharacterSearchTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public void add(char t, int q, String c)
    {
        CharacterSearchTree current = this;

        while(!current.isEmpty() && current.content.getToken() != t)
        {
            if (current.content.getToken() > t)
            {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if(current.isEmpty())
        {
            current.content = new binarySearchTree_praktikum.HuffmanTriple(t);
            current.content.setCode(c);

            for(int i = 1; i <= q; i++)
                current.content.incrementQuantity();

            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }
        else
        {
            current.content.setCode(c);
            for(int i = 1; i <= q; i++)
                current.content.incrementQuantity();
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

    public void inOrder(){
        if(!isEmpty())
        {
            leftChild.inOrder();
            System.out.print(" " + content.toString());
            rightChild.inOrder();
        }
    }




}
