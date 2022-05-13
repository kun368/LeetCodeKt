from typing import *

'''
85. 最大矩形
'''


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

    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        if not matrix:
            return 0

        N, M = len(matrix), len(matrix[0])
        hh = [[0 for j in range(M)] for i in range(N)]
        for j in range(M):
            for i in reversed(range(N)):
                if matrix[i][j] == '0':
                    hh[i][j] = 0
                elif i == N - 1:
                    hh[i][j] = 1
                else:
                    hh[i][j] = hh[i + 1][j] + 1

        ans = 0
        for i in range(N):
            ans = max(ans, self.largestRectangleArea(hh[i]))
        return ans


if __name__ == '__main__':
    print(Solution().maximalRectangle(
        [["1", "0", "1", "0", "0"],
         ["1", "0", "1", "1", "1"],
         ["1", "1", "1", "1", "1"],
         ["1", "0", "0", "1", "0"]]
    ))
    print(Solution().maximalRectangle([]))
    print(Solution().maximalRectangle([["0"]]))
    print(Solution().maximalRectangle([["1"]]))
    print(Solution().maximalRectangle([["0", "0"]]))
