package com.zybaba.leetcode.recursion;

import com.zybaba.leetcode.dp.ClimbStairsTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * 50. Pow(x, n)
 * https://leetcode-cn.com/problems/powx-n/
 */
public class MyPowTest {
    public double quickMul(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }


    @Test
    public void testCase01() {
        MyPowTest solution = new MyPowTest();
        int n = -2;
        int x=2;
        double expected =4;
        double actual = solution.myPow(x,n);
        System.out.println(actual);
//        assertEquals(actual, expected);
    }
}
