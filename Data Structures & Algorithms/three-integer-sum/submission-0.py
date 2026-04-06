class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        result = set()
        sorted_nums = sorted(nums)
        for index, item in enumerate(sorted_nums):
            left_ptr = 0
            right_ptr = len(sorted_nums) - 1
            while(left_ptr < right_ptr):
                total = item + sorted_nums[left_ptr] + sorted_nums[right_ptr]
                if index != left_ptr and index != right_ptr:
                    if total == 0:
                        result.add(tuple(sorted((item, sorted_nums[left_ptr], sorted_nums[right_ptr]))))
                        left_ptr += 1
                    elif total < 0:
                        left_ptr += 1
                    elif total > 0:
                        right_ptr -= 1
                elif index == left_ptr:
                    left_ptr += 1
                elif index == right_ptr:
                    right_ptr -= 1
        #convert tuples back to list
        result_list = [list(items) for items in result]

        return result_list
