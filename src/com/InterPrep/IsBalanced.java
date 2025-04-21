package com.InterPrep;

import com.DataStructures.TreeNode;

public class IsBalanced {
    public static void main(String[] args) {

    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean currentBalanced = Math.abs(height(root.right) - height(root.left)) <= 1;
        return currentBalanced && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
