from utils.python.predef import *


class Solution:
    def longestAlternatingSubarray(self, nums: List[int], threshold: int) -> int:
        ans = 0
        for i in range(len(nums)):
            if nums[i] % 2 != 0 or nums[i] > threshold:
                continue
            ans = max(ans, 1)
            for j in range(i + 1, len(nums)):
                if nums[j] % 2 == nums[j - 1] % 2 or nums[j] > threshold:
                    break
                ans = max(ans, j - i + 1)
        return ans


if __name__ == '__main__':
    print(Solution().longestAlternatingSubarray(nums=[3, 2, 5, 4], threshold=5))
    print(Solution().longestAlternatingSubarray(nums=[1, 2], threshold=2))
    print(Solution().longestAlternatingSubarray(nums=[2, 3, 4, 5], threshold=4))
