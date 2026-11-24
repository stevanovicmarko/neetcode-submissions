class Solution {
    private int cursor = 0;
    public String decodeString(String s) {
        var result = new StringBuilder();
        int k = 0;
        while (cursor < s.length()) {
            char c = s.charAt(cursor);

            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
                cursor++;
            } else if (c == '[') {
                cursor++;
                var decodedInner = decodeString(s);
                result.repeat(decodedInner, k);
                k = 0;
            } else if (c == ']') {
                cursor++;
                return result.toString();
            } else {
                result.append(c);
                cursor++;
            }
        }

        return result.toString();
    }
}