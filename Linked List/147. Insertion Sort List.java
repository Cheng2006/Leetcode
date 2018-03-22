public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        // dummy.next = head;!!!!!!!NOTICE!!!!!!!!
        ListNode curr = head;
        ListNode prev = dummy;
        while(curr!=null){
            while(prev.next!=null && prev.next.val<curr.val){
                prev = prev.next;
            }
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
            prev = dummy;
        }
        return dummy.next;
    }
}
