package com.zybaba.leetcode.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author tiandongbo
 * @date 2020/5/25 23:36
 */
public class KthSmallestTest {
    int target;
    int value;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count=0;
        target = k;
        try {
            dfs(root);
        }catch(Exception e){

        }
        return value;

    }

    public void dfs(TreeNode root) {

        if (root == null) {
            return;
        }
        dfs(root.left);
        System.out.println(root.val);
        count++;
        if (count == target) {
            value = root.val;
            throw new RuntimeException ();
        }
        dfs(root.right );
    }

    @Test
    public void testCase01() {
        KthSmallestTest solution = new KthSmallestTest();
        TreeNode root = TreeNode.createTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1});
        int expected = 3;
        int k = 3;
        int actual = solution.kthSmallest(root, k);
        System.out.println(actual);
        assertEquals(expected, actual);

    }
}
