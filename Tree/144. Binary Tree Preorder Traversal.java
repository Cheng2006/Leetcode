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
    //morris
    public List<Integer> preorderTraversal(TreeNode root) {
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
                TreeNode temp = curr.left;
                while(temp.right!=null && temp.right!=curr){
                    temp = temp.right;
                }
                if(temp.right != curr){
                    temp.right = curr;
                    result.add(curr.val);
                    curr = curr.left;
                }else{
                    temp.right = null;
                    curr = curr.right;
                }
            }
        }
        return result;
    }
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     List<Integer> result = new LinkedList<Integer>();
    //     if(root == null) {
    //         return result;
    //     }
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         TreeNode curr = stack.pop();
    //         result.add(curr.val);
    //         if(curr.right!=null){
    //             stack.push(curr.right);
    //         }
    //         if(curr.left!=null){
    //             stack.push(curr.left);
    //         }
    //     }
    //     return result;
    // }
}
