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
    //level traversal is easy to understand and has the same time complexty with inorder traversal
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        DFS(root,1,result);
        return result;
    }
    private void DFS(TreeNode root, int level,List<Integer> result) {
        if(root == null){
            return ;
        }
        if(result.size()<level){
            result.add(root.val);
        }
        DFS(root.right,level+1,result);
        DFS(root.left,level+1,result);
    }
}
