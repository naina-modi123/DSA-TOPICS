class Solution {
    public int atMost(int[] nums, int k){
        int i=0, j= 0, ans = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        while(i < n){
            map.put(nums[i] , map.getOrDefault(nums[i], 0)+1);
            while(map.size() > k){
                if(map.get(nums[j]) == 1){
                    map.remove(nums[j]);
                }else{
                    map.put(nums[j], map.get(nums[j]) - 1);
                }
                j++;
            }
            ans += i-j+1;
            i++;
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
        
    }
}