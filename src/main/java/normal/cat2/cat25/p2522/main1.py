class Solution:
    def minimumPartition(self, s: str, k: int) -> int:
        dp = [1 << 30] * (len(s) + 10)
        dp[0] = 0
        lenk = len(str(k))
        for i in range(1, len(s) + 1):
            for j in range(1, min(i, lenk) + 1):
                if j < lenk or int(s[i - j: i]) <= k:
                    dp[i] = min(dp[i], dp[i - j] + 1)
        return dp[len(s)] if dp[len(s)] < (1 << 30) else -1


if __name__ == '__main__':
    print(Solution().minimumPartition(s="165462", k=60))
    print(Solution().minimumPartition(s="238182", k=5))
