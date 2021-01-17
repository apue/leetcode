package com.ty.lc.dp;

public class Coins {
    public static int coinChange(int[] coins, int amount) {
        return dp(coins, 11);
    }

    private static int dp(int[] coins, int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int cnt = dp(coins, n - coin);
            if (cnt >= 0 && cnt < min) {
                min = cnt;
            }
        }
        min = min + 1;
        return min;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int count = coinChange(coins, 11);
        System.out.println(count);
    }
}
