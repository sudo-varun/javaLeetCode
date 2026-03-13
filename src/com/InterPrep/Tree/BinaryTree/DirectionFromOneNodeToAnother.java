package com.InterPrep.Tree.BinaryTree;

import com.DataStructures.TreeNode;

public class DirectionFromOneNodeToAnother {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder(), end = new StringBuilder();
        find(root, startValue, start);
        find(root, destValue, end);
        start.reverse();
        end.reverse();
        int same = 0;
        while(same < start.length() && same < end.length() && start.charAt(same) == end.charAt(same)) {
            same++;
        }
        return "U".repeat(start.length() - same) + end.reverse().substring(same);
    }

    public boolean find(TreeNode node, int target, StringBuilder sb) {
        if(node.val == target) {
            return true;
        }
        if(node.left != null && find(node.left, target, sb)) {
            sb.append("L");
        }
        else if(node.right != null && find(node.right, target, sb)) {
            sb.append("R");
        }
        return !sb.isEmpty();
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);
        DirectionFromOneNodeToAnother directions = new DirectionFromOneNodeToAnother();
        System.out.println(directions.getDirections(root, 3, 6));
    }
}
