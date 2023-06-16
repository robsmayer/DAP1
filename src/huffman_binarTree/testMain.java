package huffman_binarTree;

public class testMain {

    public static void HuffTest(){
        HuffmanTriple[] tokens =
                {
                        new HuffmanTriple('a',30),
                        new HuffmanTriple('b',40),
                        new HuffmanTriple('k',99),
                        new HuffmanTriple('x', 10)
                };

        HuffmanCoding hc = new HuffmanCoding(tokens);
        hc.showCodeTable();
    }

    public static void testTest()
    {
        HuffmanTriple[] tokens =
                {
                        new HuffmanTriple('z',20),
                        new HuffmanTriple('v',30),
                        new HuffmanTriple('y',40),

                        new HuffmanTriple('u',45),

                        new HuffmanTriple('m',60),
                        new HuffmanTriple('w',80),
                        new HuffmanTriple('a',95)
                };

        HuffmanCoding hc = new HuffmanCoding(tokens);
        hc.showCodeTable();
    }

    public static void testBin(){
        //String s = "halloween";
        String s = "OMG eu nao sei oq estou fazentdo" +
                "e os franceses falam demais eu sou linda e maravilhosa" +
                "mas as vezes as pessoas me odeiam sim a vida eh assim";
        CharacterSearchTree hal = new CharacterSearchTree();
        for(int i = 0; i < s.length(); i++)
        {
            hal.add(s.charAt(i));
        }
        System.out.println("Binary Tree");
        System.out.println("--------------------");
        hal.show();
    }
   public static void main(String[] args)
    {
        testTest();
    }


    public static void otherTest()
    {
        String s = "halloween";

        CharacterSearchTree hal = new CharacterSearchTree();
        for(int i = 0; i < s.length(); i++)
        {
            hal.add(s.charAt(i));
        }

        HuffmanTriple[] lala = hal.toArray();
        HuffmanCoding saymyname = new HuffmanCoding(lala);

        saymyname.showCodeTable();

    }


}
