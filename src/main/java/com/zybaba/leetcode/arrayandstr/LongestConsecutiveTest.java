package com.zybaba.leetcode.arrayandstr;

import java.util.Arrays;

/**
 * @author tiandongbo
 * @date 2020/06/17 23:18
 */
public class LongestConsecutiveTest {
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0){
            return 0;
        }
        int res=1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, res);
        Arrays.sort(nums);
        for (int i=1;i< nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[j]+1==nums[i]){
                    dp[i]= dp[j]+1;
                }
            }
        }
        return  Arrays.stream(dp).max().getAsInt();
    }
}
