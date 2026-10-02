class Solution {
    public int compress(char[] chars) {
        int writeIndex = 0;
        int currentIndex = 0;
        int arrayLength = chars.length;

        while (currentIndex < arrayLength) {
            int nextIndex = currentIndex + 1;
            while (nextIndex < arrayLength && chars[currentIndex] == chars[nextIndex]) {
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
                    int digit = repetitionCount / divisor;
                    chars[writeIndex++] = (char) ('0' + digit);
                    repetitionCount %= divisor;
                    divisor /= 10;
                }
            }

            currentIndex = nextIndex;
        }
        return writeIndex;
    }
}