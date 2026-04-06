class Solution {
    public int characterReplacement(String s, int k) {
        

        int start = 0;
        int longestSequence = 0;
        int highestFrequencyOfCharacterInCurrentWindow = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for( int end = 0; end < s.length(); end++){
            char c = s.charAt(end);

            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c,0)+1);


            highestFrequencyOfCharacterInCurrentWindow = Math.max(highestFrequencyOfCharacterInCurrentWindow, charFrequencyMap.get(c));


            if(end - start + 1 - highestFrequencyOfCharacterInCurrentWindow > k){
                charFrequencyMap.put(s.charAt(start), charFrequencyMap.get(s.charAt(start))-1);
                start++;
            }

            longestSequence = Math.max(longestSequence, end-start+1);


        }

        return longestSequence;
    }
}
