package com.zybaba.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tiandongbo
 * @date 2020/06/03 22:26
 */
public class SubsetsTest {
    List<List<Integer>> output = new ArrayList<>();

    int k;
    int n;

    public List<List<Integer>> subsets(int[] nums, boolean backtrack) {

        if (backtrack) {
            subsets(nums);
        } else {
            output.add(new ArrayList<Integer>(0));
            if (nums == null || nums.length == 0) {
                return output;
            }

            List<List<Integer>> sublist = new ArrayList<>(output);
            recursion(nums, 0, sublist);
        }

        return output;
    }

    private void recursion(int[] nums, int index, List<List<Integer>> sublist) {

        if (index >= nums.length) {
            return;
        }
        List<Integer> list;
        for (List<Integer> l : sublist) {
            list = new ArrayList<>(l);
            list.add(nums[index]);
            output.add(list);
        }
        recursion(nums, index + 1, new ArrayList<>(output));
    }


    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        //等于长度为0到n 的子集合之和
        for (k = 0; k <= n; k++) {
            backtrack(nums, 0, new LinkedList<>());
        }
        return output;
    }

    public void backtrack(int[] nums, int cur, LinkedList<Integer> list) {
        if (list.size() == k) {
            output.add(new ArrayList(list));
        }

        for (int i = cur; i < n; ++i) {
            list.add(nums[i]);
            backtrack(nums, i + 1, list);
            list.removeLast();
        }
    }

    @Test
    public void testCase01() {
        SubsetsTest solution = new SubsetsTest();
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution.subsets(nums);
        System.out.println(actual);
    }
}
