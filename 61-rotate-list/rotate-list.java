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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 1;
        ListNode curr = head;
        while(curr.next != null){
            curr = curr.next;
            len++;
        }
        k %= len;
        if(k == 0){
            return head;
        }
        curr.next = head;
        ListNode newcurr = head;
        for (int i=1;i<len - k;i++){
            newcurr = newcurr.next;
        }
        ListNode newHead = newcurr.next;
        newcurr.next = null;
        return newHead;

    }
}