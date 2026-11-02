class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        var result = new int[temperatures.length];
        var stack = new ArrayDeque<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            
            stack.push(i);
        }

        return result;
    }
}
