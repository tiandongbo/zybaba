package com.zybaba.leetcode.tree;

/**
 * @author tiandongbo
 * @date 2020/5/26 22:10
 */
public class NodeTest {

    public Node connect(Node root) {
        dfs(root, null);
        return root;

    }

    private void dfs(Node node, Node next) {
        if (node != null) {
            node.next = next;
            dfs(node.left, node.right);
            dfs(node.right, node.next != null ? node.next.left : null);
        }
    }
}
