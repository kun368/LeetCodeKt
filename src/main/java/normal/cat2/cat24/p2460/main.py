from utils.python.predef import *


class Solution:
    def applyOperations(self, nums: List[int]) -> List[int]:
        for i in range(len(nums) - 1):
            if nums[i] == nums[i + 1]:
                nums[i] *= 2
                nums[i + 1] = 0
        ans = []
        cnt = 0
        for i in nums:
            if i == 0:
                cnt += 1
            else:
                ans.append(i)
        for i in range(cnt):
            ans.append(0)
        return ans


if __name__ == '__main__':
    print(Solution().applyOperations(nums=[1, 2, 2, 1, 1, 0]))
    print(Solution().applyOperations(nums=[0, 1]))
