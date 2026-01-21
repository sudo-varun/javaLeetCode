package com.InterPrep.BinarySearch;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        return search(matrix, target, 0, m - 1);

    }
    public boolean search(int[][] matrix, int target, int top, int bottom) {
        if(top > bottom) {
            return false;
        }
        int mid = top + (bottom - top) / 2;
        int last = matrix[0].length - 1;
        if(target >= matrix[mid][0] && target <= matrix[mid][last]) {
            boolean found =  binarySearch(matrix[mid], target);
            if(found) return true;
        }
        if(mid > 0 && matrix[mid][0] >= target) {
            boolean found = search(matrix, target, top, mid - 1);
            if(found) return true;
        }
        if(mid < bottom && matrix[mid + 1][0] < target) {
            return search(matrix, target, mid + 1, bottom);
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1},{2},{3},{4},{5}};
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(matrix, 1));
    }
}
