from utils.python.predef import *


class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        arr = sorted(list(set(rewardValues)))
        cur = set()
        for i in arr:
            cur = set(x + i for x in cur if x < i) | cur | set([i])
        return max(cur)


if __name__ == '__main__':
    print(Solution().maxTotalReward(rewardValues=[1, 1, 3, 3]))
    print(Solution().maxTotalReward(rewardValues=[1, 6, 4, 3, 2]))
    print(Solution().maxTotalReward(rewardValues=[3, 10]))  # 13
