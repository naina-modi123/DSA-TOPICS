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
    private int idx;
    private void helperSerealize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        helperSerealize(root.left, sb);
        helperSerealize(root.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperSerealize(root, sb);
        return sb.toString();    
    }
    public TreeNode helperDeserialize(String data[]){
        if(idx >= data.length || data[idx].equals("null")) {
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(data[idx]));
        idx++;
        node.left = helperDeserialize(data);
        node.right = helperDeserialize(data);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        idx = 0;
        String[] arr = data.split(",");
        return helperDeserialize(arr);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));