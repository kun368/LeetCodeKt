from utils.python.predef import *


class Solution:
    def constructArray(self, n: int, k: int) -> List[int]:
        l, r = 1, n
        ans = []
        for i in range(k):
            if abs(l) <= abs(n - r + 1):
                ans.append(l)
                l += 1
            else:
                ans.append(r)
                r -= 1

        if ans[-1] == l - 1:
            while len(ans) < n:
                ans.append(l)
                l += 1
        else:
            while len(ans) < n:
                ans.append(r)
                r -= 1
        return ans


if __name__ == '__main__':
    print(Solution().constructArray(3, 1))
    print(Solution().constructArray(3, 2))
    print(Solution().constructArray(10, 1))
    print(Solution().constructArray(10, 2))
    print(Solution().constructArray(10, 3))
    print(Solution().constructArray(10, 9))
