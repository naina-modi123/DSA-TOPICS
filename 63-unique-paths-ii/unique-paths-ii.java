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
    private int upo_tab(int m, int n, int[][] grid, int[][] dp){
        if(grid[m-1][n-1] == 1) return 0;
        dp[m-1][n-1] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i == m-1 && j == n-1) continue;
                if(grid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    int rightPaths = (j+1 < n) ? dp[i][j+1]: 0;
                    int downPaths = (i+1 < m) ? dp[i+1][j] : 0;

                    dp[i][j] = rightPaths+downPaths;
                }
            }
        }
        return dp[0][0];

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int[] x: dp){
            Arrays.fill(x, -1);
        }
        return upo_tab(m, n, obstacleGrid, dp);
        
    }
}