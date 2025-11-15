class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int l = 0, r = 0;
        int maxCount = 0, maxLen = 0;
        while(r < n){
            freq[s.charAt(r) - 'A']++;
            maxCount = Math.max(maxCount, freq[s.charAt(r) - 'A']);
            while((r-l+1) - maxCount > k){
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(r-l+1 , maxLen);
            r++;
        }
        return maxLen;
    }
}