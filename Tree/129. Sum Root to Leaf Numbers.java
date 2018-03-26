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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root,0);
    }
    public int sumNumbers(TreeNode root, int prev){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return prev*10+root.val;
        }else{
            int curr = prev*10+root.val;
            return sumNumbers(root.left,curr)+sumNumbers(root.right,curr);
        }
    }
}
