class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> a-b);

        for ( int num: nums ){

            queue.offer(num);

            if(queue.size() > k ){
                queue.poll();
            }
        }

        return queue.isEmpty() ? -1 : queue.peek();

    }
}
