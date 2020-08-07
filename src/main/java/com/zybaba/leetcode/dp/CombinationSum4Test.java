package com.zybaba.leetcode.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 377. 组合总和 Ⅳ
 * https://leetcode-cn.com/problems/combination-sum-iv/
 */
public class CombinationSum4Test {
    public int combinationSum4(int[] nums, int target) {

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i < target + 1; i++) {
            for (int n : nums) {
                if (n<=i)
                dp[i] = dp[i] + dp[i - n];
            }
        }
        return dp[target];

    }

    @Test
    public void testCase01() {
        CombinationSum4Test solution = new CombinationSum4Test();
        int[] nums = {1, 2, 3};
        int target = 4;
        int expected = 7;
        int actual = solution.combinationSum4(nums, target);
        System.out.println(actual);
        assertEquals(actual, expected);
    }
}
