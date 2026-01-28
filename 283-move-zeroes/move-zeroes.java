class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length; 
        if(nums == null || nums.length == 0){
            return;
        }
        int w = 0;
        for(int r=0;r<n;++r){
            if(nums[r] != 0){
                nums[w] = nums[r];
                ++w;
            }
        }
        while(w < n){
            nums[w] = 0;
            ++w;
        }
        
    }
}