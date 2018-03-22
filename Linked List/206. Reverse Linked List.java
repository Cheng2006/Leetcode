public class Solution {
    // public ListNode reverseList(ListNode head) {
    //     ListNode curr = head;
    //     ListNode prev = null;
    //     while(curr!=null){
    //         ListNode next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
    //     return prev;
    // }
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
