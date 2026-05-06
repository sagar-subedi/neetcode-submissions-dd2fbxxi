class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> priorityQueue = new PriorityQueue<>(
            (a, b) -> ((a.first * a.first) + (a.second * a.second))
                    - ((b.first * b.first) + (b.second * b.second))
        );

        int[][] result = new int[k][2];

        for (int[] point : points) {
            priorityQueue.offer(new Pair(point[0], point[1]));
        }

        for (int i = 0; i < k; i++) {
            Pair p = priorityQueue.poll();
            result[i][0] = p.first;
            result[i][1] = p.second;
        }

        return result;
    }

    public class Pair {
        int first;
        int second;

        public Pair(int a, int b) {
            this.first = a;
            this.second = b;
        }
    }
}