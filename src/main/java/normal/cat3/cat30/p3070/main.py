import sortedcontainers

from utils.python.predef import *


class Solution:
    def resultArray(self, nums: List[int]) -> List[int]:
        arr1, arr2 = sortedcontainers.SortedList(), sortedcontainers.SortedList()
        res1, res2 = [], []

        arr1.add(nums[0])
        res1.append(nums[0])
        arr2.add(nums[1])
        res2.append(nums[1])

        for i in range(2, len(nums)):
            t1 = len(arr1) - arr1.bisect_left(nums[i] + 1)
            t2 = len(arr2) - arr2.bisect_left(nums[i] + 1)
            if t1 > t2:
                arr1.add(nums[i])
                res1.append(nums[i])
            elif t1 < t2:
                arr2.add(nums[i])
                res2.append(nums[i])
            elif len(arr1) <= len(arr2):
                arr1.add(nums[i])
                res1.append(nums[i])
            else:
                arr2.add(nums[i])
                res2.append(nums[i])
        return res1 + res2


if __name__ == '__main__':
    print(Solution().resultArray(nums=[2, 1, 3, 3]))
    print(Solution().resultArray(nums=[5, 14, 3, 1, 2]))
    print(Solution().resultArray(nums=[3, 3, 3, 3]))
