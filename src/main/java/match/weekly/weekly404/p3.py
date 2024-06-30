from utils.python.predef import *


class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        ls = defaultdict(list)
        for idx, v in enumerate(nums):
            ls[v % k].append(idx)

        @cache
        def dfs(idx, target):
            find = (k + target - nums[idx] % k) % k
            nx = bisect_left(ls[find], idx + 1)
            if nx >= len(ls[find]):
                return 1
            else:
                return dfs(ls[find][nx], target) + 1

        ans = 0
        for i in range(len(nums)):
            for t in range(k):
                ans = max(ans, dfs(i, t))
        return ans


if __name__ == '__main__':
    print(Solution().maximumLength(nums=[1, 2, 3, 4, 5], k=2))
    print(Solution().maximumLength(nums=[1, 4, 2, 3, 1, 4], k=3))
