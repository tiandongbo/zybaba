package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/08/31 23:27
 * https://leetcode-cn.com/problems/jump-game/submissions/
 * 55. 跳跃游戏
 */
public class CanJumpTest {
    public boolean canJump(int[] nums) {
        int maxValue = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i <= maxValue) {
                maxValue = Math.max(maxValue, nums[i] + i);
            }
            if (maxValue >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void testCase01() {
        CanJumpTest solution = new CanJumpTest();
        int[] nums = {3, 2, 1, 0, 4};
        boolean expected = false;
        boolean actual = solution.canJump(nums);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
