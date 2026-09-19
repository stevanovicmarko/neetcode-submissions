class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int minSoFar = prices[0];

        for (int i = 1; i < prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            result = Math.max(result, prices[i] - minSoFar);
        }

        return result;
    }
}
