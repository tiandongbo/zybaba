package com.zybaba.leetcode.search.bs;

/**
 * @author tiandongbo
 * @version 1.0
 * @date 2020/10/3 21:29
 * 875. 爱吃香蕉的珂珂
 */
public class MinEatingSpeedTest {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = 1_000_000_000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (possible(piles, H, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean possible(int[] piles, int H, int K) {
        int time = 0;
        for (int p : piles)
            time += (p - 1) / K + 1;
        return time <= H;
    }


}
