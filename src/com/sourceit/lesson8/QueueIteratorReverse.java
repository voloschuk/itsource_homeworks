package com.sourceit.lesson8;

public class QueueIteratorReverse<T> extends QueueIteratorAbstract<T> {
    private Node<T>[] holder;
    private int position = -1;

    public QueueIteratorReverse(Node<T> tail) {
        super(tail);
    }

    public void setCurrent(Node<T> tail) {
        if (tail == null) {
            return;
        }
        int num = 0;
        Node current = tail;
        do {
            num++;
            current = current.getNext();
        } while (current != null);

        if (num > 0) {
            this.holder = new Node[num];
            int i = 0;
            current = tail;
            do {
                this.holder[i++] = current;
                current = current.getNext();
            } while (current != null);
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
        if (!this.hasNext()) {
            for (int i = 0; i < this.holder.length; i++) {
                this.holder[i] = null;
            }
        }
        return result;
    }
}
