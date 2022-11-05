from utils.python.predef import *


class Solution:
    def secondGreaterElement(self, nums: List[int]) -> List[int]:
        from sortedcontainers import SortedList
        arr = sorted(enumerate(nums), key=lambda x: (-x[1], x[0]))
        set = SortedList()
        ans = [-1] * len(nums)
        for idx, val in arr:
            set.add(idx)
            cur = set.index(idx)
            if cur + 2 >= len(set):
                continue
            ans[idx] = nums[set[cur + 2]]
        return ans


if __name__ == '__main__':
    print(Solution().secondGreaterElement(nums=[2, 4, 0, 9, 6]))
    print(Solution().secondGreaterElement(nums=[3, 3]))
    print(Solution().secondGreaterElement(nums=[1, 17, 18, 0, 18, 10, 20, 0]))  # [18,18,-1,10,-1,-1,-1,-1]
