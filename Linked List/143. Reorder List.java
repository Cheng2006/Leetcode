/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next==null){
            return;
        }
        ListNode runner = head;
        ListNode walker = head;
        while(runner.next!=null && runner.next.next!=null){
            runner = runner.next.next;
            walker = walker.next;
        }
        ListNode curr = walker.next;
        ListNode prev = null;
        walker.next = null;
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode rCurr = prev;
        ListNode lCurr = head;
        while(rCurr!=null){
            ListNode rNext = rCurr.next;
            rCurr.next = lCurr.next;
            lCurr.next = rCurr;
            lCurr = rCurr.next;
            rCurr = rNext;
        }
        return;
    }
}
