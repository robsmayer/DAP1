package prova;

public class BinarySearchTree<T extends Comparable<T>> {
        private T content;
        private BinarySearchTree<T> leftChild, rightChild;
        public BinarySearchTree() {
            content = null;
            leftChild = null;
            rightChild = null;
        }
        public T getContent() { return content; }
        public boolean isEmpty() { return content == null; }
        public boolean isLeaf() { return leftChild == null && rightChild == null; }

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
                BinarySearchTree<T> jojo = new BinarySearchTree<>();
                jojo.setContent(t);
            }
        }


    public void setContent(T t) {
    content = t;}


}
