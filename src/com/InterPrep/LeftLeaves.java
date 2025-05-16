package com.InterPrep;
/*
Given the root of a binary tree, return the sum of all left leaves.

A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.



Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 24
Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.

Example 2:

Input: root = [1]
Output: 0

 */

import com.DataStructures.TreeNode;

public class LeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }
    private int dfs(TreeNode node, boolean left) {
        if(node == null) {
            return 0;
        }
        if(node.left == null && node.right == null) {
            if(left) return node.val;
        }
        return dfs(node.left, true) + dfs(node.right, false);
    }
}
