class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }
        int maxarea = 0;
        for(int i=0;i<m;i++){
            int[] row = matrix[i].clone();

            Arrays.sort(row);

            for(int j=0;j<n;j++){
                int height = row[n-1-j];
                int width = j+1;

                maxarea = Math.max(maxarea, height*width);
            }
        }
        return maxarea;
    }
}