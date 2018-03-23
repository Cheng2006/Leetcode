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
    public boolean isBalanced(TreeNode root) {
        return balanceHelper(root)!=-1;
    }
    public int balanceHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = balanceHelper(root.left);
        if(left==-1){
            return -1;
        }
        int right = balanceHelper(root.right);
        if(right == -1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
