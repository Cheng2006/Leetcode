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
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr!=null){
            if(curr.left==null){
                if(prev!=null && prev.val>curr.val){
                    first = first==null?prev:first;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }else{
                TreeNode prec = curr.left;
                while(prec.right!=null && prec.right!=curr){
                    prec = prec.right;
                }
                if(prec.right==null){
                    prec.right = curr;
                    curr = curr.left;
                }else{
                    prec.right = null;
                    if(prev!=null && prev.val>curr.val){
                        first = first==null?prev:first;
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        if(first!=null && second!=null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        return ;
    }
    // public TreeNode first = null;
    // public TreeNode second = null;
    // public TreeNode prev = null;
    // public void recoverTree(TreeNode root) {
    //     inorder(root);
    //     if(first!=null && second!=null) {
    //         int temp = first.val;
    //         first.val = second.val;
    //         second.val = temp;
    //     }
    //     return ;
    // }
    // private void inorder(TreeNode root) {
    //     if(root==null) {
    //         return ;
    //     }
    //     inorder(root.left);
    //     if(prev!=null && root.val<prev.val){
    //         first = first==null?prev:first;
    //         second = root;
    //     }
    //     prev = root;
    //     inorder(root.right);
    //     return ;
    // }
}
