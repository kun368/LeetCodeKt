from utils.python.predef import *


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        n = len(nums)
        pos_map = dict()
        pre = [-1] * n
        for idx, v in enumerate(nums):
            pre[idx] = pos_map.get(v, -1)
            pos_map[v] = idx

        @cache
        def dfs(idx, k, with_last):
            if idx == -1:
                return 0
            if k == -1:
                return -inf
            ans = 0
            if not with_last:
                ans = max(ans, dfs(idx - 1, k, True))
                ans = max(ans, dfs(idx - 1, k, False))
            else:
                ans = max(ans, dfs(pre[idx], k, True) + 1)
                ans = max(ans, dfs(idx - 1, k - 1, True) + 1)
                ans = max(ans, dfs(idx - 1, k - 1, False) + 1)
            return ans

        return max(dfs(n - 1, k, False), dfs(n - 1, k, True))


if __name__ == '__main__':
    print(Solution().maximumLength(nums=[1, 2, 1, 1, 3], k=2))
    print(Solution().maximumLength(nums=[1, 2, 3, 4, 5, 1], k=0))
