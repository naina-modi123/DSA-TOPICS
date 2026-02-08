class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        int maxLen = 0;
        Arrays.sort(nums);
        int i=0;
        for(int j=0;j<n;j++){
            while((long)nums[j] >(long) k*nums[i]){
                i++;
            }
            maxLen = Math.max(maxLen, j-i+1);
        }
        return n-maxLen;  
    }
}