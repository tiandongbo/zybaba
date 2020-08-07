package com.zybaba.leetcode.dp;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class ClimbStairsTest {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] asn = new int[n + 1];
        asn[1] = 1;
        asn[2] = 2;
        for (int i = 3; i <= n; i++) {
            asn[i] = asn[i - 1] + asn[i - 2];
        }
        return asn[n];
    }

    @Test
    public void testCase01() {
        ClimbStairsTest solution = new ClimbStairsTest();
        int n = 2;
        int expected =2;
        int actual = solution.climbStairs(n);
        System.out.println(actual);
        assertEquals(actual, expected);
    }

}
