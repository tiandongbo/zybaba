package com.zybaba.leetcode.arrayandstr;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author tiandongbo
 * @date 2020/08/20 23:04
 * https://leetcode-cn.com/problems/valid-triangle-number/
 * 611. 有效三角形的个数
 * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
 *
 * 示例 1:
 *
 * 输入: [2,2,3,4]
 * 输出: 3
 * 解释:
 * 有效的组合是:
 * 2,3,4 (使用第一个 2)
 * 2,3,4 (使用第二个 2)
 * 2,2,3
 * 注意:
 *
 * 数组长度不超过1000。
 * 数组里整数的范围为 [0, 1000]。
 * 通过次数8,116提交次数16,576
 * 在真实的面试中遇到过这道题？
 */
public class TriangleNumberTest {
    int ans = 0;
    public int triangleNumber(int[] nums) {
        ans = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        bt(nums, 0, queue);
        return ans;
    }

    public void bt(int[] nums, int index, LinkedList<Integer> queue) {
        if (queue.size() == 3) {
            int n1 = queue.get(0);
            int n2 = queue.get(1);
            int n3 = queue.get(2);
            if (n1 + n2 > n3 && n1 + n3 > n2 && n2 + n3 > n1) {
                ans++;
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            queue.add(nums[i]);
            bt(nums, i+1, queue);
            queue.pollLast();
        }
    }

    public int triangleNumber1(int[] nums){
        int count=0;
        for (int i=0;i<nums.length-2;i++){
            for (int j=i+1;j<nums.length-1;j++){
                for (int k= j+1;k<nums.length;k++){
                    if (nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j] && nums[j] + nums[k] > nums[i])
                        count++;
                }
            }
        }
        return count;
    }
}
