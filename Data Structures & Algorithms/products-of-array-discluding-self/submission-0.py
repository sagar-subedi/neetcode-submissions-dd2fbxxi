class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #find prefix
        prefix_arr = [1]*len(nums)
        suffix_arr = [1]*len(nums)
        prefix = 1
        suffix = 1
        result = []
        
        for n in range(len(nums)):
            prefix_arr[n] = prefix
            prefix *= nums[n]

        for n in range(len(nums)-1,-1,-1):
            suffix_arr[n] = suffix
            suffix *= nums[n]

        for n in range(len(nums)):
            result.append(prefix_arr[n]*suffix_arr[n])
        
        return result

        #find postfix