/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode curr = root;
        TreeLinkNode prev = null;
        TreeLinkNode levelHead = null;
        while(curr!=null){
            while(curr!=null){
                if(curr.left!=null){
                    if(levelHead == null){
                        levelHead = curr.left;
                    }else{
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }
                if(curr.right!=null){
                    if(levelHead == null){
                        levelHead = curr.right;
                    }else{
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
            curr = levelHead;
            levelHead = null;
            prev = null;
        }
    }
    // public void connect(TreeLinkNode root) {
    //     if(root==null){
    //         return ;
    //     }
    //     Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    //     queue.add(root);
    //     while(!queue.isEmpty()){
    //         int count = queue.size();
    //         TreeLinkNode prev = null;
    //         while(count-->0){
    //             TreeLinkNode curr = queue.poll();
    //             if(prev!=null){
    //                 prev.next = curr;
    //             }
    //             if(curr.left!=null){
    //                 queue.add(curr.left);
    //             }
    //             if(curr.right!=null){
    //                 queue.add(curr.right);
    //             }
    //             prev = curr;
    //         }
    //     }
    // }
}
