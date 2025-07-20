package com.InterPrep.Tree.BinaryTree;

import com.DataStructures.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            return;
        }

        // Append current node value to path
        String currentPath = path.isEmpty() ?
                String.valueOf(node.val) :
                path + "->" + node.val;

        // If at leaf node, add path to result
        if (node.left == null && node.right == null) {
            paths.add(currentPath);
            return;
        }

        // Continue DFS on children
        dfs(node.left, currentPath, paths);
        dfs(node.right, currentPath, paths);
    }
}
