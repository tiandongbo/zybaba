package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/07/28 22:58
 */
public class PivotIndexTest {
    public int pivotIndex(int[] nums) {
        int ans = -1;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int sum = Arrays.stream(nums).sum();
        int leftsum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return ans;
    }

    @Test
    public void testCase01() {
        PivotIndexTest solution = new PivotIndexTest();
        int[] nums = {1, 7, 3, 6, 5, 6};
        int expected = 3;
        int actual = solution.pivotIndex(nums);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        PivotIndexTest solution = new PivotIndexTest();
        int[] nums = {-1, -1, -1, -1, -1, 0};
        int expected = 2;
        int actual = solution.pivotIndex(nums);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase03() {
        PivotIndexTest solution = new PivotIndexTest();
        int[] nums = {-1, -1, 0, 1, 0, -1};
        int expected = 4;
        int actual = solution.pivotIndex(nums);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

}
