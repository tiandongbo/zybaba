package com.zybaba.leetcode.dp;

import java.util.Arrays;

/**
 * @author tiandongbo
 * @version 1.0
 * @date 2020/10/4 10:28
 * 279. 完全平方数
 * https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquaresTest {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sqrt = (int) Math.sqrt(n) + 1;
        dp[0] = 0;
        int[] sqrts = new int[sqrt + 1];
        for (int i = 1; i < sqrt + 1; i++) {
            sqrts[i] = i * i;
        }
        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < sqrt; ++s) {
                if (i < sqrts[s]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i - sqrts[s]] + 1);
            }
        }
        return dp[n];
    }
}
