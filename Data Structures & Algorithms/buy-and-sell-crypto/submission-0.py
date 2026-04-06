class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        min_number = prices[0]
        max_profit = 0
        l = len(prices)

        for i in range(1,l):
            max_profit = max(max_profit, prices[i]-min_number)
            min_number = min(min_number, prices[i])
        
        return max_profit