from utils.python.predef import *


class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        counter = Counter(nums)
        mx = max(counter.values())
        ans = 0
        for k, v in counter.items():
            if v == mx:
                ans += mx
        return ans


if __name__ == '__main__':
    print(Solution().maxFrequencyElements(nums=[1, 2, 2, 3, 1, 4]))
    print(Solution().maxFrequencyElements(nums=[1, 2, 3, 4, 5]))
