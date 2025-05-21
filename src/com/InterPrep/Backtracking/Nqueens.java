package com.InterPrep.Backtracking;

import java.util.HashSet;
import java.util.Set;

// sol = {1, 0, 0, 2, 10, 4, 40, 92, 352}[n-1]

public class Nqueens {
    int ans = 0;
    public int totalNQueens(int n) {
        if(n == 0) {
            return ans;
        }
        boolean[] cols = new boolean[n];
        boolean[] leftDiagonals = new boolean[2 * n];
        boolean[] rightDiagonals = new boolean[2 * n];

        recurse(0, cols, leftDiagonals, rightDiagonals, n);
        return ans;
    }
    public void recurse(int row, boolean[] cols, boolean[] leftDiagonals, boolean[] rightDiagonals, int n) {
        if(row == n) {
            ans++;
            return;
        }
        for(int col = 0; col < n; col++) {
            int dl = row - col + n;
            int dr = row + col;
            if(leftDiagonals[dl] || rightDiagonals[dr] || cols[col]) {
                continue;
            }
            leftDiagonals[dl] = true;
            rightDiagonals[dr] = true;
            cols[col] = true;

            recurse(row + 1, cols, leftDiagonals, rightDiagonals, n);

            leftDiagonals[dl] = false;
            rightDiagonals[dr] = false;
            cols[col] = false;
        }
    }
    public static void main(String[] args) {
        Nqueens nqueens = new Nqueens();
        System.out.println(nqueens.totalNQueens(4));
    }
}
