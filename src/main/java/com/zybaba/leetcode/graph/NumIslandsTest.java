package com.zybaba.leetcode.graph;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/5/26 22:57
 * https://leetcode-cn.com/problems/number-of-islands/
 * 200. 岛屿数量
 */
public class NumIslandsTest {
    int column;
    int row;
    int num;

    public int numIslands(char[][] grid) {
        num = 0;
        if (grid == null || grid.length == 0) {
            return num;
        }
        column = grid[0].length;
        row = grid.length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    public void dfs(char[][] grid, int y, int x) {
        if (x < 0 || x >= column || y < 0 || y >= row || grid[y][x] == '0') {
            return;
        }
        grid[y][x] = '0';
        dfs(grid, y, x + 1);
        dfs(grid, y, x - 1);
        dfs(grid, y - 1, x);
        dfs(grid, y + 1, x);
    }

    @Test
    public void testCase01() {
        NumIslandsTest solution = new NumIslandsTest();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        int expected = 3;
        int actual = solution.numIslands(grid);
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        NumIslandsTest solution = new NumIslandsTest();
        char[][] grid = {};
        int expected = 0;
        int actual = solution.numIslands(grid);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}
