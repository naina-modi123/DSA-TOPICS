class Solution {
    public boolean checkString(String s) {
        int countB = 0;
        int deletions = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                countB++;
            }else{
                deletions = Math.min(deletions+1, countB);
            }
        }
        if(deletions == 0) return true;
        else return false;
    }
}