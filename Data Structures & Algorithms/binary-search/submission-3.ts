class Solution {
    /**
     * @param {number[]} nums
     * @param {number} target
     * @return {number}
     */
    search(nums: number[], target: number): number {

        let loIdx = 0;
        let highIdx = nums.length - 1;

        while (loIdx <= highIdx) {
            let midIdx = Math.floor((highIdx + loIdx)/2);
            let currentNumber = nums[midIdx];

            if (currentNumber === target) {
                return midIdx;
            }
            if (currentNumber > target) {
                highIdx = midIdx - 1;
            } else {
                loIdx = midIdx + 1;
            }
        }


        return -1;
    }
}
