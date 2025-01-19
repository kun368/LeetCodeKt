from utils.python.predef import *

MOD = 10 ** 9 + 7


def get_combinations(max_n, max_m):
    C = [[0] * (max_m + 1) for _ in range(max_n + 1)]
    for i in range(max_n + 1):
        C[i][0] = 1
        for j in range(1, min(i, max_m) + 1):
            if j == i:
                C[i][j] = 1
            else:
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD
    return C


C = get_combinations(100005, 105)


class Solution:
    def minMaxSums(self, nums: List[int], k: int) -> int:
        n = len(nums)

        def check(rev):
            ret = 0
            nums.sort(reverse=rev)
            for i, v in enumerate(nums):
                tot = n - i - 1
                for select in range(0, min(k, tot + 1)):
                    ret = (ret + v * C[tot][select]) % MOD
            return ret

        return (check(False) + check(True)) % MOD


if __name__ == '__main__':
    print(Solution().minMaxSums(nums=[1, 2, 3], k=2))
    print(Solution().minMaxSums(nums=[5, 0, 6], k=1))
    print(Solution().minMaxSums(nums=[1, 1, 1], k=2))
    print(Solution().minMaxSums(nums=[0, 1, 1], k=3))  # 9
