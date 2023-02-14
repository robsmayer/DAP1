package generics;

import framework_strategies.DoubleInt_SubstitutionStrategy;

/**
 *      Double Linked List mixed generics with framework strategies and abstract classes
 * **/

public class DoubleLinkedList<T> {

    private Element first, last;
    private int size;

    private class Element
    {
        private T content;
        private Element pred,succ;

        public Element(T c)
        {
            content = c;
            pred = succ = null;
        }

        public T getContent(){ return content; }

        public void setContent(T c){content = c;}
        public boolean hasSucc(){    return succ != null;}
        public boolean hasPred(){    return pred != null;}
        public Element getPred(){return pred;}
        public Element getSucc(){return succ;}
        public void disconnectSucc(){
            if(hasSucc())
            {
                succ.pred = null;
                succ = null;
            }
        }
        public void disconnectPred(){
            if(hasPred())
            {
                pred.succ = null;
                pred = null;
            }
        }
        public void connectAsSucc(Element e){
            disconnectSucc();
            if(e != null)
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }
        public void connectAsPred(Element e){
            disconnectPred();
            if(e != null)
            {
                e.disconnectPred();
                e.succ = this;
            }
            pred = e;
        }

    }

    public DoubleLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public boolean isEmpty(){ return size == 0; }

    public void add(T content)
    {
        Element e = new Element(content);
        if(isEmpty()){
            first = last = e;
        } else {
            last.connectAsSucc(e);
            last = e;
        }
        size++;
    }

    public T getFirst(){
        if(!isEmpty())
            return first.getContent();
        else
            throw new IllegalStateException();
    }

    public void addArr(T[] arr)
    {
        if(arr.length > 0)
        {
            for(int i = 0; i < arr.length ; i++)
            {
                add(arr[i]);
            }
        }
    }

    public void show()
    {
        Element current = first;
        while(current != null)
        {
            if(current != last)
            {
                System.out.print(current + " , ");
            }
            else
                System.out.print(current);
            current = current.getSucc();
        }
    }

    public Iterator<T> forwardInterator() {
        return new ForwardIterator();
    }

    public Iterator<T> reverseIterator(){
        return new ReverseIterator();
    }

    private class ForwardIterator extends ListIteratore{
        public ForwardIterator(){
            current = first;
        }
        Element step()
        {
            return current.getSucc();
        }
    }

    private class ReverseIterator extends ListIteratore
    {
        public ReverseIterator()
        {
            current = last;
        }
        Element step()
        {
            return current.getPred();
        }
    }
    private abstract class ListIteratore extends Iterator<T>{
        Element current;

        abstract Element step();
        public boolean hasNext(){
            return current != null;
        }
        public T next(){
            if(hasNext())
            {
                T content = current.getContent();
                current = step();
                return content;
            }else
                throw new IllegalStateException();
        }
    }

    public static abstract class SubstitutuionStrategy<E>
    {
        public abstract E substitute(E ref);
    }

    public void substituteAll(SubstitutuionStrategy<T> s)
    {
        Element current = first;
        while(current != null)
        {
            current.setContent(s.substitute(current.getContent() ) );
            current = current.getSucc();
        }
    }
}
