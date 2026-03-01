class Solution {
    public int minPartitions(String n) {
        int ans = 0;
        int len = n.length();
        int i = 0;
        while (i < len) {
            int ch = n.charAt(i)-'0';
            ans = Math.max(ans, ch);
            i++;
        }
        return ans;
    }
}