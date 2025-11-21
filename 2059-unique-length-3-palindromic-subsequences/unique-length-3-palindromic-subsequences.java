class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for(int i =0;i<n;i++){
            int ch = s.charAt(i) - 'a';
            if(first[ch] == -1) first[ch] = i;
            last[ch] = i;
        }
        int count = 0;
        for(int c = 0;c<26;c++){
            if(first[c] != -1 && last[c] > first[c]){
                boolean[] middleEle = new boolean[26];
                for(int k = first[c]+1;k< last[c];k++){
                    middleEle[s.charAt(k) - 'a'] = true;
                }
                for(boolean m : middleEle){
                    if(m) count++;
                }
            } 
        }
        return count;
    }
}