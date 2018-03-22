/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr!=null){
            if(curr.next == null || curr.next.val != curr.val){
                prev = curr;
            }else{
                do{
                   curr = curr.next; 
                }while(curr.next!=null && curr.val == curr.next.val);
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
