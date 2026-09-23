class Solution {
    public boolean hasDuplicate(int[] nums) {
        var seenSoFar = new HashSet<Integer>();

        for (var num: nums) {
            if (!seenSoFar.add(num)) {
                return true;
            }
        }

        return false;
    }
}