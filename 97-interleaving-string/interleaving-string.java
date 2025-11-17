class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int[][] memo = new int[s1.length()+1][s2.length()+1];
        return solve(s1, s2, s3, 0, 0,memo);
    }
    
    private boolean solve(String s1, String s2, String s3, int i, int j, int[][] memo) {
        int k = i + j;
        if (k == s3.length()) return true;
        if(memo[i][j] != 0) return memo[i][j] == 1;
        
        boolean a = false, b = false;
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k))
            a = solve(s1, s2, s3, i + 1, j, memo);
        
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k))
            b = solve(s1, s2, s3, i, j + 1, memo);
        memo[i][j] = (a || b) ? 1 : -1;
        return a || b;
    }
}
