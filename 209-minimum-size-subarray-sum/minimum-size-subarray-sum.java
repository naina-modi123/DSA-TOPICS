class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int start = 0,sum = 0;
        int minLen = Integer.MAX_VALUE;
        for(int end = start;end < n;end++){
            sum += nums[end];
            while(sum >= target){
                minLen = Math.min(minLen, end-start+1);
                sum -= nums[start++];           
            }
        }
        if(minLen == Integer.MAX_VALUE) return 0;
        return minLen;
    }
}