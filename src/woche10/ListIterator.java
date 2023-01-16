package woche10;

import java.util.List;

public abstract class ListIterator {

    Element current;
    abstract Element step();
    public ListIterator(Element e)
    {
        current = e;
    }
    public boolean hasNext()
    {
        return current != null;
    }

    public Object next()
    {
        if(hasNext())
        {
            Object content = current.getSucc();
            current = step();
            return content;
        }
        else
        {
            throw new IllegalStateException("There is no next");
        }
    }




    /**
    public abstract Object next();
     **/
}
