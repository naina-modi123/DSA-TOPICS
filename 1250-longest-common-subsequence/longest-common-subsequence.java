class Solution {
    private int lcs_rec(int i, int j, String t1, String t2){
        if(i == t1.length() || j == t2.length()) return 0;
        if(t1.charAt(i) == t2.charAt(j)){
            return lcs_rec(i+1, j+1, t1, t2) + 1;
        }
        else{
            int ans1 = lcs_rec(i, j+1, t1, t2);
            int ans2 = lcs_rec(i+1, j, t1, t2);
            return Math.max(ans1, ans2);
        }

    }
    private int lcs_memo(int i, int j, String t1, String t2, int[][] dp){
        if(i == t1.length() || j == t2.length()){
            return dp[i][j] = 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(t1.charAt(i) == t2.charAt(j)){
            return dp[i][j] = lcs_memo(i+1, j+1, t1, t2, dp)+1;
        }
        else{
            int ans1 = lcs_memo(i, j+1, t1, t2, dp);
            int ans2 = lcs_memo(i+1, j, t1, t2, dp);
            return dp[i][j] = Math.max(ans1, ans2);
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        return lcs_memo(0, 0, text1, text2, dp);
    }
    
}