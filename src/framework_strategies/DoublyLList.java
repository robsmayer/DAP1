package framework_strategies;

import doubleLinkedL_Vorlesung.Element;

public class DoublyLList {

    public static abstract class SubstitutionStrategy
    {
        public abstract Object substitute(Object ref);
    }
    public void substituteAll(SubstitutionStrategy s)
    {
        Element current = first;
        while(current != null)
        {
            current.setContent(s.substitute(current.getContent() ) );
            current = current.getSucc();
        }
    }
    public static abstract class InspectionStrategy
    {
        public abstract void inspect(Object ref);
    }

     public void inspectAll(InspectionStrategy s)
    {
        Element current = first;
        while(current != null)
        {
            s.inspect(current.getContent());
            current = current.getSucc();
        }
    }

    public static abstract class DeletionStrategy
    {
        public abstract boolean select(Object ref);
    }

    public interface SubstituirStrategia<S>{
        Object substituir(Object ref);
    }
    public void substituirCadaNelementos(SubstituirStrategia s, int n)
    {
        Element current = first;
        int control = 1;
        while(current != null && control < size && n < size)
        {
            if(control % n == 0)
            {
                current.setContent(s.substituir(current.getContent()));
            }
            current = current.getSucc();
            control ++;

        }
    }
    public interface DeleteDelete<S>{
        boolean escolher(Object ref);
    }

    public void deleteTheEscolhido(DeleteDelete<Object> ref){
        Element current = first;
        while(current != null)
        {
            Element candidate = current;
            current = current.getSucc();
            if(ref.escolher(candidate.getContent()))
            {
                remove(candidate);}
        }

    }

    public void deleteSelected(DeletionStrategy s)
    {
        Element current = first;
        while(current != null)
        {
            Element candidate = current;
            current = current.getSucc();
            if(s.select(candidate.getContent() ) )
            {
                remove(candidate);
            }
        }
    }

    private void remove(Element e)
    {
        if(e != null)
        {
            if(e.hasSucc() && e.hasPred()) // Middle
            {
                e.getPred().connectAsSucc(e.getSucc());
            } else if( e == first && e.hasSucc()) // is first list has more elements
            {
                first = first.getSucc();
                first.disconnectPred();
            } else if( e == last && e.hasPred()) // is last but list has more elements
            {
                last = last.getPred();
                last.disconnectSucc();
            } else // list has only one element
            {
                first = last = null;
            }
            size --;
        }
    }
    private Element first,last;
    private int size;

    public DoublyLList(){
        first = last = null;
        size = 0;
    }


    public void addIntArr(int[] intArr)
    {
        if(intArr.length > 0)
        {
            for(int i = 0; i < intArr.length; i++)
            {
                this.add(intArr[i]);
            }

        }
    }

    public void add(Object obj)
    {
        if(obj != null)
        {
            Element elm = new Element(obj);
            if(isEmpty())
            {
                first = last = elm;
            }
            else {
                    last.connectAsSucc(elm);
                    last = elm;
                }
            size ++;
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void removeAt(int index)
    {
        if(!isEmpty() && index > 0 && index < size)
        {
            Element current = first;
            for(int i = 0; i < index ; i++)
            {
                current = first.getSucc();
            }

            current.getPred().connectAsSucc(current.getSucc());
            current.getSucc().connectAsPred(current.getPred()); // Necessary ?

            current = null; size --;
        }
    }


    public void show()
    {
        Element current = first;

        while(current != null)
        {
            if(current == first)
            {
                System.out.print("L = [ " + current.toString() + " , " );
            }
            else
            if(current == last)
                System.out.print(current.toString() + " ]");
            else
                System.out.print(current.toString() + " , ");
            current = current.getSucc();
        }

        System.out.println();

    }


}
