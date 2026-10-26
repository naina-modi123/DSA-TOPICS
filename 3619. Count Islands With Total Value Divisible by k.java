class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public long dfs(int i, int j, int[][] grid, boolean[][] vis){
        int m = grid.length;
        int n = grid[0].length;
        long sum = grid[i][j];
        vis[i][j] = true;
        for(int k=0;k<4;k++){
            int x = i+dirs[k][0], y = j+dirs[k][1];
            if(x >= 0 && y >= 0 && x < m && y<n && grid[x][y] > 0 && !vis[x][y]){
                sum += dfs(x,y,grid,vis);
            }
        }
        return sum;
    }
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j] > 0){
                    long sum = dfs(i,j,grid, visited);
                    if(sum % k == 0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
