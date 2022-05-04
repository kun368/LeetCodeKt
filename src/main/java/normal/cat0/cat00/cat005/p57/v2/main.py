from typing import *
from bisect import *


class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        insort_left(intervals, newInterval)

        ans = []
        for a, b in intervals:
            if len(ans) > 0 and a <= ans[-1][1]:
                ans[-1][1] = max(b, ans[-1][1])
            else:
                ans.append([a, b])
        return ans


if __name__ == '__main__':
    print(Solution().insert(
        intervals=[[1, 3], [6, 9]], newInterval=[2, 5]
    ))
    print(Solution().insert(
        intervals=[[1, 2], [3, 5], [6, 7], [8, 10], [12, 16]], newInterval=[4, 8]
    ))
    print(Solution().insert(
        intervals=[], newInterval=[5, 7]
    ))
    print(Solution().insert(
        intervals=[[1, 5]], newInterval=[2, 3]
    ))
    print(Solution().insert(
        intervals=[[1, 5]], newInterval=[2, 7]
    ))
