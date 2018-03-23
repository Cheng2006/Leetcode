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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }
    private boolean isValidBST(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if(min!=null && root.val<=min || max!=null && root.val>=max){
            return false;
        }
        return isValidBST(root.left,min,root.val) && isValidBST(root.right,root.val,max);
    }
}
