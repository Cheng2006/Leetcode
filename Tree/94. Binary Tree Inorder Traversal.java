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
    // public List<Integer> result = new LinkedList<Integer>();
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     DFS(root);
    //     return result;
    // }
    // private void DFS(TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     DFS(root.left);
    //     result.add(root.val);
    //     DFS(root.right);
    //     return;
    // }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            result.add(temp.val);
            curr = temp.right;
        }
        return result;
    }
}
