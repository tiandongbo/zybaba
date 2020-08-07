package com.zybaba.leetcode.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/06/16 22:44
 */
public class FindKthLargestTest {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n : nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();



        //int[] nweNums = Arrays.stream(nums).sorted().toArray();
        //return nweNums[nweNums.length - k];

    }

    @Test
    public void testCase01() {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int expected = 5;
        FindKthLargestTest solution = new FindKthLargestTest();
        int actual = solution.findKthLargest(nums, k);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int expected = 4;
        FindKthLargestTest solution = new FindKthLargestTest();
        int actual = solution.findKthLargest(nums, k);
        assertEquals(expected, actual);
    }
}

