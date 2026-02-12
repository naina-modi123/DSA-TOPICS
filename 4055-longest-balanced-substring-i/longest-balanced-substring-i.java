class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                freq[s.charAt(j) - 'a']++;

                if (isBalanced(freq)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
    private boolean isBalanced(int[] freq) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int f : freq) {

            if (f > 0) {
                min = Math.min(min, f);
                max = Math.max(max, f);
            }
        }

        return min == max;
    }
}