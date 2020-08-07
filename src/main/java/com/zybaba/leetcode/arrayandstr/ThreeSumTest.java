package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/06/05 23:04
 */
public class ThreeSumTest {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return list;
        }
        Arrays.sort(nums);
        // 用于去重
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            //都是正数没有办法凑成0
            if (nums[i] > 0) {
                break;
            }
            //刚处理过去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    r--;
                    l++;
                }

                if (sum > 0) {
                    r--;
                }
                if (sum < 0) {
                    l++;
                }
            }
        }
        return list;
    }

    @Test
    public void testCase01() {
        ThreeSumTest solution = new ThreeSumTest();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(-1, 0, 1));
        expected.add(Arrays.asList(-1, -1, 2));
        List<List<Integer>> actual = solution.threeSum(nums);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        ThreeSumTest solution = new ThreeSumTest();
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(0, 0, 0));
        List<List<Integer>> actual = solution.threeSum(nums);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase03() {
        ThreeSumTest solution = new ThreeSumTest();
        int[] nums = {-2, 0, 1, 1, 2};
        //List<List<Integer>> expected = new ArrayList<>();
        //expected.add(Arrays.asList(0, 0, 0));
        List<List<Integer>> actual = solution.threeSum(nums);
        System.out.println(actual);
        //assertEquals(expected, actual);
    }

}
