from utils.python.predef import *


class Solution:
    def maximumStrength(self, nums: List[int], k: int) -> int:
        N = len(nums)
        MIN = -(1 << 50)

        @cache
        def dfs(start: int, n: int, must_use_first: bool):
            if n == 0: return 0
            if n > N - start: return MIN
            if start >= N: return MIN
            suffix = 1 if n % 2 == 1 else -1
            ans_list = [MIN]
            if not must_use_first:
                ans_list.append(dfs(start + 1, n, False))
            ans_list.append(nums[start] * n * suffix + dfs(start + 1, n, True))
            ans_list.append(nums[start] * n * suffix + dfs(start + 1, n - 1, False))
            return max(ans_list)

        return dfs(0, k, False)


if __name__ == '__main__':
    print(Solution().maximumStrength(nums=[1, 2, 3, -1, 2], k=3))
    print(Solution().maximumStrength(nums=[12, -2, -2, -2, -2], k=5))
    print(Solution().maximumStrength(nums=[-1, -2, -3], k=1))
