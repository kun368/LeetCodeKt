from utils.python.predef import *


class Solution:
    def findKthSmallest(self, coins: List[int], k: int) -> int:
        def check(req):
            ans = 0
            for i in range(1, 1 << len(coins)):
                op = 1 if i.bit_count() % 2 else -1
                val = reduce(lcm, [coins[t] for t in range(i.bit_length()) if i & (1 << t)])
                ans += op * (req // val)
            return ans >= k

        return bisect_left(range(min(coins) * k), True, key=check)


if __name__ == '__main__':
    print(Solution().findKthSmallest(coins=[3, 6, 9], k=3))
    print(Solution().findKthSmallest(coins=[5, 2], k=7))
