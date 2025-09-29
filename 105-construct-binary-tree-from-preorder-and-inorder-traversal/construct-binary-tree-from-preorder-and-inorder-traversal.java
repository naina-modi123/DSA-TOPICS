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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return constructBT(0,0,inorder.length-1,preorder,inorder);
    }
    public TreeNode constructBT(int prestart,int instart,int inend ,int [] preorder,int[] inorder){
        if(prestart > preorder.length -1 || instart > inend) return null;
        TreeNode root = new TreeNode(preorder[prestart]);

        int inindex = 0;
        for(int i = instart;i<= inend;i++){
            if(inorder[i] == root.val){
                inindex = i;
            }
        }
        root.left = constructBT(prestart+1,instart,inindex-1,preorder,inorder);
        root.right = constructBT(prestart+inindex-instart+1,inindex+1,inend,preorder,inorder);
        return root;
    }

}