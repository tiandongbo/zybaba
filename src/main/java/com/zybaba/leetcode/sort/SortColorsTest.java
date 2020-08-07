package com.zybaba.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author tiandongbo
 * @date 2020/05/31 17:13
 */
public class SortColorsTest {
    public void sortColors(int[] nums) {
        int x = 0;
        int y = nums.length - 1;
        int cur=0;

        while ( cur<=y){

            if (nums[cur] == 2) {
                swap(nums, cur, y);
                y--;
                continue;
            }
            if (nums[cur] == 0) {
                swap(nums, cur, x);
                cur++;
                x++;
                continue;
            }
            cur++;

        }

    }

    public void swap(int[] arr, int x, int y) {
        if (arr[x] == arr[y]) {
            return;
        }
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    @Test
    public void testCase01() {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortColorsTest solution = new SortColorsTest();
        solution.sortColors(nums);
        Arrays.stream(nums).forEach(e -> System.out.println(e));
    }

    @Test
    public void testCase02() {
        int[] nums = {1,2,0};
        SortColorsTest solution = new SortColorsTest();
        solution.sortColors(nums);
        Arrays.stream(nums).forEach(e -> System.out.println(e));
    }
 

    @Test
    public void testCase03() {
        int[] nums = {2,0,2,1,1,0};
        SortColorsTest solution = new SortColorsTest();
        solution.sortColors(nums);
        Arrays.stream(nums).forEach(e -> System.out.println(e));
    }
}
