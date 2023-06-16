
package testat7;

public class DoublyLinkedList
{
    // Insert element before the last
    // if list = null dont do nothing
    // increase attribute size

    public void apply( Object obj )
    {
        if(!isEmpty() && obj != null)
        {
            if(first != last)
            {
                Element theLast = last, predLast= theLast.getPred();
                Element toInsert = new Element(obj);

                theLast.disconnectPred();
                toInsert.connectAsSucc(theLast);
                predLast.connectAsSucc(toInsert);
                toInsert.connectAsPred(predLast);
                theLast.connectAsPred(toInsert);
                last = theLast;
            }
            else {
                Element toInsert= new Element(obj);
                first.connectAsPred(toInsert);
                toInsert.connectAsSucc(first);
                first = toInsert;
            }
            size++;
        }
    }


    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    // --- weitere Methoden zum Testen ---
    public void build( Object[] elems ) 
    {
        for ( Object e : elems ) { add( e ); }      
    }

    public String toString()
    {
        String result = "";
        Element current = first;
        while ( current != null )
        {
            result += current.getContent().toString();
            if ( current != last )
            {
                result += ", ";
            }
            current = current.getSucc();
        }
        return result;
    }
    // Element

    private class Element
    {
        private Object content;
        private Element pred, succ;

        Element( Object c )
        {
            content = c;
            pred = succ = null;
        }

        Object getContent()
        {
            return content;
        }

        void setContent( Object c )
        {
            content = c;
        }

        boolean hasSucc()
        {
            return succ != null;
        }

        Element getSucc()
        {
            return succ;
        }

        void disconnectSucc()
        {
            if ( hasSucc() ) 
            {
                succ.pred = null;
                succ = null;
            }
        }

        void connectAsSucc( Element e)
        {
            disconnectSucc();
            if ( e != null ) 
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        boolean hasPred()
        {
            return pred != null;
        }

        Element getPred()
        {
            return pred;
        }

        void disconnectPred()
        {
            if ( hasPred() )
            {
                pred.succ = null;
                pred = null;

            }
        }

        void connectAsPred( Element e )
        {
            disconnectPred();
            if ( e != null )
            {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }

    }
}    
