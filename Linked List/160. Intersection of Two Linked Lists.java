/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(l1!=null && l2!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1!=null){
            l2 = headA;
            while(l1!=null){
                l1 = l1.next;
                l2 = l2.next;
            }
            l1 = headB;
        }else if(l2!=null){
            l1 = headB;
            while(l2!=null){
                l2 = l2.next;
                l1 = l1.next;
            }
            l2 = headA;
        }else{
            l1 = headA;
            l2 = headB;
        }
        while(l1!=null && l2!=null && l1!=l2){
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1;
    }
}
