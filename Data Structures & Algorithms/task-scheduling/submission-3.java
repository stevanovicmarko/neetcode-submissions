class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskMap = new HashMap<>();
        for (char task : tasks) {
            taskMap.merge(task, 1, Integer::sum);
        }

        int mostFrequent = Collections.max(taskMap.values());
        int maxCount = Collections.frequency(taskMap.values(), mostFrequent);
        return Math.max(tasks.length, ((mostFrequent - 1) * (n + 1)) + maxCount);
    }
}
