from utils.python.predef import *


class Solution:
    def clearStars(self, s: str) -> str:
        hp = []
        mark = set()
        for idx, c in enumerate(s):
            if c == '*':
                mark.add(idx)
                a, b = heappop(hp)
                mark.add(-b)
            else:
                heappush(hp, (c, -idx))
        return ''.join([v for i, v in enumerate(s) if i not in mark])


if __name__ == '__main__':
    print(Solution().clearStars(s="aaba*"))
    print(Solution().clearStars(s="abc"))
