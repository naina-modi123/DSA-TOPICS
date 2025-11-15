class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] memo = new int[m][n];  
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return helper(word1, word2, 0, 0, memo);
    }
    private int helper(String w1, String w2, int i, int j, int[][] memo){
        if(i == w1.length()) return w2.length() - j;
        if(j == w2.length()) return w1.length() - i;

        if(memo[i][j] != -1) return memo[i][j];

        if(w1.charAt(i) == w2.charAt(j)){
            return helper(w1, w2, i+1, j+1, memo);
        }
        int insert = 1+ helper(w1, w2, i, j+1, memo);
        int delete = 1+ helper(w1, w2, i+1, j, memo);
        int replace = 1+ helper(w1, w2, i+1, j+1, memo);

        memo[i] [j]= Math.min(insert, Math.min(delete, replace));
        return memo[i][j];
    }
}