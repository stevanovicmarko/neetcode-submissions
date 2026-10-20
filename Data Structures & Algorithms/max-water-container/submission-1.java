class Solution {
    public int maxArea(int[] heights) {
        int result = 0;
        int left = 0;
        int right = heights.length - 1;

        while (left < right) {
            int leftPillarHeight = heights[left];
            int rightPillarHeight = heights[right];
            int height = Math.min(leftPillarHeight, rightPillarHeight);
            int width = right - left;

            int area = height * width;
            result = Math.max(result, area);
            if (leftPillarHeight < rightPillarHeight) {
                left++;
            } else {
                right--;
            }
        }

        return result;

    }
}
