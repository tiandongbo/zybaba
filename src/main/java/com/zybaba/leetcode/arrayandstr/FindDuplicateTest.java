package com.zybaba.leetcode.arrayandstr;

/**
 * @author tiandongbo
 * @date 2020/08/26 23:18
 */
public class FindDuplicateTest {
    public int findDuplicate(int[] nums) {
        int ans =-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    ans = nums[i];
                    return ans;
                }
            }
        }
        return ans;
    }
}
