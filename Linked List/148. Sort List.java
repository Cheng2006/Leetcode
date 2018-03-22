/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode runner = head;
        ListNode walker = head;
        
        while(runner.next!=null && runner.next.next!=null){
            runner = runner.next.next;
            walker = walker.next;
        }
        runner = walker.next;
        walker.next = null;
        return merge(sortList(head),sortList(runner));
    }
    private ListNode merge(ListNode l1,ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next; ///!!!!!!!!!NOTICE!!!!!
        }
        curr.next = l1==null?l2:l1;
        return dummy.next;
    }
}
