class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitSoFar = 0;

        int minPrice = prices[0];

        for (int currentPrice : prices) {
            maxProfitSoFar = Math.max(maxProfitSoFar, currentPrice - minPrice);
            minPrice = Math.min(minPrice, currentPrice);
        }

        return maxProfitSoFar;
    }
}
