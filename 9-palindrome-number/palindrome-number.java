class Solution {
    public boolean isPalindrome(int x) {
        int oriNum = x;
        int reverse = helper(x);
        if(oriNum == reverse) return true;
        return false;
    }
    public int helper(int x){
        int revNum = 0;
        while(x > 0){
            int lastDigit = x % 10;
            revNum = (revNum * 10)+lastDigit;
            x = x/10;
        }
        return revNum;
    }
}