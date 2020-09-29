package com.zybaba.leetcode.search;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author tiandongbo
 * @date 2020/09/27 23:00
 * 130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class SolveTest {
    int rows;
    int columns;
    int[][] visited;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        rows = board.length;
        columns = board[0].length;
        visited = new int[rows][columns];

        // 找出边界为O的点
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][columns - 1] == 'O') {
                dfs(board, i, columns - 1);
            }
        }
        for (int j = 1; j < columns - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(board, rows - 1, j);
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (visited[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int column) {
        if (row > rows - 1 || column > columns - 1 || row < 0 || column < 0) {
            return;
        }
        if (visited[row][column] == 1 || board[row][column] == 'X') {
            return;
        }
        if (board[row][column] == 'O') {
            visited[row][column] = 1;
        }
        dfs(board, row - 1, column);
        dfs(board, row + 1, column);
        dfs(board, row, column - 1);
        dfs(board, row, column + 1);
    }

    @Test
    public void testCase01() {
        char[][] board = {{'X', 'O', 'O', 'X', 'X', 'X', 'O', 'X', 'O', 'O'},
                {'X', 'O', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'X', 'O', 'X', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X', 'X', 'O', 'O', 'X', 'X', 'X'},
                {'O', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'},
                {'O', 'X', 'X', 'X', 'X', 'X', 'O', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X', 'X', 'O', 'X', 'X', 'O', 'O'},
                {'X', 'X', 'X', 'O', 'O', 'X', 'O', 'X', 'X', 'O'}};
        SolveTest solution = new SolveTest();
        solution.solve(board);

    }

}
