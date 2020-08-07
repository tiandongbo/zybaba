package com.zybaba.leetcode.tree;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/5/24 23:01
 */
public class ZigzagLevelOrderTest {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> nodes = new ArrayList<>();
        if (root == null) {
            return nodes;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (queue.size() > 0) {
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while (count > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                count--;
            }
            if (level % 2 != 0) {
                Collections.reverse(list);
            }
            nodes.add(list);
            level++;
        }
        return nodes;
    }

    @Test
    public void testCase01() {
        ZigzagLevelOrderTest solution = new ZigzagLevelOrderTest();
        TreeNode root = TreeNode.createTree(new Integer[]{3,9,20,null,null,15,7});
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(new Integer[]{3}));
        expected.add(Arrays.asList(new Integer[]{20,9}));
        expected.add(Arrays.asList(new Integer[]{15,7}));
        List<List<Integer>> actual = solution.zigzagLevelOrder(root);
        System.out.println(actual);
        assertEquals(expected,actual );
    }
}
