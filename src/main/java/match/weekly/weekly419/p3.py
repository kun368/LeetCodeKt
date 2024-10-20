from utils.python.predef import *

MOD = 10 ** 9 + 7


class Solution:
    def countWinningSequences(self, s: str) -> int:
        n = len(s)
        creatures = {'F': 0, 'W': 1, 'E': 2}
        alice_seq = [creatures[c] for c in s]

        def determine_winner(alice_val, bob_val):
            if (alice_val - bob_val) % 3 == 1:
                return -1
            elif (bob_val - alice_val) % 3 == 1:
                return 1
            else:
                return 0

        dp = [[[0] * (2 * n + 1) for _ in range(3)] for _ in range(n)]
        for v in range(3):
            diff = determine_winner(alice_seq[0], v)
            dp[0][v][diff + n] = 1
        for idx in range(1, n):
            for v in range(3):
                for prev_val in range(3):
                    if v == prev_val:
                        continue
                    cc = determine_winner(alice_seq[idx], v)
                    for diff in range(-n, n + 1):
                        if 0 <= diff + n - cc <= 2 * n:
                            dp[idx][v][diff + n] = (dp[idx][v][diff + n] + dp[idx - 1][prev_val][diff + n - cc]) % MOD
        ret = 0
        for v in range(3):
            for diff in range(1, n + 1):
                ret = (ret + dp[n - 1][v][diff + n]) % MOD
        return ret % MOD


if __name__ == '__main__':
    print(Solution().countWinningSequences(s="FFF"))
    print(Solution().countWinningSequences(s="FWEFW"))
