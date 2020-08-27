package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author tiandongbo
 * @date 2020/08/27 22:59
 * 1011. 在 D 天内送达包裹的能力
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class ShipWithinDaysTest {

    public int shipWithinDays(int[] weights, int D) {
        int low = 0;
        int high = 0;
        //int high = Integer.MAX_VALUE;
        for (int i = 0; i < weights.length; i++) {
            high = high + weights[i];
            low = Math.max(low, weights[i]);
        }
        low --;
        high++;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canShipping(weights, D, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }
        return low;
    }

    public boolean canShipping(int[] weights, int d, int target) {
        int sum = 0;
        for (int w : weights) {
            if (w > target) {
                return false;
            }
            sum = sum + w;
            if (sum > target) {
                d--;
                sum = w;
                if (d < 0) {
                    return false;
                }
            }
        }
        return d > 0;
    }

    @Test
    public void testCase01() {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int d = 5;
        int expected = 15;
        int actual = new ShipWithinDaysTest().shipWithinDays(weights, d);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
