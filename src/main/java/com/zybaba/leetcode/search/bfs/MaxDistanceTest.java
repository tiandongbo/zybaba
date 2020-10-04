package com.zybaba.leetcode.search.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author tiandongbo
 * @version 1.0
 * @date 2020/10/1 16:49
 */
public class MaxDistanceTest {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        if (queue.size() == 0) {
            return -1;
        } else if (queue.size() == rows * columns) {
            return -1;
        }
        int[] point = null;
        while (queue.size() > 0) {
            point = queue.poll();
            int row = point[0];
            int column = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = row + dx[i];
                int newY = column + dy[i];
                if (newX < 0 || newX >= rows || newY < 0 || newY >= columns || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[row][column] + 1;
                queue.offer(new int[]{newX, newY});
            }
        }
        return grid[point[0]][point[1]] - 1;
    }
}
