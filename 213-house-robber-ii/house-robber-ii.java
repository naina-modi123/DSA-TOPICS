class Solution {
    private int maximumSumWithoutAdjacents(int[] nums){
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int prev2 = 0;
        int prev = nums[0];
        int curr = prev;
        for(int i=1;i<n;i++){
            int take = nums[i];
            if(i>1) take += prev2;
            int nonTake = prev;
            curr = Math.max(take, nonTake);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] excludeLast = new int[n-1];
        for(int i=0;i<n-1;i++){
            excludeLast[i] = nums[i];
        }
        int[] excludeFirst = new int[n-1];
        for(int i=1;i<n;i++){
            excludeFirst[i-1] = nums[i];
        }
        return Math.max(maximumSumWithoutAdjacents(excludeLast),maximumSumWithoutAdjacents(excludeFirst));
    }
}