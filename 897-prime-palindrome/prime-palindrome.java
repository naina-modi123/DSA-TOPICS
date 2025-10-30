class Solution {
    private boolean isPrime(int num){
        if(num < 2) return false;
        if(num == 2)return true;
        if(num % 2 == 0) return false;
        for(int i=3;i*i <= num;i += 2){
            if(num % i == 0) return false;
        }
        return true;
    }
    private boolean isPalindrome(int num){
        int oriNum = num;
        int revNum = 0;
        while(num > 0){
            int rem = num % 10;
            revNum = revNum*10+rem;
            num = num/10;
        }
        return oriNum == revNum;
    }
    public int primePalindrome(int n) {
        for(int i=n; ;i++){
            if(isPalindrome(i) && isPrime(i)){
                return i;
            }
            if (i > 11 && String.valueOf(i).length() % 2 == 0) {
                i = (int)Math.pow(10, String.valueOf(i).length());
            }
        }
    }
}