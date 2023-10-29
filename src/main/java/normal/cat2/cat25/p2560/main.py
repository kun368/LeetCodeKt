from utils.python.predef import *


class Solution:
    def minCapability(self, nums: List[int], k: int) -> int:
        def check(c):
            pre, cur = 0, 0
            for i, v in enumerate(nums):
                if i < 2:
                    pre, cur = cur, 1 if min(nums[:i + 1]) <= c else 0
                elif v > c:
                    pre, cur = cur, cur
                else:
                    pre, cur = cur, max(cur, pre + 1)
                if cur >= k: return True
            return False

        n2 = sorted(nums)
        return n2[bisect_left(n2, 1, key=check)]


if __name__ == '__main__':
    print(Solution().minCapability(nums=[2, 3, 5, 9], k=2))
    print(Solution().minCapability(nums=[2, 7, 9, 3, 1], k=2))
