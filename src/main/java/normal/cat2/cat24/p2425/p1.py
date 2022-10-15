from utils.python.predef import *


def calc_counter(nums: List[int]):
    c = [0] * 32
    for i in nums:
        b = 0
        while i > 0:
            if i & 1 == 1:
                c[b] += 1
            b += 1
            i >>= 1
    return c


class Solution:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        ca = calc_counter(nums1)
        cb = calc_counter(nums2)
        print(ca)
        print(cb)
        ans = 0
        for i in range(32):
            a, b = ca[i], cb[i]
            cur = (a * (len(nums2) - b)) + (b * (len(nums1) - a))
            if cur % 2 == 1:
                ans += 1 << i
        return ans


if __name__ == '__main__':
    # print(Solution().xorAllNums(nums1=[2, 1, 3], nums2=[10, 2, 5, 0]))
    print(Solution().xorAllNums(nums1=[1, 2], nums2=[3, 4]))
