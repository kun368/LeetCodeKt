from utils.python.predef import *


class Solution:
    def minLength(self, s: str, numOps: int) -> int:
        s = [int(i) for i in s]

        def check(cl):
            if cl == 1:
                return min(
                    sum(idx % 2 == v % 2 for idx, v in enumerate(s)),
                    sum(idx % 2 != v % 2 for idx, v in enumerate(s))
                ) <= numOps
            else:
                return sum(len(list(lst)) // (cl + 1) for _, lst in groupby(s)) <= numOps

        return bisect_left(range(1, len(s) + 1), 1, key=check) + 1


if __name__ == '__main__':
    print(Solution().minLength(s="000001", numOps=1))  # 2
    print(Solution().minLength(s="0000", numOps=2))  # 1
    print(Solution().minLength(s="0101", numOps=0))  # 1
    print(Solution().minLength(s="1101", numOps=1))  # 1
    print(Solution().minLength(s="00100", numOps=2))  # 1
    print(Solution().minLength(s="110001", numOps=1))  # 2
