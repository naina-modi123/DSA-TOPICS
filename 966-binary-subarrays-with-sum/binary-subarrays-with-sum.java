class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }
    private int atMost(int[] nums, int k){
        if(k < 0) return 0;
        int l = 0, count = 0, sum = 0;
        for(int r = 0;r< nums.length;r++){
            sum += nums[r];
            
            while(sum > k){
                sum -= nums[l];
                l++;
            }
            count += (r-l+1);
        }
        return count;
    }
}