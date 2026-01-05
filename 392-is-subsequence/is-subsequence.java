class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        int m = s.length();
        int n = t.length();
        int i=0,j=0;
        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else{
                j++;
            }
        }
        return (i == s.length());
    }
}