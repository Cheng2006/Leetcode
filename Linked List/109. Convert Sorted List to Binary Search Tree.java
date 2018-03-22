/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode curr = null;
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        curr = head;
        int length = 0;
        ListNode temp = head;
        while(temp!=null){
            length++;
            temp = temp.next;
        }
        return DPS(0,length-1);
    }
    private TreeNode DPS(int left,int right){
        if(left>right){
            return null;
        }
        int mid = left+(right-left)/2;
        TreeNode leftTree = DPS(left,mid-1);
        TreeNode currNode = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode rightTree = DPS(mid+1,right);
        currNode.left = leftTree;
        currNode.right = rightTree;
        return currNode;
    }
}
