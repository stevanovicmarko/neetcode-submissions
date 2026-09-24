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
                String countString = String.valueOf(repetitionCount);
                for (char digit : countString.toCharArray()) {
                    chars[writeIndex] = digit;
                    writeIndex++;
                }
            }
          
            currentIndex = nextIndex;
        }
      
        return writeIndex;
    }
}