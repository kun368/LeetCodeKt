from collections import *
from typing import *


class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        counter = Counter(nums)
        items = []
        for val, cnt in counter.items():
            add = []
            cur = []
            for i in range(cnt + 1):
                add.append(tuple(cur))
                cur.append(val)
            items.append(add)

        res = []
        self.dfs(items, 0, tuple(), res)
        return res

    def dfs(self, items, idx, pre, res):
        if idx >= len(items):
            res.append(list(pre))
            return
        for i in items[idx]:
            self.dfs(items, idx + 1, pre + i, res)


if __name__ == '__main__':
    print(Solution().subsetsWithDup([1, 2, 2]))
    print(Solution().subsetsWithDup([0]))
