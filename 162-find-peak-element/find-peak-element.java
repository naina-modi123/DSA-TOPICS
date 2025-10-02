class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[mid + 1]) {
                // Peak is on the right
                left = mid + 1;
            } else {
                // Peak is on the left (or mid itself)
                right = mid;
            }
        }
        
        // left == right is the peak index
        return left;
    }
}
