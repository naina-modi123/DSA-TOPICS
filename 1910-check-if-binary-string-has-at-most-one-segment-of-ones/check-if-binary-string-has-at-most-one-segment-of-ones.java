class Solution {
    public boolean checkOnesSegment(String s) {
        boolean zeroFound = false;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeroFound = true;
            }
            else{
                if(zeroFound){
                    return false;
                }
            }
        }
        return true;
    }
}