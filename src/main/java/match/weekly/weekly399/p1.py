from utils.python.predef import *


class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], k: int) -> int:
        ans = 0
        for i in nums1:
            for j in nums2:
                if i % (j * k) == 0:
                    ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().numberOfPairs(nums1=[1, 3, 4], nums2=[1, 3, 4], k=1))
    print(Solution().numberOfPairs(nums1=[1, 2, 4, 12], nums2=[2, 4], k=3))
