class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        Stack<Character> st = new Stack<>();
        for(char ch : s){
            st.push(ch);
        }
        int i=0;
        while(st.size() != 0){
            s[i++] = st.pop();
        }
    }
}