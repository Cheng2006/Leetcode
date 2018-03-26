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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<Integer>();
        if(root == null) {
            return result;
        }
        TreeNode curr = root;
        while(curr!=null){
            if(curr.right==null){
                result.addFirst(curr.val);
                curr = curr.left;
            }else{
                TreeNode temp = curr.right;
                while(temp.left != null && temp.left!=curr){
                    temp = temp.left;
                }
                if(temp.left!=curr){
                    temp.left = curr;
                    result.addFirst(curr.val);
                    curr = curr.right;
                }else{
                    temp.left = null;
                    curr = curr.left;
                }
            }
        }
        return result;
    }
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     LinkedList<Integer> result = new LinkedList<Integer>();
    //     if(root==null){
    //         return result;
    //     }
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         TreeNode curr = stack.pop();
    //         result.addFirst(curr.val);
    //         if(curr.left!=null){
    //             stack.push(curr.left);
    //         }
    //         if(curr.right!=null){
    //             stack.push(curr.right);
    //         }
    //     }
    //     return result;
    // }
}
