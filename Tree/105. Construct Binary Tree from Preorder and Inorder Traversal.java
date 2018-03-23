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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode curr = root;
        stack.push(root);
        for(int i=1,j=0;i<preorder.length;i++){
            if(curr.val!=inorder[j]){
                curr.left = new TreeNode(preorder[i]);
                stack.push(curr);
                curr = curr.left;
            }else{
                j++;
                while(!stack.isEmpty() && stack.peek().val == inorder[j]){
                    j++;
                    curr = stack.pop();
                }
                curr.right = new TreeNode(preorder[i]);
                curr = curr.right;
            }
        }
        return root;
    }
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     return buildTree(preorder,inorder,0,0,inorder.length);
    // }
    // public TreeNode buildTree(int[] preorder, int[] inorder, int preStart,int inStart, int length) {
    //     if(length==0){
    //         return null;
    //     }
    //     TreeNode curr = new TreeNode(preorder[preStart]);
    //     int count = 0;
    //     while(inorder[inStart+count]!=preorder[preStart]){
    //         count++;
    //     }
    //     curr.left= buildTree(preorder,inorder,preStart+1,inStart,count);
    //     curr.right = buildTree(preorder,inorder,preStart+1+count,inStart+count+1,length-1-count);
    //     return curr;
    // }
}
