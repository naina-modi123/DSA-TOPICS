class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int w = 0;
        for(int r=0;r<nums.length;++r){
            if(nums[r] != val){
                nums[w] = nums[r];
                ++w;
            }
        }
        return w;
        
    }
}