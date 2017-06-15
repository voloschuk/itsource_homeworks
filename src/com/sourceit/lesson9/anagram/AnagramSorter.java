/**
 * Распечатать строки strings отсортировав по анограмности. Т.е.
 * - done, node, deno;
 * - none, neno;
 * - .....
 */

package com.sourceit.lesson9.anagram;

import com.sourceit.lesson9.anagram.Holder;

import java.util.*;

public class AnagramSorter {
    public static void main(String[] args) {
        List<String> strings =
                Arrays.asList("done", "node", "neno", "onion", "deno", "gram", "ramg", "nioon");

        /*Sort with HashSet*/
        Set<Holder> anagrams = new HashSet<>(strings.size());
        for (String string: strings) {
            Holder item = new Holder(string);
            anagrams.add(item);
        }
        System.out.println("Sorted with HashSet anagrams: " + anagrams);

        int hash = 0;
        String anagramString = " - ";
        for (Holder item: anagrams) {
            if (hash != 0 && item.hashCode() != hash) {
                System.out.println(anagramString.substring(0, anagramString.length()-1) + ";");
                anagramString = " - ";
            }
            hash = item.hashCode();
            anagramString += item.getItem() + ",";
        }
        if (anagrams.size() > 0) {
            System.out.println(anagramString.substring(0, anagramString.length() - 1) + ";");
        }

        /*Sort with Comparator*/
        strings.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return -1;
                } else if (o1.length() < o2.length()) {
                    return  1;
                }
                char[] chars1 = o1.toCharArray();
                char[] chars2 = o2.toCharArray();
                Arrays.sort(chars1);
                Arrays.sort(chars2);
                for (int i = 0; i < chars1.length; i++) {
                    if (chars1[i] > chars2[i]) {
                        return -1;
                    } else if (chars1[i] < chars2[i]) {
                        return 1;
                    }
                }
                return 0;
            }
        });
        System.out.println("Sorted with Comparator anagrams: " + strings);
    }
}
