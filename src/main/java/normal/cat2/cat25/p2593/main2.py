from utils.python.predef import *


class Solution:
    def findScore(self, nums: List[int]) -> int:
        ans = 0
        vis = [False] * (len(nums) + 3)
        for i, v in sorted(enumerate(nums), key=lambda x: x[1]):  # stable sort
            if not vis[i]:
                ans += v
                vis[i - 1] = vis[i + 1] = True
        return ans


if __name__ == '__main__':
    print(Solution().findScore(nums=[2, 1, 3, 4, 5, 2]))
    print(Solution().findScore(nums=[2, 3, 5, 1, 3, 2]))
