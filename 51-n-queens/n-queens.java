class Solution {
    public List<String> prepareTheConfig(boolean[][] board, int n){
        List<String> config = new ArrayList<>();
        for(int i=0;i<n;i++){
            String ans = "";
            for(int j=0;j<n;j++){
                ans += board[i][j] ? 'Q' : '.';
            }
            config.add(ans);
        }
        return config;
    }

    public boolean isSafe(int row, int col, boolean[][] board, int n){
        for(int r = row-1,c = col-1; r >= 0 && c >= 0; r--,c--){
            if(board[r][c]) return false;
        }
        for(int r = row-1; r >= 0; r--){
            if(board[r][col]) return false;
        }
        for(int r = row-1,c=col+1; r >= 0 && c<n; r--,c++){
            if(board[r][c]) return false;
        }
        return true;
    }

    public void helper(int row, boolean[][] board, int n, List<List<String>> ans){
        if(row == n){
            ans.add(prepareTheConfig(board, n));
            return;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(row, col, board, n)){
                board[row][col] = true;
                helper(row+1, board, n, ans);
                board[row][col] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        helper(0, board, n, ans);
        return ans;
    }
}
