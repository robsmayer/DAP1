package doubleLinkedL_Vorlesung;

public class ReverseIterator {

    private Element current;
    public ReverseIterator(Element e)
    {
        current = e;
    }

    public boolean hasNext(){
        return current !=  null;
    }

    Element step()
    {
        return current.getPred();
    }

    /**
    public Object next(){
        if(hasNext())
        {
            Object content = current.getContent();
            current = current.getPred();
            return content;
        }
        else
        {
            throw new IllegalStateException();
        }
    }**/
}
