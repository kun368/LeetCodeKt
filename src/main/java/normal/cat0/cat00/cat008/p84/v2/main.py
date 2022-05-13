from typing import *


class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        if min(heights) == max(heights):
            return len(heights) * heights[0]
        stack = []
        ans = 0
        heights.append(0)
        for i in range(len(heights)):
            while stack and heights[i] < heights[stack[-1]]:
                hi = stack.pop()
                ans = max(ans, heights[hi] * (i - (stack[-1] if stack else -1) - 1))
            stack.append(i)
        return ans


if __name__ == '__main__':
    print(Solution().largestRectangleArea(heights=[2, 1, 5, 6, 2, 3]))
    print(Solution().largestRectangleArea(heights=[2, 4]))
