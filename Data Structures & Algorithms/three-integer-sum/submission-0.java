class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
                List<List<Integer>> res = new ArrayList<>();
        
        // Step 1: Sort the array to handle duplicates easily and use two pointers
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Optimization: If the current number is > 0, the sum can never be 0 
            // because all numbers to its right are also positive.
            if (nums[i] > 0) {
                break;
            }
            
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Step 2: Initialize two pointers
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    // Valid triplet found
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move both pointers inward
                    left++;
                    right--;
                    
                    // Skip duplicate values for the second element
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    // Skip duplicate values for the third element
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++; // Sum is too small; move left pointer to a larger value
                } else {
                    right--; // Sum is too large; move right pointer to a smaller value
                }
            }
        }
        
        return res;
    }
}
