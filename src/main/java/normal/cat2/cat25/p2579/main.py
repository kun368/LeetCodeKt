class Solution:
    def coloredCells(self, n: int) -> int:
        return (n - 1) ** 2 + n ** 2


if __name__ == '__main__':
    print(Solution().coloredCells(1))
    print(Solution().coloredCells(2))
    print(Solution().coloredCells(3))
    print(Solution().coloredCells(4))
    print(Solution().coloredCells(100000))
