class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int cnt = 0;
        double product = 1;
        int start = 0;
        for(int end = start;end < nums.length;end++){
            product *= nums[end];
            while(product >= k){
                product /= nums[start];
                start++;
            }
            cnt += end - start + 1;
        }
        return cnt;
    }
}