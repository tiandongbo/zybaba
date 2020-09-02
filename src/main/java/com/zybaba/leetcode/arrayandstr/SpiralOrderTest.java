package com.zybaba.leetcode.arrayandstr;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author tiandongbo
 * @date 2020/09/02 22:54
 * https://leetcode-cn.com/problems/spiral-matrix/
 * 54. 螺旋矩阵
 */
public class SpiralOrderTest {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int y = matrix.length;
        int x = matrix[0].length;
        int left = 0, right = x - 1, top = 0, bottom = y - 1;
        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                ans.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                ans.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    ans.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    ans.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }

    @Test
    public void testCase01() {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        SpiralOrderTest solution = new SpiralOrderTest();
        List<Integer> actual = solution.spiralOrder(matrix);
        System.out.println(actual);
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase02() {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}};

        SpiralOrderTest solution = new SpiralOrderTest();
        List<Integer> actual = solution.spiralOrder(matrix);
        System.out.println(actual);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
        Assert.assertEquals(expected, actual);
    }
}
