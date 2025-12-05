class Solution {
    public int countPartitions(int[] nums) {
        int total = 0;
        for(int num : nums){
            total += num;
        }
        int count = 0;
        int left = 0;
        for(int i=0;i<nums.length - 1;i++){
            left += nums[i];

            if((left % 2) == ((total - left) % 2)) count++;
        }
        return count;
    }
}