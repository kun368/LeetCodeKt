from utils.python.predef import *


class Solution:
    def queryString(self, s: str, n: int) -> bool:
        return all(bin(i)[2:] in s for i in range(1, n + 1))


if __name__ == '__main__':
    print(Solution().queryString(s="0110", n=3))
    print(Solution().queryString(s="0110", n=4))
