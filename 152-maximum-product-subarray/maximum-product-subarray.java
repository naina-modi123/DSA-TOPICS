class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int product = 1;
            for(int j = i;j<n;j++){
                product = product * nums[j]; 
                maxi = Math.max(maxi , product);
            }
            
        }
        return maxi;
    }
}