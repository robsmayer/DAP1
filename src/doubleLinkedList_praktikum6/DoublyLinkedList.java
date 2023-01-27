
/**"C:\Users\Roberta\tuDortmund\Dap1\DAP-1_Praktikumsblatt-06\DAP-1_Praktikumsblatt-06.pdf"**/

package doubleLinkedList_praktikum6;

public class DoublyLinkedList
{
    private Element first, last;
    private int size;

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public void clear()
    {
        if(!isEmpty())
        {
            Element current = first;
            if(current != last)
            {
                while (current != null)
                {
                    current = current.getSucc();
                    current.disconnectPred();

                    if(current == last)
                        current = last = null;
                }

            } else {
                first = last = null;
            }
        }
    }

    public void percorreTdsForward()
    {
        if(isEmpty())
            throw new IllegalStateException("Empty list");
        else
        {
            Element current = first;

            while(current != null)
            {
                /**     Faz algo       **/

                current = current.getSucc();
            }
        }
    }

    public Element getLast()
    {
        if(isEmpty())
            throw new IllegalStateException();
        else
        {
            return last;
        }
    }

    public boolean contains(Object obj)
    {
        if(isEmpty())
            throw new IllegalStateException("Empty list");
        else
        {
            Element current = first;

            while(!current.equals(obj) && current != null)
            {
                current = current.getSucc();
            }
            return current != null;
        }
    }

    public int count(Object obj)
    {
        if(isEmpty())
            return 0;
        else
        {
            Element current = first, mirror = new Element(obj);
            int c = 0;
            while(current != null)
            {
                if(mirror.equals(current))
                    c++;
                current = current.getSucc();
            }
            return c;
        }
    }

    //TODO: check if correct
    public boolean allEqual()
    {
        if(isEmpty())
            throw new IllegalStateException("   List is Empty   ");
        else
        {
            Element current = first;
            while(current != null)
            {
                if(current.hasSucc())
                {
                    if(!current.equals(current.getSucc()))
                        return false;
                    current = current.getSucc();
                }
            }
            return true;
        }
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

    public void addFirst( Object content ) 
    {
        Element e = new Element( content );
        if ( isEmpty() ) 
        {
            first = last = e;
        }
        else 
        {
            first.connectAsPred( e );
            first = e;
        }
        size++;
    }

    public Object getFirst() 
    {
        if ( !isEmpty() )
        {
            return first.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object get( int index ) 
    {
        if ( index >= 0 && index < size )
        {
            Element current = first;
            for ( int i = 0; i < index; i++ )
            {
                current = current.getSucc();
            }
            return current.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object removeFirst()
    {
        if ( !isEmpty() ) 
        {
            Object result = first.getContent();
            if ( first.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            }
            else
            {
                first = last = null;
            }
            size--;
            return result;
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent() );  // impliziter Aufruf von toString, falls != null
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    public boolean containsdouble()
    {
        if(isEmpty()){
            throw new IllegalStateException();
        }
        else
        {
            Element current = first;
            if(!current.hasSucc()) {
                return false;
            }
            Element next = current.getSucc();
            while(current != null || next != null)
            {
                if(current.equals(next))
                {
                    return true;
                }
            }
            return false;
        }
    }

}
