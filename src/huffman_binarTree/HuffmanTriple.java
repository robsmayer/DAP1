package huffman_binarTree;

/**
 *  Folien Bis 548
 *      Datenkompression
 *
 *    Left side -> 0    Right side -> 1
 *    Make the tree counting the number times used
 */

public class HuffmanTriple {

    private char token; // Character
    private int quantity; // Number of occurences
    private String code; // Place of the node

    public HuffmanTriple(char t, int q)
    {
        token = t;
        quantity = q;
        code = "";
    }

    public HuffmanTriple(char t)
    {
        this(t,1);
    }

    public HuffmanTriple()
    {
        this(' ',0);
    }

    public char getToken()
    {
        return token;
    }

    public String getCode()
    {
        return code;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setCode(String c)
    {
        code = c;
    }

    public void incrementQuantity()
    {
        quantity++;
    }

    public int compareTo(HuffmanTriple other)
    {
        return quantity - other.quantity; // Compare quantity
    }

    public String toString()
    {
        return token + " : " + quantity + "  -> code: " + code;
    }

}
