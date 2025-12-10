class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];  
        boolean[] visited = new boolean[26];
        
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        Stack<Character> st = new Stack<>();
        
        for (char c : s.toCharArray()) {
            
            count[c - 'a']--;  
            
            if (visited[c - 'a']) continue; 
            
            while (!st.isEmpty() && st.peek() > c && count[st.peek() - 'a'] > 0) {
                char removed = st.pop();
                visited[removed - 'a'] = false;
            }
            
            st.push(c);
            visited[c - 'a'] = true;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c : st) sb.append(c);
        
        return sb.toString();
    }
}
