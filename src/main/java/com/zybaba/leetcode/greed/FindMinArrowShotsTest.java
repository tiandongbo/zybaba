package com.zybaba.leetcode.greed;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tiandongbo
 * @date 2020/09/08 23:28
 * 452. 用最少数量的箭引爆气球
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class FindMinArrowShotsTest {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int x = points[0][1];
        int num = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > x) {
                num++;
                x = points[i][1];
            }
        }
        return num;
    }

    @Test
    public void testCase01() {
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};

        Arrays.stream(points).sorted((a, b) -> {
            return a[0] - b[0];
        });


        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }

        // Arrays.sort(points, (a, b) -> {
        //     return a[0] - b[0];
        // });
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < points.length; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }
    }

    @Test
    public void testCase02() {
        int[][] points = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        FindMinArrowShotsTest solution = new FindMinArrowShotsTest();
        int expected = 2;
        int actual = solution.findMinArrowShots(points);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCase03() {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        FindMinArrowShotsTest solution = new FindMinArrowShotsTest();
        int expected = 2;
        int actual = solution.findMinArrowShots(points);
        Assert.assertEquals(expected, actual);
    }


}
