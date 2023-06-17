from utils.python.predef import *


class Solution:
    def sumDistance(self, nums: List[int], s: str, d: int) -> int:
        pos = []
        for a, b in zip(nums, s):
            pos.append(a + d if b == 'R' else a - d)
        pos.sort()

        mod = 1000000007
        pre = pos[0]
        ans = 0
        for i in range(1, len(pos)):
            ans = (ans + (i * pos[i]) - pre) % mod
            pre += pos[i]
        return ans


if __name__ == '__main__':
    print(Solution().sumDistance(nums=[-2, 0, 2], s="RLL", d=3))
    print(Solution().sumDistance(nums=[1, 0], s="RL", d=2))
