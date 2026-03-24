class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        // flatten
        int size = n*m;
        int[] arr = new int [size];
        // filling
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[idx++] = grid[i][j];
            }
        }
        // prefixProduct
        int[] prefix = new int[size];
        prefix[0] = 1;
        for(int i=1;i<size;i++){
            prefix[i] = (int)((1L * prefix[i-1] * arr[i-1]) % mod);
        }
        // suffixProduct
        int[] suffix = new int[size];
        suffix[size - 1] = 1;
        for(int i= size-2; i >=0;i--){
            suffix[i] = (int)((1L * suffix[i+1] * arr[i+1]) % mod);
        }
        // building p matrix
        int[][] p = new int[n][m];
        idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                p[i][j] = (int)((1L * prefix[idx] * suffix[idx]) % mod);
                idx++;
            }
        }
        return p;
    }
}