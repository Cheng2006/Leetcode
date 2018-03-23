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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode curr = new TreeNode(nums[mid]);
        curr.left = sortedArrayToBST(nums,start,mid-1);
        curr.right = sortedArrayToBST(nums,mid+1,end);
        return curr;
    }
}
