class Solution {
    public int maxSubArray(int[] nums) {
        int maximumSum = nums[0];
        int currentMaximum = maximumSum;
        for (int i = 1; i < nums.length; i++) {
            currentMaximum = Math.max(currentMaximum + nums[i], nums[i]);
            maximumSum = Math.max(maximumSum, currentMaximum);
        }
        return maximumSum;
    }
}
