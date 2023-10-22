from utils.python.predef import *


class Solution:
    def maxSum(self, nums: List[int], k: int) -> int:
        mod = 1000000007
        counter = [0] * 40
        for i in nums:
            cur = 0
            while i > 0:
                if i % 2 == 1:
                    counter[cur] += 1
                i //= 2
                cur += 1

        ans = 0
        for i in range(k):
            cur = 0
            for v, c in enumerate(counter):
                if c > 0:
                    cur |= 1 << v
                    counter[v] -= 1
            ans += (cur * cur) % mod
        return ans % mod


if __name__ == '__main__':
    print(Solution().maxSum(nums=[2, 6, 5, 8], k=2))
    print(Solution().maxSum(nums=[4, 5, 4, 7], k=3))
