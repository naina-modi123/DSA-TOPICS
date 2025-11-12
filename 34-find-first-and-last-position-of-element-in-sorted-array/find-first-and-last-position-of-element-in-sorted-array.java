class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = lb(nums, target);
        int last = ub(nums, target);
        return new int[]{first, last};
        
    }
    private int lb(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1;
        int ans1 = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                ans1 = mid;
                high = mid-1;
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans1;
    }
    private int ub(int[] nums, int target){
        int n = nums.length;
        int low = 0, high = n-1;
        int ans2 = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                ans2 = mid;
                low = mid+1;
            
            }
            else if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans2;
    }
}
