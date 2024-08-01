class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        if (nums.length == 0) {
            return result;
        }

        // Find the first position of the target
        result[0] = findLeftPosition(nums, target);

        // If the target is not found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }

        // Find the last position of the target
        result[1] = findRightPosition(nums, target);

        return result;
    }

    private int findLeftPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                leftPosition = mid;  // potential first occurrence
                right = mid - 1;     // continue to search in the left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return leftPosition;
    }

    private int findRightPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightPosition = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                rightPosition = mid;  // potential last occurrence
                left = mid + 1;       // continue to search in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return rightPosition;
    }
}
