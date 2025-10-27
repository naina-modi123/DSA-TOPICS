class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        int[] map = new int[128];
        for (char ch : t.toCharArray()) {
            map[ch]++;
        }

        int start = 0, end = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;

        while (end < s.length()) {
            char endChar = s.charAt(end);
            if (map[endChar] > 0) count--;
            map[endChar]--;
            end++;
            while (count == 0) {
                if (end - start < minLen) {
                    minLen = end - start;
                    startIndex = start;
                }
                char startChar = s.charAt(start);
                map[startChar]++;
                if (map[startChar] > 0) count++;
                start++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
