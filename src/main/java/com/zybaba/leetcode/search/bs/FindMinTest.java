package com.zybaba.leetcode.search.bs;

/**
 * @author tiandongbo
 * @version 1.0
 * @date 2020/10/3 22:50
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * [4,5,6,7,0,1,2] )
 */
public class FindMinTest {
    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            }
            if (nums[mid] < nums[high]) {
                high = mid;


            }
        }
        return nums[low];
    }
}
