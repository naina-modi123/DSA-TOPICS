class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int freq = 0, ans = 0;
        for(int num:nums){
            if(freq == 0){
                ans = num;
                freq++;
            }
            else if(ans == num){
                freq++;
            }
            else{
                freq--;
            }
        }
        return ans;
    }
}