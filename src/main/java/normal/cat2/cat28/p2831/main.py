from utils.python.predef import *


class Solution:
    def longestEqualSubarray(self, nums: List[int], k: int) -> int:
        mp = defaultdict(list)
        for i, v in enumerate(nums):
            mp[v].append(i)

        ans = 1
        for ls in mp.values():
            for i in range(len(ls)):
                ins = bisect_left(range(i), True, key=lambda idx: ls[i] - ls[idx] <= i - idx + k)
                ans = max(ans, i - ins + 1)
        return ans


if __name__ == '__main__':
    print(Solution().longestEqualSubarray(nums=[1, 3, 2, 3, 1, 3], k=3))
    print(Solution().longestEqualSubarray(nums=[1, 1, 2, 2, 1, 1], k=2))
    print(Solution().longestEqualSubarray(nums=[5, 5, 5, 0, 5, 0, 5, 5, 5], k=2))
    print(Solution().longestEqualSubarray(nums=[5, 5, 5, 0, 5, 0, 5, 5, 5], k=0))
