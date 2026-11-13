class Solution {
    public String decodeString(String s) {
        var numStack = new ArrayDeque<Integer>();
        var strStack = new ArrayDeque<StringBuilder>();
        var currentString = new StringBuilder();
        var digits = new StringBuilder();
        var charArray = s.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            digits.setLength(0);
            while (i < charArray.length && Character.isDigit(charArray[i])) {
                digits.append(charArray[i]);
                i++;
            }

            if (digits.length() > 0) {
                numStack.push(Integer.parseInt(digits.toString()));
                i--;
            } else if (charArray[i] == '[') {
         
                strStack.push(currentString);
                currentString = new StringBuilder();
            } else if (charArray[i] == ']') {

                int repeat = numStack.pop();
                StringBuilder decoded = strStack.pop();
                decoded.repeat(currentString, repeat);
                currentString = decoded;
            } else {
                currentString.append(charArray[i]);
            }
        }

        return currentString.toString();
    }
}