package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/06/12 00:03
 */
public class IncreasingTripletTest {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] >= 2) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testCase01() {
        IncreasingTripletTest solution = new IncreasingTripletTest();
        int[] nums = {1, 2, 3, 4};
        boolean expected = true;
        boolean actual = solution.increasingTriplet(nums);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
