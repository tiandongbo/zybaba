package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author tiandongbo
 * @date 2020/09/01 22:52
 * https://leetcode-cn.com/problems/next-permutation/
 * 31. 下一个排列
 */
public class NextPermutationTest {
    public int[] nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }


        int h = nums.length - 1;
        int l = 0;
        while (l < h) {
            swap(nums, l, h);
            l++;
            h--;
        }
        return nums;
    }

    private int[] swap(int[] nums, int l, int h) {
        int temp;
        temp = nums[l];
        nums[l] = nums[h];
        nums[h] = temp;
        return nums;
    }

    @Test
    public void testCase01() {
        int[] nums = {1, 2, 3};
        int[] expected = {1, 3, 2};
        NextPermutationTest solution = new NextPermutationTest();
        int[] actual = solution.nextPermutation(nums);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        int[] nums = {3, 2, 1};
        int[] expected = {1, 2, 3};
        NextPermutationTest solution = new NextPermutationTest();
        int[] actual = solution.nextPermutation(nums);
        Assert.assertArrayEquals(expected, actual);
    }
}
