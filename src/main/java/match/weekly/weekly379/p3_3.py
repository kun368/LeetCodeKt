from utils.python.predef import *


class Solution:
    def maximumSetSize(self, nums1: List[int], nums2: List[int]) -> int:
        ans = 0
        n = len(nums1) // 2
        s1, s2 = set(nums1), set(nums2)

        ans += min(n, len(s1 - s2))
        ans += min(n, len(s2 - s1))

        r1 = max(0, n - len(s1 - s2))
        r2 = max(0, n - len(s2 - s1))
        inter = s1 & s2
        ans += min(len(inter), r1 + r2)
        return ans


if __name__ == '__main__':
    print(Solution().maximumSetSize(nums1=[1, 2, 1, 2], nums2=[1, 1, 1, 1]))
    print(Solution().maximumSetSize(nums1=[1, 2, 3, 4, 5, 6], nums2=[2, 3, 2, 3, 2, 3]))
    print(Solution().maximumSetSize(nums1=[1, 1, 2, 2, 3, 3], nums2=[4, 4, 5, 5, 6, 6]))
