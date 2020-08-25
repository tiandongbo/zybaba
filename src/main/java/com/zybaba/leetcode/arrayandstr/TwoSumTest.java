package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author tiandongbo
 * @date 2020/08/25 22:25
 */
public class TwoSumTest {
    public int[] twoSum(int[] numbers, int target) {
        int indexS = 0;
        int indexE = numbers.length - 1;
        while (indexS < indexE) {
            int sum = numbers[indexS] + numbers[indexE];

            if (sum < target) {
                indexS++;
            } else if (sum > target) {
                indexE--;
            } else {
                indexS++;
                indexE++;
                break;
            }
        }
        return new int[]{indexS, indexE};
    }

    @Test
    public void testCase01() {
        int target = 9;
        int[] nums = {2, 7, 11, 15};
        int[] expected = {1, 2};
        TwoSumTest solution = new TwoSumTest();
        int[] actual = solution.twoSum(nums, target);
        Assert.assertArrayEquals(expected, actual);
    }
}
