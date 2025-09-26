/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     private Map<Integer, Integer> leftMost; 
    private int maxWidth;
    public int widthOfBinaryTree(TreeNode root) {
         leftMost = new HashMap<>();
        maxWidth = 0;
        dfs(root, 0, 0); 
        return maxWidth;
    }

    private void dfs(TreeNode node, int depth, int index) {
        if (node == null) return;

        
        leftMost.computeIfAbsent(depth, x -> index);

       
        int width = index - leftMost.get(depth) + 1;
        maxWidth = Math.max(maxWidth, width);
        dfs(node.left, depth + 1, 2 * index);
        dfs(node.right, depth + 1, 2 * index + 1);

        
    }
}