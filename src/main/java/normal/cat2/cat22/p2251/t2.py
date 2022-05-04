from collections import *
from typing import *


class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], persons: List[int]) -> List[int]:

        cnt = Counter()
        for a, b in flowers:
            cnt[a] += 1
            cnt[b + 1] -= 1

        p_map = defaultdict(list)
        for idx, i in enumerate(persons):
            cnt.setdefault(i, 0)
            p_map[i].append(idx)

        s = 0
        for i, v in sorted(cnt.items()):
            s += v
            for t in p_map.get(i, []):
                persons[t] = s
        return persons


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

    # [1,2,2,2]
    print(Solution().fullBloomFlowers(
        flowers=[[1, 6], [3, 7], [9, 12], [4, 13]], persons=[2, 3, 7, 11]
    ))
