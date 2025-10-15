class Solution {
    public boolean isPerfectSquare(int num) {
        if(num < 2) return true; 
        
        long left = 2, right = num / 2;
        while(left <= right){
            long mid = left + (right - left) / 2;
            long sq = mid * mid;
            
            if(sq == num) return true;
            else if(sq > num) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
