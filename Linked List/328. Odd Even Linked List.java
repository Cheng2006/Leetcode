
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode oddCurr = head;
        ListNode evenHead = head.next;
        ListNode evenCurr = evenHead;
        while(evenCurr!=null && evenCurr.next!=null){
            oddCurr.next = evenCurr.next;
            evenCurr.next = evenCurr.next.next;
            oddCurr = oddCurr.next;
            evenCurr = evenCurr.next;
        }
        oddCurr.next = evenHead;
        return head;
    }
}
