package com.tan.leetcode.p21;

public class MergeTwoLinkList {
    /**
     * Definition for singly-linked list.
     * */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

  static  class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

            ListNode mergeHead = null;
            ListNode mergeLink = null;
            
            ListNode current1=l1;
            ListNode current2=l2;
            if(current1==null){
                return l2;
            }
            if(current2==null){
                return l1;
            }

            
            while (current1 != null || current2 != null) {
                
                
                if(current1==null){
                    if(current2==null){
                        break;
                    }
                    ListNode newNode = new ListNode(current2.val);
                    if (mergeLink == null) {
                        mergeLink = newNode;
                        mergeHead = newNode;
                    }
                    mergeLink.next = newNode;
                    mergeLink = newNode;
                    current2 = current2.next;
                    continue;
                }

                if (current2 == null) {
                    ListNode newNode = new ListNode(current1.val);
                    if (mergeLink == null) {
                        mergeLink = newNode;
                        mergeHead = newNode;
                    }
                    mergeLink.next = newNode;
                    mergeLink = newNode;
                    current1 = current1.next;
                    continue;
                }

                
                if (current1.val > current2.val) {
                    ListNode newNode = new ListNode(current2.val);
                    if (mergeLink == null) {
                        mergeLink = newNode;
                        mergeHead = newNode;
                    }
                    mergeLink.next = newNode;
                    mergeLink = newNode;
                    current2 = current2.next;
                } else if (current2.val >= current1.val) {
                    ListNode newNode = new ListNode(current1.val);
                    if (mergeLink == null) {
                        mergeLink = newNode;
                        mergeHead = newNode;
                    }
                    mergeLink.next = newNode;
                    mergeLink = newNode;
                    current1 = current1.next;
                }


            }
            
            
         
            
            return mergeHead;
            
        }
    }
    
    
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.mergeTwoLists(new ListNode(2), new ListNode(1));
        
    }
}
