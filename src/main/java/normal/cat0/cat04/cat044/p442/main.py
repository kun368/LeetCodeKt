from typing import *


class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        ans = []
        for idx in range(len(nums)):
            while True:
                v = nums[idx]
                if v <= 0 or v == idx + 1:
                    break
                target = v - 1
                if nums[target] == v:
                    nums[target] = -1
                    nums[idx] = 0
                    ans.append(v)
                else:
                    nums[target], nums[idx] = nums[idx], nums[target]
        return ans


if __name__ == '__main__':
    print(Solution().findDuplicates([4, 3, 2, 7, 8, 2, 3, 1]))
    print(Solution().findDuplicates([1, 1, 2]))
    print(Solution().findDuplicates([1]))
