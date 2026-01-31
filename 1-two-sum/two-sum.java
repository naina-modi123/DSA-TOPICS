class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int [2];
        ans[0] = -1;
        ans[1] = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            int sum = nums[i];
            int more = target - sum;
            if(map.containsKey(more)){
                ans[0] = i;
                ans[1] = map.get(more);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
        
        
    }
}