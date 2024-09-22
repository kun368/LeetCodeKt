from utils.python.predef import *


class Solution:
    def minNumberOfSeconds(self, mountainHeight: int, workerTimes: List[int]) -> int:
        def can_reduce_in_time(T):
            total_height = 0
            for time in workerTimes:
                l, r = 0, mountainHeight
                while l < r:
                    mid = (l + r + 1) // 2
                    if time * mid * (mid + 1) // 2 <= T:
                        l = mid
                    else:
                        r = mid - 1
                total_height += l
                if total_height >= mountainHeight:
                    return True
            return total_height >= mountainHeight

        left, right = 0, 10 ** 18
        while left < right:
            mid = (left + right) // 2
            if can_reduce_in_time(mid):
                right = mid
            else:
                left = mid + 1
        return left


if __name__ == '__main__':
    print(Solution().minNumberOfSeconds(mountainHeight=4, workerTimes=[2, 1, 1]))
    print(Solution().minNumberOfSeconds(mountainHeight=10, workerTimes=[3, 2, 2, 4]))
    print(Solution().minNumberOfSeconds(mountainHeight=5, workerTimes=[1]))
