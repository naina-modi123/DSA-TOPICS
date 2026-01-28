class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i < s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch) && map.get(ch) >= len){
                len = map.get(ch)+1;
            }
            map.put(ch,i);
            maxLen = Math.max(maxLen, i-len+1);
        }
        return maxLen;
    }
}