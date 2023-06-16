package exercise_sheets.BinarySearchTree;

public class Ubungsblatt8 {
    public static class Node {
        private char token;

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        private int value;

        public Node() {
            token = ' ';
            value = 0;
        }

        public Node(char t, int v) {
            token = t;
            value = v;
        }

        public char getToken() {
            return token;
        }

        public void setToken(char a) {
            token = a;
        }

        public boolean isEmpty() {
            return token == ' ' || value == 0;
        }

        public boolean vGreaterThan(int x) {
            return value - x > 0;
        }

        public boolean vSmallerThan(int x) {
            return value - x < 0;
        }

        public boolean vIsEqual(int x) {
            return value - x == 0;
        }

        public String toString() {
            return "( " + token + " , " + value + " )";
        }

    }

    // BST = Binary Search Tree
    public static class SimpleBST {
        private Node node;
        private SimpleBST leftChild, rightChild;

        public SimpleBST() {
            node = null;
            leftChild = rightChild = null;
        }

        public boolean isEmpty(){
            return node == null;
        }


        public void addNodeChar(char c) { //adds node considering char compare
            SimpleBST current = this;
            int i = 1;

            while (!current.isEmpty() && current.node.getToken() != c) {

                if (current.node.getToken() > c) {

                    current = current.leftChild;

                } else if (current.node.getToken() < c) {
                    current = current.rightChild;
                }
                i++;
            }
            /* Super importante: se novo nodo, tem que colocar
              if(current.node == null) e nao current == null
              se nao nao cria outro nodo */
            if (current.node == null) {

                current.node = new Node(c, i);
                current.leftChild = new SimpleBST();
                current.rightChild = new SimpleBST();
            }
            // Else if I want to do something with a node with the same data
        }

        public void addNodeValue(int x) {
            SimpleBST current = this;
            int i = 97;

            //Fazer sempre um current.isEMpty por alguma rarao da errado
            while (!current.isEmpty()&&current.node.getValue() != x) {
                if (current.node.vGreaterThan(x)) {
                    current = current.leftChild;
                } else if(current.node.vSmallerThan(x))
                {
                    current = current.rightChild;
                }
                if (i > 122)
                    i = 97;
                i++;
            }
            if (current.node == null) {
                current.node = new Node((char) i, x);
                current.leftChild = new SimpleBST();
                current.rightChild = new SimpleBST();
            }
        }

        public boolean isLeaf() {
            return leftChild == null && rightChild == null;
        }

        public void postOrder() {
            if (node != null) {
                leftChild.postOrder();
                rightChild.postOrder();
                System.out.print(node.toString() + " ");
            }
        }

        public void preOrder(){
            if (node != null) {
                System.out.print(node.toString() + " ");
                leftChild.preOrder();
                rightChild.preOrder();
            }
        }

        public void inOrder(){
            if(node != null)
            {
                leftChild.inOrder();
                System.out.print(node.toString() + " ");
                rightChild.inOrder();
            }
        }
    }

    public static void main(String[] args)
    {
        SimpleBST intTree = new SimpleBST();
        intTree.addNodeValue(25);intTree.addNodeValue(15);intTree.addNodeValue(50);
        intTree.addNodeValue(70);intTree.addNodeValue(35);intTree.addNodeValue(10);
        intTree.addNodeValue(4);intTree.addNodeValue(22);intTree.addNodeValue(12);
        intTree.addNodeValue(18);intTree.addNodeValue(66);intTree.addNodeValue(31);
        intTree.addNodeValue(24);intTree.addNodeValue(44);intTree.addNodeValue(90);

        System.out.println("\t PreOrder (int values considered)");
        intTree.preOrder();

        System.out.println("\n\t PostOrder (int values considered)");
        intTree.postOrder();

        System.out.println("\n\t InOrder (int value considered)");
        intTree.inOrder();
    }

    public static void testChar()
    {
        SimpleBST charTree = new SimpleBST(); // Char ordened tree
        charTree.addNodeChar('k');charTree.addNodeChar('e');
        charTree.addNodeChar('f');charTree.addNodeChar('p');
        charTree.addNodeChar('r');charTree.addNodeChar('m');

        System.out.println("\t PreOrder (char value considered)");
        charTree.preOrder();
        System.out.println("\n\t PostOrder (char value considered)");
        charTree.postOrder();
        System.out.println("\n\t InOrder (char value considered)");
        charTree.inOrder();
    }

}
