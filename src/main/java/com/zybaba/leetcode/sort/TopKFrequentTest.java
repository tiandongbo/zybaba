package com.zybaba.leetcode.sort;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author tiandongbo
 * @date 2020/06/15 23:17
 */
public class TopKFrequentTest {
    public int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        for (Integer m : map.keySet()) {
            queue.offer(m);
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }

        return res;
    }


    @Test
    public void testCase01() {
        int[] nums = {4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        int[] expected = {-1, 2};
        TopKFrequentTest solution = new TopKFrequentTest();
        int[] actual = solution.topKFrequent(nums, k);
        assertArrayEquals(expected, actual);
    }
}

