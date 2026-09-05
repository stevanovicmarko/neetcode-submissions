class Solution {
    /**
     * @param {string} s
     * @return {boolean}
     */
    validPalindrome(s: string): boolean {
            /**
     * Helper function to check if a substring is a palindrome
     * @param leftIndex - Starting index for comparison
     * @param rightIndex - Ending index for comparison
     * @returns true if the substring from leftIndex to rightIndex is a palindrome
     */
    const isPalindromeInRange = (leftIndex: number, rightIndex: number): boolean => {
        // Compare characters from both ends moving towards the center
        while (leftIndex < rightIndex) {
            if (s[leftIndex] !== s[rightIndex]) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    };
  
    // Initialize two pointers at the start and end of the string
    let leftPointer: number = 0;
    let rightPointer: number = s.length - 1;
  
    // Compare characters from both ends
    while (leftPointer < rightPointer) {
        if (s[leftPointer] !== s[rightPointer]) {
            // If mismatch found, try deleting either the left or right character
            // Check if remaining substring is a palindrome after deletion
            return isPalindromeInRange(leftPointer + 1, rightPointer) || 
                   isPalindromeInRange(leftPointer, rightPointer - 1);
        }
        leftPointer++;
        rightPointer--;
    }
  
    // If no mismatches found, the string is already a palindrome
    return true;
    }
}
