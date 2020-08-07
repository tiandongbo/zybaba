package com.zybaba.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * @author tiandongbo
 * @date 2020/5/24 20:09
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 113. 路径总和 II
 */
public class PathSumTest {
    List<List<Integer>> pathList;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathList = new ArrayList<List<Integer>>();
        LinkedList<Integer> subList = new LinkedList<>();
        if (root == null) {
            return pathList;
        }
        dfs(root, subList, sum);
        return pathList;
    }

    private void dfs(TreeNode root, LinkedList<Integer> subList, int sum) {
        if (root == null) {
            return;
        }
        sum = sum - root.val;
        subList.offer(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            pathList.add(new ArrayList<>(subList));
        }
        dfs(root.left, subList, sum);
        dfs(root.right, subList, sum);
        subList.pollLast();
    }

    @Test
    public void testCase01() {
        PathSumTest solution = new PathSumTest();
        Integer[] nodes = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        int sum = 22;
        TreeNode root = TreeNode.createTree(nodes);
        List<List<Integer>> actual = solution.pathSum(root, sum);
        System.out.println(actual);
        //assertEquals(actual, expected);
    }
}
