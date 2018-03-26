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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<String>();
        DFS(result,root,new StringBuilder());
        return result;
    }
    private void DFS(List<String> result, TreeNode root, StringBuilder prev) {
        if(root == null){
            return ;
        }
        int length = prev.length();
        prev.append(root.val);
        if(root.left==null && root.right==null){
            result.add(new String(prev));
        }else{
            prev.append("->");
            DFS(result,root.left,prev);
            DFS(result,root.right,prev);
        }
        prev.setLength(length);
    }
}
