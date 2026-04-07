/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        int len1 = 0;
        int len2 = 0;
        while(first != null){
            len1++;
            first = first.next;
        }
        while(second != null){
            len2++;
            second = second.next;
        }
        first = headA;
        second = headB;
        int diff = Math.abs(len1 - len2);

        if(len1 > len2){
            for(int i = 0; i < diff; i++) first = first.next;
        } 
        else {
            for(int i = 0; i < diff; i++) second = second.next;
        }

        while(first != null && second != null){
            if(first == second) return first;
            first = first.next;
            second = second.next;
        }
        return null;
    }
}