class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // build s1 frequency map
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int start = 0;

        for (int end = 0; end < s2.length(); end++) {
            char c = s2.charAt(end);
            window.put(c, window.getOrDefault(c, 0) + 1);

            // shrink window if size > s1.length()
            if (end - start + 1 > s1.length()) {
                char left = s2.charAt(start);
                if (window.get(left) == 1) {
                    window.remove(left);
                } else {
                    window.put(left, window.get(left) - 1);
                }
                start++;
            }

            // check match
            if (window.equals(s1Map)) return true;
        }

        return false;
    }
}