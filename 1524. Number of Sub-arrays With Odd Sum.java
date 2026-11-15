class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        long count = 0;
        long even = 1;
        long odd = 0;
        int sum = 0;

        for(int num : arr){
            sum += num;
            if(sum % 2 == 0){
                count += odd;
                even++;
            }else{
                count += even;
                odd++;
            }
            count %= mod;
        }
        return (int)count;
    }
}
