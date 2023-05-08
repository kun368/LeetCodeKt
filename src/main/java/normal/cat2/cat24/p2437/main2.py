from utils.python.predef import *


class Solution:
    def countTime(self, time: str) -> int:
        t1, t2 = time.split(':')
        a1, a2 = 0, 0
        for i in range(24):
            if all(a == b or (b == '?') for a, b in zip(f"{i:02d}", t1)):
                a1 += 1
        for i in range(60):
            if all(a == b or (b == '?') for a, b in zip(f"{i:02d}", t2)):
                a2 += 1
        return a1 * a2


if __name__ == '__main__':
    print(Solution().countTime(time="?5:00"))
    print(Solution().countTime(time="0?:0?"))
    print(Solution().countTime(time="??:??"))
