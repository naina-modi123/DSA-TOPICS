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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder ,0,preorder.length-1);   
    }
    public TreeNode helper(int[] preorder, int s,int e){
       if(s>e) return null;
       TreeNode node = new TreeNode (preorder[s]);
       int i;
       for(i=s;i<=e;i++){
            if(preorder[i] > node.val){
                break;
            }
       }
       node.left = helper(preorder,s+1,i-1);
       node.right = helper(preorder,i,e);
       return node;

    }
}