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
    private TreeNode clone(TreeNode root, int offset) {
        if(root == null){
            return null;
        }
        TreeNode node = new TreeNode(root.val+offset);
        node.left = clone(root.left,offset);
        node.right = clone(root.right,offset);
        return node;
    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        List<TreeNode>[] dp = new LinkedList[n+1];
        dp[0] = new LinkedList<TreeNode>();
        dp[0].add(null);
        for(int i = 1;i<=n;i++){
            List<TreeNode> curr = new LinkedList<TreeNode>();
            for(int j = 0;j<i;j++){
                for(TreeNode left : dp[j]){
                    for(TreeNode right : dp[i-j-1]){
                        TreeNode node = new TreeNode(j+1);
                        node.left = clone(left,0);
                        node.right = clone(right,j+1);
                        curr.add(node);
                    }
                }
            }
            dp[i] = curr;
        }
        return dp[n];
    }
}
