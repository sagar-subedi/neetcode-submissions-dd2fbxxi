from collections import Counter
class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dictionary = {}

        for item in strs:
            sorted_item = ''.join(sorted(item))
            if sorted_item in dictionary:
                dictionary.get(sorted_item).append(item)
            else:
                dictionary.update({sorted_item:[item]})
        return list(dictionary.values())
            