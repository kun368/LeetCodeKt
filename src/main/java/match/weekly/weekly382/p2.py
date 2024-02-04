import sortedcontainers

from utils.python.predef import *


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        nums = sortedcontainers.SortedList(nums)

        ans = 1
        vis = set()
        for top in nums:
            if top in vis:
                continue
            if top == 1:
                vis.add(top)
                c = nums.count(1)
                if c % 2 == 0:
                    c -= 1
                ans = max(ans, c)
                continue

            # print(top)
            t = 1
            while top <= nums[-1]:
                if top not in nums:
                    break
                # print('!!!', top)
                vis.add(top)
                if nums.count(top) >= 2 and nums.count(top * top) >= 1:
                    t += 2
                top = top * top
            ans = max(ans, t)
        return ans


if __name__ == '__main__':
    # print(Solution().maximumLength(nums=[5, 4, 1, 2, 2]))
    # print(Solution().maximumLength(nums=[1, 3, 2, 4]))
    # print(Solution().maximumLength(nums=[2, 4, 16, 4, 2]))
    # print(Solution().maximumLength(nums=[3, 9, 3]))
    # print(Solution().maximumLength(nums=[3]))
    # print(Solution().maximumLength(nums=[2, 4, 8, 4, 2]))
    print(
        Solution().maximumLength(nums=[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024]))  # 9
