class Solution {
    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            var startIndex = map.get(complement);
            if (startIndex != null) {
                return new int[] {startIndex, i};
            }
            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
