package com.zybaba.leetcode.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author tiandongbo
 * @date 2020/09/14 23:02
 * https://leetcode-cn.com/problems/decode-string/
 * 394. 字符串解码
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DecodeStringTest {
    public String decodeString(String s) {

        int len = s.length();
        int i = 0;
        Stack<String> stack = new Stack<>();
        int low = 0;
        int high = 0;
        while (i < len) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                high++;
                i++;
                continue;
            } else if (c == '[') {
                stack.push(s.substring(low, high));
                stack.push("[");

            } else if (c == ']') {
                String temp;
                String str = "";
                temp = stack.peek();
                while (temp != "[") {
                    temp = stack.pop();
                    str = str + temp;
                    temp = stack.peek();
                }
                stack.pop();
                int t = Integer.parseInt(stack.pop());
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < t; j++) {
                    sb.append(str);
                }
                stack.push(sb.toString());

            } else {
                stack.push(c + "");
            }
            high = i + 1;
            low = high;
            i++;
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    @Test
    public void testCase01() {
        String s = "3[a2[c]]";
        String expected = "accaccacc";
        DecodeStringTest solution = new DecodeStringTest();
        String actual = solution.decodeString(s);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testCase02() {
        String s = "3[a]2[bc]";
        String expected = "aaabcbc";
        DecodeStringTest solution = new DecodeStringTest();
        String actual = solution.decodeString(s);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase04() {
        String s = "10[le]";
        String expected = "lelelelelelelelelele";
        DecodeStringTest solution = new DecodeStringTest();
        String actual = solution.decodeString(s);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }


}
