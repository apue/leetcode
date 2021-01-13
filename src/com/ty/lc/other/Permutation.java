package com.ty.lc.other;

import java.util.LinkedList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permutation(int[] nums) {
        LinkedList<Integer> route = new LinkedList<>();
        backtrack(route, nums);
        return results;
    }

    private static final List<List<Integer>> results = new LinkedList<>();

    private static void backtrack(LinkedList<Integer> route, int[] nums) {
        if (route.size() == nums.length) {
            results.add(new LinkedList<>(route));
            return;
        }
        for (int num : nums) {
            if (route.contains(num)) {
                continue;
            }
            route.add(num);
            backtrack(route, nums);
            route.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = permutation(new int[]{1, 2, 3});
        for (List<Integer> row : result) {
            StringBuilder sb = new StringBuilder();
            for (int i : row) {
                sb.append(i);
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length() - 1);
            System.out.println(sb);
        }
    }
}
