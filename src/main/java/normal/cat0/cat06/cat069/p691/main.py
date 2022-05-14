from typing import *
from collections import deque


class Solution:
    def minStickers(self, stickers: List[str], target: str) -> int:
        target_set = set(target)
        if target_set - set(''.join(stickers)):
            return -1

        target_expr = tuple(target.count(i) for i in target_set)
        sticker_exprs = []
        for s in stickers:
            sticker_exprs.append(tuple(s.count(i) for i in target_set))

        qu = deque([(target_expr, 0)])
        visited = set()
        while qu:
            top, step = qu.popleft()
            for i in sticker_exprs:
                sub = tuple(max(0, a - b) for a, b in zip(top, i))
                if sum(sub) == 0:
                    return step + 1
                if sub == top or sub in visited:
                    continue
                visited.add(sub)
                qu.append((sub, step + 1))
        return -1



if __name__ == '__main__':
    print(Solution().minStickers(stickers=["with", "example", "science"], target="thehat"))
    print(Solution().minStickers(stickers=["notice", "possible"], target="basicbasic"))
