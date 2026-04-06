class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('{', '}');
        charMap.put('(', ')');
        charMap.put('[', ']');

        Set<Character> openBrackets = charMap.keySet();

        for( int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(openBrackets.contains(c)){
                stack.push (c);
            }else {
                if (stack.isEmpty()) return false;
                char lastOpen = stack.pop();
                if(charMap.get(lastOpen) != c) return false;
            }
        }
        return stack.isEmpty();
    }
}
