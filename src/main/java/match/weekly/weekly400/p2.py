from utils.python.predef import *


class Solution:
    def countDays(self, days: int, meetings: List[List[int]]) -> int:
        cur = 0
        ans = 0
        meetings.sort()
        for st, ed in meetings:
            if st > cur:
                ans += st - cur - 1
            cur = max(cur, ed)
        ans += max(0, days - cur)
        return ans


if __name__ == '__main__':
    print(Solution().countDays(days=10, meetings=[[5, 7], [1, 3], [9, 10]]))
    print(Solution().countDays(days=5, meetings=[[2, 4], [1, 3]]))
    print(Solution().countDays(days=6, meetings=[[1, 6]]))
    print(Solution().countDays(days=8, meetings=[[3, 4], [4, 8], [2, 5], [3, 8]]))  # 1
