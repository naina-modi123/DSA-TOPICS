class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;

        for (int idx = 1; idx < n; idx++) {
            for (int prev = 0; prev < idx; prev++) {
                if (checkPre(words[idx], words[prev])) {
                    dp[idx] = Math.max(dp[idx], dp[prev] + 1);
                }
            }
            ans = Math.max(ans, dp[idx]);
        }
        return ans;

    }

    private boolean checkPre(String s, String t) {
        if (s.length() != t.length() + 1)
            return false;

        int i = 0, j = 0;
        while (i < s.length()) {
            if (j < t.length() && s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == t.length();
    }

}