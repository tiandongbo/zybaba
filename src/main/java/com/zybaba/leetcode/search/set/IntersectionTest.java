package com.zybaba.leetcode.search.set;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tiandongbo
 * @date 2020/10/14 23:11
 * 349. 两个数组的交集
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class IntersectionTest {
    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);
        int[] ans = new int[set1.size()];
        int j = 0;
        for (Integer i : set1) {
            ans[j++] = i;
        }
        return ans;
    }
}
