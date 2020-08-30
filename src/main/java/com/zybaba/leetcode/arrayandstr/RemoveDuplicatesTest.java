package com.zybaba.leetcode.arrayandstr;

/**
 * @author tiandongbo
 * @date 2020/08/25 22:46
 */
public class RemoveDuplicatesTest {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[len] != nums[i]) {
                len++;
                nums[len] = nums[i];
            }
        }
        return len + 1;
    }
}
