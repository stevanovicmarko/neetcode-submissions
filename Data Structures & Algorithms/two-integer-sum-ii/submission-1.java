class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        var result = new int[]{0, 0};
        while (true) {
            int lValue = numbers[left];
            int rValue = numbers[right];
            if (lValue + rValue == target) {
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
            if (lValue + rValue > target) {
                right--;
            } else {
                left++;
            }
            
        }


        return result;
    }
}
