class Solution {
    public boolean canJump(int[] nums) {
        int maxReachableIndex = 0;

        // Iterate through each position in the array
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            // If current position is beyond our maximum reach, we can't proceed
            if (maxReachableIndex < currentIndex) {
                return false;
            }

            // Update maximum reachable index
            // Current index plus jump length from current position
            maxReachableIndex = Math.max(maxReachableIndex, currentIndex + nums[currentIndex]);
        }

        // If we complete the loop, we can reach the last index
        return true;
    }
}