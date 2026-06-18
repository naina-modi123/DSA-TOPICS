class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for(int i=0;i<nums.size();i++){
            int curr = 0;
            for(int j=i;j<nums.size();j++){
                curr += nums.get(j);
                if(j-i+1 >= l && j-i+1 <= r && curr > 0) minSum = Math.min(minSum, curr);
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}
