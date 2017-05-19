package com.sourceit.lesson4;

public class FibonacciNumbers {
    public static void main(String[] args) {
        int fibonacci = fibonacci(11);
        System.out.println("Fibonacci number = " + fibonacci);
    }

    private static int fibonacci(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return  1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
