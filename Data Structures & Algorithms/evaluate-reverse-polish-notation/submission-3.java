class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (String token: tokens){

            if(operators.contains(token)){
                int operand1 = stack.pop();
                int operand2 = stack.pop();

                if("+".equals(token)){
                    stack.push(operand2+operand1);
                }else if("-".equals(token)){
                     stack.push(operand2-operand1);
                }else if("*".equals(token)){
                     stack.push(operand2*operand1);
                }else if("/".equals(token)){
                    // if(operand2 == 0 ) stack.push(0); else{
                     stack.push(operand2/operand1);
                    // }
                }

            }else {
                stack.push(Integer.parseInt(token));
            }

        }
        return stack.pop();
    }
}
