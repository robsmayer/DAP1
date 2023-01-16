package praktikum5Woche8;

public class TreeTest
{
    public static void main( String[] args )
    {
        testEqualStructure();
        testRotate();
        testCompleteNodesAndStructure();
        testMinimumAndContains();
        preOrder_Height_Count_Encode();
    }

    /** testRotate: encode(), rotateNodeToRight(), resetCode() **/
    public static void testRotate()
    {
        char[] lola = {'k','h','o','f','n','j'};
        CharacterSearchTree tLola = new CharacterSearchTree(lola);

        System.out.println(" - tLola"); tLola.encode();
        tLola.show(); System.out.println(" - Pre-Order: "); tLola.showPreOrder(); System.out.println();

        CharacterSearchTree tJason = tLola.rotateNodeToRight();
        tJason.resetCode();
        tJason.encode();
        System.out.println(" - tJason");
        tJason.show();System.out.println(" - Pre-Order: "); tJason.showPreOrder();
    }

    /** Testing: addTo(char[] chars), containsCharacter(char t), longestCode()
     *           minimum(),                 **/

    public static void testMinimumAndContains()
    {
        char[] bro = {'l','f','k','p','c','d'}, bud = {'i','h','c','d','q','r','o'}, pBud = {'l','f','p','b','d','m','t'},
        tiny = {'p','r','b'};
        CharacterSearchTree pony = new CharacterSearchTree(bud), joey = new CharacterSearchTree(pBud), guy = new CharacterSearchTree(tiny);

        pony.show(); System.out.println(" add To char: "); pony.addTo(bro); pony.show(); // Works
        System.out.println(" - containsCharacter(m): " + joey.containsCharacter('m') + " - tiny " + guy.containsCharacter('z'));

        System.out.println("    ###  Minimum ###");
        System.out.println(" - Minimum of Joey (b) : " + joey.minimum() + " and of pony (c) : " + pony.minimum());

    }

    /** tests hasOnlyCompleteNodes() , equalStructure() **/
    public static void testCompleteNodesAndStructure()
    {
        char[] arr = {'k','h','o','f','j','o','n','p'}, nope = {'l','p', 'f','k','c','d'};
        CharacterSearchTree stuart = new CharacterSearchTree(arr);

        System.out.println(" - stuart : ");stuart.show();System.out.println(" - Pre-Order: ");stuart.showPreOrder();
        System.out.println(" - Has complete nodes: " + stuart.hasOnlyCompleteNodes());

        CharacterSearchTree lui = new CharacterSearchTree(nope);

        System.out.println();System.out.println(" - Lui : "); lui.show();System.out.println(" - Pre-Order: ");lui.showPreOrder();
        System.out.println(" - Has complete nodes: " + lui.hasOnlyCompleteNodes());
        System.out.println(" - Equal Structure: ");
    }

    /** Test equal structure - content of the Triples doesn't matter**/
    public static void testEqualStructure()
    {
        char[] guido = {'f','b','l','m','k','q'}; CharacterSearchTree tGuido = new CharacterSearchTree(guido);
        char[] mario = {'m', 'r','l','t','z','o'}; CharacterSearchTree tMario = new CharacterSearchTree(mario);
        char[] lala = {'m','r','w','v'}; CharacterSearchTree tLala = new CharacterSearchTree(lala);
        char[] matilde = {'a','b','z','x'}; CharacterSearchTree tMatilde = new CharacterSearchTree(matilde);
        char[] bibibi ={'k','d','v','c'}; CharacterSearchTree tBibibi = new CharacterSearchTree(bibibi);

        System.out.println(" - Guido : "); tGuido.show();System.out.println();System.out.println(" - Mario : ");
        System.out.println(" - Equal Structure Guido x Mario: " + tGuido.equalStructure(tMario)); System.out.println();

        System.out.println(" - Guido : "); System.out.println();System.out.println(" - Lala : ");tLala.show();
        System.out.println(" - Equal Structure Guido x Lala: " + tGuido.equalStructure(tLala)); System.out.println();

        System.out.println(" - Matilde : "); tMatilde.show();System.out.println();
        System.out.println(" - Equal Structure Lala x Matilde : " + tMatilde.equalStructure(tLala)); System.out.println();

        System.out.println(" - Bibibi : "); tBibibi.show();System.out.println();
        System.out.println(" - Equal Structure Lala x Bibibi : " + tBibibi.equalStructure(tLala)); System.out.println();
    }

    /** Testing: showPreOrder(), height(), countCharacters(), encode() **/
    public static void preOrder_Height_Count_Encode()
    {
        char[] chars = {'m','r','q','w','v'}; CharacterSearchTree lala = new CharacterSearchTree(chars);

        System.out.println(" - Pre-Order: "); lala.showPreOrder();
        System.out.println(" - Height: " + lala.height());

        lala.add('m',12,"");lala.add('w',8,"8585");lala.show();

        System.out.println(" - N characters = " + lala.countCharacters());
        lala.encode();
        lala.showPreOrder();


    }


     public static void asciiValues()
    {
        System.out.println("A = " +(int)'A');
        System.out.println("M = " +(int)'M');
        System.out.println("Z = " +(int)'Z');
        System.out.println();
        System.out.println("a = " +(int)'a');
        System.out.println("m = " +(int)'m');
        System.out.println("z = " + (int)'z');
    }

}

