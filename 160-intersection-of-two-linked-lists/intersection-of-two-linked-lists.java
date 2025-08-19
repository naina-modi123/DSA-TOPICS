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
        if(headA == null || headB == null){
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA != null) {
                pA = pA.next;
            } 
            else {
                    pA = headB;
            }
            if (pB != null) {
                pB = pB.next;
            } 
            else {
                pB = headA;
            }

        }
        return pA;
    }
}