public class Solution {
    public int count = 0;
    public int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        DFS(root,k);
        return result;
    }
    public void DFS(TreeNode root,int k){
        if(root==null || count==k){
            return;
        }
        DFS(root.left,k);
        if(++count==k){
            result = root.val;
            return;
        }
        DFS(root.right,k);
        return;
    }
}
