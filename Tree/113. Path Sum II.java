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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        pathSumDFS(result,root,sum,new LinkedList<Integer>());
        return result;
    }
    public void pathSumDFS(List<List<Integer>> result, TreeNode root,int sum,List<Integer> prev){
        if(root == null){
            return ;
        }
        if(root.left == null && root.right == null){
            if(sum == root.val){
                List<Integer> list = new LinkedList<Integer>(prev);
                list.add(root.val);
                result.add(list);
            }
            return ;
        }
        prev.add(root.val);
        pathSumDFS(result,root.left,sum-root.val,prev);
        pathSumDFS(result,root.right,sum-root.val,prev);
        prev.remove(prev.size()-1);
        return ;
    }
}
