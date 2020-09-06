package com.zybaba.leetcode.tree;

/**
 * @author tiandongbo
 * @version 1.0
 * @date 2020/9/6 10:13
 */
public class InvertTreeTest {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode node = new TreeNode(root.val);
            node.left = invertTree(root.right);
            node.right = invertTree(root.left);
            return node;
        }
        return null;
    }
}
