package com.zybaba.leetcode.backtrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tiandongbo
 * @date 2020/09/18 22:20
 * 22. 括号生成
 */
public class GenerateParenthesisTest {
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<String>();
        dfs("", 0, 0, n, combinations);
        return combinations;
    }

    private void dfs(String curStr, int left, int right, int n, List<String> res) {
        if (left == n && right == n) {
            res.add(curStr);
            return;
        }
        // 剪枝
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(curStr + "(", left + 1, right, n, res);
        }
        if (right < n) {
            dfs(curStr + ")", left, right + 1, n, res);
        }
    }


    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }


    @Test
    public void testCase01() {
        int n = 3;
        GenerateParenthesisTest solution = new GenerateParenthesisTest();
        List<String> list;
        list = solution.generateParenthesis(n);
        System.out.println(list);

    }
}
