class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int zeroes = 0;
            for(int j=i;j<n;j++){
                if(nums[j] == 0){
                    zeroes++;
                }
                if(zeroes > k){
                    break;
                }
                maxLen = Math.max(maxLen , j-i+1);
            }
        }
        return maxLen;
    }
}