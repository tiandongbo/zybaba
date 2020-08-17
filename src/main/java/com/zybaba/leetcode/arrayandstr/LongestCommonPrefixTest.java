package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author tiandongbo
 * @date 2020/08/17 22:54
 */
public class LongestCommonPrefixTest {
    public String longestCommonPrefix(String[] strs) {
        // 合法性检查
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = strs[0].length();
        char c;
        // 有多个字符串情况
        for (int i = 0; i < len; i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    @Test
    public void testCase01() {
        LongestCommonPrefixTest solution = new LongestCommonPrefixTest();
        String[] strs = {"flower", "flow", "flight"};

        String expected = "fl";
        String actual = solution.longestCommonPrefix(strs);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testCase02() {
        LongestCommonPrefixTest solution = new LongestCommonPrefixTest();
        String[] strs = {"f"};

        String expected = "f";
        String actual = solution.longestCommonPrefix(strs);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }


}
