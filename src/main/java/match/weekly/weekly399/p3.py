from utils.python.predef import *


class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], k: int) -> int:
        ans = 0
        limit = max(nums1)
        counter = Counter(nums1)
        for k, v in Counter(i * k for i in nums2).items():
            for i in range(k, limit + 1, k):
                ans += counter.get(i, 0) * v
        return ans


if __name__ == '__main__':
    print(Solution().numberOfPairs(nums1=[1, 3, 4], nums2=[1, 3, 4], k=1))
    print(Solution().numberOfPairs(nums1=[1, 2, 4, 12], nums2=[2, 4], k=3))
