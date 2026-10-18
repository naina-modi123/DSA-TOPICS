class Solution {
    public int balancedStringSplit(String s) {
        int cnt = 0;
        int fcnt = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='L'){
                cnt--;
            }else{
                cnt++;
            } 
            if(cnt==0){
                fcnt++;
            }
        }
        return fcnt;   
    }
}
