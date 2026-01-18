class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        int[][] diagonal1 = new int[m + 1][n + 1]; 
        int[][] diagonal2 = new int[m + 1][n + 1]; 

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                row[i][j+1] = row[i][j] + grid[i][j];
                col[i+1][j] = col[i][j] + grid[i][j];
                diagonal1[i+1][j+1] = diagonal1[i][j] + grid[i][j];
                diagonal2[i+1][j] = diagonal2[i][j+1] + grid[i][j];
            }
        }
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    int target = row[i][j + k] - row[i][j];
                    boolean isMagic = true;

                    for (int r = i; r < i + k; r++) {
                        if (row[r][j + k] - row[r][j] != target) {
                            isMagic = false;
                            break;
                        }
                    }
                    for (int c = j; c < j + k && isMagic; c++) {
                        if (col[i + k][c] - col[i][c] != target) {
                            isMagic = false;
                            break;
                        }
                    }
                    int d1 = diagonal1[i + k][j + k] - diagonal1[i][j];
                    int d2 = diagonal2[i + k][j] - diagonal2[i][j + k];

                    if (isMagic && d1 == target && d2 == target) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }
}
