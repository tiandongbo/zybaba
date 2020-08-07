package com.zybaba.leetcode.tree;

import java.util.List;

/**
 * @author tiandongbo
 * @date 2020/07/20 22:59
 */
public class MutiTreeNode {
    public int val;
    public List<MutiTreeNode> children;

    public MutiTreeNode() {}

    public MutiTreeNode(int _val) {
        val = _val;
    }

    public MutiTreeNode(int _val, List<MutiTreeNode> _children) {
        val = _val;
        children = _children;
    }
}
