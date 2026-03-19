class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n-1;
        int i=n-1;
        int[] ans = new int[n];
        while(left <= right){
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if(leftSq > rightSq){
                ans[i] = leftSq;
                left++;
            }else{
                ans[i] = rightSq;
                right--;
            }
            i--;
        } 
        return ans;
    }
}