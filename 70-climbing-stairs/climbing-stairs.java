class Solution {
    public int climb_memo(int n, int[] dp){
        dp[0] = 1;
        dp[1] = 1;
        if(dp[n] !=  -1){
            return dp[n];
        }
        dp[n] = climb_memo(n-1, dp)+climb_memo(n-2, dp);
        return dp[n];
        
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climb_memo(n, dp);
    }
}