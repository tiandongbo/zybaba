package com.zybaba.leetcode.recursion;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/5/23 22:34
 * https://leetcode-cn.com/problems/k-th-symbol-in-grammar/
 * 779. 第K个语法符号
 */
public class KthGrammarTest {
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            return 0;
        }


        int index = (1 << N - 1) - 1 + K;

        int ans = kthGrammar(N - 1, index / 2);

        if (ans == 1 ) {
            if (index % 2 == 0) {
                return ans == 0 ? 1 : 0;
            } else {
                return ans;
            }
        } else {
            if (index % 2 == 0) {
                return ans;
            } else {
                return ans == 0 ? 1 : 0;
            }

        }


    }

    @Test
    public void testCase01() {
        KthGrammarTest solution = new KthGrammarTest();
        int K = 4;
        int N = 3;
        int expected = Integer.bitCount(K - 1) % 2;
        int actual = solution.kthGrammar(N, K);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
