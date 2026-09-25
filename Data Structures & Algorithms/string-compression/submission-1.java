class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0;
        int arrayLength = chars.length;
        int currentIndex = 0;

        while (currentIndex < arrayLength) {
            int nextIndex = currentIndex + 1;
            while (nextIndex < arrayLength && chars[nextIndex] == chars[currentIndex]) {
                nextIndex++;
            }
            chars[writeIndex] = chars[currentIndex];
            writeIndex++;

            int repetitionCount = nextIndex - currentIndex;

            if (repetitionCount > 1) {
                int divisor = 1;
                while (divisor <= repetitionCount / 10) {
                    divisor *= 10;
                }

                while (divisor > 0) {
                    int digit = repetitionCount / divisor; // Peel off the front digit
                    chars[writeIndex++] = (char) ('0' + digit); // Convert int (0-9) to char ('0'-'9')
                    repetitionCount %= divisor; // Drop the front digit from count
                    divisor /= 10; // Move down one place value
                }

            }

            currentIndex = nextIndex;
        }

        return writeIndex;
    }
}