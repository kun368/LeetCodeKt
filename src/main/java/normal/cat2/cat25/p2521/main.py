from utils.python.predef import *


class Solution:
    def distinctPrimeFactors(self, nums: List[int]) -> int:
        sz = 10240
        isp = [True] * sz
        isp[0] = isp[1] = False
        for i in range(2, int(sqrt(sz)) + 1):
            if not isp[i]: continue
            for j in range(i * i, sz, i):
                isp[j] = False
        pri = [a for a, b in enumerate(isp) if b]

        ans = set()
        for i in nums:
            for j in pri:
                while i % j == 0:
                    i //= j
                    ans.add(j)
                if i == 1:
                    break
        return len(ans)


if __name__ == '__main__':
    print(Solution().distinctPrimeFactors(nums=[2, 4, 3, 7, 10, 6]))
    print(Solution().distinctPrimeFactors(nums=[2, 4, 8, 16]))
