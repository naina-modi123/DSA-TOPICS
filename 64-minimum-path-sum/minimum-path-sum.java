public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int [m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                memo[i][j] = -1;
            }
        }
        return helper(m - 1, n - 1, grid, memo);
    }

    public int helper(int i, int j, int[][] grid, int[][] memo) {
        if (i == 0 && j == 0)
            return grid[0][0];
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
            if (memo[i][j] != -1) return memo[i][j];
        int up = helper(i - 1, j, grid, memo);
        int left = helper(i, j - 1, grid, memo);
        memo[i][j] = grid[i][j] + Math.min (up, left);
        return memo[i][j];
    }
}