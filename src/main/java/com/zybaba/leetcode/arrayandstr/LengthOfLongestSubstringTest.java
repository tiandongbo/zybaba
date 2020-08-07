package com.zybaba.leetcode.arrayandstr;

import org.junit.Test;


/**
 * @author tiandongbo
 * @date 2020/06/09 23:11
 */
public class LengthOfLongestSubstringTest {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return (slideWindow(s) + normal(s) + dp(s)) / 3;
    }

    public int slideWindow(String s) {
        int maxLen = 1;
        int l = 0;
        for (int i = 1; i < s.length(); i++) {
            int index = Math.max(s.substring(l, i).indexOf(s.charAt(i) + "") + 1, 0);
            maxLen = Math.max(maxLen, i - index - l + 1);
            l = l + index;
        }
        return maxLen;
    }

    public int normal(String s) {
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int curLen = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.substring(i, j).indexOf(s.charAt(j) + "") < 0) {
                    curLen++;
                } else {
                    break;
                }
            }
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }

    public int dp(String s) {
        //动态规划
        String[] res = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            res[i] = s.substring(i, i + 1);
        }
        int maxLen = 1;
        for (int i = 1; i < res.length; i++) {
            int index = Math.max(res[i - 1].indexOf(res[i]) + 1, 0);
            res[i] = res[i - 1].substring(index) + res[i];
            maxLen = Math.max(maxLen, res[i].length());
        }
        return maxLen;
    }

    @Test
    public void testCase01() {
        String str = "pwwkew";
        LengthOfLongestSubstringTest solution = new LengthOfLongestSubstringTest();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }

    @Test
    public void testCase02() {
        String str = "aab";
        LengthOfLongestSubstringTest solution = new LengthOfLongestSubstringTest();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }

    @Test
    public void testCase03() {
        String str = "dvdf";
        LengthOfLongestSubstringTest solution = new LengthOfLongestSubstringTest();
        System.out.println(solution.lengthOfLongestSubstring(str));
    }

}
