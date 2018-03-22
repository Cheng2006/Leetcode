/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode prev = dummy;
        ListNode currL = l1;
        ListNode currS = l2;
        ListNode longHead = l1;
        ListNode shortHead = l2;
        ListNode last = dummy;
        while(currL!=null && currS!=null){
            currL = currL.next;
            currS = currS.next;
        }
        if(currL==null){
            longHead = l2;
            shortHead = l1;
            currL = currS;
            currS = longHead;
        }
        currS = longHead;
        
        while(currL!=null){
            prev.next = new ListNode(currS.val);
            if(currS.val==9){
                stack.push(prev.next);
            }else{
                stack.clear();
                last = prev.next;
            }
            currS = currS.next;
            currL = currL.next;
            prev = prev.next;
        }
        currL = shortHead;
        while(currL!=null){
            int temp = currL.val+currS.val;
            if(temp<9){
                prev.next = new ListNode(temp);
                stack.clear();
                last = prev.next;
            }else if(temp==9){
                prev.next = new ListNode(temp);
                stack.push(prev.next);
            }else{
                prev.next = new ListNode(temp%10);
                while(!stack.isEmpty()){
                    stack.pop().val = 0;
                }
                last.val = last.val+1;
                last = prev.next;
            }
            currL = currL.next;
            currS = currS.next;
            prev = prev.next;
        }
        return dummy.val==0?dummy.next:dummy;
        
    }
}
