class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] expectedNums = new int[n];
        expectedNums[0] = nums[0];
        int count = 1;
        for(int i=1;i<n;i++){
            if(expectedNums[count-1] != nums[i]){
                expectedNums[count] = nums[i];
                count++;
            }
        }
        for(int i=0;i<count;i++){
            nums[i] = expectedNums[i];
        }
        return count;
    }
}