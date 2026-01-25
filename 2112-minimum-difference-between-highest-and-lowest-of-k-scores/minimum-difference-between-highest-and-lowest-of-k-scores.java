class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if (k == 1) return 0;

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;

        for(int i = 0; i + k - 1 < n; i++){
            int currDiff = nums[i + k - 1] - nums[i];
            minDiff = Math.min(minDiff, currDiff);
        }
        return minDiff;
    }
}
