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
        if (countNodes - position - 1 < 0) {
            System.out.println("Position is more than list size.");
            return;
        } else {
            QueueNode prev = getNodeBeforePosition(position);
            if (prev == null) {
                tail = tail.getNext();
            } else {
                QueueNode current = prev.getNext();
                prev.setNext(current.getNext());
            }
            countNodes--;
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
        if (countNodes - position < 0) {
            System.out.println("Position is more than list size.");
        } else {
            if (countNodes - position == 0) {
                node.setNext(tail);
                tail = node;
            } else {
                QueueNode prev = getNodeBeforePosition(position);
                QueueNode current;
                if (prev == null) {
                    current = tail;
                } else {
                    current = prev.getNext();
                }
                node.setNext(current.getNext());
                current.setNext(node);
            }
            countNodes++;
        }
    }

    /**
     * Gets then Node that located on the position starting from the head (start of the list)
     * if position is more than list size - prints error message
     * @param position number of the Node starting from the tail
     * @return Node that located on the position from the head (start of list) if position exists in list
     */
    public QueueNode getFromHead(int position) {
        if (countNodes - 1 - position < 0) {
            System.out.println("Position is more than list size.");
            return null;
        } else {
            QueueNode prev = getNodeBeforePosition(position);
            QueueNode current = null;
            if (prev == null) {
                current = tail;
                tail = tail.getNext();
            } else {
                current = prev.getNext();
                prev.setNext(current.getNext());
            }
            countNodes--;
            return current;
        }
    }

    /**
     * Returns previous node before searching position
     * @param position
     * @return Returns previous node before searching position
     */
    private QueueNode getNodeBeforePosition(int position)
    {
        int foundPos = countNodes - 1 - position;
        QueueNode prev = null;
        QueueNode current = tail;
        while (foundPos > 0) {
            prev = current;
            current = prev.getNext();
            foundPos--;
        }
        return  prev;
    }
}
