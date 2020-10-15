package com.zybaba.leetcode.search.set;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author tiandongbo
 * @date 2020/10/15 23:17
 * 217. 存在重复元素
 */
public class ContainsDuplicateTest {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> duplicate = new HashSet<>();
        for (int i:nums){
            if (duplicate.contains(i)){
                return true;
            }
            duplicate.add(i);
        }
        return false;


        // return Arrays.stream(nums).parallel().distinct().count()<nums.length;
    }
}
