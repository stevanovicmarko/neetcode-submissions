class Solution {
    private int cursor = 0;
    public String decodeString(String s) {
        var result = new StringBuilder();
        int k = 0;
        while (cursor < s.length()) {
            char ch = s.charAt(cursor);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
                cursor++;
            } else if (ch == '[') {
                cursor++;
                var decodedInner = decodeString(s);
                result.repeat(decodedInner, k);
                k = 0;
            } else if (ch == ']') {
                cursor++;
                return result.toString();
            } else {
                result.append(ch);
                cursor++;
            }
        }

        return result.toString();
    }
}