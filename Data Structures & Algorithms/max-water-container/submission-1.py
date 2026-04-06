class Solution:
    def maxArea(self, heights: List[int]) -> int:
        left_ptr = 0
        right_ptr = len(heights) - 1
        max_area = 0
        while left_ptr < right_ptr:
            area = (right_ptr-left_ptr)*min(heights[left_ptr], heights[right_ptr])
            max_area = max(max_area, area)

            if heights[left_ptr] < heights[right_ptr]:
                left_ptr += 1
            else:
                right_ptr -= 1
        return max_area
