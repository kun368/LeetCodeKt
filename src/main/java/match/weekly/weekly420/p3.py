from utils.python.predef import *


def preprocess_largest_proper_divisors(limit: int):
    max_proper_divisor = [0] * (limit + 1)
    for i in range(1, limit // 2 + 1):
        for j in range(2 * i, limit + 1, i):
            max_proper_divisor[j] = i
    return max_proper_divisor


max_divisors = preprocess_largest_proper_divisors(1000010)


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        @cache
        def dfs(idx, limit):
            if idx < 0:
                return 0
            cur = nums[idx]
            cnt = 0
            while cur > limit:
                div = max_divisors[cur]
                if div > 1:
                    cur //= div
                    cnt += 1
                else:
                    cnt = 1 << 30
                    break
            return cnt + dfs(idx - 1, cur)

        ans = dfs(len(nums) - 2, nums[-1])
        return ans if ans < (1 << 30) else -1


if __name__ == '__main__':
    print(Solution().minOperations([25, 7]))
    print(Solution().minOperations([7, 7, 6]))
    print(Solution().minOperations([1, 1, 1, 1]))
    print(Solution().minOperations([105, 11])) # 1
