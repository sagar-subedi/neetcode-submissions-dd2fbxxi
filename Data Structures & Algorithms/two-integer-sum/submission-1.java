class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();
        int[] retArr = {0,0};

        for(int i = 0; i < nums.length; i++){
            int diff = target - nums[i];
            if(prevMap.containsKey(diff)){
                retArr[0] = prevMap.get(diff);
                retArr[1] = i;
            }
            else{
                prevMap.put(nums[i], i);
            }
        }
         return retArr;
    }
}
