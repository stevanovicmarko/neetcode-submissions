class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {
            int candidate = numbers[l] + numbers[r];
            if (candidate == target) {
                return new int[]{l+1, r+1};
            }
            if (candidate < target) {
                l++;
                continue;
            }
            if (candidate > target) {
                r--;
                continue;
            }
        }
        return new int[]{0, 0};
    }
}
