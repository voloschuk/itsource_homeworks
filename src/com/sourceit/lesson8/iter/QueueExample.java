package com.sourceit.lesson8.iter;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> stringQueue = new Queue<>();
        stringQueue.add("123");
        stringQueue.add("XZD");
        stringQueue.add("Gftaf");
        System.out.println(stringQueue);

        for (String s : stringQueue) {
            System.out.print(s + " -> ");
        }

        System.out.println();
        stringQueue.add("New element");
        stringQueue.setReverseOrder(true);
        for (String s : stringQueue) {
            System.out.print(s + (stringQueue.getIterator().hasNext() ? " -> " : ""));
        }

    }
}
