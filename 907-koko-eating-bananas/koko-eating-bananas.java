class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        return minimumRateToEatBanana(piles, h);
    }

    private int minimumRateToEatBanana(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // Find the maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalH = calculateTotalHour(piles, mid);  // Changed to long

            if (totalH <= h) {
                high = mid - 1; // try smaller speed
            } else {
                low = mid + 1; // need faster speed
            }
        }

        return low;
    }

    private long calculateTotalHour(int[] piles, int hourly) {
        long totalH = 0;  // Changed to long
        for (int pile : piles) {
            totalH += (pile + (long)hourly - 1) / hourly;  // Prevent overflow
        }
        return totalH;
    }
}
