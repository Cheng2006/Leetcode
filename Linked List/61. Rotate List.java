/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k<=0){
            return head;
        }
        int length = 0;
        ListNode curr = head;
        ListNode tail = head;
        while(curr != null){
            length++;
            tail = curr;
            curr = curr.next;
        }
        
        curr = head;
        ListNode prev = null;
        for(int i = 0;i<(length-k%length)%length;i++){
            prev = curr;
            curr = curr.next;
        }
        if(prev!=null){
            prev.next = null;
            tail.next = head;
        }
        return curr;
    }
}
