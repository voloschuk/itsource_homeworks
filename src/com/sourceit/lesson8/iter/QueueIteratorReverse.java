package com.sourceit.lesson8.iter;

import java.util.Iterator;

public class QueueIteratorReverse<T> implements Iterator<T> {
    private Node<T>[] holder;
    private int position = -1;

    public QueueIteratorReverse(Node<T> tail) {
        if (tail == null) {
            return;
        }
        int num = 0;
        Node current = tail;
        do {
            num++;
            current = current.getNext();
        } while (current.getNext() != null);

        if (num > 0) {
            this.holder = new Node[num];
            int i = 0;
            do {
                this.holder[i++] = current;
                current = current.getNext();
            } while (current.getNext() != null);
            this.position = num - 1;
        }
    }

    @Override
    public boolean hasNext() {
        return this.position > - 1;
    }

    @Override
    public T next() {
        T result = this.holder[position].getValue();
        this.position--;
        return result;
    }

    @Override
    public void remove() {
        throw new IllegalStateException();
    }
}
