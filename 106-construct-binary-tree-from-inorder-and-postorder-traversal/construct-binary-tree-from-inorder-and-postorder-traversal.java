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
    private TreeNode constructBT(int[] post, int psi, int pei, int[] in, int isi, int iei){
        if(isi > iei) return null;
        TreeNode node = new TreeNode(post[pei]);
        int idx = isi;
        while(in[idx] != post[pei]){
            idx += 1;
        }

        int nodes = idx - isi;
        node.left = constructBT(post,psi, psi+nodes-1, in, isi, idx-1);
        node.right = constructBT(post, psi+nodes, pei-1, in, idx+1, iei);

        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return constructBT(postorder, 0, n-1, inorder, 0, n-1);
        
    }
}