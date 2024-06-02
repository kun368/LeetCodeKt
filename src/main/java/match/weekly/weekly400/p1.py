from utils.python.predef import *


class Solution:
    def minimumChairs(self, s: str) -> int:
        cur = 0
        ans = 0
        for i in s:
            if i == 'E':
                cur -= 1
            else:
                cur += 1
            ans = min(ans, cur)
        return -ans


if __name__ == '__main__':
    pass
