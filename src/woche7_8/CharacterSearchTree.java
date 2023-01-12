package woche7_8;

public class CharacterSearchTree {

    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;

    public CharacterSearchTree(){
        content = null;
        leftChild = rightChild = null;
    }

    public boolean isEmpty(){
        return content == null;
    }
    public HuffmanTriple getContent()
    {
        if(!isEmpty()){
            return content;
        }else
            throw new IllegalStateException("Node/Tree is Empty");
    }

    public boolean isLeaf(){
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add(char t){
        if(isEmpty()) // next empty creates new Node or increment quantity of an already created node
        {
            content = new HuffmanTriple(t);
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        }
        else
        {
            if(t > content.getToken()){ // t bigger go right
                rightChild.add(t);
            }else
                if (t < content.getToken()){ // t smaller go left
                    leftChild.add(t);
                }
                else{
                    content.incrementQuantity(); // t same increment quantity
                }
        }
    }

    public int size()
    {
        if(!isEmpty())
        {
            return leftChild.size() + rightChild.size() + 1; //TODO: DOes the order maters ?
        }
        else return 0;
    }

    public void show(){
        if(!isEmpty())
        {
            leftChild.show();
            System.out.println(content.toString());
            rightChild.show();
        }
    }

    public HuffmanTriple[] toArray(){
        if(!isEmpty())
        {
            HuffmanTriple[] output = new HuffmanTriple[size()];
            toArray(output,0);
            return output;
        }
        else
            return new HuffmanTriple[0];
    }

    private int toArray(HuffmanTriple[] collector,int index){ //inOrder durchlauf
        if(!isEmpty())
        {
            index = leftChild.toArray(collector,index);
            collector[index] = content;
            index = rightChild.toArray(collector,index + 1);
        }
        return index;
    }

    public void iterativeAdd(char t)
    {
        CharacterSearchTree current = this;
        while(!current.isEmpty() && current.content.getToken() != t)
        {
            if(t > current.content.getToken())
            {
                current = current.rightChild;
            }else{
                current = current.leftChild;
            }
        }
        if(current.isEmpty())
        {
            current.content = new HuffmanTriple(t);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }else
        {
            current.content.incrementQuantity();
        }
    }
}
