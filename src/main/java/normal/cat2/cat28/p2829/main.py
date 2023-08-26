from utils.python.predef import *


class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        ls = set()
        cur = 1
        while len(ls) < n:
            if k - cur not in ls:
                ls.add(cur)
            cur += 1
        return sum(ls)


if __name__ == '__main__':
    print(Solution().minimumSum(n=5, k=4))
    print(Solution().minimumSum(n=2, k=6))
    print(Solution().minimumSum(n=1, k=6))
