from utils.python.predef import *


class Solution:
    def maxSumSubmatrix(self, matrix: List[List[int]], k: int) -> int:
        ans = -inf
        m, n = len(matrix), len(matrix[0])
        for st in range(m):
            ps = [0] * n
            for ed in range(st, m):
                s = 0
                for i in range(n):
                    s += matrix[ed][i]
                    ps[i] += s
                st = [0]
                for t in ps:
                    if (p := bisect_left(st, t - k)) < len(st):
                        ans = max(ans, t - st[p])
                    insort_left(st, t)
        return ans


if __name__ == '__main__':
    print(Solution().maxSumSubmatrix(matrix=[[1, 0, 1], [0, -2, 3]], k=2))
    print(Solution().maxSumSubmatrix(matrix=[[2, 2, -1]], k=3))
    print(Solution().maxSumSubmatrix(matrix=[[2, 2, -1]], k=0))  # -1
