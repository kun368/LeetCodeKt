from utils.python.predef import *


class Solution:
    def isArraySpecial(self, nums: List[int], queries: List[List[int]]) -> List[bool]:
        arr = [0]
        for i in range(1, len(nums)):
            arr.append(1 if nums[i] % 2 == nums[i - 1] % 2 else 0)
        acc = list(accumulate(arr))

        ans = []
        for a, b in queries:
            cur = acc[b] - acc[a]
            ans.append(not bool(cur))
        return ans


if __name__ == '__main__':
    print(Solution().isArraySpecial(nums=[3, 4, 1, 2, 6], queries=[[0, 4]]))
    print(Solution().isArraySpecial(nums=[4, 3, 1, 6], queries=[[0, 2], [2, 3]]))
    # print(Solution().isArraySpecial(nums=[4], queries=[[0, 0]]))
