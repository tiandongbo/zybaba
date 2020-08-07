package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/06/11 22:06
 */
public class LongestPalindromeTest {
    public String longestPalindrome(String s) {
        String res = "";
        if (s == null || s.length() == 0) {
            return res;
        }

        for (int i = 1; i <= s.length(); i++) {
            res = longestPalindrome(s.substring(0, i), res);
        }
        return res;
    }

    private String longestPalindrome(String s, String res) {
        String r= res;
        //bab 情况
        String temp = s.substring(s.length() - res.length() - 1);
        if (temp.equals(new StringBuilder(temp).reverse().toString())) {
            r = temp;
        }
        //abba 情况
        if (s.length() >= res.length() + 2) {
            temp = s.substring(s.length() - res.length() - 2);
            if (temp.equals(new StringBuilder(temp).reverse().toString())) {
                r = temp;
            }
        }
        return r;
    }

    @Test
    public void testCase01() {
        String s = "012345";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(-1));
    }

    @Test
    public void testCase02() {
        LongestPalindromeTest solution = new LongestPalindromeTest();
        String s = "bb";
        String expected = "bb";
        String actual = solution.longestPalindrome(s);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

}
