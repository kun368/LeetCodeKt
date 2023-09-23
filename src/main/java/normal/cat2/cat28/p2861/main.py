from utils.python.predef import *


class Solution:
    def maxNumberOfAlloys(self, n: int, k: int, budget: int,
                          composition: List[List[int]],
                          stock: List[int],
                          cost: List[int]) -> int:

        ans = []
        for c in composition:
            def check(cnt):
                money = 0
                for i in range(n):
                    req = max(0, c[i] * cnt - stock[i])
                    money += cost[i] * req
                return money > budget

            cur = bisect.bisect_left(range(int(1e9 + 5)), True, key=check) - 1
            ans.append(cur)
        return max(ans)


if __name__ == '__main__':
    print(Solution().maxNumberOfAlloys(n=3, k=2, budget=15, composition=[[1, 1, 1], [1, 1, 10]], stock=[0, 0, 0],
                                       cost=[1, 2, 3]))
    print(Solution().maxNumberOfAlloys(n=3, k=2, budget=15, composition=[[1, 1, 1], [1, 1, 10]], stock=[0, 0, 100],
                                       cost=[1, 2, 3]))
    print(Solution().maxNumberOfAlloys(n=2, k=3, budget=10, composition=[[2, 1], [1, 2], [1, 1]], stock=[1, 1],
                                       cost=[5, 5]))
