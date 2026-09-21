class Solution {
    public int[] productExceptSelf(int[] nums) {
        var result = new int[nums.length];
        result[0] = nums[0];
        for(int i = 1; i < result.length; i++) {
            result[i] = nums[i]*result[i-1];
        }
        int currentSufix = 1;
        for (int i = nums.length - 1; i > 0 ; i--) {
            result[i] = i == nums.length - 1 ? result[i-1] : result[i-1] * currentSufix;
            currentSufix = currentSufix * nums[i];
        }
        result[0] = currentSufix;


        return result;
    }
}  
