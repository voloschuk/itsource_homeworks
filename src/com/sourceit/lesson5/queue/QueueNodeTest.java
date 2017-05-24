package com.sourceit.lesson5.queue;

import java.util.Queue;

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
        queue.addNode(0, new QueueNode(5));
        queue.addNode(1, new QueueNode(4));
        queue.addNode(3, new QueueNode(2));
        queue.addNode(5, new QueueNode(0));
        queue.addNode(7, new QueueNode(10));
        queue.printQueue();

        System.out.println("Get from head.");
        System.out.println(queue.getFromHead(0).getValue());
        System.out.println(queue.getFromHead(0).getValue());
        System.out.println(queue.getFromHead(3).getValue());
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
