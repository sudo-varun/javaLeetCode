package com.InterPrep.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {
    static int[][] directions = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int n = grid.length;
        int m = grid[0].length;
        int minutes = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    freshOranges++;
                }
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while(!queue.isEmpty() && freshOranges != 0) {
            minutes++;
            List<int[]> rotten = new ArrayList<>();
            while(!queue.isEmpty()) {
                int[] curr = queue.poll();
                for(int[] direction: directions) {
                    int newX = curr[0] + direction[0];
                    int newY = curr[1] + direction[1];
                    if (newX < 0 || newX >= n || newY < 0 || newY >= m || grid[newX][newY] != 1) {
                        continue;
                    }
                    grid[newX][newY] = 2;
                    freshOranges--;
                    rotten.add(new int[]{newX, newY});
                }
            }
            queue.addAll(rotten);
        }
        return freshOranges == 0 ? minutes : -1;
    }
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        RottingOranges rottingOranges = new RottingOranges();
        System.out.println(rottingOranges.orangesRotting(grid));

    }
}
