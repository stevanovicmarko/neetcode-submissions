class Solution {
    public int search(int[] nums, int target) {
        int result = -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int index = low + ((high - low) / 2);
            int currentValue = nums[index];

            if (currentValue == target) {
                return index;
            }
            if (target < currentValue) {
                high = index - 1;
            } else {
                low = index + 1;
            }
            
        }
        return result;
    }
}
