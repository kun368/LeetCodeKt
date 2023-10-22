from utils.python.predef import *


class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        num1, num2 = 0, 0
        for i in range(1, n + 1):
            if i % m != 0:
                num1 += i
            else:
                num2 += i
        return num1 - num2


if __name__ == '__main__':
    print(Solution().differenceOfSums(n=10, m=3))
    print(Solution().differenceOfSums(n=5, m=6))
    print(Solution().differenceOfSums(n=5, m=1))
