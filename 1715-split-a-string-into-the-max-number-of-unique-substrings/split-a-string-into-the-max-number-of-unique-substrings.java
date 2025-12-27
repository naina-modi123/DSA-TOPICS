class Solution {
    int ans = 0;

    public int maxUniqueSplit(String s) {
        backtrack(s, 0, new HashSet<>());
        return ans;
    }

    private void backtrack(String s, int idx, HashSet<String> set) {
        if (idx == s.length()) {
            ans = Math.max(ans, set.size());
            return;
        }
        for (int i = idx + 1; i <= s.length(); i++) {
            String sub = s.substring(idx, i);

            if (!set.contains(sub)) {
                set.add(sub);
                backtrack(s, i, set);
                set.remove(sub); 
            }
        }
    }
}
