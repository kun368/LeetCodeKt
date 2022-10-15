from utils.python.predef import *


class Solution:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        ca, cb = 0, 0
        for i in nums1:
            ca ^= i
        for i in nums2:
            cb ^= i

        ans = 0
        l1 = len(nums1) & 1
        l2 = len(nums2) & 1
        for i in range(32):
            check_1 = 1 if ca & 1 and (l2 - cb & 1) & 1 else 0
            check_2 = 1 if cb & 1 and (l1 - ca & 1) & 1 else 0
            if check_1 + check_2 == 1:
                ans += 1 << i
            ca >>= 1
            cb >>= 1
        return ans


if __name__ == '__main__':
    print(Solution().xorAllNums(nums1=[2, 1, 3], nums2=[10, 2, 5, 0]))
    print(Solution().xorAllNums(nums1=[1, 2], nums2=[3, 4]))
