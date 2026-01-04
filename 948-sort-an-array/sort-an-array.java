class Solution {
    public int[] sortArray(int[] nums) {
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : nums){
            pq.add(ele);
        }
        int idx = 0;
        while(pq.size() > 0){
            ans[idx] = pq.poll();
            idx++;
        }
        return ans;
    }
}