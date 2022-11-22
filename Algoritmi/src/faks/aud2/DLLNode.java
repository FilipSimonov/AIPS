package faks.aud2;

public class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;
    protected int numOccurrences;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
        this.numOccurrences = 1;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}
