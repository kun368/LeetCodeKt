from utils.python.predef import *


class Solution:
    def countWays(self, ranges: List[List[int]]) -> int:
        ranges.sort()
        cnt = 1
        r = ranges[0][1]
        for x, y in ranges:
            if x > r:
                cnt += 1
                r = y
            else:
                r = max(r, y)
        return (1 << cnt) % int(1e9 + 7)


if __name__ == '__main__':
    print(Solution().countWays(ranges=[[6, 10], [5, 15]]))
    print(Solution().countWays(ranges=[[1, 3], [10, 20], [2, 5], [4, 8]]))
