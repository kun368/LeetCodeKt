from utils.python.predef import *


class Solution:
    def isFascinating(self, n: int) -> bool:
        return sorted(str(n) + str(n * 2) + str(n * 3)) == sorted(string.digits[1:])


if __name__ == '__main__':
    print(Solution().isFascinating(n=192))
    print(Solution().isFascinating(n=100))
    print(Solution().isFascinating(n=783))
