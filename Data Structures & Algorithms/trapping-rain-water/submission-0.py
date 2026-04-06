class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        total_water = 0
        for i in range(1,len(height)-1):
            # left_ptr = i - 1
            # right_ptr = i + 1
            # water_at_index_i = 0
            # while left_ptr >= 0 and right_ptr <= len(height) - 1:
            #     if height[left_ptr] > height[i] and height[right_ptr] > height[i]:
            #         water_at_index_i = min(height[left_ptr], height[right_ptr]) - height[i]
                
            #     else:
            #         if height[left_ptr] < height[i]:
            #         left_ptr -= 1
            #         if height[right_ptr] < height[i]:
            #         right_ptr += 1
            # total_water += water_at_index_i
            left_max = max(height[:i])
            right_max = max(height[i+1:]) 
            trapped_at_index_i = min(left_max, right_max) - height[i]
            if trapped_at_index_i > 0:
                total_water += trapped_at_index_i
        return total_water