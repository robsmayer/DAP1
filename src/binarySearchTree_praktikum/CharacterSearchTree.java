package binarySearchTree_praktikum;

public class CharacterSearchTree
{

    // Vorgaben

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

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
            current.content = new HuffmanTriple(t);
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


 public void encode()
    {
        if(!isEmpty())
        {
            if(content.getCode().equals("")) // To set root as "0"
                content.setCode("0");

            if(!leftChild.isEmpty()) // Left child gets code of parent + "0" concatenation(?)
            {                        // Zero means the left side
                leftChild.content.setCode(content.getCode() +  "0");
                leftChild.encode();
            }
            if(!rightChild.isEmpty()) // Right child receives the code of parent + "1"
            {
                rightChild.content.setCode(content.getCode() + "1");
                rightChild.encode();
            }
        }

    }

    public void resetCode()
    {
        if(!isEmpty())
        {
            content.setCode("");
            leftChild.resetCode();
            rightChild.resetCode();

        }

    }
    public void showPreOrder()
    {
        if(!isEmpty())
        {
            System.out.println(content.toString());
            leftChild.showPreOrder();
            rightChild.showPreOrder();
        }
    }

    public void showInOrder()
    {
        if(!isEmpty())
        {
            leftChild.showInOrder();
            System.out.println(content.toString());
            rightChild.showInOrder();
        }
    }

    public void showPostOrder()
    {
        if(!isEmpty())
        {
            leftChild.showPostOrder();
            rightChild.showPostOrder();
            System.out.println(content.toString());
        }
    }

    public CharacterSearchTree(char[] chars)
    {
        if(chars.length != 0)
        {
            for(char aChar: chars)
            {
                iterativeAdd(aChar);
            }
        }
    }

    public int height()
    {
        if(!isEmpty())
        {
            if(!isLeaf())
            {
                if(leftChild.isEmpty())
                    return 1 + rightChild.height();
                else
                    if(rightChild.isEmpty())
                        return 1 + leftChild.height();
                    else
                        return leftChild.height() + rightChild.height();

            }
            else
                return 1;

        }
        else
            return 0;

    }

    public int countCharacters() //Count quantity of all contents
    {
        if(isEmpty())
            return 0;
        else
        {
            if(isLeaf())
                return content.getQuantity(); // Has no children
            else {
                if (!leftChild.isEmpty() && !rightChild.isEmpty()) // has right and left
                    return content.getQuantity() + leftChild.countCharacters() + rightChild.countCharacters();
                else if (!leftChild.isEmpty()) // Only left
                    return content.getQuantity() + leftChild.countCharacters();
                else  // Only right
                    return content.getQuantity() + rightChild.countCharacters();
            }
        }
    }

    public void addTo(char[] chars)
    {
        if(chars.length > 0)
        {
            if(!isEmpty())
            {
                for(char aChar: chars)
                {
                    iterativeAdd(aChar);
                }
            } else
            {
                new CharacterSearchTree(chars);
            }
        }
        else
            throw new IllegalArgumentException();
    }

    public boolean hasOnlyCompleteNodes()
    {
        if(!isEmpty())
        {
            if(!isLeaf())
            {
                if(leftChild.isEmpty() && !rightChild.isEmpty()|| !leftChild.isEmpty() && rightChild.isEmpty())
                {
                    return false;
                }
                else
                    return leftChild.hasOnlyCompleteNodes() && rightChild.hasOnlyCompleteNodes();
            }

            return true;
        }

        return true;
    }

    public boolean containsCharacter(char t)
    {
        if(!isEmpty())
        {
            if(t > content.getToken())
            {
                return rightChild.containsCharacter(t);
            }else
                if(t < content.getToken())
                {
                    return leftChild.containsCharacter(t);
                }
                else {
                    return true;
                }

        }else
            return false;
    }

    public int longestCode()
    {
        if(isEmpty())
            return 0;
        else
        {
            int longest = 0; CharacterSearchTree current = this;
            while(!current.isEmpty())
            {
                if(longest < current.getContent().getCode().length())
                    longest = current.getContent().getCode().length();
                current = current.leftChild;
                current = current.rightChild;
            }

            return longest;
        }
    }

    public HuffmanTriple minimum()
    {
        if(isEmpty())
        {
            throw new IllegalStateException();
        }else
        {
            CharacterSearchTree minimum = this;

            while(!minimum.leftChild.isEmpty())
            {
                minimum = minimum.leftChild;
            }

            return minimum.content;
        }
    }

    // Could be done by comparing the encoding
    public boolean equalStructure(CharacterSearchTree other)
    {
        if(!isEmpty() && !other.isEmpty())
        {
            return leftChild.isEmpty() && !other.leftChild.isEmpty() || !leftChild.isEmpty() && other.leftChild.isEmpty()
            || rightChild.isEmpty() && !other.rightChild.isEmpty() || !rightChild.isEmpty() && other.rightChild.isEmpty();

        }
        else
            return isEmpty() && other.isEmpty();
    }

    public CharacterSearchTree rotateNodeToRight()
    {
        if(!isEmpty() || !leftChild.isEmpty())
        {
            CharacterSearchTree out = leftChild, aux = this;

            if(!out.rightChild.isEmpty())
            {
                aux.leftChild = out.rightChild;
            } else
            {
                aux.leftChild = new CharacterSearchTree();
            }

            out.rightChild = aux;
            return out;
        }
        else
            return this;
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
