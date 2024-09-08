from utils.python.predef import *


class Solution:
    def maxPossibleScore(self, start: List[int], d: int) -> int:
        def can_achieve_min_diff(min_diff):
            prev = float('-inf')
            for s in start:
                current = max(prev + min_diff, s)
                if current > s + d:
                    return False
                prev = current
            return True

        start.sort()
        left, right = 0, max(start) + d - min(start)
        while left < right:
            mid = (left + right + 1) // 2
            if can_achieve_min_diff(mid):
                left = mid
            else:
                right = mid - 1
        return left


if __name__ == '__main__':
    print(Solution().maxPossibleScore(start=[6, 0, 3], d=2))
    print(Solution().maxPossibleScore(start=[2, 6, 13, 13], d=5))
