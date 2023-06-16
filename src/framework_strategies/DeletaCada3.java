package framework_strategies;

public class DeletaCada3<S> implements DoublyLList.DeleteDelete<S> {

    private int remains;
    public DeletaCada3() {
        remains = 0;
    }

    @Override
    public boolean escolher(Object ref) {

        if(remains % 3 == 0)
        {
            remains ++;
            return false;
        }
        remains ++;
        return true;
      /*  if(remains % 3 != 0){
            remains ++;
            return true;
        }
        remains ++;
            return false;*/



    }
}
