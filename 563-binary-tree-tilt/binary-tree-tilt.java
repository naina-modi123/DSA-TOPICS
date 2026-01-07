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
    int ans = 0;
    private int helper(TreeNode root){
        if(root == null) return 0;
        int lh = helper(root.left);
        int rh = helper(root.right);
        ans += Math.abs(lh - rh);
        return lh+rh+root.val;
    }
    public int findTilt(TreeNode root) {
        if(root == null) return 0;
        helper(root);
        return ans;
    }
}