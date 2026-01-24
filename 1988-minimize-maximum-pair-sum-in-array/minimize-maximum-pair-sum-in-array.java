class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = n-1;
        int maxSum = 0;
        while(left < right){
            int currSum = nums[left]+nums[right];
            maxSum = Math.max(maxSum, currSum);
            left++;
            right--;
        }
        return maxSum;
        
    }
}