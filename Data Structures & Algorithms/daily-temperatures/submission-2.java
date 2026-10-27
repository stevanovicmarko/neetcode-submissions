class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       
        var result = new int[temperatures.length];
        var stack = new ArrayDeque<Integer>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousDay = stack.pop();
                result[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        return result;
    }
}
