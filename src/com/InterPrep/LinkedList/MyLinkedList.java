package com.InterPrep.LinkedList;


import javax.management.ValueExp;

public class MyLinkedList {
    private class Node {
        int val;
        Node next;
        public Node(int val) {
            this.val = val;
        }
    }
    Node head;
    Node tail;
    int len;
    public MyLinkedList() {
        len = 0;
        head = null;
        tail = null;
    }

    public int get(int index) {
        if(index >= this.len) return -1;
        Node ans = this.head;
        for(int i = 0; i < index;i++) {
            ans = ans.next;
        }
        return ans.val;
    }

    public void addAtHead(int val) {
        if(this.len == 0) {
            this.head = this.tail = new Node(val);
            this.len++;
            return;
        }
        Node oldHead = this.head;
        this.head = new Node(val);
        this.head.next = oldHead;
        this.len++;
    }

    public void addAtTail(int val) {
        if(this.len == 0) {
            this.head = this.tail = new Node(val);
            this.len++;
            return;
        }
        this.tail.next = new Node(val);
        this.tail = this.tail.next;
        this.len++;
    }

    public void addAtIndex(int index, int val) {
        if(index > len) return;
        if(index == 0) {
            this.addAtHead(val);
            return;
        }
        if(index == len) {
            this.addAtTail(val);
            return;
        }
        Node start = this.head;
        for (int i = 1; i < index; i++) {
            start = start.next;
        }
        Node next = start.next;
        start.next = new Node(val);
        start.next.next = next;
        this.len++;
    }

    public void deleteAtIndex(int index) {
        if(index >= len) return;
        if(index == 0) {
            Node head = this.head;
            this.head = this.head.next;
            head.next = null;
            this.len--;
            if(len == 0) this.tail = null;
            return;
        }
        Node start = this.head;
        for (int i = 1; i < index; i++) {
            start = start.next;
        }
        Node toDelete = start.next;
        start.next = toDelete != null ? toDelete.next : null;
        if(start.next == null) this.tail = start;
        len--;
    }
    public void print() {
        Node curr = this.head;
        System.out.println("Curr len: " + len);
        while(curr != null) {
            System.out.print(curr.val);
            System.out.print("->");
            curr = curr.next;
        }
        System.out.println(""   );
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(4);
        System.out.println(myLinkedList.get(1));
        myLinkedList.addAtHead(1);
        myLinkedList.addAtHead(5);
        myLinkedList.deleteAtIndex(3);
        myLinkedList.addAtHead(7);
        myLinkedList.print();
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));
        System.out.println(myLinkedList.get(3));

        myLinkedList.addAtHead(4);

        myLinkedList.print();
        myLinkedList.deleteAtIndex(3);

        myLinkedList.addAtIndex(5,0);
        myLinkedList.addAtHead(6);
        myLinkedList.print();
    }
}
