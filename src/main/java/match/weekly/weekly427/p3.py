from utils.python.predef import *


class Solution:
    def maxSubarraySum(self, nums: List[int], k: int) -> int:
        current_sum = 0
        ans = -(1 << 60)
        min_sum_map = {0: 0}
        for idx, v in enumerate(nums, 1):
            current_sum += v
            req = idx % k
            if idx < k:
                min_sum_map[idx] = current_sum
            else:
                ans = max(ans, current_sum - min_sum_map[req])
                min_sum_map[req] = min(min_sum_map[req], current_sum)
        return ans


if __name__ == '__main__':
    print(Solution().maxSubarraySum(nums=[1, 2], k=1))
    print(Solution().maxSubarraySum(nums=[-1, -2, -3, -4, -5], k=4))
    print(Solution().maxSubarraySum(nums=[-5, 1, 2, -3, 4], k=2))
