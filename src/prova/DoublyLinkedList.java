package prova;

import generics.DoubleLinkedList;

import java.util.ArrayList;

public class DoublyLinkedList<T> {
    private Element first, last;
    private int size;
    public DoublyLinkedList() { first = last = null;
        size = 0; }
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

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

    public void blabla(DoubleLinkedList list, T cont)
    {
        ArrayList<Integer> aa = new ArrayList<Integer>();
    }
}

