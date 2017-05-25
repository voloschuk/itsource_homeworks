package com.sourceit.lesson5.stack;

import java.util.Arrays;

public class Stack {
    private static final int DEFAULT_STACK_SIZE          = 10;// ToDo: HomeWork - implement auto resize of inner array
    private static final int DEFAULT_CAPACITY_MULTIPLIER = 2; // ToDo: you should use this variable to increase/decrease
                                                              // ToDo: holder size in push() & pop() methods.
    private static final float DEFAULT_REDUCING_LIMIT = 0.4f; // If holder is filled less then this limit then reduce
                                                              // holder

    private int[] holder;
    private int currentPosition = -1;

    public Stack(int size) {
        this.holder = new int[size];
    }

    public Stack() {
        this.holder = new int[DEFAULT_STACK_SIZE];
    }

    public int pop() {
        if (currentPosition < 0) {
            System.err.println("No elements in stack, returning Integer.MIN_VALUE");
            return Integer.MIN_VALUE;
        }
        int result = holder[currentPosition--];
        if (((float) currentPosition / (float) holder.length) <= DEFAULT_REDUCING_LIMIT) {
            System.out.println("Is limit? " + ((float) currentPosition / (float) holder.length) + " " + DEFAULT_REDUCING_LIMIT);
            changeHolderCapacity(false);
        }
        return result;
    }

    public void push(int element) {
        if (currentPosition == holder.length - 1) {
            changeHolderCapacity(true);
        }
        holder[++currentPosition] = element;
    }

    public int peek() {
        if (currentPosition < 0) {
            return Integer.MIN_VALUE;
        }
        return holder[currentPosition];
    }

    public void print() {
        if (currentPosition < 0) {
            return;
        }
        int[] realStack = new int[currentPosition + 1];
        System.arraycopy(holder, 0, realStack, 0, currentPosition + 1);
        System.out.println(Arrays.toString(realStack));
    }

    private void changeHolderCapacity(boolean isIncrease)
    {
        int newHolderLength;
        int countCopiedElem;
        if (isIncrease) {
            newHolderLength = holder.length*DEFAULT_CAPACITY_MULTIPLIER;
            countCopiedElem = holder.length;
        } else {
            newHolderLength = holder.length/DEFAULT_CAPACITY_MULTIPLIER;
            countCopiedElem = currentPosition;
        }
        int[] newHolder = new int[newHolderLength];
        System.arraycopy(holder, 0, newHolder, 0, countCopiedElem);
        holder = newHolder;
    }
}
