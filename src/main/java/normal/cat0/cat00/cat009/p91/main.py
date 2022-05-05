class Solution:
    def numDecodings(self, s: str) -> int:
        l = len(s)
        dp = [0] * l
        dp[0] = 0 if s[0] == '0' else 1
        for i in range(1, l):
            if s[i] != '0':
                dp[i] += dp[i - 1]
            if i >= 1 and s[i - 1] != '0' and 1 <= int(s[i - 1:i + 1]) <= 26:
                dp[i] += dp[i - 2] if i >= 2 else 1

        return dp[-1]


if __name__ == '__main__':
    print(Solution().numDecodings('12'))
    print(Solution().numDecodings('226'))
    print(Solution().numDecodings('0'))
