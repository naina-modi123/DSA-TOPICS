class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j = 0, ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(i < s.length()){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            while(map.get(ch) > 1){
                char ch1 = s.charAt(j);
                map.put(ch1, map.get(ch1) - 1);
                j++;
            }
            ans = Math.max(ans, i-j+1);
            i++;
        }
        return ans;
    }
}