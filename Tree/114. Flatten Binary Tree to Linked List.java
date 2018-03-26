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
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode prev = curr.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
    // public void flatten(TreeNode root) {
    //     if(root==null){
    //         return;
    //     }
    //     flattenHelper(root);
    // }
    // private TreeNode flattenHelper(TreeNode root) {
    //     if(root.left==null && root.right==null){
    //         return root;
    //     }else if(root.left == null){
    //         return flattenHelper(root.right);
    //     }else if(root.right == null){
    //         root.right = root.left;
    //         root.left = null;
    //         return flattenHelper(root.right);
    //     }else {
    //         TreeNode left = flattenHelper(root.left);
    //         left.right = root.right;
    //         root.right = root.left;
    //         root.left = null;
    //         return flattenHelper(left.right);
    //     }
    // }
}
