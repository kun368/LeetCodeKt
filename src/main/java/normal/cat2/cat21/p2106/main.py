from utils.python.predef import *


class Solution:
    def maxTotalFruits(self, fruits: List[List[int]], startPos: int, k: int) -> int:
        min_pos = min(startPos, fruits[0][0])
        max_pos = max(startPos, fruits[-1][0])
        fruits = {position: amount for position, amount in fruits}
        range_sum = [0] * (max_pos - min_pos + 10)
        range_sum[0] = fruits.get(startPos, 0)
        # print(startPos, min_pos, max_pos)
        for i in range(startPos - min_pos):
            range_sum[-i-1] = range_sum[-i] + fruits.get(startPos-i-1, 0)
        for i in range(max_pos - startPos):
            range_sum[i+1] = range_sum[i] + fruits.get(startPos+i+1, 0)

        ans = range_sum[0]
        for i in range(k):
            j = k - 2 * i
            if j <= 0:
                break
            ans = max(ans, range_sum[max(-i, min_pos - startPos)] + range_sum[min(j, max_pos - startPos)] - range_sum[0]) 
            ans = max(ans, range_sum[min(i, max_pos - startPos)] + range_sum[max(-j, min_pos - startPos)] - range_sum[0])
        return ans


if __name__ == '__main__':
    print(Solution().maxTotalFruits(
        fruits=[[2, 8], [6, 3], [8, 6]], startPos=5, k=4))
    print(Solution().maxTotalFruits(fruits=[[0, 9], [4, 1], [
          5, 7], [6, 2], [7, 4], [10, 9]], startPos=5, k=4))
    print(Solution().maxTotalFruits(fruits=[[20, 10]], startPos=20, k=0))
    print(Solution().maxTotalFruits(fruits=[[0, 10000]], startPos=200000, k=200000))
