class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       
        var result = new int[temperatures.length];
        var stack = new ArrayDeque<Integer>();

        for (int i = 0; i < temperatures.length; i++) {

            // Resolve previous days colder than today.
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();
                result[previousDay] = i - previousDay;
            }

            // Today still needs a warmer future day.
            stack.push(i);
        }

        return result;
    }
}
