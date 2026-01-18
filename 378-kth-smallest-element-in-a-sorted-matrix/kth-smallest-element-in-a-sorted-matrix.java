class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pq.add(matrix[i][j]);
            }
        }
        while(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}