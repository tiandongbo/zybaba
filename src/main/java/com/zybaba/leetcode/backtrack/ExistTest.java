package com.zybaba.leetcode.backtrack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/06/03 23:45
 * https://leetcode-cn.com/problems/word-search/
 * 79. 单词搜索
 */
public class ExistTest {
    int x;
    int y;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        x = board[0].length;
        y = board.length;
        int[][] visited = new int[y][x];
        //return true;
        for (int r = 0; r < y; r++) {
            for (int c = 0; c < x; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (backTrack(board, visited, word, r, c, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, int[][] visited, String word, int r, int c, int cur) {
        if (r < 0 || c < 0 || r >= y || c >= x || cur >= word.length() || visited[r][c] == 1) {
            return false;
        }
        if (board[r][c] != word.charAt(cur)) {
            return false;
        }
        if (cur == word.length() - 1) {
            return true;
        }
        visited[r][c] = 1;
        boolean ans = backTrack(board, visited, word, r + 1, c, cur + 1) ||
                backTrack(board, visited, word, r - 1, c, cur + 1) ||
                backTrack(board, visited, word, r, c + 1, cur + 1) ||
                backTrack(board, visited, word, r, c - 1, cur + 1);
        visited[r][c] = 0;
        return ans;
    }

    @Test
    public void testCase01() {
        ExistTest solution = new ExistTest();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        boolean expected = true;
        boolean actual = solution.exist(board, word);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        ExistTest solution = new ExistTest();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean expected = false;
        boolean actual = solution.exist(board, word);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}

