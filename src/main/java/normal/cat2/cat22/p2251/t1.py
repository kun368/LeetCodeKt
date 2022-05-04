import itertools
from collections import *
from typing import *


class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], persons: List[int]) -> List[int]:
        all_dig = sorted(list(set(itertools.chain.from_iterable(flowers)) | set(persons)))
        val2id = {val: id for id, val in enumerate(all_dig)}

        flowers_st, flowers_ed = defaultdict(int), defaultdict(int)
        for a, b in flowers:
            flowers_st[val2id[a]] += 1
            flowers_ed[val2id[b]] += 1

        persons_idx = defaultdict(set)
        for i, v in enumerate(persons):
            persons_idx[val2id[v]].add(i)

        ans = [0] * len(persons)
        cur = 0
        for i in range(len(all_dig)):
            cur += flowers_st.get(i, 0)
            for t in persons_idx.get(i, []):
                ans[t] = cur
            cur -= flowers_ed.get(i, 0)
        return ans

if __name__ == '__main__':
    print(Solution().fullBloomFlowers(
        flowers=[[1, 6], [3, 7], [9, 12], [4, 13]], persons=[2, 3, 7, 11]
    ))
    print(Solution().fullBloomFlowers(
        flowers=[[1, 10], [3, 3]], persons=[3, 3, 2]
    ))

    # [0,0,3,0,0,2,0,2,0,0]
    print(Solution().fullBloomFlowers(
        flowers=[[19, 37], [19, 38], [19, 35]], persons=[6, 7, 21, 1, 13, 37, 5, 37, 46, 43]
    ))
