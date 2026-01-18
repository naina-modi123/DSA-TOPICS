class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            int maxFreq = 0;
            int maxNum = 0;
            for(int key : map.keySet()){
                if(map.get(key) > maxFreq){
                    maxFreq = map.get(key);
                    maxNum = key;
                }
            }
            ans[i] = maxNum;
            map.remove(maxNum);
        }
        return ans;
    }
}
