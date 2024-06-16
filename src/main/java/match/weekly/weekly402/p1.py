from utils.python.predef import *


class Solution:
    def countCompleteDayPairs(self, hours: List[int]) -> int:
        a = Counter()
        ans = 0
        for i in hours:
            i = i % 24
            if i == 12:
                ans += a.get(12, 0)
            elif i == 0:
                ans += a.get(0, 0)
            else:
                ans += a.get(24 - i, 0)
            a.update([i])
        return ans


if __name__ == '__main__':
    print(Solution().countCompleteDayPairs(hours=[12, 12, 30, 24, 24]))
    print(Solution().countCompleteDayPairs(hours=[72, 48, 24, 3]))
    print(Solution().countCompleteDayPairs(hours=[11, 11, 13])) # 2
