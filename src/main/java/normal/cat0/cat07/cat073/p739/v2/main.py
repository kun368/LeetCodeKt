from typing import *


class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        l = len(temperatures)
        stack = []
        ans = [0] * l
        for i in range(l):
            while stack and temperatures[i] > temperatures[stack[-1]]:
                back = stack.pop()
                ans[back] = i - back
            stack.append(i)
        return ans


if __name__ == '__main__':
    print(Solution().dailyTemperatures([73, 74, 75, 71, 69, 72, 76, 73]))
    print(Solution().dailyTemperatures([30, 40, 50, 60]))
    print(Solution().dailyTemperatures([30, 60, 90]))
