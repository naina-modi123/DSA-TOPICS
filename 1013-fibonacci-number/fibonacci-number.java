class Solution {
    public int fib_memo(int n, int[] dp){
        if(n == 0 || n == 1){
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = fib_memo(n-1, dp)+fib_memo(n-2, dp);
        return dp[n];
    }
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fib_memo(n, dp);
    }
}