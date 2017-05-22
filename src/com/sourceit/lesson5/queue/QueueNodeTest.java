package com.sourceit.lesson5.queue;

public class QueueNodeTest {
    public static void main(String[] args) {
        NodeQueueWrapper queue = new NodeQueueWrapper(new QueueNode(1));
        queue.addNode(new QueueNode(2));
        queue.addNode(new QueueNode(5));
        queue.printQueue();
        queue.printQueueRecurcive();

        getHeadAndPrintQueue(queue);
        getHeadAndPrintQueue(queue);
        getHeadAndPrintQueue(queue);
        getHeadAndPrintQueue(queue);

        System.out.println("Fill queue again using array: ");
        int[] elements = {1, 3, 5};
        fillQueueWithArray(queue, elements);
        queue.printQueue();
        System.out.println("Remove element num 0: ");
        queue.remove(0);
        queue.printQueue();
        System.out.println("Remove element num 2: ");
        queue.remove(2);
        queue.printQueue();
        System.out.println("Remove element num 1: ");
        queue.remove(1);
        queue.printQueue();
        System.out.println("Remove element num 0: ");
        queue.remove(0);
        queue.printQueue();
        System.out.println("Remove element num 0: ");
        queue.remove(0);
        queue.printQueue();

        queue.addNode(0, new QueueNode(1));
        queue.addNode(0, new QueueNode(3));
        queue.addNode(2, new QueueNode(5));
        queue.printQueue();
    }

    private static void getHeadAndPrintQueue(NodeQueueWrapper queue)
    {
        QueueNode head = queue.getHead();
        System.out.println(head != null ? head.getValue() : null);
        queue.printQueue();
    }

    private static void fillQueueWithArray(NodeQueueWrapper queue, int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            queue.addNode(new QueueNode(arr[i]));
        }
    }
}
