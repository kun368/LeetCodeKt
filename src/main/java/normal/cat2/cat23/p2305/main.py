from utils.python.predef import *
import itertools
import functools


class Solution:
    def distributeCookies(self, cookies: List[int], k: int) -> int:
        N = len(cookies)

        @functools.cache
        def dfs(bits: int, k):
            cnt = bits.bit_count()
            if cnt == 0:
                return 0

            nums = [i for i in range(N) if (bits & (1 << i)) > 0]
            if k == 1:
                return sum(cookies[i] for i in nums)
            ans = 1 << 30
            for i in range(1, cnt - k + 2):
                for ids in itertools.combinations(nums, i):
                    next_bit = bits
                    cur_num = 0
                    for id in ids:
                        next_bit ^= (1 << id)
                        cur_num += cookies[id]
                    ans = min(ans, max(cur_num, dfs(next_bit, k - 1)))
            return ans

        return dfs((1 << N) - 1, k)


if __name__ == '__main__':
    print(Solution().distributeCookies(cookies=[8, 15, 10, 20, 8], k=2))
    print(Solution().distributeCookies(cookies=[6, 1, 3, 2, 2, 4, 1, 2], k=3))
