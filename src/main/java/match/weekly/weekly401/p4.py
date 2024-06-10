from utils.python.predef import *


class Solution:
    def maxTotalReward(self, rewardValues: List[int]) -> int:
        arr = sorted(list(set(rewardValues)))
        # prev x: [0, i)
        # next x: [i, 2 * i)
        # copy from pre to next using python int bits
        bit = 1
        for i in arr:
            prev = bit & ((1 << i) - 1)
            bit |= prev << i
        return bit.bit_length() - 1


if __name__ == '__main__':
    print(Solution().maxTotalReward(rewardValues=[1, 1, 3, 3]))
    print(Solution().maxTotalReward(rewardValues=[1, 6, 4, 3, 2]))
    print(Solution().maxTotalReward(rewardValues=[3, 10]))  # 13
    print(Solution().maxTotalReward(rewardValues=[4, 13, 16]))  # 29
    print(Solution().maxTotalReward(rewardValues=list(range(100))))
    print(Solution().maxTotalReward(rewardValues=list(range(2000))))
    print(Solution().maxTotalReward(rewardValues=list(range(50000))))
