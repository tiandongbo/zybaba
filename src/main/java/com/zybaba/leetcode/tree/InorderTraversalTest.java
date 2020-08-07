package com.zybaba.leetcode.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author tiandongbo
 * @date 2020/5/24 21:53
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * 给定一个二叉树，返回它的中序 遍历
 */
public class InorderTraversalTest {
    List<Integer> nodes;
    public List<Integer> inorderTraversal(TreeNode root) {
        nodes = new ArrayList<>();
        interation(root);
        return nodes;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        nodes.add(root.val);
        dfs(root.right);
    }

    /**
     * 迭代方式遍历
     */
    public void interation(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            nodes.add(node.val);
            node = node.right;
        }
    }


    @Test
    public void testCase01() {
        InorderTraversalTest solution = new InorderTraversalTest();
        //Integer[] nodes= {1,3};
        TreeNode root = TreeNode.createTree(new Integer[]{1, null, 2, 3});
        List<Integer> actual = solution.inorderTraversal(root);
        System.out.println(actual);

    }
}
