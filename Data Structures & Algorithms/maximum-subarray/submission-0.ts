class Solution {
    /**
     * @param {number[]} nums
     * @return {number}
     */
    maxSubArray(nums: number[]): number {
        let maximumSum = nums[0];
        let currentMaximum = maximumSum;
        for (let i = 1; i < nums.length; i++) {
            currentMaximum = Math.max(nums[i], currentMaximum + nums[i]);
            maximumSum = Math.max(maximumSum, currentMaximum);
        }
        return maximumSum;
    }
}
