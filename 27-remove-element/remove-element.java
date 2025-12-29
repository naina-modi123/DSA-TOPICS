class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int[] expectedNums = new int[n];
        int count = 0, j = 0;
        for(int i=0;i<n;i++){
            if(nums[i] != val){
                expectedNums[j] = nums[i];
                count++; 
                j++;
            }
        }
        for(int i=0;i<n;i++){
            nums[i] = expectedNums[i];
        }
        return count;
    }
}