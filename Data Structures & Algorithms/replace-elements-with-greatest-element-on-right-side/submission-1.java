class Solution {
    public int[] replaceElements(int[] arr) {
 
        int n = arr.length; 
        
        // Initialize the maximum element seen so far from the right
        int maxFromRight = -1;
        
        // Traverse the array backwards (from right to left)
        for (int i = n - 1; i >= 0; i--) {
            
            // Store the current element temporarily before we overwrite it
            int temp = arr[i];
            
            // Replace the current element with the max seen so far
            arr[i] = maxFromRight;
            
            // Update maxFromRight if the original element was larger
            maxFromRight = Math.max(maxFromRight, temp);
        }
        
        return arr;
    }
}