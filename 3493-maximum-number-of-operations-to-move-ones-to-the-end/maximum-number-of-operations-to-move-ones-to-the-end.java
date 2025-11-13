class Solution {
    public int maxOperations(String s) {
        int ones = 0;
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '1') {
                ones++;
            } else {
                if (i == n - 1 || s.charAt(i + 1) == '1') {
                    ans += ones;
                }
            }
        }
        return ans;
    }
}
