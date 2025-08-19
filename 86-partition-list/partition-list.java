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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode ();
        ListNode dummy2 = new ListNode ();
        ListNode head1 = dummy1, head2 = dummy2;
        while(head != null){
            if(head.val < x){
                head1.next = head;
                head1 = head1.next;
            }
            else{
                head2.next = head;
                head2 = head2.next;

            }
            head = head.next;
        }
        head1.next = dummy2.next;
        head2.next = null;
        return dummy1.next;
    }
}