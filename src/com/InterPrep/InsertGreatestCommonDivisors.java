package com.InterPrep;

import com.DataStructures.ListNode;

/*
Input: head = [18,6,10,3]
Output: [18,6,6,2,10,1,3]
 */

public class InsertGreatestCommonDivisors {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode left = head, right = head.next;
        while(right != null) {
            int gcd = getGreatestCommonDivisor(left.val, right.val);
            ListNode newNode = new ListNode(gcd);
            left.next = newNode;
            newNode.next = right;
            left = right;
            right = right.next;
        }
        return head;
    }
    private int getGreatestCommonDivisor(int a, int b) {
        if(a % b == 0) {
            return b;
        }
        if( b % a == 0) {
            return a;
        }
        int greater = Math.max(a, b);
        int lesser = Math.min(a, b);
        int remainder = 1;
        while(remainder != 0) {
            remainder = greater % lesser;
            greater = lesser;
            lesser = remainder;
        }
        return greater;
    }
    public static void main(String[] args) {
        InsertGreatestCommonDivisors insertGreatestCommonDivisors = new InsertGreatestCommonDivisors();
        System.out.println(insertGreatestCommonDivisors.getGreatestCommonDivisor(10, 6));
    }
}
