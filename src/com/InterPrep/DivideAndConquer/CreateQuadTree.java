package com.InterPrep.DivideAndConquer;

import com.DataStructures.QuadTreeNode;

public class CreateQuadTree {
    public static class Node extends QuadTreeNode {
        public Node(boolean b, boolean b1) {
            this.val = b;
            this.isLeaf = b1;
        }

        public Node() {
            this.val = false;
            this.isLeaf = false;
        }
    }
    public Node construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private Node helper(int[][] grid, int x, int y, int w) {
        // if all are same return the node with the value of all
        if(allSame(grid, x, y, w)) {
            return new Node(grid[x][y] == 1, true);
        }
        Node node = new Node();
        node.topLeft = helper(grid, x, y, w/2);
        node.topRight = helper(grid, x,  y + w/2 , w / 2);
        node.bottomLeft = helper(grid, x + w/ 2, y, w / 2);
        node.bottomRight = helper(grid, x + w/2, y +w/2, w/2);
        return node;
    }

    private boolean allSame(int[][] grid, int x, int y, int w) {
        for(int i = x; i < x + w; i++) {
            for(int j = y; j < y + w; j++) {
                if(grid[x][y] != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,1,1,1,1},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0},
                {1,1,1,1,0,0,0,0}};
    }
}
