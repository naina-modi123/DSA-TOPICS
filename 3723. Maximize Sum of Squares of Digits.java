class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num){
            return "";
        }
        StringBuilder sb = new StringBuilder();

        while(num-- > 0){
            int digit = Math.min(9, sum);
            sb.append(digit);
            sum -= digit;
        }
        if(sum == 0){
            return sb.toString();
        }else{
            return "";
        }
    }
}
