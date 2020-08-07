package com.zybaba.leetcode.tree;

import java.util.HashMap;

/**
 * @author tiandongbo
 * @date 2020/5/25 22:36
 */
public class BuildTreeTest {
    HashMap<Integer,Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        TreeNode root= new TreeNode(preorder[0]);
        TreeNode node =root;
        int leftFromIndex ,leftEndIndex;
        int rightFromIndex,rightEndIndex;
        leftFromIndex=0;
        rightEndIndex =  preorder.length-1;

        //leftEndIndex= map.get(node.val)-1>leftFromIndex?map.get(node.val)-1:leftFromIndex;
        //rightFromIndex =map.get(node.val)+1>lastIndex?lastIndex:map.get(node.val)+1;


        //if (map.get(node.val)>0)


        return null;
    }
}
