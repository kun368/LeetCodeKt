from utils.python.predef import *


class Solution:
    def solve(self, red: int, blue: int) -> int:
        for i in range(1, 200):
            if i % 2 == 1:
                if blue < i:
                    return i - 1
                else:
                    blue -= i
            else:
                if red < i:
                    return i - 1
                else:
                    red -= i
        return -1

    def maxHeightOfTriangle(self, red: int, blue: int) -> int:
        return max(self.solve(red, blue), self.solve(blue, red))


if __name__ == '__main__':
    print(Solution().maxHeightOfTriangle(red=2, blue=4))
    print(Solution().maxHeightOfTriangle(red=2, blue=1))
    print(Solution().maxHeightOfTriangle(red=1, blue=1))
