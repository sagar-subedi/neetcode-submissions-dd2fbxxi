class Solution {


    
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        Arrays.fill(result, 0);

        for(int i = 0; i < temperatures.length; i ++){
            while( !stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int topIndex = stack.pop();
                result[topIndex]= i - topIndex;
            }
            stack.push(i);
        }
        return result;
        
    }
}
