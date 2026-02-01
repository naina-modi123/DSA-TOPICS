class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch != ' '){
                sb.append(ch);
            }
            else{
                sb.reverse();
                ans.append(sb);
                ans.append(" ");
                sb = new StringBuilder();
            }
        }
        sb.reverse();
        ans.append(sb);
        return ans.toString();
        
    }
}