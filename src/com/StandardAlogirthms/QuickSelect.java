package com.StandardAlogirthms;

public class QuickSelect {

    private int quickSelect(int[] nums, int left, int right, int kSmallest) {
        if (left == right) {
            return nums[left];
        }

        // Choose random pivot to avoid worst case
        int pivotIndex = right;
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (kSmallest == pivotIndex) {
            return nums[kSmallest];
        } else if (kSmallest < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, kSmallest);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, kSmallest);
        }
    }

    private int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];

        // Move pivot to end
        swap(nums, pivotIndex, right);

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, storeIndex, i);
                storeIndex++;
            }
        }

        // Move pivot to its final place
        swap(nums, storeIndex, right);
        return storeIndex;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        QuickSelect selectKthSmallest = new QuickSelect();
        int[] problem = {1,7,4,9,3,6,2,8,5};
        System.out.println(selectKthSmallest.quickSelect(problem, 0, problem.length - 1, 0));
    }
}
