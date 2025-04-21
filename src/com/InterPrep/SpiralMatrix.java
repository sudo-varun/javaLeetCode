package com.InterPrep;

import java.util.ArrayList;
import java.util.List;

class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();

        // Example 1: 2x2 matrix
        int[][] matrix1 = {
                {1, 2},
                {3, 4}
        };
        System.out.println(sm.spiralOrder(matrix1)); // Expected: [1, 2, 4, 3]

        // Example 2: 3x3 matrix
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(sm.spiralOrder(matrix2)); // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Example 3: 4x3 matrix
        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };
        System.out.println(sm.spiralOrder(matrix3)); // Expected: [1, 2, 3, 6, 9, 12, 11, 10, 7, 4, 5, 8]
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rowStart = 0, colStart = 0, rowEnd = matrix.length - 1, colEnd = matrix[0].length - 1;
        while(ans.size() < matrix.length * matrix[0].length) {
            traverseRow(rowStart, colStart, colEnd, matrix, ans);
            rowStart++;
            traverseCol(colEnd, rowStart, rowEnd, matrix, ans);
            colEnd--;
            traverseRowBackwards(rowEnd, colEnd, colStart, matrix, ans);
            rowEnd--;
            traverseColUpwards(colStart, rowEnd, rowStart, matrix, ans);
            colStart++;
        }
        return ans;
    }

    private void traverseRow(int row, int startCol, int endCol, int[][] matrix, List<Integer> ans) {
        while(startCol <= endCol) {
            ans.add(matrix[row][startCol]);
            startCol++;
        }
    }
    private void traverseCol(int col, int startRow, int endRow, int[][] matrix, List<Integer> ans) {
        while(startRow <= endRow) {
            ans.add(matrix[startRow][col]);
            startRow++;
        }
    }
    private void traverseRowBackwards(int row, int startCol, int endCol, int[][] matrix, List<Integer> ans) {
        while(startCol >= endCol) {
            ans.add(matrix[row][startCol]);
            startCol--;
        }
    }
    private void traverseColUpwards(int col, int startRow, int endRow, int[][] matrix, List<Integer> ans) {
        while(startRow >= endRow) {
            ans.add(matrix[startRow][col]);
            startRow--;
        }
    }
}
