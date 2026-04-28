class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int minSpeed = high;

        while (low <= high){
            int mid = low + (high-low)/2;
            int hours = 0;

            for( int pile : piles){
                hours += (int) Math.ceil( (double) pile/mid  );
            }

            if ( hours > h ) low = mid + 1;
            else if ( hours <= h) {
                minSpeed = mid;
                high = mid - 1;
            }
        }

        return minSpeed;
    }
}
