class Solution {
    public int characterReplacement(String s, int k) {
        int i=0, j=0, maxFreq = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(i < s.length()){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));
            while((i-j+1)- maxFreq > k){
                char ch1 = s.charAt(j);
                map.put(ch1, map.get(ch1)- 1);
                j++;
            }
            ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
        
    }
}