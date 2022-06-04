from utils.python.predef import *


class Solution:
    def countTexts(self, pressedKeys: str) -> int:
        MOD = int(1e9 + 7)
        N = len(pressedKeys)
        dp = [0] * (N + 1)
        dp[1] = 1
        dp[0] = 1

        for i in range(1, len(pressedKeys)):
            cur = pressedKeys[i]
            max_len = 4 if cur in ('7', '9') else 3
            for j in range(1, max_len + 1):
                if i - j + 1 < 0:
                    break
                dp[i + 1] = (dp[i + 1] + dp[i - j + 1]) % MOD
                if pressedKeys[i - j] != cur:
                    break
        return dp[-1]


if __name__ == '__main__':
    print(Solution().countTexts('22233'))
    print(Solution().countTexts('222222222222222222222222222222222222'))
    print(Solution().countTexts('444479999555588866'))
