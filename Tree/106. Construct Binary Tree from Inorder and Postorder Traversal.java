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
    public TreeNode buildTree(int[] inorder,int[] postorder) {
        if(postorder==null || postorder.length==0){
            return null;
        }
        int length = postorder.length;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = new TreeNode(postorder[length-1]);
        TreeNode curr = root;
        for(int i = length-2,j=length-1;i>=0;i--){
            if(curr.val!=inorder[j]){
                curr.right = new TreeNode(postorder[i]);
                stack.push(curr);
                curr = curr.right;
            }else{
                j--;
                while(!stack.isEmpty() && stack.peek().val==inorder[j]){
                    j--;
                    curr = stack.pop();
                }
                curr.left = new TreeNode(postorder[i]);
                curr = curr.left;
            }
        }
        return root;
    }
    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    //     return buildTree(inorder,postorder,0,0,inorder.length);
    // }
    // private TreeNode buildTree(int[] inorder,int[] postorder,int inStart,int postStart,int length) {
    //     if(length==0){
    //         return null;
    //     }
    //     int count = 0;
    //     while(inorder[inStart+count]!=postorder[postStart+length-1]){
    //         count++;
    //     }
    //     TreeNode curr = new TreeNode(postorder[postStart+length-1]);
    //     curr.left = buildTree(inorder,postorder,inStart,postStart,count);
    //     curr.right=  buildTree(inorder,postorder,inStart+count+1,postStart+count,length-count-1);
    //     return curr;
    // }
}
