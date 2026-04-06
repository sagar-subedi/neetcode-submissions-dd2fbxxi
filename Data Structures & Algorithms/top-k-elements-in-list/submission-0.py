class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        dictionary = {}

        for num in nums:
            if num not in dictionary:
                dictionary.update({num:1})
            else:
                dictionary[num]+=1
        sorted_items = sorted(dictionary.items(), key=lambda item : item[1],reverse=True)
        result = []
        # print(sorted_items)
        for item in sorted_items[:k]:
            result.append(item[0])

        return result