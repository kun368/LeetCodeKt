from utils.python.predef import *


class Solution:
    def maximizeTheProfit(self, n: int, offers: List[List[int]]) -> int:
        offers.sort(key=lambda x: x[1])
        dp = []
        for st, ed, gd in offers:
            ins = bisect_left(range(len(dp)), True, key=lambda idx: offers[idx][1] >= st)
            if ins == 0:
                dp.append(gd if not dp else max(dp[-1], gd))
            else:
                dp.append(max(dp[-1], gd + dp[ins - 1]))
        return dp[-1]


if __name__ == '__main__':
    print(Solution().maximizeTheProfit(n=5, offers=[[0, 0, 1], [0, 2, 2], [1, 3, 2]]))
    print(Solution().maximizeTheProfit(n=5, offers=[[0, 0, 1], [0, 2, 10], [1, 3, 2]]))
    print(Solution().maximizeTheProfit(n=4, offers=[[0, 0, 6], [1, 2, 8], [0, 3, 7], [2, 2, 5], [0, 1, 5], [2, 3, 2],
                                                    [0, 2, 8], [2, 3, 10], [0, 3, 2]]))  # 16
