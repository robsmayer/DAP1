package generics;


public class BinarySearchTree< T  extends Comparable<T> > {

    private T content;
    BinarySearchTree<T> leftChild, rightChild;

    public BinarySearchTree()
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public T getContent(){ return content; }
    public boolean isEmpty(){ return content == null; }
    public boolean isLeaf(){ return leftChild == null && rightChild == null; }
    public void setContent(T t){ content = t; }



    public int size()
    {
        if(isEmpty())
            return 0;
        else {
            return 1 + leftChild.size() + rightChild.size();
        }
    }

    public boolean contains(T t)
    {
        if(isEmpty())
            return false;
        else
        {
            if(content.compareTo(t) > 0)
                return leftChild.contains(t); // content is bigger than t
            else
                if(content.compareTo(t) < 0)
                    return rightChild.contains(t);
                else
                    return true;
        }
    }

    public void add(T t)
    {
        if(!isEmpty())
        {
            if(content.compareTo(t) > 0)
            {
                leftChild.add(t);
            }
            else
            {
                rightChild.add(t);
            }
        }
        else
        {
            BinarySearchTree<T> jojo = new BinarySearchTree<T>();
            jojo.setContent(t);
            leftChild =  new BinarySearchTree<T>();
            rightChild =  new BinarySearchTree<T>();
        }
    }

    public void add(T[] arr)
    {
        if(arr.length > 0 && arr != null)
        {
            for(T t : arr)
            {
                add(t);
            }
        }

    }


    public void inOrder()
    {
        if(!isEmpty())
        {
            leftChild.preOrder();
            System.out.print(content.toString());
            rightChild.preOrder();
        }
    }

    public void preOrder()
    {
        if(!isEmpty())
        {
            System.out.print(content.toString());
            leftChild.preOrder();
            rightChild.preOrder();
        }
    }

    public void postOrder()
    {
        if(!isEmpty())
        {
            leftChild.postOrder();
            rightChild.postOrder();
            System.out.print(content.toString());
        }

    }

}
