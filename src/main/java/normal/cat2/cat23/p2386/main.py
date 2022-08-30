from utils.python.predef import *


class Solution:
    def kSum(self, nums: List[int], k: int) -> int:
        base_sum = 0
        for i in range(len(nums)):
            if nums[i] > 0:
                base_sum += nums[i]
            else:
                nums[i] *= -1

        nums.sort(reverse=False)
        pq = [(0, 0)]
        for i in range(k - 1):
            tv, tp = heapq.heappop(pq)
            if tp < len(nums):
                heapq.heappush(pq, (tv + nums[tp], tp + 1))
                if tp:
                    heapq.heappush(pq, (tv + nums[tp] - nums[tp - 1], tp + 1))
        return base_sum - pq[0][0]


if __name__ == '__main__':
    print(Solution().kSum(nums=[2, 4, -2], k=5))
    print(Solution().kSum(nums=[1, -2, 3, 4, -10, 12], k=16))
