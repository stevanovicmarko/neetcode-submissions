class Solution {
    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();
        for (var ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.addFirst(ch);
            } else {
                var popped = stack.pollFirst();
                if (popped == null) {
                    return false;
                }
                // popped is ( or { or [
                System.out.println(popped + " " + ch);
                if (popped == '(' && ch != ')' ||
                    popped == '{' && ch != '}' ||
                    popped == '[' && ch != ']' 
                ) {
                    return false;
                }
            }
        }
        if (stack.size() != 0) {
            return false;
        }

        return true;
    }
}
