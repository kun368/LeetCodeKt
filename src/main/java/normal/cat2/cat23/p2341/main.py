from utils.python.predef import *


class Solution:
    def numberOfPairs(self, nums: List[int]) -> List[int]:
        from collections import Counter
        counter = Counter(nums)
        ans = 0
        for k, v in counter.items():
            ans += v // 2
        return [ans, len(nums) - ans * 2]


if __name__ == '__main__':
    print(Solution().numberOfPairs(nums=[1, 3, 2, 1, 3, 2, 2]))
    print(Solution().numberOfPairs(nums=[1, 1]))
    print(Solution().numberOfPairs(nums=[0]))
