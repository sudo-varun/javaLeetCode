package com.InterPrep.Tree.BinaryTree;

import com.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumRootLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return walk(root, 0);
    }
    public int walk(TreeNode node, int currSum) {
        if(node == null) {
            return 0;
        }
        currSum = currSum * 10 + node.val;
        if(node.left == null && node.right == null) {
            return currSum;
        }
        return walk(node.left, currSum) + walk(node.right, currSum);
    }
}
