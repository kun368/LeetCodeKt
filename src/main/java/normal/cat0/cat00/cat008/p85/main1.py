from typing import *

'''
85. 最大矩形
'''


class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        from collections import defaultdict
        from sortedcontainers import SortedList

        if not matrix:
            return 0

        N, M = len(matrix), len(matrix[0])
        hh = [[0 for j in range(M)] for i in range(N)]

        for j in range(M):
            for i in reversed(range(N)):
                if matrix[i][j] == '0':
                    hh[i][j] = 0
                elif i == N - 1:
                    hh[i][j] = 1
                else:
                    hh[i][j] = hh[i + 1][j] + 1

        ans = 0
        for i in range(N):
            mp = SortedList([-1, M])
            hg = defaultdict(list)
            for j, h in enumerate(hh[i]):
                hg[h].append(j)
            for h, js in sorted(hg.items()):
                for j in js:
                    pos = mp.bisect_left(j)
                    ans = max(ans, h * (mp[pos] - mp[pos - 1] - 1))
                for j in js:
                    mp.add(j)
        return ans


if __name__ == '__main__':
    print(Solution().maximalRectangle(
        [["1", "0", "1", "0", "0"],
         ["1", "0", "1", "1", "1"],
         ["1", "1", "1", "1", "1"],
         ["1", "0", "0", "1", "0"]]
    ))
    print(Solution().maximalRectangle([]))
    print(Solution().maximalRectangle([["0"]]))
    print(Solution().maximalRectangle([["1"]]))
    print(Solution().maximalRectangle([["0", "0"]]))
