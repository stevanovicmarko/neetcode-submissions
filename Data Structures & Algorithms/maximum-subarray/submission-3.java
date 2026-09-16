class Solution {
    public int maxSubArray(int[] nums) {
        int maximumSum = nums[0];
        int currentMaximum = maximumSum;
        for (int i = 1; i < nums.length; i++) {
            int candidate = nums[i];
            currentMaximum = Math.max(currentMaximum + candidate, candidate);
            maximumSum = Math.max(maximumSum, currentMaximum);
        }
        return maximumSum;
    }
}
