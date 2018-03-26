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
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int height = 0;
        while(right!=null){
            left = left.left;
            right = right.left;
            height++;
        }
        if(left != null){
            return countNodes(root.left) + (1<<height);
        }else{
            return countNodes(root.right) + (1<<height);
        }
    }
}
