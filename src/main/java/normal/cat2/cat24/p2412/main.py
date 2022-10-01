from utils.python.predef import *


class Solution:
    def minimumMoney(self, transactions: List[List[int]]) -> int:
        pos_sum = 0
        for cost, cashback in transactions:
            pos_sum += max(0, cost - cashback)
        ans = 0
        for cost, cashback in transactions:
            ans = max(ans, (pos_sum - (cost - cashback) if cost - cashback > 0 else pos_sum) + cost)
        return ans


if __name__ == '__main__':
    print(Solution().minimumMoney([[2, 1], [5, 0], [4, 2]]))  # 10
    print(Solution().minimumMoney([[3, 0], [0, 3]]))  # 3
    print(Solution().minimumMoney(  # 24
        [[3, 9], [0, 4], [7, 10], [3, 5], [0, 9], [9, 3], [7, 4], [0, 0], [3, 3], [8, 0]])
    )
