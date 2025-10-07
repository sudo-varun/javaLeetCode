package com.InterPrep.PrefixSum;
/*
Given a 2D matrix matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Implement the NumMatrix class:

    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

You must design an algorithm where sumRegion works on O(1) time complexity.

eg:
Input ; [
            [3, 0, 1, 4, 2],
            [5, 6, 3, 2, 1],
            [1, 2, 0, 1, 5],
            [4, 1, 0, 1, 7],
            [1, 0, 3, 0, 5]
]
[           [0, 0, 0, 0, 0, 0],
            [0, 3, 3, 4, 8, 10],
            [0, 8, 14, 18, 24, 27],
            [0, 9, 17, 21, 28, 36],
            [0, 13, 22, 26, 34, 49],
            [0, 14, 23, 30, 38, 58]]
[2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]
 */
public class NumMatrix {
    int[][] ps;

    public NumMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = (n == 0) ? 0 : matrix[0].length;
        ps = new int[n+1][m + 1];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                /*
                 * +------------+
                 * | A  | B     |
                 * |----+-------|
                 * | C  | (i,j) |
                 * +------------+
                 *    (B + A) + ( C + A) - A
                 *
                 *
                 *                  B             C             A
                 */
                ps[i+1][j+1] = ps[i][j + 1] + ps[i + 1][j] - ps[i][j] + matrix[i][j];

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return ps[row2 + 1][col2 + 1] - ps[row1][col2 + 1] - ps[row2 + 1][col1] + ps[row1][col1];
    }
}

/*
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 *
 *
 *
 */
