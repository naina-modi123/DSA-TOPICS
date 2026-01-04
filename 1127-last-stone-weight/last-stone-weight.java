class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int ele : stones) pq.add(ele);
        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1 != stone2){
                pq.add(Math.abs(stone1 - stone2));
            }
        }
        if(pq.size() == 0){
            return 0;
        }else{
            return pq.poll();
        }
    }
}