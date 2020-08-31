package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author tiandongbo
 * @date 2020/08/28 22:37
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 */
public class LongestValidParenthesesTest {
    // 指针、滑动窗口 最基本的解法，但是超时
    public int longestValidParentheses1(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() && i + ans < s.length() + 1; j++) {
                String temp = s.substring(i, j + 1);
                int v = valid(temp);
                if (v == 0) {
                    len = j + 1 - i;
                    ans = Math.max(ans, len);
                }
                if (v < 0) {
                    break;
                }
            }
        }
        return ans;
    }

    public int longestValidParentheses(String s) {
        int ans = 0;
        if (s == null || s.length() == 0) {
            return ans;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, i - stack.peek());
                }
            }
        }

        return ans;
    }

    private int valid(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
                if (balance < 0) {
                    return -1;
                }
            }
        }
        return balance;
    }

    @Test
    public void testCase01() {
        LongestValidParenthesesTest solution = new LongestValidParenthesesTest();
        String s = "(()";
        int actual = solution.longestValidParentheses(s);
        int expected = 2;
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testCase02() {
        LongestValidParenthesesTest solution = new LongestValidParenthesesTest();
        String s = "()";
        int actual = solution.longestValidParentheses(s);
        int expected = 2;
        System.out.println(actual);
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testCase03() {
        LongestValidParenthesesTest solution = new LongestValidParenthesesTest();
        String s = "()(()";
        int actual = solution.longestValidParentheses(s);
        int expected = 2;
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase05() {
        System.out.println(Integer.parseInt(""));

    }

    @Test
    public void testCase04() {
        LongestValidParenthesesTest solution = new LongestValidParenthesesTest();
        String s = ")()(())";
        int actual = solution.longestValidParentheses(s);
        int expected = 6;
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}


