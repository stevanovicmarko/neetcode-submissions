class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int right = numbers.length - 1;
        int left = 0;
        var result = new int[]{0, 0};
        while (true) {
            int currentValue = numbers[left] +  numbers[right];
            if (currentValue == target) {
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
            if (currentValue > target) {
                right--;
            } else {
                left++;
            }
            
        }


        return result;
    }
}
