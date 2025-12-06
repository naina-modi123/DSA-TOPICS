class Solution {
    private int lis_rec(int[] nums, int idx, int prev){
        if(idx == nums.length){
            return 0;
        }
        int ans = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            int take = lis_rec(nums, idx+1, idx) + 1;
            ans = Math.max(ans, take);
        }
        int nonTake = lis_rec(nums, idx+1, prev);
        ans = Math.max(ans, nonTake);

        return ans;
    }
    private int lis_memo(int[] nums, int idx, int prev, int[][] dp){
        if(idx == nums.length){
            return 0;
        }
        if(prev != -1 && dp[prev][idx] != -1) return dp[prev][idx];
        int ans = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            int take = lis_memo(nums, idx+1, idx, dp) + 1;
            ans = Math.max(ans, take);
        }
        int nonTake = lis_memo(nums, idx+1, prev, dp);
        ans = Math.max(ans, nonTake);

        return (prev != -1) ? dp[prev][idx] = ans : ans;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] a: dp){
            Arrays.fill(a, -1);
        }
        return lis_memo(nums, 0, -1, dp);
        
    }
}