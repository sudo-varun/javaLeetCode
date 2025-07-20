package com.InterPrep.DivideAndConquer;

import com.DataStructures.ListNode;

public class SortLinkedList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return divide(head);
    }
    public ListNode divide(ListNode head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return new ListNode(head.val);
        }
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        ListNode left = divide(head);
        ListNode right = divide(slow);
        return merge(left, right);
    }
    public ListNode merge(ListNode start, ListNode mid) {
        ListNode temp = new ListNode();
        ListNode head = temp;
        while(start != null && mid != null) {
            if(start.val <= mid.val) {
                temp.next = new ListNode(start.val);
                temp = temp.next;
                start = start.next;
            } else {
                temp.next = new ListNode(mid.val);
                mid = mid.next;
                temp = temp.next;
            }
        }
        if(start != null) {
            temp.next = start;
        }
        if(mid != null) {
            temp.next = mid;
        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        SortLinkedList sortLinkedList = new SortLinkedList();
        ListNode sorted = sortLinkedList.sortList(head);
        while(sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }
}
