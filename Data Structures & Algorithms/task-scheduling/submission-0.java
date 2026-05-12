
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        
        // Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        
        // Find maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            maxCount = Math.max(maxCount, f);
        }
        
        // Count how many tasks have max frequency
        int numMax = 0;
        for (int f : freq) {
            if (f == maxCount) {
                numMax++;
            }
        }
        
        // Apply formula
        return Math.max(tasks.length, (maxCount - 1) * (n + 1) + numMax);
    }
}