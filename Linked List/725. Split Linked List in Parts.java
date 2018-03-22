/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        ListNode curr = root;
        while(curr!=null){
            length++;
            curr = curr.next;
        }
        curr = root;
        int offset = length % k;
        int n = length / k;
        
        ListNode[] result = new ListNode[k];
        for(int i = 0;i<k;i++){
            int count = n + (i<offset?1:0);
            if(count==0){
                result[i] = null;
            }else{
                result[i] = curr;
                while(count-->1){
                    curr = curr.next;
                }
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }
        return result;
    }
}
