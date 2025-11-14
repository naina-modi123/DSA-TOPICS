class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] memo = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                memo[i][j] = -1;
            }
        }
        return helper(obstacleGrid,0,0,memo);
        
    }
    private int helper(int[][] obstacleGrid, int i, int j, int[][] memo){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(i >= n || j >= m || obstacleGrid[i][j] == 1){
            return 0;
        }
        if(memo[i][j] != -1) return memo[i][j];
        if(i == n-1 && j == m-1) return 1;
        return memo[i][j] = helper(obstacleGrid,i+1,j,memo)+helper(obstacleGrid,i,j+1,memo);
    }
}