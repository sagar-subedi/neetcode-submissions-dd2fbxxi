class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();

        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // Max heap for available tasks
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.addAll(freq.values());

        // Queue for cooling tasks
        Queue<int[]> cooldown = new LinkedList<>();
        // each element: [availableTime, remainingCount]

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            // Release cooled-down tasks
            if (!cooldown.isEmpty() && cooldown.peek()[0] == time) {
                maxHeap.offer(cooldown.poll()[1]);
            }

            // Execute task if possible
            if (!maxHeap.isEmpty()) {
                int count = maxHeap.poll();
                count--;

                if (count > 0) {
                    cooldown.offer(new int[]{time + n + 1, count});
                }
            }
        }

        return time;
    }
}