from utils.python.predef import *


class Solution:
    def getFinalState(self, nums: List[int], k: int, multiplier: int) -> List[int]:
        from sortedcontainers import SortedList

        ls = SortedList()
        for idx, v in enumerate(nums):
            ls.add([v, idx])

        for _ in range(k):
            v, idx = ls.pop(0)
            v *= multiplier
            ls.add([v, idx])

        ans = list(ls)
        ans.sort(key=lambda x: x[1])
        return [v for v, idx in ans]


if __name__ == '__main__':
    print(Solution().getFinalState(nums=[2, 1, 3, 5, 6], k=5, multiplier=2))
    print(Solution().getFinalState(nums=[1, 2], k=3, multiplier=4))
