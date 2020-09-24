package com.zybaba.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author tiandongbo
 * @date 2020/09/23 23:23
 * 173. 二叉搜索树迭代器
 * https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class BSTIterator {
    LinkedList<Integer> list;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        dfs(root);
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right);
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return list.poll();
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return list.size()>0;
    }
}
