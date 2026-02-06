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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dO = new ListNode();
        ListNode de = new ListNode();
        ListNode t1 = dO;
        ListNode t2 = de;
        ListNode t = head;
        int idx = 1;
        while(t != null){
            if(idx%2 != 0){
                t1.next = t;
                t1 = t1.next;
                t = t.next;
            }else{
                t2.next = t;
                t2 = t2.next;
                t = t.next;
            }
            idx++;
        }
        t2.next = null;
        t1.next = de.next;
        return dO.next;
        
    }
}