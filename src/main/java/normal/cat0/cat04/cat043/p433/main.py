from typing import *
from collections import deque


class Solution:
    def minMutation(self, start: str, end: str, bank: List[str]) -> int:
        vis = set()
        qu = deque()

        qu.append((start, 0))
        vis.add(start)
        while len(qu) > 0:
            top, cnt = qu.popleft()
            if top == end:
                return cnt
            for i in bank:
                if i in vis:
                    continue
                change = len([1 for a, b in zip(top, i) if a != b])
                if change == 1:
                    qu.append((i, cnt + 1))
                    vis.add(i)
        return -1


if __name__ == '__main__':
    print(Solution().minMutation(start="AACCGGTT", end="AACCGGTA", bank=["AACCGGTA"]))
    print(Solution().minMutation(start="AACCGGTT", end="AAACGGTA", bank=["AACCGGTA", "AACCGCTA", "AAACGGTA"]))
    print(Solution().minMutation(start="AAAAACCC", end="AACCCCCC", bank=["AAAACCCC", "AAACCCCC", "AACCCCCC"]))
