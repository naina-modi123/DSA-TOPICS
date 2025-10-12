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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prevA = list1;
        for(int i=1;i<a;i++){
            prevA = prevA.next;
        }
        ListNode afterB = prevA;
        for(int i=0;i<b-a+2;i++){
            afterB = afterB.next;
        }
        ListNode tail = list2;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = afterB;
        prevA.next = list2;
        return list1;
    }
}