public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = dummy;
        int count = n;
        while(count-->0){
            l1 = l1.next;
        }
        while(l1.next!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        l2.next = l2.next.next;
        return dummy.next;
    }
}
