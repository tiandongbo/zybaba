package com.zybaba.leetcode.backtrack;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/06/02 22:57
 * https://leetcode-cn.com/problems/permutations/
 * 46. 全排列
 */
public class PermuteTest {
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> temp = new LinkedList();
        backTack(temp,nums);
        return res;
    }
    public void backTack( LinkedList<Integer> temp ,int[] nums){
        if(temp.size() == nums.length){
            res.add(new LinkedList(temp));
        }
        for(int i = 0;i < nums.length;i++){
            if(temp.contains(nums[i])){
                continue;
            }
            temp.offer(nums[i]);
            backTack(temp,nums);
            temp.pollLast();
        }
    }




    @Test
    public void testCase01() {
        PermuteTest solution = new PermuteTest();
        int[] nums = {1, 2, 3};
        List<List<Integer>> actual = solution.permute(nums);
        System.out.println(actual);
    }
}
