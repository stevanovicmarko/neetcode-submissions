class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskMap = new HashMap<>();
        for (char task : tasks) {
            taskMap.merge(task, 1, Integer::sum);
        }
        if (taskMap.size() > n) {
            return taskMap.values().stream()
                      .mapToInt(Integer::intValue)
                      .sum();
        }

        int mostFrequent = Collections.max(taskMap.values());
        int maxCount = Collections.frequency(taskMap.values(), mostFrequent);
        return ((mostFrequent-1) * (n+1)) + maxCount;
    }
}
