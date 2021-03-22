import java.util.LinkedList;

public class TqsStack<T> {

    private LinkedList<T> elementsCollection = new LinkedList<>();
    private int limit = -1;

    public TqsStack(){
    }

    public TqsStack(int limit) {
        this.limit = limit;
    }

    public void push(T item){
        if(this.limit > 0) {
            if (elementsCollection.size() < limit)
                elementsCollection.addFirst(item);
            else
                throw new IllegalStateException();
        } else {
            elementsCollection.addFirst(item);
        }
    }

    public T pop() {
        return elementsCollection.removeFirst();
    }

    public T peek() {
        return elementsCollection.getFirst();
    }

    public int size() {
        return elementsCollection.size();
    }

    public boolean isEmpty(){
        return elementsCollection.isEmpty();
    }
}
