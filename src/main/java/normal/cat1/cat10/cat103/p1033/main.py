from utils.python.predef import *

class Solution:
    def numMovesStones(self, a: int, b: int, c: int) -> List[int]:
        a, b, c = sorted([a, b, c])
        if a + 1 == b and b + 1 == c:
            return [0, 0]
        if b - a <= 2 or c - b <= 2:
            return [1, c - a - 2]
        return [2, c - a - 2]

if __name__ == '__main__':
    print(Solution().numMovesStones(a = 1, b = 2, c = 5))
    print(Solution().numMovesStones(a = 4, b = 3, c = 2))
