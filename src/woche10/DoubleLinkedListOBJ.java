package woche10;

public class DoubleLinkedListOBJ {

    private Element first,last;
    private int size;

    public DoubleLinkedListOBJ(){
        first = last = null;
        size = 0;
    }

    // Creates list with array of objects
    public DoubleLinkedListOBJ(Object[] arr){
        if(arr.length > 0)
        {
            DoubleLinkedListOBJ list = new DoubleLinkedListOBJ();

            for(int i = 0; i < arr.length; i++)
            {
                list.add(arr[i]);
            }

            list.showAll();
        }
        else
            throw new IllegalArgumentException();
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(Object content){
        if(content != null){
            Element e = new Element(content);
            if(isEmpty()){
                first = last = e;
                // size ++ aqui ou no fim
            }
            else
            {
                last.connectAsSucc(e);
                last = e;
            }
            size ++;
        }
    }

    public void addFirst(Object content){
        Element e = new Element(content); // check if null
        assert content!=null;
        if(isEmpty()){
            first = last = e;
            size++;
        }else{
            first.connectAsPred(e);
            first = e;
        }
        size++;
    }

    // i = index of list 0 ... size -1
    public Object getAt(int index){
        assert !isEmpty();
        if(index > -1 && index <= size -1 )
        {
            if(index == 0)
                return first.getContent();
            Element aux = first;
            for(int i = 0; i <= index ; i++){
                aux = aux.getSucc();
            }
            return aux.getContent();
        }else
            throw new IndexOutOfBoundsException();
    }

    public Object removeFirst(){
        if(!isEmpty()){
            Object out = first.getContent();
            if(first.hasSucc()){
                first = first.getSucc();
                first.disconnectPred(); // Because disconnectPred already freed first
            }else
                first = last = null;
           size--;
            return out;
        }
        else
            throw new IllegalStateException();
    }

    public void addArr(Object[] cont){
        if(cont.length > 0){
            for(int i = 0; i < cont.length; i++){
                add(cont[i]);
            }
        }else
            throw new IllegalArgumentException();
    }

    public void showAll(){
        Element current = first; // No need to check if list is empty because current will be null
        while(current != null){
            if(current != last)
                System.out.print(current.toString() + " , ");
            else
                System.out.print(current.toString());
            current = current.getSucc();
        }
        System.out.println();
    }



    /**
     *  Iterator methods
     */

    public ForwardIterator iterator()
    {
        return new ForwardIterator(first);
    }

    public ReverseIterator revIterator()
    {
        return new ReverseIterator(last);
    }






}
