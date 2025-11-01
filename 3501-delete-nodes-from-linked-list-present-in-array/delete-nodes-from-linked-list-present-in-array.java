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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        while(head == null || set.contains(head.val)){
            head = head.next;
        }
        if(head == null) return null;
        ListNode prev = head;
        ListNode temp = head.next;
        while(temp != null){
            if(set.contains(temp.val)){
                prev.next = temp.next;
            }
            else{
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
        
    }
}