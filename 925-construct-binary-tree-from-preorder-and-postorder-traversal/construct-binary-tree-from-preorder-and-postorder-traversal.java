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
    int preindex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructBT(preorder,postorder,0,postorder.length - 1);  
    }
    public TreeNode constructBT(int[] preorder, int[] postorder,int poststart, int postend){
        if(preindex > preorder.length - 1 || poststart > postend) return null;
        TreeNode root = new TreeNode(preorder[preindex++]);
        if(poststart == postend) return root;

        int leftRootVal = preorder[preindex];
        int leftRootIndex = poststart;

        while (leftRootIndex <= postend && postorder[leftRootIndex] != leftRootVal) {
            leftRootIndex++;
        }

        root.left = constructBT(preorder, postorder, poststart, leftRootIndex);
        root.right = constructBT(preorder, postorder, leftRootIndex + 1, postend - 1);

        return root;
    }
}