package com.zybaba.leetcode.search.bs;

import java.util.LinkedList;
import java.util.List;

/**
 * @author tiandongbo
 * @date 2020/10/12 23:00
 * 658. 找到 K 个最接近的元素
 * https://leetcode-cn.com/problems/find-k-closest-elements/
 */
public class FindClosestElementsTest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        //以l作为起始索引，长度为k
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[i + l]);
        }
        return res;

    }


}
