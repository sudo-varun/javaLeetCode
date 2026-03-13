package com.DataStructures;

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode() {}
      public TreeNode(int val) { this.val = val; }
      public TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.left = new TreeNode();
        root.right = new TreeNode();
        root.right.right = new TreeNode();
        preorderAssign(root, 0);
    }

    static int preorderAssign(TreeNode node, int counter) {
          if(node == null) return counter;
          node.val = counter++;
          counter = preorderAssign(node.left, counter);
          counter = preorderAssign(node.right, counter);
          return counter;
    }
}

