package com.zybaba.leetcode.tree;


import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode createTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(nodes[0]);
        queue.offer(root);
        int count = 1;
        while (count < nodes.length) {
            TreeNode node = queue.poll();
            if (count < nodes.length) {
                if (nodes[count] != null) {
                    node.left = new TreeNode(nodes[count]);
                    queue.offer(node.left);
                }
                count++;
            }
            if (count < nodes.length) {
                if (nodes[count] != null) {
                    node.right = new TreeNode(nodes[count]);
                    queue.offer(node.right);
                }
                count++;
            }
        }
        return root;
    }

    public static List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<List<Integer>>();
        if (root == null) {
            return ansList;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (queue.size() > 0) {
            int count = queue.size();
            List<Integer> list = new ArrayList<Integer>();
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
            ansList.add(list);
        }
        return ansList;
    }


    public static List<Integer> dfs(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        dfs(root, list);
        return list;
    }

    public static List<List<Integer>> allPath(TreeNode root) {
        List<List<Integer>> pathList = new ArrayList<>();
        if (root == null) {
            return pathList;
        }
        LinkedList<Integer> sublist = new LinkedList<>();
        dfs(root, pathList, sublist);
        return pathList;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (stack.size() > 0 || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            list.add(node.val);
            node = node.right;
        }
        return list;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (stack.size() > 0 || node != null) {
            while (node != null) {
                list.add(node.val);
                stack.push(node);
                node= node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return list;
    }

    private static void dfs(TreeNode root, List<List<Integer>> pathList, LinkedList<Integer> subList) {
        if (root == null) {
            return;
        }
        subList.offer(root.val);
        if (root.left == null && root.right == null) {
            pathList.add(new ArrayList<>(subList));
        }
        dfs(root.left, pathList, subList);
        dfs(root.right, pathList, subList);
        subList.pollLast();
    }

    private static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
