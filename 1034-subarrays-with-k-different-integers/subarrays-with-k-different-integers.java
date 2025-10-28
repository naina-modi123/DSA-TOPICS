class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        if(k <= 0) return 0;
        long res = atmost(nums , k) - atmost(nums , k-1);
        return (int) res;
    }
    private long atmost(int []nums, int k){
        if(k == 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int left = 0;
        long count = 0L;
        for(int right = 0;right < nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (map.size() > k) {
                int v = nums[left++];
                map.put(v, map.get(v) - 1);
                if (map.get(v) == 0) map.remove(v);
            }
            count += right - left + 1;
        }
        return count;
    }
}