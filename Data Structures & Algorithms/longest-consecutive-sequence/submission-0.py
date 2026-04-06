class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        nums_set = set(nums)
        longest_sequence = 1
  
        for num in nums:
            if num-1 not in nums_set:
                current_sequence = 1
                while num+current_sequence in nums_set:
                    current_sequence +=1
                longest_sequence = max(longest_sequence,current_sequence)
        return longest_sequence

        