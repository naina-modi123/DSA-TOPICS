class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        result[0] = firstOcc(nums, target);
        result[1] = lastOcc(nums, target);
        return result;
    }

    private int firstOcc(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int first = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                first = mid;
                end = mid - 1; // move left for first occurrence
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return first;
    }

    private int lastOcc(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int last = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                last = mid;
                start = mid + 1; // move right for last occurrence
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return last;
    }
}
