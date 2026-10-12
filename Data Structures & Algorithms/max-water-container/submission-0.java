class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;

        int result = 0;
        while (left < right) {
            int dist = right - left;
            
            int a = heights[left];
            int b = heights[right];
            result = Math.max(result, Math.min(a, b) * dist);
            if (a < b) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
