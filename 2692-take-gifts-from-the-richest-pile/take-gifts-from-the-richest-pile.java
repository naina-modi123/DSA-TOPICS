class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for(int num : gifts){
            pq.add(num);
        }
        long ans = 0;
        while(k > 0){
            int gift = pq.poll();
            gift = (int)(Math.sqrt(gift));
            pq.add(gift);
            k--;
        }
        while(pq.size() > 0){
            ans += pq.poll();
        }
        return ans;
        
    }
}