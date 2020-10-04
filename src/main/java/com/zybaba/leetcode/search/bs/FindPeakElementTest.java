package com.zybaba.leetcode.search.bs;

/**
 * @author tiandongbo
 * @version 1.0
 * @date 2020/10/3 23:20
 * https://leetcode-cn.com/problems/find-peak-element/
 * 162. 寻找峰值
 */
public class FindPeakElementTest {
    // 模版一：查找单个索引
    public int findPeakElement1(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // 0
            long pre = mid - 1 < 0 ? -Long.MAX_VALUE : nums[mid - 1];
            long cur = nums[mid];
            long next = mid + 1 > hi ? -Long.MAX_VALUE : nums[mid + 1];

            if (pre < cur && cur > next) {
                return mid;
            }

            if (pre < cur) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }


    // 模版二：查找单个索引及其右邻居
    public int findPeakElement2(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // 模版三：查找当前索引及其左右邻居
    public int findPeakElement3(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[mid + 1]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        // post process
        if (lo < hi  && nums[lo] < nums[hi]) {
            return hi;
        } else {
            return lo;
        }
    }

}
