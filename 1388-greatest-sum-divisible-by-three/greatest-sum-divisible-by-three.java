class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int num : nums) {
            int[] next = dp.clone();
            for (int r = 0; r < 3; r++) {
                int newR = (r + num) % 3;
                next[newR] = Math.max(next[newR], dp[r] + num);
            }
            dp = next;
        }

        return dp[0];
    }
}
