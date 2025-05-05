package com.InterPrep;
import com.DataStructures.TreeNode;

public class LongestUnivaluePath {
    int result = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        int ans = dfs(root);
        return Math.max(result, ans);
    }
    public int dfs(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftTreeHeight = dfs(node.left);
        int rightTreeHeight = dfs(node.right);
        int validLeftHeight = (node.left != null && node.val == node.left.val) ? leftTreeHeight : 0;
        int validRightHeight = (node.right != null && node.val == node.right.val) ? rightTreeHeight : 0;
        result = Math.max(result, 1 + validRightHeight + validLeftHeight);
        return 1 + Math.max(validLeftHeight, validRightHeight);
    }
}
