class KthLargest {

    PriorityQueue<Integer> queue;
    int size;

    public KthLargest(int k, int[] nums) {
        queue = new PriorityQueue<>();
        size = k;

        for (int num:nums){
            queue.offer(num);
            if(queue.size() > k ){
                queue.poll();
            }
        }
    }
    
    public int add(int val) {
        queue.offer(val);
        if(queue.size()> size) {
            queue.poll();
        }
        return queue.peek();
    }
}

