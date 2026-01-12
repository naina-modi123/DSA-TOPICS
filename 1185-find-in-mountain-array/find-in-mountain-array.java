/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peakele = Peak(mountainArr, n);

        int left = binarySearch(mountainArr, target, 0, peakele, true);
        if (left != -1) return left;

        return binarySearch(mountainArr, target, peakele + 1, n - 1, false);
    }

    private int Peak(MountainArray arr, int n){
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) < arr.get(mid + 1)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(MountainArray arr, int target, int low, int high, boolean flag){
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = arr.get(mid);

            if (val == target) return mid;

            if (flag) {
                if (val < target) low = mid + 1;
                else high = mid - 1;
            } else {
                if (val > target) low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
