package com.zybaba.leetcode.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TreeNodeTest {
    @Test
    public void testCase01() {
        Integer[] nodes = {1, 2, 3, null, null, 4, 5, null, null, 6, 7};
        TreeNode root = TreeNode.createTree(nodes);
        //层次遍历
        List<List<Integer>> lists = TreeNode.bfs(root);
        System.out.println(lists);
        //深度优先遍历
        List<Integer> list = TreeNode.dfs(root);
        System.out.println(list);
        //全部根节点到叶子节点的路径
        lists = TreeNode.allPath(root);
        System.out.println(lists);
    }

    @Test
    public void testCase02() {
        Integer[] nodes = {1, 2, 3, null, null, 4, 5, null, null, 6, 7};
        TreeNode root = TreeNode.createTree(nodes);
        //深度优先遍历
        List<Integer> expected = TreeNode.dfs(root);
        List<Integer> actual = TreeNode.preorderTraversal(root);
        System.out.println(expected);
        System.out.println(actual);
        assertEquals(expected,actual);
    }
}
