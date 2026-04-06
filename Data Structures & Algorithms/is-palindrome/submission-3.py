class Solution:
    def isPalindrome(self, s: str) -> bool:

        if len(s) == 0 or len(s) == 1:
            return True
        
        sanitized_text = ''
        for char in s:
            if char.isalnum():
                sanitized_text += char.lower()
        
        left_ptr = 0
        right_ptr = len(sanitized_text) -1

        while left_ptr < right_ptr:
            if sanitized_text[left_ptr] != sanitized_text[right_ptr]:
                return False
            left_ptr += 1
            right_ptr -= 1
        return True
        

        