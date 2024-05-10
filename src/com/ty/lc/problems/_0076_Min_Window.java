package com.ty.lc.problems;

import java.util.HashSet;
import java.util.Set;

public class _0076_Min_Window {
    private static String findMinWindow(String source, String target) {
        if (source == null) {
            return null;
        }
        int left = 0, right = 0;
        Set<Character> set = new HashSet<>();
        while (right < source.length()) {
            Character c = source.charAt(right);
            right++;
            if (!containsAll(set, target)) {
                set.add(c);
            }
            System.out.println("left: " + left + ", right: " + right + ", substring: " + source.substring(left, right));
            while (containsAll(set, target)) {
                set.remove(source.charAt(left));
                left++;
            }
        }
        return source.substring(left, right);
    }

    private static boolean containsAll(Set<Character> set, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (!set.contains(target.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(findMinWindow(s, t));
    }
}
