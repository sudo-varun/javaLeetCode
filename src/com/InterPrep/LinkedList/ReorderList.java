package com.InterPrep.LinkedList;

import com.DataStructures.ListNode;

import java.util.List;

/**
 * You are given the head of a singly linked-list. The list can be represented as:

 * L0 → L1 → … → Ln - 1 → Ln

 * Reorder the list to be on the following form:

 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        int n = 0;
        ListNode start = head;
        while(start != null) {
            n++;
            start = start.next;
        }
        ListNode[] nodes = new ListNode[n];
        start = head;
        n = 0;
        while(start != null) {
            nodes[n] = start;
            n++;
            start = start.next;
        }
        for (int i = 0; i < n/2-1; i++) {
            ListNode f = nodes[i];
            ListNode e = nodes[n- i - 1];
            ListNode temp = f.next;
            f.next = e;
            e.next = temp;

        }
    }
    public static void main(String[] args) {
        ReorderList reorderList = new ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        reorderList.reorderList(head);
    }
}
