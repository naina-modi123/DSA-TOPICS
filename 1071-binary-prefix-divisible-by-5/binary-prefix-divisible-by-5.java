class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> ans = new ArrayList<>();
        int rem = 0;
        for(int bit : nums){
            rem = (rem*2 + bit)% 5;
            ans.add(rem == 0);
        }
        return ans;
    }
}