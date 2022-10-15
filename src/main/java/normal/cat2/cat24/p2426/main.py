from utils.python.predef import *


class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], diff: int) -> int:
        from sortedcontainers import SortedList
        num = [a - b for a, b in zip(nums1, nums2)]
        sl = SortedList()
        ans = 0
        for i in num:
            ans += sl.bisect_right(i + diff)
            sl.add(i)
        return ans


if __name__ == '__main__':
    print(Solution().numberOfPairs(nums1=[3, 2, 5], nums2=[2, 2, 1], diff=1))
    print(Solution().numberOfPairs(nums1=[3, -1], nums2=[-2, 2], diff=-1))
