package woche7_8;

/**
 *      Folien bis 548
 *
 *   Tree defined recursively
 */
public class HuffmanTree {

    private HuffmanTriple content;
    private HuffmanTree leftChild, rightChild;

    public HuffmanTree(){   // Empty tree Constructor
        content = null;
        leftChild = null;
        rightChild =  null;
    }

    public HuffmanTree(HuffmanTriple h) // Tree node with content without child (leaf node)
    {
        content = h;
        leftChild = new HuffmanTree();
        rightChild = new HuffmanTree();
    }

    public boolean isEmpty(){
        return content == null;
    }

    public boolean isLeaf(){ //
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }
    public HuffmanTree(HuffmanTree lc, HuffmanTree rc) // Constructs the root of the binary tree
    {
        content = new HuffmanTriple(' ', lc.getContent().getQuantity() + rc.getContent().getQuantity() );
        leftChild =  lc;
        rightChild = rc;
    }

    public HuffmanTriple getContent()
    {
        if(!isEmpty()) {
            return content;
        }else
            throw new IllegalStateException("No content");
    }

    public int compareTo( HuffmanTree other )
    {
        if(!isEmpty() && !other.isEmpty())
        {
            return content.compareTo(other.content);
        }else
            throw new IllegalArgumentException("No compared with empty tree");

    }

    public void generateCodes()
    {
        if(!isEmpty() && !isLeaf())
        {
            leftChild.content.setCode(content.getCode() + "0");
            rightChild.content.setCode(content.getCode() + "1");
            leftChild.generateCodes();
            rightChild.generateCodes();
        }
    }

    public void showCodes()
    {
        if(!isEmpty())
        {
            if(isLeaf())
            {
                System.out.println(content.toString());
            }
            else
            {
                leftChild.showCodes();
                rightChild.showCodes();
            }
        }
    }


}
