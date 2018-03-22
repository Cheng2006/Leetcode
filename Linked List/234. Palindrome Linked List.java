/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next==null){
            return true;
        }
        ListNode runner = head;
        ListNode walker = head;
        ListNode prev = null;
        while(runner.next!=null && runner.next.next!=null){
            runner = runner.next.next;
            ListNode next = walker.next;
            walker.next = prev;
            prev = walker;
            walker = next;
        }
        if(runner.next!=null){
            runner = walker.next;
            walker.next = prev;
        }else{
            runner = walker.next;
            walker = prev;
        }
        
        while(runner!=null){
            if(walker.val!=runner.val){
                return false;
            }
            walker = walker.next;
            runner = runner.next;
        }
        return true;
    }
}
