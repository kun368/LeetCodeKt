from utils.python.predef import *


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        pos_map = dict()
        pre = [-1] * n
        for idx, v in enumerate(nums):
            pre[idx] = pos_map.get(v, -1)
            pos_map[v] = idx

        # k = -1
        dp = [(-(1 << 30), -(1 << 30)) for _ in range(n + 1)]
        dp[-1] = (0, 0)
        for kk in range(0, k + 1):
            ndp = [[0, 0] for _ in range(n + 1)]
            for idx in range(n):
                ndp[idx] = (
                    max(ndp[idx - 1][1], ndp[idx - 1][0]),  # not with it
                    max(ndp[pre[idx]][1] + 1, dp[idx - 1][1] + 1, dp[idx - 1][0] + 1)  # with
                )
            dp = ndp
        return max(dp[n - 1][0], dp[n - 1][1])


if __name__ == '__main__':
    print(Solution().maximumLength(nums=[1, 2, 1, 1, 3], k=2))
    print(Solution().maximumLength(nums=[1, 2, 3, 4, 5, 1], k=0))
