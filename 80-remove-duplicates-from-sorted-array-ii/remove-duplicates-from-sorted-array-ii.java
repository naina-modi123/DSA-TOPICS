class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int[] expectedNums = new int [n];
        expectedNums[0] = nums[0];
        int res = 1, count = 1;
        for(int i=1;i<n;i++){
            if(expectedNums[res - 1] != nums[i]){
                count = 1;
                expectedNums[res] = nums[i];
                res++;
            }
            else{
                if(count < 2){
                    expectedNums[res] = nums[i];
                    res++;
                    count++;
                }

            }
        }
        for(int i=0;i<res;i++){
            nums[i] = expectedNums[i];
        }
        return res;
    }
}