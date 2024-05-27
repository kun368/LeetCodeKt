from utils.python.predef import *


class PreSum1:
    def __init__(self, data):
        self.s = list(accumulate(data)) + [0]

    def query(self, i, j):  # [i, j]
        return self.s[j] - self.s[i - 1]


class PreSum2:
    def __init__(self, matrix: List[List[int]]):
        m, n = len(matrix), len(matrix[0])
        s = [[0] * (n + 1) for _ in range(m + 1)]
        for i, row in enumerate(matrix):
            for j, x in enumerate(row):
                s[i + 1][j + 1] = s[i + 1][j] + s[i][j + 1] - s[i][j] + x
        self.s = s

    def sumRegion(self, r1: int, c1: int, r2: int, c2: int) -> int:  # [r1,c1] ~ [r2,c2]
        return self.s[r2 + 1][c2 + 1] - self.s[r2 + 1][c1] - self.s[r1][c2 + 1] + self.s[r1][c1]


if __name__ == '__main__':
    t = PreSum1([0, 1, 2, 3])
    print(t.query(0, 3))
    print(t.query(3, 3))
