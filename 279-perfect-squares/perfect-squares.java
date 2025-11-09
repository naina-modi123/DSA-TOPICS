class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n, memo);
    }

    private int helper(int n, int[] memo) {
        if (n < 0) return Integer.MAX_VALUE;
        if (n == 0) return 0;
        if (memo[n] != -1) return memo[n];

        int minCount = n;
        for (int i = 1; i * i <= n; i++) {
            int count = helper(n - i * i, memo);
            if (count != Integer.MAX_VALUE) {
                minCount = Math.min(minCount, count + 1);
            }
        }

        memo[n] = minCount;
        return minCount;
    }
}
