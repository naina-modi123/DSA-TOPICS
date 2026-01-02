class NumArray {
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;   
    }
    public int sumRange(int left, int right) {
        int n = nums.length;
        int psa[] = new int[n];
        int ans = 0;
        psa[0] = nums[0];
        for(int i=1;i<n;i++){
            psa[i] = psa[i-1]+nums[i];
        }
        if (left == 0) return psa[right];
        else return psa[right] - psa[left-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */