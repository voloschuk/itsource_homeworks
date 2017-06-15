package com.sourceit.lesson9.anagram;

import java.util.Arrays;

public class Holder<T extends String> {
    private T item;

    public Holder(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Holder)) return false;

        Holder<?> holder = (Holder<?>) o;

        return getItem().equals(holder.getItem());
    }

    @Override
    public int hashCode() {
        String item = (String) getItem();
        char[] chars = item.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);
        int hash = sorted.hashCode();
        return hash;
    }

    @Override
    public String toString() {
        return item;
    }
}
