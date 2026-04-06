class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest_seq = 0
        start  = 0
        charset = set()

        for end in range(len(s)):
            while s[end] in charset:
                charset.remove(s[start])
                start += 1
            charset.add(s[end])
            longest_seq = max(longest_seq, end - start + 1)

        return longest_seq