class Solution {
    private int upo_rec(int row, int col, int m, int n, int[][] grid){
        if(row >= m || col >= n || grid[row][col] == 1){
            return 0;
        }
        if(row == m-1 && col == n-1){
            return 1;
        }
        int rightPaths = upo_rec(row, col+1, m, n, grid);
        int downPaths = upo_rec(row+1, col, m, n, grid);

        return rightPaths+downPaths;
    }
    private int upo_memo(int row, int col, int m, int n, int[][] grid, int[][] dp){
        if(row >= m || col >= n || grid[row][col] == 1){
            return 0;
        }
        if(row == m-1 && col == n-1){
            return 1;
        }
        if(dp[row][col] != -1) return dp[row][col];
        int rightPaths = upo_memo(row, col+1, m, n, grid, dp);
        int downPaths = upo_memo(row+1, col, m, n, grid, dp);

        return dp[row][col] = rightPaths+downPaths;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return upo_memo(0, 0, m, n, obstacleGrid, dp);
        
    }
}