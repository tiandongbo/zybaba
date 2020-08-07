package com.zybaba.leetcode.tree;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 894. 所有可能的满二叉树
 * https://leetcode-cn.com/problems/all-possible-full-binary-trees/
 */
public class AllPossibleFBTTest {
    public List<TreeNode> allPossibleFBT(int N) {

        if(N%2==0){
         RuntimeException exception = new RuntimeException("N不合法");
          throw exception;
        }

        int [] dp = new int[N+1];
        dp[0]=0;
        dp[1]=1;
        dp[3]=1;
        for (int i=3;i<N+1;i=i+2){
            dp[i]= dp[i-2]+1;
        }
        return null;
    }

    @Test
    public void testCase01(){
        AllPossibleFBTTest solution = new AllPossibleFBTTest();
        solution.allPossibleFBT(4);

    }

}
