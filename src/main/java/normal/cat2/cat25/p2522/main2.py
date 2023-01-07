class Solution:
    def minimumPartition(self, s: str, k: int) -> int:
        cur = 0
        ans = 1
        for i in s:
            t = int(i)
            if t > k:
                return -1
            cur = cur * 10 + t
            if cur > k:
                ans += 1
                cur = t
        return ans


if __name__ == '__main__':
    print(Solution().minimumPartition(s="165462", k=60))
    print(Solution().minimumPartition(s="238182", k=5))
    print(Solution().minimumPartition(s="238182", k=10))
    print(Solution().minimumPartition(s="34", k=100))
