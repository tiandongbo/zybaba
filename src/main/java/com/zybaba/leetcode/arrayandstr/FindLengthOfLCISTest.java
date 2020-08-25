package com.zybaba.leetcode.arrayandstr;

import java.util.Arrays;

/**
 * @author tiandongbo
 * @date 2020/08/25 23:08
 */
public class FindLengthOfLCISTest {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count=1;
        int ans=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i-1]< nums[i]){
                count++;
            }
            else{
                count=1;
            }
            ans= Math.max(ans,count);
        }
        return  ans;

        //int[] dp = new int[nums.length];
        //Arrays.fill(dp, 1);
        //for (int i = 1; i < nums.length; i++) {
        //    if (nums[i - 1] < nums[i]) {
        //        dp[i] = dp[i - 1] + 1;
        //    }
        //}
        //return Arrays.stream(dp).max().getAsInt();
    }
}
