class Solution:

    def encode(self, strs: List[str]) -> str:
        result = ''
        for string in strs:
            result += (str(len(string)) + '#' + string)
        print(result)
        return result

    def decode(self, s: str) -> List[str]:
        result = []
        pointer = 0
        length_of_current_str = ''
        while(pointer < len(s)):
            if s[pointer] != '#':
                length_of_current_str += s[pointer]
                pointer +=1
            elif s[pointer]=='#':
                length_of_current_word = int(length_of_current_str)
                current_word = s[pointer+1:pointer+length_of_current_word+1]
                result.append(current_word)
                length_of_current_str = ''
                pointer += length_of_current_word + 1
        return result
            
            
        
