package com.sourceit.lesson5.queue;

public class NodeQueueWrapper {
    private QueueNode tail;
    private int countNodes;

    public NodeQueueWrapper(QueueNode node) {
        if (node != null) {
            tail = node;
            countNodes++;
        }
    }

    public void addNode(QueueNode node) {
        if (node != null) {
            node.setNext(tail);
            tail = node;
            countNodes++;
        }
    }

    public QueueNode getHead() {
        if (tail == null) {
            return tail;
        }
        if (tail.getNext() == null) {
            QueueNode current = tail;
            tail = null;
            countNodes--;
            return current;
        }
        QueueNode current = tail.getNext();
        QueueNode prev = tail;
        while (current.getNext() != null) {
            current = current.getNext();
            prev = prev.getNext();
        }
        prev.setNext(null);
        countNodes--;
        return current;
    }

    public void printQueue() {
        QueueNode current = tail;
        while (current != null) {
            System.out.print(current.getValue() + " --> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void printQueueRecurcive() {
        printRecurcive(tail);
        System.out.println("null");
    }

    private void printRecurcive(QueueNode current) {
        System.out.print(current.getValue() + " --> ");
        if (current.getNext() != null) {
            printRecurcive(current.getNext());
        }
    }

    /**
     * Removes Node from list that is located on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     **/
    public void remove(int position) {
        if (position < 0) {
            System.out.println("Position must be >= 0");
            return;
        }
        if (position <= countNodes - 1) {
            int foundPos = countNodes - 1 - position;
            if (foundPos == 0) {
                tail = tail.getNext();
            } else {
                QueueNode prev = tail;
                QueueNode current = prev.getNext();
                foundPos--;
                while (foundPos > 0) {
                    prev = current;
                    current = prev.getNext();
                    foundPos--;
                }
                prev.setNext(current.getNext());
            }
            countNodes--;
        } else {
            System.out.println("List is empty!");
        }
    }

    /**
     * Adds Node to list on position from head(start of the list).
     * If position is more than list size prints error message
     * @param position number of the Node starting from the head
     * @param node node should be inserted at position
     */
    public void addNode(int position, QueueNode node) {
        if (node == null) {
            System.out.println("Inserted node shouln'd be empty!");
            return;
        }
        if (countNodes == 0 && position == 0) {
            tail = node;
            countNodes++;
        } else if (position <= countNodes - 1) {
            int foundPos = countNodes - 1 - position;
            if (foundPos == 0) {
                node.setNext(tail);
                tail = node;
            } else {
                QueueNode prev = tail;
                QueueNode current = prev.getNext();
                foundPos--;
                while (foundPos >= 0) {
                    prev = current;
                    current = prev.getNext();
                    foundPos--;
                }
                prev.setNext(node);
                node.setNext(current);
            }
            countNodes++;
        }
    }

    /**
     * Gets then Node that located on the position starting from the tail (end of the list)
     * if position is more than list size - prints error message
     * @param position number of the Node starting from the tail
     * @return Node that located on the position from the tail (end of list) if position exists in list
     */
    public QueueNode getFromHead(int position) {
        /*Your code here and please remove "return null". I've put it for ability to compile code*/
        return null;
    }
}
