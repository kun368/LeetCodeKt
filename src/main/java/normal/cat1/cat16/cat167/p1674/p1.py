from utils.python.predef import *


class DiffArray:  # 通用加减类的差分数组模板
    def __init__(self, arr):
        self.diff = [arr[0]] * len(arr)
        for i in range(1, len(arr)):
            self.diff[i] = arr[i] - arr[i - 1]

    def modify(self, i: int, j: int, value):  # 取[i~j]的双闭区间进行区间修改
        self.diff[i] += value  # 复原时, arr[i]之后的数都会 + value
        if j + 1 < len(self.diff):
            self.diff[j + 1] -= value

    def recover(self):  # 复原修改后的数组
        res = [self.diff[0]]
        for i in range(1, len(self.diff)):
            res.append(res[-1] + self.diff[i])
        return res


class Solution:
    def check(self, a, b, limit: int):
        a, b = min(a, b), max(a, b)
        return a + 1, a + b, limit + b

    def minMoves(self, nums: List[int], limit: int) -> int:
        da = DiffArray([0 for _ in range(limit * 2 + 1)])
        for i in range(len(nums) // 2):
            j = len(nums) - 1 - i
            x, y, z = self.check(nums[i], nums[j], limit)
            da.modify(2, 2 * limit, 2)
            da.modify(max(2, x), min(2 * limit, z), -1)
            da.modify(y, y, -1)
        ans = da.recover()
        return min(ans[i] for i in range(2, 2 * limit + 1))


if __name__ == '__main__':
    print(Solution().minMoves(nums=[1, 2, 4, 3], limit=4))
    print(Solution().minMoves(nums=[1, 2, 2, 1], limit=2))
    print(Solution().minMoves(nums=[1, 2, 1, 2], limit=2))
