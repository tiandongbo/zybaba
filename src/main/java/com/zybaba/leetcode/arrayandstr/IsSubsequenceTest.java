package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;

/**
 * @author tiandongbo
 * @date 2020/09/04 23:24
 * 392. 判断子序列
 */
public class IsSubsequenceTest {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        int fromIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), fromIndex);
            if (index < 0) {
                return false;
            }
            fromIndex = Math.min(index + 1, t.length());
        }
        return true;
    }

    @Test
    public void testCase01() {
        String t = "01234";
        System.out.println(t.substring(t.indexOf("2")));
    }
}
