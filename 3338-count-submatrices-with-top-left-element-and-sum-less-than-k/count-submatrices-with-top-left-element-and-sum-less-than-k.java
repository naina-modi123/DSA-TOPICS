class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] prefixSum = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                prefixSum[i][j] = grid[i][j];
                if(i > 0) prefixSum[i][j] += prefixSum[i-1][j];
                if(j > 0) prefixSum[i][j] += prefixSum[i][j-1];
                if(i > 0 && j > 0) prefixSum[i][j] -= prefixSum[i-1][j-1];
                
                if(prefixSum[i][j] <= k) count++;
            }
        }
        return count;
    }
}