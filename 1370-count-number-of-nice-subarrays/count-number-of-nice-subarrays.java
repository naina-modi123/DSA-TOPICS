class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
      return countAtMost(nums, k) - countAtMost(nums, k-1);
    }
    private int countAtMost(int[] nums, int k){
        int n = nums.length;
        int left = 0, right = 0;
        int countOdd = 0, total = 0;
        while(right < n){
            if(nums[right] % 2 == 1){
                countOdd++;
            }
            while(countOdd > k){
                if(nums[left] % 2 == 1){
                    countOdd--;
                }
                left++;
            }
            total += (right - left + 1);
            right++;
        }
        return total;
    }
}