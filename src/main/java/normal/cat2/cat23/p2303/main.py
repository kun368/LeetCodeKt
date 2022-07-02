from utils.python.predef import *


class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        ans = 0
        pre = 0
        for up, percent in brackets:
            ans += max(0, (min(income, up) - pre) * percent * 0.01)
            pre = up
        return ans


if __name__ == '__main__':
    print(Solution().calculateTax(brackets=[[3, 50], [7, 10], [12, 25]], income=10))
    print(Solution().calculateTax(brackets=[[1, 0], [4, 25], [5, 50]], income=2))
    print(Solution().calculateTax(brackets=[[2, 50]], income=0))
