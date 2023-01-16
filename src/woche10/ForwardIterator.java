package woche10;

public class ForwardIterator extends ListIterator{
    public ForwardIterator(Element e)
    {
        super(e);
    }
    Element step()
    {
        return current.getSucc();
    }

    /** LESS ABSTRACT
    public Object next()
    {
        if(hasNext())
        {
            Object content = current.getContent();
            current = current.getSucc();
            return content;
        }
        else
        {
            throw new IllegalStateException();
        }
    }**/

    /*
            WITHOUT ABSTRACT CLASS LISTITERATOR
    private Element current;

    public ForwardIterator(Element e)
    {
        current = e;
        System.out.println(current==null);
    }

    public boolean hasNext()
    {
        return current != null; // but current is next ????
    }

    public Object next()
    {
        if(hasNext())
        {
            Object content = current.getContent();
            current = current.getSucc();
            return content;
        }else
        {
            throw new IllegalStateException();
    }}

     */


}
