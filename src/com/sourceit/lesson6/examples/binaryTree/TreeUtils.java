package com.sourceit.lesson6.examples.binaryTree;

public class TreeUtils {

    public static int getDepth(BinaryTree tree) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (tree.getLeft() != null) {
            leftDepth = getDepth(tree.getLeft());
        }
        if (tree.getRight() != null) {
            rightDepth = getDepth(tree.getRight());
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static int getSum(BinaryTree tree)
    {
        int sum = tree.getValue();
        if (tree.getLeft() != null) {
            sum += getSum(tree.getLeft());
        }
        if (tree.getRight() != null) {
            sum += getSum(tree.getRight());
        }
        return sum;
    }

    public static int getMin(BinaryTree tree)
    {
        int min = tree.getValue();
        if (tree.getLeft() != null) {
            int treeMin = getMin(tree.getLeft());
            if (treeMin < min) {
                min = treeMin;
            }
        }
        if (tree.getRight() != null) {
            int treeMin = getMin(tree.getRight());
            if (treeMin < min) {
                min = treeMin;
            }
        }
        return min;
    }

    public static int getMax(BinaryTree tree)
    {
        int max = tree.getValue();
        if (tree.getLeft() != null) {
            int treeMin = getMax(tree.getLeft());
            if (treeMin > max) {
                max = treeMin;
            }
        }
        if (tree.getRight() != null) {
            int treeMin = getMax(tree.getRight());
            if (treeMin > max) {
                max = treeMin;
            }
        }
        return max;
    }
}
