package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author tiandongbo
 * @date 2020/08/18 23:17
 * https://leetcode-cn.com/problems/decode-ways/
 * 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2:
 * <p>
 * 输入: "226"
 * 输出: 3
 * 解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 通过次数62,323提交次数257,105
 */
public class NumDecodingsTest {
    public int numDecodings(String s) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '0') {
                i++;
                break;
            }

        }
        s = s.substring(i);
        return dfs("", s, 0);
    }

    public int dfs(String s, String leftStr, int num) {
        if (leftStr == null || leftStr.length() == 0) {
            return num;
        }
        char c = leftStr.charAt(0);

        String temp = s + c;
        boolean okFlag = true;
        for (int i = 0; i < temp.length() - 2; i++) {
            if (Integer.valueOf(temp.substring(i, 2)) > 26) {
                okFlag = false;
                break;
            }
        }
        if (okFlag) {
            num++;
        }
        if (leftStr.length() > 1) {
            return dfs(s + c, leftStr.substring(1), num);
        }
        return dfs(s + c, "", num);
    }

    @Test
    public void testCase01() {
        String s = "0226";
        int expected = 3;
        NumDecodingsTest solution = new NumDecodingsTest();
        int actual = solution.numDecodings(s);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        String s = "0";
        int expected = 0;
        NumDecodingsTest solution = new NumDecodingsTest();
        int actual = solution.numDecodings(s);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase03() {
        String s = "27";
        int expected = 2;
        NumDecodingsTest solution = new NumDecodingsTest();
        int actual = solution.numDecodings(s);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
