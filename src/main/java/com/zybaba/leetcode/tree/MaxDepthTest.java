package com.zybaba.leetcode.tree;

import java.util.Arrays;

/**
 * @author tiandongbo
 * @date 2020/07/20 23:00
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 * 559. N叉树的最大深度
 */
public class MaxDepthTest {


    public int maxDepth(MutiTreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(MutiTreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        if (root.children == null || root.children.size() == 0) {
            return depth + 1;
        }
        int[] d = new int[root.children.size()];

        for (int i = 0; i < root.children.size(); i++) {
            d[i] = dfs(root.children.get(i), depth);
        }
        return Arrays.stream(d).max().getAsInt() + 1;
    }
}
