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
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null) {
            return result;
        }
        TreeNode curr = root;
        while(curr!=null){
            if(curr.left==null){
                result.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode prev = curr.left;
                while(prev.right!=null && prev.right!=curr){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right = curr;
                    curr = curr.left;
                }else{
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}
