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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head , fast = head;
        ListNode p = null , q = null;
        for(int i=1;i<k;i++){
            if(fast != null){
                fast = fast.next;
            }
        }
        p = fast;
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        q = slow;
        int temp = p.val;
        p.val = q.val;
        q.val = temp;
        return head;
        
    }
}