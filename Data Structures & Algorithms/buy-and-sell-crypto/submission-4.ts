class Solution {
    /**
     * @param {number[]} prices
     * @return {number}
     */
    maxProfit(prices: number[]): number {
        let currentMin = prices[0];
        let result = 0;

        for (let i = 0; i < prices.length; i++) {
            currentMin = Math.min(currentMin, prices[i]);
            result = Math.max(result, prices[i] - currentMin);
        }

        return result;
    }
}
