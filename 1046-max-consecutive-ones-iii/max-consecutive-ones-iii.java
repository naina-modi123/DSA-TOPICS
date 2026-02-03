class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0, j= 0, ans = 0, zeroes = 0;
        while(i < nums.length){
            if(nums[i] == 0) zeroes += 1;
            while(zeroes > k){
                if(nums[j] == 0){
                    zeroes--;
                }
                j++;
            }
            ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }
}