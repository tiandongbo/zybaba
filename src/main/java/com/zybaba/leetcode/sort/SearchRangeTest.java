package com.zybaba.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author tiandongbo
 * @date 2020/06/16 23:32
 */
public class SearchRangeTest {
    public int[] searchRange(int[] nums, int target) {

       HashMap<Integer,int[]> map = new HashMap<>();
       for (int i=0;i<nums.length;i++){
          if (map.containsKey(nums[i])){
              map.get(nums[i])[1]= i;
          }else{
              int[] temp = {i,i};
              map.put(nums[i],temp);
          }
       }
       return  map.getOrDefault(target, new int[]{-1,-1});
    }
    @Test
    public void testCase01() {
        int[] nums = {5,7,7,8,8,10};
        int target = 18;
        int[] expected = {3,4};
        SearchRangeTest solution = new SearchRangeTest();
        int[] actual = solution.searchRange(nums, target);
        assertArrayEquals(expected, actual);
    }
}
