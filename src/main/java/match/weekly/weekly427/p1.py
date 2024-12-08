from utils.python.predef import *


class Solution:
    def constructTransformedArray(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = []
        for i in range(n):
            if nums[i] > 0:
                res.append(nums[(i + nums[i] + n * 1000) % n])
            elif nums[i] < 0:
                res.append(nums[(i - abs(nums[i]) + n * 1000) % n])
            else:
                res.append(nums[i])
        return res


if __name__ == '__main__':
    print(Solution().constructTransformedArray(nums=[3, -2, 1, 1]))
    print(Solution().constructTransformedArray(nums=[-1, 4, -1]))
