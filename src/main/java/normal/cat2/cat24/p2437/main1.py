from utils.python.predef import *


class Solution:
    def countTime(self, time: str) -> int:
        ans = 0
        for i in range(24):
            for j in range(60):
                t = f"{i:02d}:{j:02d}"
                if all(a == b or (b == '?') for a, b in zip(t, time)):
                    ans += 1
        return ans


if __name__ == '__main__':
    print(Solution().countTime(time="?5:00"))
    print(Solution().countTime(time="0?:0?"))
    print(Solution().countTime(time="??:??"))
