package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tiandongbo
 * @date 2020/08/19 23:37
 * https://leetcode-cn.com/problems/integer-to-roman/
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class IntToRomanTest {

    public String intToRoman(int num) {
        String[] thousandArr = {"", "M", "MM", "MMM"};
        String[] hundredArr = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tenArr = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] oneArr = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousandArr[num / 1000] + hundredArr[num % 1000 / 100] + tenArr[num % 100 / 10] + oneArr[num % 10];

    }

    @Test
    public void testCase01() {
        System.out.println(1009 % 10 / 1);
    }

    @Test
    public void testCase02() {
        IntToRomanTest solution = new IntToRomanTest();
        int num = 1994;
        String expected = "MCMXCIV";
        String actual = solution.intToRoman(num);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase03() {
        IntToRomanTest solution = new IntToRomanTest();
        int num = 58;
        String expected = "LVIII";
        String actual = solution.intToRoman(num);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
