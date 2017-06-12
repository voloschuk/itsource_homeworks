package com.sourceit.lesson8.iter;

public class QueueIteratorDirect<T> extends QueueIteratorAbstract<T> {
    private Node<T> current;

    public QueueIteratorDirect(Node<T> tail) {
        super(tail);
    }

    public void setCurrent(Node<T> tail) {
        current = tail;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T result = current.getValue();
        current = current.getNext();
        return result;
    }
}
