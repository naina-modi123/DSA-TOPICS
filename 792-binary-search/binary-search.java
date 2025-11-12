class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low +(high - low)/2;
            if(target == nums[mid]){
                return mid;
            }
            else if(target < nums[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}