/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode runner = head;
        ListNode walker = head;
        while(runner.next!=null && runner.next.next!=null){
            runner = runner.next.next;
            walker = walker.next;
            if(runner == walker){
                runner = head;
                while(runner!=walker){
                    runner = runner.next;
                    walker = walker.next;
                }
                return runner;
            }
        }
        return null;
    }
}
