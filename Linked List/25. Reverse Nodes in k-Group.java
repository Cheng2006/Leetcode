public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // if(head == null || head.next == null || k<2){
        //     return head;
        // }
        ListNode curr = head;
        int count = k;
        while(count-->0){
            if(curr == null){
                return head;
            }
            curr = curr.next;
        }
        
        ListNode prev = reverseKGroup(curr,k);
        count = k;
        curr = head;
        while(count-->0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
