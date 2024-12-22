from utils.python.predef import *


class Solution:
    def maxDistinctElements(self, nums: List[int], k: int) -> int:
        nums.sort()
        pre = -(1 << 30)
        ans = []
        for v in nums:
            cur_v = min(max(pre + 1, v - k), v + k)
            ans.append(cur_v)
            pre = cur_v
        return len(set(ans))


if __name__ == '__main__':
    print(Solution().maxDistinctElements(nums=[1, 2, 2, 3, 3, 4], k=2))
    print(Solution().maxDistinctElements(nums=[4, 4, 4, 4], k=1))
