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
import java.util.*;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || postorder.length != inorder.length) {
            return null;
        }

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, hm);
    }

    private TreeNode buildTreePostIn(int[] inorder, int st, int ie, int[] postorder, int ps, int pe, HashMap<Integer, Integer> hm) {
        if (ps > pe || st > ie) return null;

        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot = hm.get(postorder[pe]);
        int numsLeft = inRoot - st;

        root.left = buildTreePostIn(inorder, st, inRoot - 1, postorder, ps, ps + numsLeft - 1, hm);
        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder, ps + numsLeft, pe - 1, hm);

        return root;
    }
}
