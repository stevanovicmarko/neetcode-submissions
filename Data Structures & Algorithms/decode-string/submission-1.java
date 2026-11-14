class Solution {
    private int index;

    public String decodeString(String s) {
        StringBuilder currentString = new StringBuilder();
        int k = 0;

        while (index < s.length()) {
            char c = s.charAt(index);

            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
                index++;
            } else if (c == '[') {
                index++; // Step past '['
                String decodedInner = decodeString(s);
                for (int i = 0; i < k; i++) {
                    currentString.append(decodedInner);
                }
                k = 0;
            } else if (c == ']') {
                index++; // Step past ']'
                return currentString.toString();
            } else {
                currentString.append(c);
                index++;
            }
        }

        return currentString.toString();
    }
}