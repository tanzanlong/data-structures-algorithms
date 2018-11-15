package com.tan.leetcode.p19;

import java.util.ArrayList;
import java.util.List;

public class LinkListDel {
    /**
     * Definition for singly-linked list.
     * */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            ListNode currentNode = head;
            List<ListNode> nodes = new ArrayList<ListNode>();
            nodes.add(currentNode);
            while (currentNode.next != null) {
                nodes.add(currentNode.next);
                currentNode = currentNode.next;
            }
            int size = nodes.size();

            if(size==1){
                head=currentNode=null;
                return head;
            }
            
            
            ListNode delNode = nodes.get(size - n);
            
            if(size - n==0){
                head=delNode.next;
                head.next=delNode.next.next;
                return head;
            }
            
            ListNode delNodeB = nodes.get(size - n-1);
            
            if(n==1){
                delNodeB.next=null;
                return head;
            }

         
            delNodeB.next = delNode.next;
            return head;
        }
        
        
        public ListNode removeNthFromEndOne(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;
            // Advances first pointer so that the gap between first and second is n nodes apart
            for (int i = 1; i <= n + 1; i++) {
                first = first.next;
            }
            // Move first to the end, maintaining the gap
            while (first != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
        
    }
}
