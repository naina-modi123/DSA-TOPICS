class NumArray {
    int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        
    }
    
    public int sumRange(int left, int right) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for(int i=1;i<n;i++){
            ans[i] = ans[i-1]+nums[i];
        }
        if(left == 0) return ans[right];
        else return ans[right] - ans[left-1];
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */