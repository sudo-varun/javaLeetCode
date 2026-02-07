package com.InterPrep.LinkedList;

import com.DataStructures.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as
 * the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.

 * The twin sum is defined as the sum of a node and its twin.

 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.

 * Example 1:

 * Input: head = [5,4,2,1]
 * Output: 6
 * Explanation:
 * Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
 * There are no other nodes with twins in the linked list.
 * Thus, the maximum twin sum of the linked list is 6.
 */
public class PairSum {
//    public int pairSum(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        ListNode start = head;
//        while(start != null) {
//            list.add(start.val);
//            start = start.next;
//        }
//        System.out.println(list);
//        // we know that len is even no need to check anything for now
//        int maxSum = Integer.MIN_VALUE;
//        int n = list.size();
//        for (int i = 0; i < n/2; i++) {
//            System.out.println("i: " + i);
//            int twin = n - 1 - i;
//            System.out.println("twin: " + twin);
//            maxSum = Math.max(maxSum, list.get(i) + list.get(twin));
//            System.out.println(maxSum);
//        }
//
//        return maxSum;
//    }
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        Stack<Integer> prev = new Stack<>();
        while(fast != null && fast.next != null) {
            prev.add(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        int maxSum = Integer.MIN_VALUE;
        while(slow != null) {
            int twin = prev.pop();
            maxSum = Math.max(twin + slow.val, maxSum);
            slow = slow.next;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        PairSum pairSum = new PairSum();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        pairSum.pairSum(head);
    }
}
