package com.zybaba.leetcode.dp;

import java.sql.Array;
import java.util.Arrays;

/**
 * @author tiandongbo
 * @date 2020/09/09 22:42
 * https://leetcode-cn.com/problems/coin-change/
 * 322. 零钱兑换
 */
public class CoinChangeTest {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
