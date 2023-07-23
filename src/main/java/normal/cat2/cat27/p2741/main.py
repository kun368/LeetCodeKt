from utils.python.predef import *


class Solution:
    def specialPerm(self, nums: List[int]) -> int:
        return self.dfs(1, tuple(sorted(nums)))

    @cache
    def dfs(self, pre: int, cur: Tuple[int]) -> int:
        if len(cur) == 0:
            return 1
        ans = 0
        for idx, i in enumerate(cur):
            if pre % i == 0 or i % pre == 0:
                son = tuple(cur[:idx] + cur[idx + 1:])
                ans = (ans + self.dfs(i, son)) % 1000000007
        return ans


if __name__ == '__main__':
    print(Solution().specialPerm(nums=[2, 3, 6]))
    print(Solution().specialPerm(nums=[1, 4, 3]))
