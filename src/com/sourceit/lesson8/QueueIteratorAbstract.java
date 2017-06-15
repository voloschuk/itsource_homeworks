package com.sourceit.lesson8;

import java.util.Iterator;

public abstract class QueueIteratorAbstract<T> implements Iterator<T> {
    private QueueIteratorAbstract() {
    }

    public QueueIteratorAbstract(Node<T> node) {
        this.setCurrent(node);
    }

    public abstract void setCurrent(Node<T> tail);

    @Override
    public void remove() {
        throw new IllegalStateException();
    }
}
