class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int rem = sum % k;
        if(rem == 0) return 0;
        return rem; 
        
    }
}