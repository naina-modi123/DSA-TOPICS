class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long MOD = 1_000_000_007;
        Map<Integer, Long> right = new HashMap<>();
        for (int x : nums) {
            right.put(x, right.getOrDefault(x, 0L) + 1);
        }

        Map<Integer, Long> left = new HashMap<>();
        long total = 0;

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            right.put(val, right.get(val) - 1);

            long leftCount = 0, rightCount = 0;
            int target = val * 2;
            if (left.containsKey(target)) leftCount = left.get(target);
            if (right.containsKey(target)) rightCount = right.get(target);

            total = (total + (leftCount * rightCount) % MOD) % MOD;

            left.put(val, left.getOrDefault(val, 0L) + 1);
        }

        return (int) total;
    }
}
