package com.tan.leetcode.p83;

import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicates {
    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

   static class Solution {
        
        public ListNode deleteDuplicates(ListNode head) {

            Map<Integer, Integer> keyMap = new HashMap<>();

            if(head==null||head.next==null){
                return head;
            }
            
            ListNode currentB=head;
            ListNode current=head.next;
            keyMap.put(head.val, head.val);
            while(current!=null){
                Integer key= keyMap.get(current.val);
                if(key!=null){
                    currentB.next=current.next;
                    if(currentB.next!=null){
                        current=currentB.next;
                    }else{
                        break;
                    }
                   
                }else{
                    keyMap.put(current.val, current.val);
                    current=current.next;
                    currentB=currentB.next;
                }
               
            }
            
            return head;

        }
    }
}
