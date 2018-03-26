/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static final String split = ",";
    public static final String NU = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        DFS(root, sb);
        return sb.toString();
    }
    private void DFS(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(NU).append(split);
        }else{
            sb.append(root.val).append(split);
            DFS(root.left,sb);
            DFS(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> in = new LinkedList<String>();
        in.addAll(Arrays.asList(data.split(split)));
        return buildTree(in);
    }
    private TreeNode buildTree(Queue<String> queue){
        if(queue.isEmpty()){
           return null; 
        }
        String str = queue.poll();
        if(str.equals(NU)){
            return null;
        }
        TreeNode curr = new TreeNode(Integer.valueOf(str));
        curr.left = buildTree(queue);
        curr.right = buildTree(queue);
        return curr;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
