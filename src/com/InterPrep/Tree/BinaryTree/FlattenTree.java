package com.InterPrep.Tree.BinaryTree;


import com.DataStructures.TreeNode;
import com.sun.source.tree.Tree;

import java.util.Queue;
import java.util.LinkedList;

public class FlattenTree {
    Queue<TreeNode> nodes;
    public void flatten(TreeNode root) {
        if(root == null) return;
        nodes = new LinkedList<>();
        walk(root);
        TreeNode head = new TreeNode();
        while(!nodes.isEmpty()) {
            head.right = nodes.poll();
            head.left = null;
        }
    }
    public void walk(TreeNode node) {
        if(node == null) {
            return;
        }
        nodes.offer(node);
        walk(node.left);
        walk(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(3),
                        new TreeNode(4)
                ),
                new TreeNode(
                        5,
                        new TreeNode(6),
                        null
                )
        );

        FlattenTree ft = new FlattenTree();
        ft.flatten(root);
    }
}
