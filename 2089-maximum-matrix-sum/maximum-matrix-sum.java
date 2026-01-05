class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negative = 0;
        int minAbs = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int value = matrix[i][j];
                if(value < 0) {
                    negative++;
                }
                sum += Math.abs(value);
                minAbs = Math.min(minAbs, Math.abs(value)); 
            }
        }
        if((negative&1)== 0) return sum;
        else return (sum - 2L * minAbs);
    }
}