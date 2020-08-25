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
 * <p>
 * 定义dp[i]是nums前i个字符可以得到的解码种数，假设之前的字符串是abcx，现在新加入了y，则有以下5种情况：
 * <p>
 * 如果x=='0'，且y=='0'，无法解码，返回0；
 * 如果只有x=='0'，则y只能单独放在最后，不能与x合并(不能以0开头)，此时有：
 * dp[i] = dp[i-1]
 * 如果只有y=='0'，则y不能单独放置，必须与x合并，并且如果合并结果大于26，返回0，否则有：
 * dp[i] = dp[i-2]
 * 如果 xy<=26: 则y可以“单独”放在abcx的每个解码结果之后后，并且如果abcx以x单独结尾，此时可以合并xy作为结尾，而这种解码种数就是abc的解码结果，此时有：
 * dp[i+1] = dp[i] + dp[i-1]
 * 如果 xy>26: 此时x又不能与y合并，y只能单独放在dp[i]的每一种情况的最后，此时有：
 * dp[i+1] = dp[i]
 * <p>
 * 作者：zackqf
 * 链接：https://leetcode-cn.com/problems/decode-ways/solution/javajie-ti-si-lu-xiang-jie-by-zackqf/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class NumDecodingsTest {
    public int numDecodings(String s) {

        //todo
        return -1;
    }


    @Test
    public void testCase01() {
        String s = "226";
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
