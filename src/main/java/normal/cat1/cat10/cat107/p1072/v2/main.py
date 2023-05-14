from utils.python.predef import *


class Solution:
    def maxEqualRowsAfterFlips(self, matrix: List[List[int]]) -> int:
        full = (1 << len(matrix[0])) - 1
        counter = Counter()
        for i in matrix:
            a = int(''.join(str(t) for t in i), base=2)
            counter.update([a, full - a])
        return counter.most_common(1)[0][1]


if __name__ == '__main__':
    print(Solution().maxEqualRowsAfterFlips(matrix=[[0, 1], [1, 1]]))
    print(Solution().maxEqualRowsAfterFlips(matrix=[[0, 1], [1, 0]]))
    print(Solution().maxEqualRowsAfterFlips(matrix=[[0, 0, 0], [0, 0, 1], [1, 1, 0]]))
