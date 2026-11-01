class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int moves = 0;
        int minimum = Integer.MAX_VALUE;
        for(int num : nums){
            minimum = Math.min(num, minimum);
        }
        for(int num : nums){
            moves += num - minimum;
        }
        return moves;
    }
}
