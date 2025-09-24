import java.util.*;

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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map: col -> list of {row, val}
        Map<Integer, List<int[]>> map = new TreeMap<>();
        
        // BFS queue: node, row, col
        Queue<Object[]> q = new LinkedList<>();
        q.offer(new Object[]{root, 0, 0});
        
        while (!q.isEmpty()) {
            Object[] arr = q.poll();
            TreeNode node = (TreeNode) arr[0];
            int row = (int) arr[1];
            int col = (int) arr[2];
            
            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(new int[]{row, node.val});
            
            if (node.left != null) {
                q.offer(new Object[]{node.left, row + 1, col - 1});
            }
            if (node.right != null) {
                q.offer(new Object[]{node.right, row + 1, col + 1});
            }
        }
        
        // Sort each column by row, then by value
        List<List<Integer>> result = new ArrayList<>();
        for (List<int[]> list : map.values()) {
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            });
            
            List<Integer> colVals = new ArrayList<>();
            for (int[] pair : list) {
                colVals.add(pair[1]);
            }
            result.add(colVals);
        }
        
        return result;
    }
}
