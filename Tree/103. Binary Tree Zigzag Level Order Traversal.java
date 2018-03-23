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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean isLeft = true;
        while(!queue.isEmpty()){
            int count = queue.size();
            LinkedList<Integer> levelList = new LinkedList<Integer>();
            for(int i = 0;i<count;i++){
                TreeNode curr = queue.poll();
                if(isLeft==true){
                    levelList.add(curr.val);
                }else{
                    levelList.addFirst(curr.val);
                }
                if(curr.left!=null){
                    queue.add(curr.left);
                }
                if(curr.right!=null){
                    queue.add(curr.right);
                }
            }
            result.add(levelList);
            isLeft = !isLeft;
        }
        return result;
    }
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<LinkedList<Integer>> result = new LinkedList<LinkedList<Integer>>();
//         traversalHelper(root,result,0);
//         List<List<Integer>> result1 = new LinkedList<List<Integer>>();
//         result1.addAll(result);
//         return result1;
//     }
    
//     private void traversalHelper(TreeNode root, List<LinkedList<Integer>> result,int level){
//         if(root == null){
//             return ;
//         }
//         if(result.size()<=level){
//             LinkedList<Integer> levelList = new LinkedList<Integer>();
//             result.add(levelList);
//         }
//         if(level%2==0){
//             result.get(level).add(root.val);
//         }else{
//             result.get(level).addFirst(root.val);
//         }
//         traversalHelper(root.left,result,level+1);
//         traversalHelper(root.right,result,level+1);
//         return ;
//     }
}
