public class Solution {
    public int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        getLongestPath(root);
        return result;
    }
    private int getLongestPath(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = Math.max(getLongestPath(root.left),0);
        int right = Math.max(getLongestPath(root.right),0);
        result = Math.max(result,left+right+root.val);
        return Math.max(left,right)+root.val;
    }
}
