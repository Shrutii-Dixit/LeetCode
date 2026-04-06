/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int n = 0;
        int count = 0;
        ListNode curr = head;
        while(curr != null){
            n++;
            curr = curr.next;
        }
        count = (n/2);
        curr = head;
        while(count>0){
            curr = curr.next;
            count--;
        }
        return curr;
    }
}