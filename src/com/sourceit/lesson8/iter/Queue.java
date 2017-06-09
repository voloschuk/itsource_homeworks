package com.sourceit.lesson8.iter;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node<T> tail;

    public Queue() {
        tail = null;
    }

    public void add(T value) {
        Node node = new Node();
        node.setValue(value);
        node.setNext(tail);
        tail = node;
    }

    public T get() {
        if (tail == null) {
            return null;
        }

        if (tail.getNext() == null) {
            T result = tail.getValue();
            tail = null;
            return result;
        }

        Node<T> current = tail;
        Node newLastNode = null;
        while (current.getNext() != null) {
            newLastNode = current;
            current = current.getNext();
        }

        newLastNode.setNext(null);
        return current.getValue();
    }

    @Override
    public String toString() {
        String result = "";
        Node current = tail;
        while (current != null) {
            result += current.getValue() + (current.getNext() != null ? " --> " : "");
            current = current.getNext();
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIteratorReverse<>(tail);
    }
}
