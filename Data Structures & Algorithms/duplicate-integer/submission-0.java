class Solution {
    public boolean hasDuplicate(int[] nums) {
        var duplicateSet = new HashSet<Integer>();

        for (var num: nums) {
            if (duplicateSet.contains(num)) {
                return true;
            }
            duplicateSet.add(num);
        }

        return false;
    }
}