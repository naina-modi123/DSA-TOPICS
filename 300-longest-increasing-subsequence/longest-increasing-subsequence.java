class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int idx = 1;idx<n;idx++){
            for(int prev = 0;prev<idx;prev++){
                if(nums[prev] < nums[idx]){
                    dp[idx] = Math.max(dp[idx], dp[prev]+1);
                }
            }
            ans = Math.max(ans, dp[idx]);
        }
        return ans;
    }
}