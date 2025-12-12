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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        curr = dummy;
        inorder(root);
        return dummy.right;
    }
    private void inorder(TreeNode node){
        if(node == null) return;
        inorder(node.left);

        node.left = null;
        curr.right = node;
        curr = node;
        inorder(node.right);
    }
}