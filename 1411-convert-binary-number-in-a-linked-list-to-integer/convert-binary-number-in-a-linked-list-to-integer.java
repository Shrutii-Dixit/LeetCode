/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; 
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int n = 0;
        int sum = 0;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            sum += (temp.val)*(1<<(n-1));
            temp = temp.next;
            n--;
        }
        return sum;
    }
}