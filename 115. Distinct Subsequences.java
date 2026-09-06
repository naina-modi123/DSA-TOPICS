class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return helper(s, t, 0, 0, memo);
    }

    private int helper(String s, String t, int i, int j, int[][] memo) {
        if (j == t.length()) return 1;      
        if (i == s.length()) return 0;       

        if (memo[i][j] != -1) return memo[i][j];

        int ans;
        if (s.charAt(i) == t.charAt(j)) {
            ans = helper(s, t, i + 1, j + 1, memo) 
                + helper(s, t, i + 1, j, memo);
        } else {
            ans = helper(s, t, i + 1, j, memo);
        }

        memo[i][j] = ans;
        return ans;
    }
}
