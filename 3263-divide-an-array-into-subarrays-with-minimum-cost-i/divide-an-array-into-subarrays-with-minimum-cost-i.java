class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int cost = Integer.MAX_VALUE;
        int minSoFar = nums[1];
        for(int i=2;i<n;i++){
            cost = Math.min(nums[0]+minSoFar+nums[i], cost);
            minSoFar = Math.min(minSoFar, nums[i]);
        }
        return cost;
    }
}